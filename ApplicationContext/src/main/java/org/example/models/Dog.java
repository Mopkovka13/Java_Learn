package org.example.models;

public class Dog implements Pet{
    @Override
    public void voice() {
        System.out.print("Woof");
    }
}
