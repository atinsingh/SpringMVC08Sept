package io.pragra.learning.mvc.service;

import io.pragra.learning.mvc.domain.Course;
import io.pragra.learning.mvc.domain.Student;
import io.pragra.learning.mvc.exceptions.StudentNotFoundExceptions;
import io.pragra.learning.mvc.repo.CourseRepo;
import io.pragra.learning.mvc.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    private StudentRepo repo;
    private CourseService service;

    public StudentService(StudentRepo repo, CourseService service) {
        this.repo = repo;
        this.service = service;
    }

    public Student createStudent(Student student) {
        if (student.getEnrolledCourse() == null) {
            student.setEnrolledCourse(new ArrayList<>());
        }
        student.setCreateDate(new Date());
        student.setUpdateDate(new Date());

        return this.repo.save(student);
    }

    public Student enrollCourse(Long studentId,String courseName) {
        Course course = service.getCourseByName(courseName);
        if(course!=null) {
            //
        }
        this.repo.findById(studentId).ifPresent(
                s->{
                    s.getEnrolledCourse().add(course);
                    this.repo.save(s);

                }
        );
        return this.repo.findById(studentId).get();
    }

    public List<Student> getAllStudent() {
        return this.repo.findAll();
    }

    public Student getOneById(Long id) {
        return this.repo.findById(id).orElseThrow(
                ()->new StudentNotFoundExceptions( "No Such Student in Database"));
    }
}
