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
@Data
public class User {
    @Id
    long id;
    String name;

    @OneToMany
    @JoinColumn(name = "user_id")
    List<Post> posts;
}
