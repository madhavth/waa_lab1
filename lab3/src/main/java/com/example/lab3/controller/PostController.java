package com.example.lab3.controller;

import com.example.lab3.aspects.annotations.ExecutionTime;
import com.example.lab3.domain.dto.response.PostDto;
import com.example.lab3.repo.PostRepo;
import com.example.lab3.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/posts")
@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*", originPatterns = "*")
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

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") int id) {
        postService.deletePost(id);
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable("id") int id) {
        return postService.getPost(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addPost(@RequestBody PostDto postDto) {
        postService.savePost(postDto);
    }

    @PutMapping("/{id}")
    public void updatePost(@RequestBody PostDto postDto, @PathVariable("id") int id) {
        postService.updatePost(id, postDto);
    }
}
