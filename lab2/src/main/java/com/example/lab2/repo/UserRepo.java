package com.example.lab2.repo;

import com.example.lab2.domain.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    List<User> findAll();
}
