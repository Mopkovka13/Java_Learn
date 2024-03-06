package ru.mopkovka.springstudents.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

/*@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor*/
/*Data включает все + HashCode и Equels*/
@Data
//@Builder // Почитать про него, помогает создавать классы
@Entity // Создание таблицы в базе данных
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    //@NonNull
    @Column(unique = true)
    private String email;
    @Transient // age будет генерироваться на основе даты рождения
    // Поле возраст при этом не будет сгенерировано в базе данных, оно будет сгенерировано в приложении относительно даты рождения
    private int age;

    // Автоматически рассчитать возраст от даты рождения
    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}
