package com.example.lab3.service.impl;

import com.example.lab3.domain.User;
import com.example.lab3.domain.dto.response.PostDto;
import com.example.lab3.domain.dto.response.UserDto;
import com.example.lab3.repo.UserRepo;
import com.example.lab3.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
class UserServiceImpl implements UserService {
    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    public UserRepo userRepo;

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepo.findAll();
        return users.stream().map(e -> modelMapper.map(e, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto findUserById(long id) {
        return modelMapper.map(userRepo.findById(id).orElse(null), UserDto.class);
    }

    @Override
    public void addUser(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
    }

    @Override
    public List<PostDto> getUserPosts(long id) {
        User user = userRepo.findById(id).orElse(null);
        return user.getPosts().stream().map(p -> modelMapper.map(p, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllPostGreaterThan(int n) {
        return userRepo.findAllPostGreaterThan(n).stream().map(
                user -> modelMapper.map(user, UserDto.class)
        ).collect(Collectors.toList());
    }

}
