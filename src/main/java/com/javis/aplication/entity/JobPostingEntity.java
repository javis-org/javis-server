package com.javis.aplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "job_postings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JobPostingEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "member_id",
            nullable = false)
    private MemberEntity member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "answer_id",
            nullable = false)
    private AnswerEntity answer;

    @Column(name = "title", nullable = false)
    public String title;

    @Column(name = "compony", nullable = false)
    public String compony;

    @Column(name = "description")
    public String description;

    @Column(name = "created_at", nullable = false)
    public LocalDateTime createdAt;

    @Column(name = "updated_at")
    public LocalDateTime updatedAt;
}
