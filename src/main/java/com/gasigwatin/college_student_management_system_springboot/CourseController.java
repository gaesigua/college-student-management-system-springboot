package com.gasigwatin.college_student_management_system_springboot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

//       a. Create new course (POST /api/courses)

    @PostMapping("/api/courses")
    public Course createCourse(Course course){

        return courseRepository.save(course);
    }
}
