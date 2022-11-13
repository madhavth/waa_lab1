package com.example.lab3.repo;

import com.example.lab3.domain.Logger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoggerRepo extends CrudRepository<Logger, Integer> {
    List<Logger> findAll();
}
