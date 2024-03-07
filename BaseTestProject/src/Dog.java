class Animal {
    private String name;
    private int age;

    public void sound() {
        System.out.println("Animal sound");
    }
}

public class Dog extends Animal {
    @Override
    public void sound() {
        super.sound();
        System.out.println("Woof");
    }

}