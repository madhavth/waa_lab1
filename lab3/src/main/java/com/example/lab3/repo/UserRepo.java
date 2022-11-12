package com.example.lab3.repo;

import com.example.lab3.domain.User;
import com.example.lab3.domain.dto.response.UserDto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    List<User> findAll();

    @Query("select u from users u where u.posts.size > :n")
    List<User> findAllPostGreaterThan(int n);

    User findUserByName(String userName);
}
