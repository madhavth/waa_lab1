package com.example.lab2.repo;

import com.example.lab2.domain.Post;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends CrudRepository<Post, Integer> {
}
