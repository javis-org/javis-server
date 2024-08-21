package com.javis.aplication.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class QuestionWithAnswer {
    private QuestionEntity questionEntity;
    private AnswerEntity answerEntity;
}
