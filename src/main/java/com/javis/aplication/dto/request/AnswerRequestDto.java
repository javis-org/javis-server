package com.javis.aplication.dto.request;

import com.javis.aplication.entity.AnswerEntity;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AnswerRequestDto(
        Long id,
        String answer,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static AnswerRequestDto from(QnARequestDto qnARequestDto){
        return AnswerRequestDto.builder()
                .answer(qnARequestDto.answer())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public AnswerEntity toAnswerEntity(){
        return AnswerEntity.builder()
                .answer(answer)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
