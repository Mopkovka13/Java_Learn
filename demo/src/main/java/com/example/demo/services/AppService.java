package com.example.demo.services;

import com.example.demo.models.Applications;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class AppService {
    private List<Applications> applications;

    @PostConstruct // Вызов метода сразу после инициализации свойств компонентов
    public void loadAppInDB(){
        Faker faker = new Faker();
        applications = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> Applications.builder()
                        .id(i)
                        .name(faker.app().name())
                        .author(faker.app().author())
                        .version(faker.app().version())
                        .build())
                .toList();

    }

    public List<Applications> allApplications() {
        return applications;
    }

    public Applications applicationById(int id){
        return applications.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
