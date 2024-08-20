package com.javis.aplication.repository;

import com.javis.aplication.entity.JobPostingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostingJpaRepository extends JpaRepository<JobPostingEntity, Long> {
    public List<JobPostingEntity> findAllByMemberId(Long memberId);
}
