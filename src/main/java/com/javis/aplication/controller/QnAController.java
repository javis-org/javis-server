package com.javis.aplication.controller;

import com.javis.aplication.dto.request.QnARequestDto;
import com.javis.aplication.entity.QuestionWithAnswer;
import com.javis.aplication.service.QnAService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qna")
@RequiredArgsConstructor
@Tag(name = "QnA")
public class QnAController {

    private final QnAService qnAService;

    @PostMapping("/{jobPosting}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "QnA 추가 API")
    public int create(@RequestBody List<QnARequestDto> qnARequestDtoList, @PathVariable("jobPosting") Long jobPostingId) {
        return qnAService.create(qnARequestDtoList, jobPostingId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "QnA 조회 API")
    public List<QuestionWithAnswer> create(@RequestParam Long jobPostingId) {
        return qnAService.getQuestionWithAnswer(jobPostingId);
    }

}
