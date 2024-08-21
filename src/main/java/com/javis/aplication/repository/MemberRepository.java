package com.javis.aplication.repository;

import com.javis.aplication.entity.MemberEntity;
import com.javis.aplication.exception.MemberException.MemberNotFoundException;
import com.javis.aplication.exception.MemberException.MEMBER_EMAIL_CONFLICT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final MemberJpaRepository jpaRepository;

    public MemberEntity save(MemberEntity memberEntity) {
        return jpaRepository.save(memberEntity);
    }

    public MemberEntity findByEmailAndPassword(String email, String password) {
        return jpaRepository.findByEmailAndPassword(email, password).orElseThrow(MemberNotFoundException::new);
    }

    public MemberEntity findById(Long id) {
        return jpaRepository.findById(id).orElseThrow(MemberNotFoundException::new);
    }

    public Optional<MemberEntity> findByEmail(String email) {
        return jpaRepository.findByEmail(email);
    }
}
