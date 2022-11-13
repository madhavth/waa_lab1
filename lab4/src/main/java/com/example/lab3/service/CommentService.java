package com.example.lab3.service;

import com.example.lab3.domain.dto.response.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getAllComments();

    CommentDto getCommentById(long id);

    void deleteCommentById(long id);

    void addComment(CommentDto commentDto);
}
