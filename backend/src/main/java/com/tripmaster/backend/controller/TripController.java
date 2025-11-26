package com.tripmaster.backend.controller;

import com.tripmaster.backend.dto.OptimizationRequest;
import com.tripmaster.backend.dto.OptimizationResponse;
import com.tripmaster.backend.service.AiApiService;
import java.util.Arrays;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/trips")
public class TripController {

    private final AiApiService aiApiService;

    public TripController(AiApiService aiApiService) {
        this.aiApiService = aiApiService;
    }

    @PostMapping("/optimize-test")
    public ResponseEntity<OptimizationResponse> testOptimization(
        @RequestBody OptimizationRequest request) {
        // 1. 요청 데이터를 Python 서버로 보냄
        OptimizationResponse response = aiApiService.getOptimizedRoute(request);

        // 2. Python 서버의 응답을 클라이언트에 반환
        return ResponseEntity.ok(response);
    }

    // 테스트용 샘플 데이터 생성 API
    @GetMapping("/sample-request")
    public OptimizationRequest getSampleRequest() {
        // 테스트를 위해 Python이 이해할 수 있는 Mock Request 생성
        OptimizationRequest.PlaceData hotel = OptimizationRequest.PlaceData.builder()
            .placeId(1).name("숙소").lat(37.805).lng(128.908).category("ACCOMMODATION").duration(0)
            .mealType("NONE").build();

        OptimizationRequest.PlaceData restaurant = OptimizationRequest.PlaceData.builder()
            .placeId(2).name("초당순두부").lat(37.791).lng(128.914).category("RESTAURANT").duration(60)
            .mealType("LUNCH").build();

        return OptimizationRequest.builder()
            .tripId(101).startDate("2024-05-20").days(1).startTime("09:00").endTime("21:00")
            .places(Arrays.asList(hotel, restaurant))
            .build();
    }
}