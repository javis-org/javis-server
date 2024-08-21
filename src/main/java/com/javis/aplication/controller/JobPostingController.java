package com.javis.aplication.controller;

import com.javis.aplication.dto.request.JobPostingRequestDto;
import com.javis.aplication.dto.request.JobPostingUpdateRequestDto;
import com.javis.aplication.dto.response.JobPostingResponseDto;
import com.javis.aplication.service.JobPostingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobPostings")
@RequiredArgsConstructor
@Tag(name = "JobPosting")
public class JobPostingController {

    private final JobPostingService jobPostingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "JD 추가 API")
    public JobPostingResponseDto create(JobPostingRequestDto jobPostingRequestDto){
        return jobPostingService.create(jobPostingRequestDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "JD 수정 API")
    public JobPostingResponseDto update(JobPostingUpdateRequestDto jobPostingUpdateRequestDto){
        return jobPostingService.update(jobPostingUpdateRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "유저의 JD 전체 조회 API")
    public List<JobPostingResponseDto> findAll(
            @RequestParam
            @Parameter(
                    name = "memberId",
                    description = "member pk입니다.",
                    required = true)
            Long memberId
    ){
        return jobPostingService.findAll(memberId);
    }

    @GetMapping("/{jobPostingId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "JD 조회(pk 사용) API")
    public JobPostingResponseDto findById(@PathVariable Long jobPostingId){
        return jobPostingService.findById(jobPostingId);
    }
}
