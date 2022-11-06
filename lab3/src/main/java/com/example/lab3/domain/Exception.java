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
public class Exception {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    Integer transactionId;

    LocalDate date;

    LocalTime time;

    @OneToOne(cascade = CascadeType.MERGE)
    User principle;

    String operation;

    @Column(name = "exception_type")
    String exceptionType;
}
