package com.example.lab1.service.impl;

import com.example.lab1.domain.PostV2;
import com.example.lab1.domain.dto.Post;
import com.example.lab1.domain.dto.response.PostDto;
import com.example.lab1.domain.dto.response.PostV2Dto;
import com.example.lab1.repo.impl.PostRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    public List<PostDto> getAllPosts(String author) {
        Stream<Post> postStream = postRepo.getAllPosts().stream();

        if (author != null) {
            postStream = postStream.filter(p -> p.getAuthor().equals(author));
        }

        return postStream.map(p -> modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());
    }

    public List<PostV2Dto> getAllPostsV2(String author) {
        Stream<Post> postStream = postRepo.getAllPosts().stream();

        if (author != null) {
            postStream = postStream.filter(p -> p.getAuthor().equals(author));
        }

        return postStream.map(post -> modelMapper.map(post, PostV2.class)).map(p -> modelMapper.map(p, PostV2Dto.class))
                .collect(Collectors.toList());
    }

    public PostDto getPostById(int id) {
        Post post = postRepo.getPostById(id);
        return modelMapper.map(post, PostDto.class);
    }

    public PostV2Dto getPostByIdV2(int id) {
        Post post = postRepo.getPostById(id);
        PostV2 postV2 = modelMapper.map(post, PostV2.class);
        return modelMapper.map(postV2, PostV2Dto.class);
    }

    public void addPost(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        postRepo.addPost(post);
    }

    public void addPostV2(PostV2Dto postDtoV2) {
        PostV2 postV2 = modelMapper.map(postDtoV2, PostV2.class);
        Post post = modelMapper.map(postV2, Post.class);
        postRepo.addPost(post);
    }


    public void deleteById(int id) {
        postRepo.deleteById(id);
    }

    public void updatePost(int id, PostDto postDto) {
        postDto.setId(id);
        postRepo.updatePost(id, modelMapper.map(postDto, Post.class));
    }

    public void updatePostV2(int id, PostV2Dto postV2Dto) {
        postV2Dto.setId(id);
        PostV2 postV2 = modelMapper.map(postV2Dto, PostV2.class);
        Post post = modelMapper.map(postV2, Post.class);
        postRepo.updatePost(id, post);
    }
}
