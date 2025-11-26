package com.tripmaster.backend.controller; // 패키지명은 실제 구조에 맞게 조정하세요.

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 이 클래스가 REST API의 엔드포인트임을 선언
public class HealthController {

    // GET /health 요청을 처리하는 메소드
    @GetMapping("/health")
    public String checkHealth() {
        return "Backend Server is Up and Running! 🚀";
    }
}