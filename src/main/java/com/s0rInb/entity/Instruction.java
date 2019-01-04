package com.s0rInb.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.s0rInb.entity.dictionary.Category;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Instruction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String theme;

    @Column(columnDefinition = "text", nullable = false)
    private String description;

    @OneToMany(mappedBy = "instruction")
    @JsonManagedReference
    private List<File> files;

    @ManyToOne
    @JoinColumn(name = "category", nullable = false)
    private Category category;
}
