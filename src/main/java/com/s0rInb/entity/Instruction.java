package com.s0rInb.entity;

import javax.persistence.*;
import java.util.List;

public class Instruction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String theme;

    @Column(columnDefinition = "text", nullable = false)
    private String description;

/*    @OneToMany(mappedBy = "files")
    private List<File> files;*/
}
