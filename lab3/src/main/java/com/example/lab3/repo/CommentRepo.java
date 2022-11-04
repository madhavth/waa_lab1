package com.example.lab3.repo;

import com.example.lab3.domain.Comment;
import com.example.lab3.domain.dto.response.CommentDto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {
    List<Comment> findAll();
}
