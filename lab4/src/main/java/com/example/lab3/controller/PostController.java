package com.example.lab3.controller;

import com.example.lab3.aspects.annotations.ExecutionTime;
import com.example.lab3.domain.dto.response.PostDto;
import com.example.lab3.repo.PostRepo;
import com.example.lab3.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/posts")
@RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/throw")
    public void throwException() throws Exception {
        throw new Exception("this is a new exception unchecked");
    }

    @ExecutionTime
    @GetMapping
    public List<PostDto> findAllPostsWithTitle(@RequestParam(required = false) String title) {
        return postService.getPostsWithTitle(title);
    }
}
