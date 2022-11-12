package com.example.lab3.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class MyException {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    Integer transactionId;

    LocalDate date;

    LocalTime time;

    String principle;

    String operation;

    @Column(name = "exception_type")
    String exceptionType;
}
