from fastapi import FastAPI
from pydantic import BaseModel, Field
from typing import List, Optional

# FastAPI 인스턴스 생성
app = FastAPI()

# Pydantic 모델 정의: Spring DTO와 완벽히 일치해야 합니다. (camelCase 사용)

class PlaceData(BaseModel):
    placeId: int
    name: str
    lat: float
    lng: float
    category: str
    duration: int
    mealType: str = Field("NONE", alias="mealType") # 'mealType' 필드명을 JSON에서는 camelCase로 받도록 명시

    class Config:
        # JSON key를 camelCase로 변환하여 Python 내부에서는 snake_case를 사용하도록 허용 (API Naming Convention 준수)
        populate_by_name = True 
        
class OptimizationRequest(BaseModel):
    tripId: int
    startDate: str
    days: int
    startTime: str
    endTime: str
    places: List[PlaceData]

class RouteStep(BaseModel):
    order: int
    placeId: int
    arrivalTime: str
    departureTime: str

class DayItinerary(BaseModel):
    day: int
    routes: List[RouteStep]

class OptimizationResponse(BaseModel):
    isFeasible: bool
    itinerary: List[DayItinerary]

# =========================================================
# 1. 헬스 체크 엔드포인트 (경로: /health)
# =========================================================

@app.get("/health", response_model=dict)
def health_check():
    # 이제 /health로 접속해야 정상 응답이 나옵니다.
    return {"status": "Route Master AI Server is Running 🚀"}

# =========================================================
# 2. 최적화 엔드포인트 (경로: /optimize)
# =========================================================

@app.post("/optimize", response_model=OptimizationResponse)
async def optimize_route(request: OptimizationRequest):
    # Spring으로부터 받은 요청 데이터는 request 변수에 OptimizationRequest 타입으로 자동 검증되어 들어옵니다.
    
    # TODO: 여기에 OR-Tools 알고리즘 로직이 들어갑니다. (현재는 Mock 응답)
    
    # Python 서버가 Spring의 요청을 성공적으로 처리했음을 나타내는 Mock 데이터
    mock_response = OptimizationResponse(
        isFeasible=True,
        itinerary=[
            DayItinerary(
                day=1,
                routes=[
                    # 요청받은 데이터를 사용해 응답을 구성합니다.
                    RouteStep(order=1, placeId=request.places[0].placeId, arrivalTime="09:00", departureTime="09:00"),
                    RouteStep(order=2, placeId=request.places[1].placeId, arrivalTime="11:10", departureTime="12:10"),
                ]
            )
        ]
    )
    return mock_response
    
# 실행 명령: uvicorn main:app --reload --port 8000