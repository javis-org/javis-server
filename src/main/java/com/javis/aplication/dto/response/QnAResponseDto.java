package com.javis.aplication.dto.response;

import java.time.LocalDateTime;

public record QnAResponseDto(
        Long questionId,
        String question,
        String size,
        Long answerId,
        String answer,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
