package ru.mopkovka.springstudents.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.mopkovka.springstudents.model.Student;
import ru.mopkovka.springstudents.repository.StudentRepository;
import ru.mopkovka.springstudents.service.StudentService;

import java.util.List;

@Service
@AllArgsConstructor
@Primary // Обозначает какая реализация интерфейса будет использоваться
//@Qualifier - почитать, можно брать один метод с одного сервиса, а друг с другого ?
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public List<Student> findAllStudent() {
        return repository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student findByEmail(String email) {
        return repository.findStudentByEmail(email);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(String email) {
        repository.deleteByEmail(email);
    }
}
