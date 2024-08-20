package com.javis.aplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "members")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class MemberEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "email", nullable = false, length = 50)
    public String email;

    @Column(name = "password", nullable = false, length = 20)
    public String password;

    @Column(name = "name", nullable = false, length = 20)
    public String name;
}
