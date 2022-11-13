package com.example.lab3.domain;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;
}
