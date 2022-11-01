package com.example.lab1.repo.impl;

import com.example.lab1.domain.dto.Post;
import com.example.lab1.repo.PostRepo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {

    private static List<Post> postsList;
    private static int postId = 100;

    static {
        postsList = new ArrayList<>() {{
            add(new Post(1, "Title 1", "contents", "Author"));
            add(new Post(2, "Title 2", "contents1", "Author2"));
            add(new Post(3, "Title 3", "contents2", "Author3"));
            add(new Post(4, "Title 4", "contents3", "Author4"));
        }};
    }

    @Override
    public List<Post> getAllPosts() {
        return postsList;
    }

    @Override
    public Post getPostById(int id) {
        return postsList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void addPost(Post post) {
        post.setId(++postId);
        postsList.add(post);
    }

    @Override
    public void deleteById(int id) {
        postsList.remove(postsList.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null));
    }

    @Override
    public void updatePost(int id, Post post) {
        postsList = postsList.stream().map(p -> {
            if(p.getId() == id) {
                return post;
            }
            return p;
        }).collect(Collectors.toList());
    }


}
