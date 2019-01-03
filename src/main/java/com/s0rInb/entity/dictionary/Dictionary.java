package com.s0rInb.entity.dictionary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Size(max = 480)
    @NotNull
    @Column(name = "name", nullable = false)
    @Getter
    @Setter
    private String name;
}
