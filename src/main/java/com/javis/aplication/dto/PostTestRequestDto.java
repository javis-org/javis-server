package com.javis.aplication.dto;

import com.javis.aplication.entity.TestEntity;

public record PostTestRequestDto(
        String name,
        String description
        ) {

    public TestEntity toEntity(){
        return TestEntity.builder()
                .name(name)
                .description(description)
                .build();
    }
}
