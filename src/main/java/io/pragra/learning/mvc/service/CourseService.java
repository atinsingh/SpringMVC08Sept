package io.pragra.learning.mvc.service;

import io.pragra.learning.mvc.domain.Course;
import io.pragra.learning.mvc.repo.CourseRepo;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class CourseService {

    private CourseRepo repo;

    public CourseService(CourseRepo repo) {
        this.repo = repo;
    }

    public Course getCourseByName(String name){
        return this.repo.findByCourseName(name);
    }

    public Course createCourse(Course course) {
        course.setStartDate(new Date());
        course.setEndDate(new Date(Instant.now().plusSeconds(27837837287L).toEpochMilli()));
        return this.repo.save(course);
    }
}
