package com.evgeniyA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// SpringBootApplication заменяет 3 интерфейса
// @ComponentScan(basePackages="com.evgeniyA")
// @Configuration
// @EnableAutoConfiguration
@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public String greet() {
        return "Hello";
    }
}
