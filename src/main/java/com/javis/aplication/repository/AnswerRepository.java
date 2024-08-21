package com.javis.aplication.repository;

import com.javis.aplication.entity.AnswerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AnswerRepository {
    private final AnswerJpaRepository answerJpaRepository;

    public AnswerEntity save(AnswerEntity answerEntity) {
        return answerJpaRepository.save(answerEntity);
    }

    public AnswerEntity findByQuestionId(Long questionId) {
        return answerJpaRepository.findByQuestionId(questionId).orElse(new AnswerEntity());
    }
}
