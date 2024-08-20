package com.javis.aplication.repository;

import com.javis.aplication.dto.request.PostTestRequestDto;
import com.javis.aplication.entity.TestEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestRepository {
    private final TestJpaRepository testJpaRepository;

    public List<TestEntity> findAll() {
        return testJpaRepository.findAll();
    }

    public TestEntity save(PostTestRequestDto postTestRequestDto) {
        TestEntity testEntity = postTestRequestDto.toEntity();
        return testJpaRepository.save(testEntity);
    }

    @Service
    @RequiredArgsConstructor
    public static class TestService {
        private final TestRepository testRepository;

        public List<TestEntity> getAllTests() {
            return testRepository.findAll();
        }

        public TestEntity save(PostTestRequestDto postTestRequestDto) {
            return testRepository.save(postTestRequestDto);
        }

    }
}
