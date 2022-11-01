package com.example.lab1.repo;

import com.example.lab1.domain.dto.Post;
import com.example.lab1.domain.dto.response.PostDto;

import java.util.List;

public interface PostRepo {
    public List<Post> getAllPosts();

    public Post getPostById(int id);

    public void addPost(Post post);

    void deleteById(int id);

    void updatePost(int id, Post post);
}
