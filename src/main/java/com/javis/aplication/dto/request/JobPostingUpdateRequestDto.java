package com.javis.aplication.dto.request;

import com.javis.aplication.entity.JobPostingEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record JobPostingUpdateRequestDto(
        @NotNull(message = "id값은 필수 값입니다.")
        @Schema(description = "jobPosting pk입니다.")
        Long id,
        
        @NotNull(message = "제목은 필수 값입니다.")
        @Schema(description = "제목입니다.")
        String title,
        
        @NotNull(message = "회사명은 필수 값입니다.")
        @Schema(description = "회사명입니다.")
        String company,

        @Schema(description = "작성하고 싶은 세부 내용입니다.")
        String description
) {

    public JobPostingEntity toJobPostingEntity(){
        return JobPostingEntity.builder()
                .id(id)
                .title(title)
                .company(company)
                .description(description)
                .updatedAt(LocalDateTime.now())
                .build();
    }

}
