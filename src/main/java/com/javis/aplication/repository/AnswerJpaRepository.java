package com.javis.aplication.repository;

import com.javis.aplication.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerJpaRepository extends JpaRepository<AnswerEntity, Long> {
    public Optional<AnswerEntity> findByQuestionId(Long questionId);
}
