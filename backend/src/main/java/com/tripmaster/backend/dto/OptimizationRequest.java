package com.tripmaster.backend.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OptimizationRequest {

    private int tripId;
    private String startDate;
    private int days;
    private String startTime;
    private String endTime;
    private List<PlaceData> places;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PlaceData {

        private int placeId;
        private String name;
        private double lat;
        private double lng;
        private String category;
        private int duration;
        private String mealType;
    }
}