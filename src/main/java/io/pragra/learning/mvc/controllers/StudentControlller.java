package io.pragra.learning.mvc.controllers;

import io.pragra.learning.mvc.domain.ErrorResponse;
import io.pragra.learning.mvc.domain.Student;
import io.pragra.learning.mvc.exceptions.StudentNotFoundExceptions;
import io.pragra.learning.mvc.service.StudentService;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestController
@RequestMapping("/api")
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




    @ApiParam(
            name = "id",
            value = "1",
            required = true
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Returns Student by Id", response = Student.class),
            @ApiResponse(code = 400, message = "Bad Request for id", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "No Student found", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "Not Implemeted", response = Void.class)
    })

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id) {
       return ResponseEntity.status(HttpStatus.OK).body(this.studentService.getOneById(id));
    }

    @PostMapping("/student/{id}/course/{courseName}")
    public Student enrollToCOurse(@PathVariable Long id, @PathVariable String courseName) {
        return this.studentService.enrollCourse(id,courseName);
    }

}
