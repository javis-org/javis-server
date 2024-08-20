package com.javis.aplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "questions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class QuestionEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "answer_id",
            nullable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private AnswerEntity answer;

    @Column(name = "question", nullable = false)
    public String question;

    @Column(name = "size")
    public String size;
}
