package com.gasigwatin.college_student_management_system_springboot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

//       a. Create new course (POST /api/courses) (In Postman, it will return )

    @PostMapping("/api/courses")
    public CourseResponseDto createCourse(CourseDto courseDto){
        return courseService.createCourse(courseDto);
    }

}
