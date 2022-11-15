package com.example.lab3.service;

import com.example.lab3.domain.dto.response.PostDto;

import java.util.List;

public interface PostService {
   public List<PostDto> getPostsWithTitle(String title);

   void deletePost(int id);
   
   PostDto getPost(int id);
   
   void savePost(PostDto postDto);
   
   void updatePost(int id, PostDto postDto);
}
