package com.javis.aplication.repository;

import com.javis.aplication.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestJpaRepository extends JpaRepository<TestEntity, Long> {
}
