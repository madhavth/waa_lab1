package com.example.lab3.service.impl;

import com.example.lab3.domain.Post;
import com.example.lab3.domain.dto.response.PostDto;
import com.example.lab3.repo.PostRepo;
import com.example.lab3.service.PostService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PostRepo postRepo;

    @Override
    public List<PostDto> getPostsWithTitle(String title) {
        Stream<Post> postStream = postRepo.findAll().stream();

        if (title != null) {
            postStream = postStream.filter(post -> post.getTitle().equals(title));
        }

        return postStream.map(
                        post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deletePost(int id) {
        postRepo.deleteById(id);
    }

    @Override
    public PostDto getPost(int id) {
        Post post = postRepo.findById(id).orElse(null);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public void savePost(PostDto postDto) {
        postRepo.save(modelMapper.map(postDto, Post.class));
    }

    @Override
    public void updatePost(int id, PostDto postDto) {
        postDto.setId(id);
        postRepo.save(modelMapper.map(postDto, Post.class));
    }
}
