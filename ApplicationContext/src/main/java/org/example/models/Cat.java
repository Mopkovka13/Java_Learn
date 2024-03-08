package org.example.models;

public class Cat implements Pet{
    @Override
    public void voice() {
        System.out.print("Meaw");
    }
}
