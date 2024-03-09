package org.example;

import org.example.models.Cat;
import org.example.models.Dog;
import org.example.models.Person;
import org.example.models.Pet;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        app.ConfigClass();
    }

    public void ConfigClass() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Person person = context.getBean("person", Person.class);
        person.heyPet();

        context.close();
    }

    // Ишем по аннотациям Component
    public void BeanAnnotation() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        /*Cat myCat = context.getBean("catBean", Cat.class);

        myCat.voice();*/

        Person person = context.getBean("person", Person.class);
        person.heyPet();

        context.close();
    }

    // Use applicationContext2.xml
    public void BeanScope() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        // Singlton - Общий для всех
        // Singlton - по умолчанию, создаст даже если мы не обращаемся к определенному Bean
        Dog myDog = context.getBean("myPet", Dog.class);
        Dog yourDog = context.getBean("myPet", Dog.class);
        myDog.v = "Meow";
        System.out.println(myDog == yourDog);
        myDog.voice();
        yourDog.voice();
        // Ссылаются на один объект в памяти, при изменении myDog изменится и yourDog

        // Prototype - создаст Bean только когда обратиться к Bean
        // Создает каждый раз новый бин Bean обращении

        context.close();
    }

    public void DIWithParamFromPropFile() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("myPersonWithPropFile", Person.class);

        person.heyPet();

        context.close();
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

        /*Person person = new Person(pet);
        person.heyPet();*/

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
