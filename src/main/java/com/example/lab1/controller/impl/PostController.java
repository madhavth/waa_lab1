package com.example.lab1.controller.impl;

import com.example.lab1.domain.PostV2;
import com.example.lab1.domain.dto.response.PostDto;
import com.example.lab1.domain.dto.response.PostV2Dto;
import com.example.lab1.service.impl.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/posts")
@RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping()
    public List<PostDto> getAllPosts(@RequestParam(required = false, name = "author") String author) {
        return postService.getAllPosts(author);
    }


    @GetMapping(headers = "api-version=2")
    public List<PostV2Dto> getAllPostsV2(@RequestParam(required = false, name = "author") String author) {
        return postService.getAllPostsV2(author);
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }


    @GetMapping(path = "/{id}", headers = "api-version-2")
    public PostV2Dto getPostByIdV2(@PathVariable int id) {
        return postService.getPostByIdV2(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addPost(@RequestBody PostDto postDto) {
        postService.addPost(postDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(headers = "api-version-2")
    public void addPostV2(@RequestBody PostV2Dto postV2Dto) {
        postService.addPostV2(postV2Dto);
    }

    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable int id) {
        postService.deleteById(id);
    }

    @DeleteMapping(path = "/{id}", headers = "api-version=2")
    public void deletePostByIdV2(@PathVariable int id) {
        postService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable int id, @RequestBody PostDto postDto) {
        postService.updatePost(id, postDto);
    }

    @PutMapping(value = "/{id}", headers = "api-version=2")
    public void updatePostV2(@PathVariable int id, @RequestBody PostV2Dto postV2Dto) {
        postService.updatePostV2(id, postV2Dto);
    }

}
