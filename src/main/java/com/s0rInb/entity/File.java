package com.s0rInb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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
    @JsonBackReference
    private Instruction instruction;
}
