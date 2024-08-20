package com.javis.aplication.service;

import com.javis.aplication.dto.PostTestRequestDto;
import com.javis.aplication.entity.TestEntity;
import com.javis.aplication.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public List<TestEntity> getAllTests() {
        return testRepository.findAll();
    }

    public TestEntity save(PostTestRequestDto postTestRequestDto) {
        return testRepository.save(postTestRequestDto);
    }

}
