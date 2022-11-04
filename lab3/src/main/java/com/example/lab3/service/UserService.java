package com.example.lab3.service;

import com.example.lab3.domain.dto.response.PostDto;
import com.example.lab3.domain.dto.response.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findUserById(int id);

    void addUser(UserDto userDto);

    List<PostDto> getUserPosts(int id);

    List<UserDto> findAllPostGreaterThan(int n);
}
