package com.example.lab3.service;

import com.example.lab3.domain.dto.response.PostDto;

import java.util.List;

public interface PostService {
   public List<PostDto> getPostsWithTitle(String title);
}
