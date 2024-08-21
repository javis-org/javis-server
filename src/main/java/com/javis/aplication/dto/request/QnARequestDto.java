package com.javis.aplication.dto.request;

public record QnARequestDto(
        String question,
        String size,
        String answer
) {
}
