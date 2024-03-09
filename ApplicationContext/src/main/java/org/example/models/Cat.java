package org.example.models;

import org.springframework.stereotype.Component;

// applicationContext3.xml найдет и зарегистрирует Bean
@Component("catBean")
//@Component // Bean - По названию класса, первая буква прописная
public class Cat implements Pet {
    @Override
    public void voice() {
        System.out.print("Meaw");
    }
}
