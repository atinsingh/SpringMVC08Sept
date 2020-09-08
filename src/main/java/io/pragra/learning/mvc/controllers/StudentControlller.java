package io.pragra.learning.mvc.controllers;

import io.pragra.learning.mvc.domain.Student;
import io.pragra.learning.mvc.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentControlller {

    private StudentService studentService;

    public StudentControlller(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student createStudent(@RequestBody Student student) {
        return this.studentService.createStudent(student);
    }

    @GetMapping("/student")
    public List<Student> getAllStudent() {
        return this.studentService.getAllStudent();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Long id) {
        return this.studentService.getOneById(id);
    }

    @PostMapping("/student/{id}/course/{courseName}")
    public Student enrollToCOurse(@PathVariable Long id, @PathVariable String courseName) {
        return this.studentService.enrollCourse(id,courseName);
    }

}
