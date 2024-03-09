package org.example.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Value("Stas")
    private String name;

    @Value("${person.age}")
    private int age;

    @Qualifier("dog")
    private Pet pet;

/*    public Person() { }*/
    public Person(Pet pet, String name, int age) {
        this.pet = pet;
        this.name = name;
        this.age = age;
    }

    @Autowired()
    public Person(@Qualifier("dog") Pet pet) {
        System.out.println("a");
        this.pet = pet;
    }

    @Autowired
    @Qualifier("dog")
    private void anyMethodName(Pet pet) {
        System.out.println("b");
        this.pet = pet;
    }
    // Важно правильно называть для DI через Setter
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void heyPet() {
        System.out.println("I am " + name + ": " + age + "\nHello my pet");
        pet.voice();
    }
}
