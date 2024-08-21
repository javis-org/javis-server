package com.javis.aplication.repository;

import com.javis.aplication.entity.QuestionEntity;
import com.javis.aplication.entity.QuestionWithAnswer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionRepository {
    private final QuestionJpaRepository questionJpaRepository;

    public QuestionEntity save(QuestionEntity questionEntity) {
        return questionJpaRepository.save(questionEntity);
    }

    public List<QuestionEntity> findAll() {
        return questionJpaRepository.findAll();
    }

    public List<QuestionWithAnswer> findAllWithAnswer(Long jobPostingId) {
        return questionJpaRepository.findAllByJobPostingId(jobPostingId);
    }
}
