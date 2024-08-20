package com.javis.aplication.dto;

import lombok.Builder;

@Builder
public record GemRequestDto(
        String content
) {
}
