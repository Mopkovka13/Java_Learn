package org.example.aspects;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

public class MyPointcuts {
    @Pointcut("execution(* add*(..))")
    public void allAddMethods() {}
}
