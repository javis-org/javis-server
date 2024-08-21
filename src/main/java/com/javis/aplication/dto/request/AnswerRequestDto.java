package com.javis.aplication.dto.request;

import com.javis.aplication.entity.AnswerEntity;
import com.javis.aplication.entity.QuestionEntity;
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

    public AnswerEntity toAnswerEntity(QuestionEntity questionEntity){
        return AnswerEntity.builder()
                .answer(answer)
                .question(questionEntity)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
