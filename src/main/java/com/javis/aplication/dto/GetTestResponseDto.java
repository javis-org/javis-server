package com.javis.aplication.dto;

import com.javis.aplication.entity.TestEntity;
import lombok.Builder;

@Builder
public record GetTestResponseDto(
        // ㅅ
        Long id,
        String name,
        String description
){
    public static GetTestResponseDto from(TestEntity testEntity){
        return GetTestResponseDto.builder()
                .id(testEntity.id)
                .name(testEntity.name)
                .description(testEntity.description)
                .build();
    }
}
