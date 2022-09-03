package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String password;

    @NotEmpty
    @Column(nullable = false, unique = true,
            columnDefinition = "varchar(50)")
    private String name;

    @Min(16)
    private int age;

    @NotEmpty
    private String address;
     private String email;

    private String phone;
    @OneToOne
    private Restaurants restaurant;


    @ManyToMany(targetEntity = Roles.class,fetch = FetchType.EAGER)
    @JoinTable(name = "user_role")
    private Set<Roles> roles;


}
