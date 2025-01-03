package com.javis.aplication.dto.request;

import com.javis.aplication.entity.JobPostingEntity;
import com.javis.aplication.entity.MemberEntityV1;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record JobPostingRequestDto(
        @NotNull(message = "멤버 pk값은 필수 값입니다.")
        @Schema(description = "member pk입니다.")
        Long memberId,
        
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
                .member(MemberEntityV1.builder()
                        .id(memberId)
                        .build())
                .title(title)
                .company(company)
                .description(description)
                .createdAt(LocalDateTime.now())
                .build();
    }

}
