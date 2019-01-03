package com.s0rInb.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String theme;

    @Column(columnDefinition = "text", nullable = false)
    private String description;

    @Column(columnDefinition = "varchar(2048)")
    private String attach;

    private LocalDate date;


    @PrePersist
    void prePersist(){
        date=LocalDate.now();
    }
}
