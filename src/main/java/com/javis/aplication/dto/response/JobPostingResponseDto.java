package com.javis.aplication.dto.response;

import com.javis.aplication.entity.JobPostingEntity;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record JobPostingResponseDto(
        Long id,
        String title,
        String company,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static JobPostingResponseDto from(JobPostingEntity jobPostingEntity){
        return JobPostingResponseDto.builder()
                .id(jobPostingEntity.getId())
                .title(jobPostingEntity.title)
                .company(jobPostingEntity.company)
                .description(jobPostingEntity.description)
                .createdAt(jobPostingEntity.createdAt)
                .updatedAt(jobPostingEntity.updatedAt)
                .build();
    }
}
