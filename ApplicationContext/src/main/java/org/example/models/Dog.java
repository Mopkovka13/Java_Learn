package org.example.models;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog implements Pet{
    public String v = "Woof";
    public Dog() {
        System.out.println("Dog created");
    }

    @Override
    public void voice() {
        System.out.print(v);
    }

    // При prototype вызывается для каждого Bean
    @PostConstruct
    public void init() {
        System.out.println("Class Dog: init method");
    }

    // При prototype вызываться не будет
    @PreDestroy
    public void destroy() {
        System.out.println("Class Dog: destroy method");
    }
}
