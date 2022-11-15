package com.example.lab3.controller;

import com.example.lab3.domain.dto.response.PostDto;
import com.example.lab3.domain.dto.response.UserDto;
import com.example.lab3.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/query")
    public List<UserDto> getUsersGreaterThanNPosts(@RequestParam(required = false) Integer posts) {
        return userService.findAllPostGreaterThan(posts);
    }


    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") int id) {
        return userService.findUserById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getUserPosts(@PathVariable int id) {
        return userService.getUserPosts(id);
    }

}
