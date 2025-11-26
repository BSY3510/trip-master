package com.tripmaster.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 여행 계획의 메인 정보를 저장하는 엔티티 (테이블 설계도)
 */
@Entity
@Table(name = "trip")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Trip {

    @Id // 기본 키(Primary Key) 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL의 AUTO_INCREMENT 설정
    private Long tripId;

    private String title;

    private LocalDate startDate;

    private int days;

    @Builder
    public Trip(String title, LocalDate startDate, int days) {
        this.title = title;
        this.startDate = startDate;
        this.days = days;
    }
}