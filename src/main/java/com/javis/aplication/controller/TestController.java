package com.javis.aplication.controller;

import com.javis.aplication.dto.GetTestResponseDto;
import com.javis.aplication.dto.PostTestRequestDto;
import com.javis.aplication.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Tag(name = "Test")
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);
    private final TestService testService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @Operation(summary = "Get 테스트 API")
    public List<GetTestResponseDto> getTest() {
        return testService.getAllTests()
                .stream()
                .map(GetTestResponseDto::from)
                .toList();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Post 테스트 API")
    public GetTestResponseDto postTest(@RequestBody PostTestRequestDto postTestRequestDto){
        GetTestResponseDto getTestResponseDto = GetTestResponseDto.from(testService.save(postTestRequestDto));
        log.info("성공 : {}", getTestResponseDto);
        return getTestResponseDto;
    }
}
