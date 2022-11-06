package com.example.lab3.repo;

import com.example.lab3.domain.Exception;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionRepo extends CrudRepository<Exception, Integer> {
}
