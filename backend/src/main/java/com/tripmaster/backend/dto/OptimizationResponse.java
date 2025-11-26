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
public class OptimizationResponse {

    private boolean isFeasible;
    private List<DayItinerary> itinerary;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DayItinerary {

        private int day;
        private List<RouteStep> routes;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RouteStep {

        private int order;
        private int placeId;
        private String arrivalTime;
        private String departureTime;
    }
}