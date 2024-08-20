package com.javis.aplication.controller;

import com.javis.aplication.dto.GemRequestDto;
import com.javis.aplication.dto.GemResponseDto;
import com.javis.aplication.service.GemService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gem")
@Slf4j
public class GemController {
    private final GemService gemService;
    @PostMapping("")
    @Operation(summary = "gem 생성 API 입니다.", description = "API for producing gem")
    public String ProduceGem(@RequestBody @Valid GemRequestDto gemRequestDto) {
        String jsonString = gemService.producingGemService(gemRequestDto.content());

        // Remove leading and trailing backticks if present
        String cleanJsonString = jsonString.trim();
        if (cleanJsonString.startsWith("```") && cleanJsonString.endsWith("```")) {
            cleanJsonString = cleanJsonString.substring(7, cleanJsonString.length() - 3).trim();
        }
        System.out.println(cleanJsonString);
//        GemResponseDto gemResponseDto = GemResponseDto.from(cleanJsonString);


        return cleanJsonString;
    }
}
