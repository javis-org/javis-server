package com.javis.aplication.repository;

import com.javis.aplication.entity.MemberEntity;
import com.javis.aplication.exception.MemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final MemberJpaRepository jpaRepository;

    public MemberEntity save(MemberEntity memberEntity) {
        return jpaRepository.save(memberEntity);
    }

    public MemberEntity findByEmailAndPassword(String email, String password) {
        return jpaRepository.findByEmailAndPassword(email, password).orElseThrow(MemberException.MemberNotFoundException::new);
    }
}
