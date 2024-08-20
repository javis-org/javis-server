package com.javis.aplication.service;

import com.javis.aplication.dto.request.JobPostingRequestDto;
import com.javis.aplication.dto.request.JobPostingUpdateRequestDto;
import com.javis.aplication.dto.response.JobPostingResponseDto;
import com.javis.aplication.entity.JobPostingEntity;
import com.javis.aplication.repository.JobPostingRepository;
import com.javis.aplication.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostingService {
    private final JobPostingRepository jobPostingRepository;

    private final MemberRepository memberRepository;

    public JobPostingResponseDto create(JobPostingRequestDto jobPostingRequestDto) {
        memberRepository.findById(jobPostingRequestDto.memberId());
        JobPostingEntity jobPostingEntity = jobPostingRepository.save(jobPostingRequestDto.toJobPostingEntity());
        return JobPostingResponseDto.from(jobPostingEntity);
    }

    public JobPostingResponseDto update(JobPostingUpdateRequestDto jobPostingUpdateRequestDto) {
        JobPostingEntity jobPostingEntity = jobPostingRepository.save(jobPostingUpdateRequestDto.toJobPostingEntity());
        return JobPostingResponseDto.from(jobPostingEntity);
    }

    public List<JobPostingResponseDto> findAll(Long memberId) {
        memberRepository.findById(memberId);
        return jobPostingRepository
                .findAllByMemberId(memberId)
                .stream()
                .map(JobPostingResponseDto::from)
                .toList();
    }

    public JobPostingResponseDto findById(Long id) {
        return JobPostingResponseDto.from(jobPostingRepository.findById(id));
    }
}
