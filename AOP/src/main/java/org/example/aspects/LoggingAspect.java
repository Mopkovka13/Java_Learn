package org.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
    @Before("org.example.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature.getMethod());
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("return Type = " + methodSignature.getReturnType());
        System.out.println("name method = " + methodSignature.getName());
        System.out.println("beforeAddLoggingAdvice: логирование попытки получить книгу/журнал");

        if (methodSignature.getName().equals("addBook")) {
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                System.out.println("args = " + arg);
            }
        }
    }
}
