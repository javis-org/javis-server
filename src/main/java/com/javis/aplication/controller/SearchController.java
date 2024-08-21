package com.javis.aplication.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Search")
@RequiredArgsConstructor
@Tag(name = "Search")
public class SearchController {
    // TODO : 제목, Question, Answer 조회 기능 구현
}
