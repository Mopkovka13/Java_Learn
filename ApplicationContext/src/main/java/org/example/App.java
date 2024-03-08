package org.example;

import org.example.models.Dog;
import org.example.models.Person;
import org.example.models.Pet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        app.DIWithCtor();
    }

    public void DIWithSetter() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("myPersonSet", Person.class);

        person.heyPet();

        context.close();
    }

    public void DIWithCtor() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("myPerson", Person.class);

        person.heyPet();

        context.close();
    }

    public void WithoutDI() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Pet pet = context.getBean("myPet", Pet.class);

        Person person = new Person(pet);
        person.heyPet();

        context.close();
    }

    public void IoCXml() {
        // IoC with Xml container
        Pet pet = new Dog();
        pet.voice();

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Pet pet2 = context.getBean("myPet", Pet.class);
        pet2.voice();

        context.close();
    }
}
