package org.example;

import org.example.models.Cat;
import org.example.models.Person;
import org.example.models.Pet;
import org.springframework.context.annotation.*;

// Все бины вручную
/*@Configuration
@ComponentScan("org.example")
public class MyConfig {
    // Без Autowired и Component можно вручную прописать в классе Bean

    // Название метода - idBean
    @Bean
    @Scope("singlton")
    public Pet catBean() {
        System.out.println("!!!"); // При Singloton выполнится 1 раз
        return new Cat();
    }

    @Bean
    public Person personBean() {
        return new Person(catBean());
    }
}*/

// Автоматически ищет по Component и Autowired
@Configuration
@ComponentScan("org.example") // где сканировать
@PropertySource("classpath:application.properties")
public class MyConfig {

}