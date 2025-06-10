package com.gasigwatin.college_student_management_system_springboot.course;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

//       a. Create new course (POST /api/courses)

    @PostMapping("/api/courses")
    public CourseResponseDto createCourse(@RequestBody CourseDto courseDto) {
        return courseService.createCourse(courseDto);
    }

//       b. Get all courses (GET /api/courses) (With all the courses' details)

    @GetMapping("/api/courses")
    public List<Course> retrieveAllCourses(){
        return courseService.retrieveAllCourses();
    }

//       c. Get all courses (GET /api/courses-nodetails) (Without the courses' details)

    @GetMapping("/api/courses-nodetails")
    public List<CourseResponseDto> retrieveAllCoursesWithNoDetails(){
        return courseService.retrieveAllCoursesWithNoDetails();
    }

//       d. Get course by ID (GET /api/courses/{id}) (With all the details)

    @GetMapping("/api/courses/{course-id}")
    public Course retrieveCourseById(@PathVariable("course-id") Integer courseId){
        return courseService.retrieveCourseById(courseId);
    }

//       e. Get course by ID (GET /api/courses/{id} (With no details)

    @GetMapping("api/courses-nodetails/{course-id}")
    public CourseResponseDto retrieveCourseByIdWithNoDetails(@PathVariable("course-id") Integer courseId){
        return courseService.retrieveCourseByIdWithNoDetails(courseId);
    }

//       f. PUT /api/courses/{id} (Update existing course)
    




//       g. DELETE /api/courses/{id} (Delete course)

    @DeleteMapping("/api/courses/{course-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteOneCourse(@PathVariable("course-id") Integer courseId){
        courseService.deleteOneCourse(courseId);
    }

}
