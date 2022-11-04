package com.example.lab2.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    private long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Post> post;
}
