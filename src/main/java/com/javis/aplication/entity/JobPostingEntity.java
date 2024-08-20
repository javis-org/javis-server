package com.javis.aplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "job_postings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class JobPostingEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "member_id",
            nullable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private MemberEntity member;

    @Column(name = "title", nullable = false)
    public String title;

    @Column(name = "company", nullable = false)
    public String company;

    @Column(name = "description")
    public String description;

    @Column(name = "created_at", nullable = false)
    public LocalDateTime createdAt;

    @Column(name = "updated_at")
    public LocalDateTime updatedAt;
}
