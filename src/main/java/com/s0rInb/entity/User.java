package com.s0rInb.entity;

import com.s0rInb.entity.dictionary.City;
import com.s0rInb.entity.dictionary.PointType;
import com.s0rInb.entity.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String password;

    @Column(unique = true, name = "login", nullable = false)
    private String login;
    @NotNull
    @Email
    private String email;

    @Column(name = "user_role")
    private UserRole userRole = UserRole.CUSTOMER;

    @Column(columnDefinition = "varchar(512)")
    private String name;

    @JoinColumn
    @ManyToOne
    private City city;

    @Column(columnDefinition = "varchar(512)")
    private String phone;

    @JoinColumn
    @ManyToOne
    private PointType pointType;

    @Column(columnDefinition = "varchar(1024)")
    private String address;

    private String places;

    private String energy;
    @Column(columnDefinition = "varchar(512)")
    private String manager;

    private String employees;
}
