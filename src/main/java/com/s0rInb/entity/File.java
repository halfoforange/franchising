package com.s0rInb.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(1024)")
    private String description;

    @Column(columnDefinition = "varchar(512)")
    private String url;

    @JoinColumn(name = "instruction")
    @ManyToOne
    private Instruction instruction;
}
