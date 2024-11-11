package com.javis.aplication.repository;

import com.javis.aplication.entity.MemberEntityV1;
import com.javis.aplication.exception.MemberException.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final MemberJpaRepository jpaRepository;

    public MemberEntityV1 save(MemberEntityV1 memberEntityV1) {
        return jpaRepository.save(memberEntityV1);
    }

    public MemberEntityV1 findByEmailAndPassword(String email, String password) {
        return jpaRepository.findByEmailAndPassword(email, password).orElseThrow(MemberNotFoundException::new);
    }

    public MemberEntityV1 findById(Long id) {
        return jpaRepository.findById(id).orElseThrow(MemberNotFoundException::new);
    }

    public Optional<MemberEntityV1> findByEmail(String email) {
        return jpaRepository.findByEmail(email);
    }
}
