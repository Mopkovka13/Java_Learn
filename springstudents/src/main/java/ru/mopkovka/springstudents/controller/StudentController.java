package ru.mopkovka.springstudents.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.mopkovka.springstudents.model.Student;
import ru.mopkovka.springstudents.service.StudentService;

import java.util.List;

@RestController
// Можно заменить на просто Controller, но тогда надо дописать у метода @ResponseBody
@RequestMapping("/students")
@AllArgsConstructor // внедрение зависимости через конструктор
public class StudentController {

    // @Autowired // Устаревший способ внедрения зависимости
    // @Qualifier("InMemoryStudentServiceImpl") // Устаревший способ внедрения зависимости
    private final StudentService service; // делегируем на Spring создание экземпляра = new StudentService();

    @GetMapping
    public List<Student> findAllStudent(){
        return service.findAllStudent();
    }

    // PathVariable позволяет передать входящие данные в виде URL
    // Если бы передано несколько параметров, то они были бы разделены символом "/"
    // public Student findStudentById(@PathVariable("email") String anotherEmail){
    @GetMapping("/{email}")
    public Student findStudentById(@PathVariable String email){
        return service.findByEmail(email);
    }

    // Request body сериализует входящие данные в объект Student
    // Response body десериализует входящие данные из объекта Student
    @PostMapping("save")
    public Student saveStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    // @RequestBody для JSON объекта
    @PutMapping("update")
    public Student updateStudent(@RequestBody Student student){
        return service.updateStudent(student);
    }

    @DeleteMapping("delete/{email}")
    public void deleteStudent(@PathVariable String email){
        service.deleteStudent(email);
    }
}
