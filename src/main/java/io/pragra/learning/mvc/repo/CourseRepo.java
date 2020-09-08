package io.pragra.learning.mvc.repo;

import io.pragra.learning.mvc.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
    Course findByCourseName(String name);
}
