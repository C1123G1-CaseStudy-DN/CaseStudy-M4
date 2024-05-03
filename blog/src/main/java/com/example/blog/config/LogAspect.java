package com.example.blog.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LogAspect {

    //    @Pointcut("execution(* vn.codegym.controller.StudentController.showStudentList(..))")
//    @Pointcut("execution(* vn.codegym.controller.StudentController.show*(..))")
    @Pointcut("within(vn.codegym.controller.*)")
    public void allMethodPointCut() {
    }

    @Before("allMethodPointCut()")
    public void beforeCallMethod(JoinPoint joinPoint) {
        //ghi log - log4J
        System.out.println("Start method name: "
                + joinPoint.getSignature().getName()
                + " Time: " + LocalDateTime.now());
    }


    @AfterReturning("allMethodPointCut()")
    public void afterReturningCallMethod(JoinPoint joinPoint) {
        //ghi log - log4J
        System.out.println("End method name: "
                + joinPoint.getSignature().getName()
                + " Time: " + LocalDateTime.now());
    }
}
