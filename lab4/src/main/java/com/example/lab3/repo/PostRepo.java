package com.example.lab3.repo;


import com.example.lab3.domain.Post;
import com.example.lab3.domain.dto.response.PostDto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface PostRepo extends CrudRepository<Post, Integer> {
    List<Post> findAll();
}
