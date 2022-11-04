package com.example.lab2.controller;

import com.example.lab2.domain.dto.response.PostDto;
import com.example.lab2.domain.dto.response.UserDto;
import com.example.lab2.repo.UserRepo;
import com.example.lab2.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") int id) {
        return userService.findUserById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveUser(UserDto userDto) {
        userService.addUser(userDto);
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getUserPosts(@PathVariable int id) {
        return userService.getUserPosts(id);
    }
}
