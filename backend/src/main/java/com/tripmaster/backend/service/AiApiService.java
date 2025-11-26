package com.tripmaster.backend.service;

import com.tripmaster.backend.dto.OptimizationRequest;
import com.tripmaster.backend.dto.OptimizationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AiApiService {

    private final WebClient webClient;

    // application.properties에서 AI 서버 URL 주입
    public AiApiService(@Value("${ai.server.base-url}") String aiBaseUrl) {
        this.webClient = WebClient.builder()
            .baseUrl(aiBaseUrl)
            .build();
    }

    // Python의 /optimize 엔드포인트로 요청을 보냄
    public OptimizationResponse getOptimizedRoute(OptimizationRequest request) {
        // Mock 데이터 요청을 위한 임시 구현
        return webClient.post()
            .uri("/optimize") // http://localhost:8000/optimize
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(request)
            .retrieve()
            .bodyToMono(OptimizationResponse.class)
            .block(); // 동기식으로 결과를 기다림 (실제 운영에서는 비동기 처리 권장)
    }
}