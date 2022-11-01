package com.example.lab1.service;

import com.example.lab1.domain.PostV2;
import com.example.lab1.domain.dto.Post;
import com.example.lab1.domain.dto.response.PostDto;
import com.example.lab1.domain.dto.response.PostV2Dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface PostService {
    public List<PostDto> getAllPosts(String author);

    public List<PostV2Dto> getAllPostsV2(String author);

    public PostDto getPostById(int id);


    public PostV2Dto getPostByIdV2(int id);

    public void addPost(PostDto postDto);

    public void addPostV2(PostV2Dto postDtoV2);


    public void deleteById(int id);

    public void updatePost(int id, PostDto postDto);

    public void updatePostV2(int id, PostV2Dto postV2Dto);
}
