package com.example.lab3.service.impl;

import com.example.lab3.domain.Comment;
import com.example.lab3.domain.dto.response.CommentDto;
import com.example.lab3.repo.CommentRepo;
import com.example.lab3.service.CommentService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<CommentDto> getAllComments() {
        return commentRepo.findAll().stream().map(
                comment -> modelMapper.map(comment, CommentDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(long id) {
        Comment comment =  commentRepo.findById(id).orElse(null);
        return modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public void deleteCommentById(long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public void addComment(CommentDto commentDto) {
        commentRepo.save(modelMapper.map(commentDto, Comment.class));
    }
}
