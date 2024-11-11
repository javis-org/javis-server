package com.javis.aplication.repository;

import com.javis.aplication.entity.MemberEntityV1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<MemberEntityV1, Long> {
    Optional<MemberEntityV1> findByEmailAndPassword(String email, String password);
    Optional<MemberEntityV1> findByEmail(String email);
}
