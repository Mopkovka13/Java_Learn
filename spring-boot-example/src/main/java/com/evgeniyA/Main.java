package com.evgeniyA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

// SpringBootApplication заменяет 3 интерфейса
// @ComponentScan(basePackages="com.evgeniyA")
// @Configuration
// @EnableAutoConfiguration
@SpringBootApplication
@RestController
@RequestMapping("api/v1/students")
public class Main {

    private final StudentRepository studentRepository;

    public Main(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentRepository.save(new Student(0, student.getName(), student.getEmail(), student.getAge()));
    }

    @GetMapping
    public List<Student> getStudents() {
        return  studentRepository.findAll();
    }

    public Student getStudentById() {
        return new Student();
    }

}

/*    class GreetResponse {
        private final  String greet;

        GreetResponse(String greet) {
            this.greet = greet;
        }

        @Override
        public String toString() {
            return "GreetResponse{" +
                    "greet='" + greet + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GreetResponse that = (GreetResponse) o;
            return Objects.equals(greet, that.greet);
        }

        @Override
        public int hashCode() {
            return Objects.hash(greet);
        }
    }*/
