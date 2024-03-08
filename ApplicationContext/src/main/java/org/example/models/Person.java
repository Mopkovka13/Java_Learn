package org.example.models;

public class Person {
    private String name;
    private int age;
    private Pet pet;

    public Person() { }
    public Person(Pet pet, String name, int age) {
        this.pet = pet;
        this.name = name;
        this.age = age;
    }
    public Person(Pet pet) {
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
