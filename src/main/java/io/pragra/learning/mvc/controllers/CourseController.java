package io.pragra.learning.mvc.controllers;

import io.pragra.learning.mvc.domain.Course;
import io.pragra.learning.mvc.service.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/course")
    public Course course(@RequestBody Course course){
        return this.courseService.createCourse(course);
    }


}
