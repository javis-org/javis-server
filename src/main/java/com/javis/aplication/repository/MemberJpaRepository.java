package com.javis.aplication.repository;

import com.javis.aplication.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {
    MemberEntity findByEmailAndPassword(String email, String password);
}
