package com.example.lab3.repo;

import com.example.lab3.domain.MyException;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionRepo extends CrudRepository<MyException, Integer> {
}
