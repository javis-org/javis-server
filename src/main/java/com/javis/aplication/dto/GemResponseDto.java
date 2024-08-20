package com.javis.aplication.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GemResponseDto {

    private List<Gem> gemList;
    private int totalScore;
    private int count;
    private Map<Integer, Integer> rateCount;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Gem {
        private String name;
        private int rate;
        private String comment;
        private String answer;
    }

    public static GemResponseDto from(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonString, GemResponseDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
