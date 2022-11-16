package com.example.lab3.aspects;

import com.example.lab3.domain.Exception;
import com.example.lab3.domain.Logger;
import com.example.lab3.domain.User;
import com.example.lab3.repo.ExceptionRepo;
import com.example.lab3.repo.LoggerRepo;

import net.bytebuddy.implementation.bytecode.Throw;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.hibernate.mapping.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    LoggerRepo loggerRepo;

    @Autowired
    ExceptionRepo exceptionRepo;

    @Pointcut("@annotation(com.example.lab3.aspects.annotations.ExecutionTime)")
    public void useExecutionTime() {
    }

    @Pointcut("execution(* com.example.lab3.controller..*(..))")
    public void allMethodExecutions() {
    }


    @AfterThrowing(value = "allMethodExecutions()", throwing = "exception", argNames = "joinPoint,exception")
    public void afterExceptionThrown(JoinPoint joinPoint, java.lang.Exception exception) {
        String exceptionType = exception.getClass().getName();
        Exception customException = new Exception();

        customException.setDate(LocalDate.now());
        customException.setTime(LocalTime.now());
        customException.setExceptionType(exceptionType);

        // custom fake user
//        User user = new User();
//        user.setName("Testing fake user");
//        customException.setPrinciple(user);

        customException.setOperation(joinPoint.getSignature().getName());
        exceptionRepo.save(customException);
    }


    @Before("allMethodExecutions()")
    public void beforeAllMethodsExecution(JoinPoint jointPoint) {
        Logger logger = new Logger();
        logger.setDate(LocalDate.now());
        logger.setTime(LocalTime.now());
        logger.setOperation(jointPoint.getSignature().getName());

        // fake user principle
//        User user = new User();
//        user.setName("Fake User");
//        logger.setPrinciple(user);
        loggerRepo.save(logger);
    }


    @Around("useExecutionTime()")
    public Object aroundExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.nanoTime();
        Object proceeding = pjp.proceed();
        long endTime = System.nanoTime();

        System.out.printf("Time taken to complete function %s is %d ms\n\n\n\n",
                pjp.getSignature().getName(),
                endTime - startTime
        );
        return proceeding;
    }

}
