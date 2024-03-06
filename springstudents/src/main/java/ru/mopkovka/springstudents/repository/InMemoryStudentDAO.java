package ru.mopkovka.springstudents.repository;

import org.springframework.stereotype.Repository;
import ru.mopkovka.springstudents.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryStudentDAO {
    // Final - const
    private final List<Student> STUDENTS = new ArrayList<>();

    public List<Student> findAllStudent(){
        return STUDENTS;
    }

    public Student saveStudent(Student student) {
        STUDENTS.add(student);
        return student;
    }

    public Student findByEmail(String email) {
        return STUDENTS.stream()
                .filter(student -> student.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Student updateStudent(Student student) {
        var studentIndex = IntStream.range(0, STUDENTS.size())
                .filter(i -> STUDENTS.get(i).getEmail().equals(student.getEmail()))
                .findFirst()
                .orElse(-1);
        if (studentIndex > -1){
            STUDENTS.set(studentIndex, student);

            return student;
        }

        return null;
    }

    public void deleteStudent(String email) {
        STUDENTS.removeIf(student -> student.getEmail().equals(email));
    }
}
