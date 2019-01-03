package com.s0rInb.entity;

import com.s0rInb.entity.dictionary.Category;
import com.s0rInb.entity.dictionary.City;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @ManyToMany
    @JoinTable(name = "news_city",
            joinColumns = @JoinColumn(name = "news_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "city_id", nullable = false))
    private List<City> city;

    @PrePersist
    void prePersist() {
        date = LocalDate.now();
    }
}
