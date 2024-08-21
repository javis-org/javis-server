package com.javis.aplication.dto.request;

import com.javis.aplication.entity.JobPostingEntity;
import com.javis.aplication.entity.QuestionEntity;
import lombok.Builder;

@Builder
public record QuestionRequestDto(
        Long id,
        String question,
        String size
) {

    public static QuestionRequestDto from(QnARequestDto qnARequestDto) {
        return QuestionRequestDto.builder()
                .question(qnARequestDto.question())
                .size(qnARequestDto.size())
                .build();
    }

    public QuestionEntity toQuestionEntity(Long jobPostingId){
        return QuestionEntity.builder()
                .jobPosting(JobPostingEntity.builder().id(jobPostingId).build())
                .question(question)
                .size(size)
                .build();
    }
}
