package ru.mopkovka.springstudents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mopkovka.springstudents.model.Student;

//@Repository - нет смысла писать, автоматически подставляется
public interface StudentRepository extends JpaRepository<Student, Long> {
    void deleteByEmail(String email);

    Student findStudentByEmail(String email);
}
