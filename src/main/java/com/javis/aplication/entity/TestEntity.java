package com.javis.aplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "name", nullable = false, length = 20)
    public String name;

    @Column(name = "description",length = 255)
    public String description;

}
