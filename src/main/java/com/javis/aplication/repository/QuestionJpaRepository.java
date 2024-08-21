package com.javis.aplication.repository;

import com.javis.aplication.entity.QuestionEntity;
import com.javis.aplication.entity.QuestionWithAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionJpaRepository extends JpaRepository<QuestionEntity, Long> {

    public List<QuestionWithAnswer> findAllByJobPostingId(Long jobPostingId);
}
