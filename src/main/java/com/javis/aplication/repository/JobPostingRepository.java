package com.javis.aplication.repository;

import com.javis.aplication.entity.JobPostingEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JobPostingRepository {
    private final JobPostingJpaRepository jobPostingJpaRepository;

    public JobPostingEntity save(JobPostingEntity jobPostingEntity) {
        return jobPostingJpaRepository.save(jobPostingEntity);
    }

    public List<JobPostingEntity> findAllByMemberId(Long memberId) {
        return jobPostingJpaRepository.findAllByMemberId(memberId);
    }
}
