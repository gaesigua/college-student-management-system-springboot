package com.gasigwatin.college_student_management_system_springboot.course;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    // a. Business logic to Create new course (POST /api/courses)

    public CourseResponseDto createCourse(CourseDto courseDto){

        // Let's MAP the CourseDto TO our Course Entity

        var course = courseMapper.toCourse(courseDto);

        // Let's now save that new Course

        var savedCourse = courseRepository.save(course);

        // Let's now MAP the saved ENTITY back to the ResponseDto

        return courseMapper.toCourseResponseDto(savedCourse);
    }

    // b. Business logic to Get all courses (GET /api/courses) (With all the courses' details)

    public List<Course> retrieveAllCourses(){
        return courseRepository.findAll();
    }

    // c. Business logic to Get all courses (GET /api/courses-nodetails) (Without the courses' details)

    public List<CourseResponseDto> retrieveAllCoursesWithNoDetails(){
        return courseRepository.findAll().stream().map(courseMapper::toCourseResponseDto).collect(Collectors.toList());
    }

    // d. Business logic to Get course by ID (GET /api/courses/{id}) (With all the details)

    public Course retrieveCourseById(Integer courseId){
        return courseRepository.findById(courseId).orElse(new Course());
    }

    // e. Business logic to Get course by ID (GET /api/courses-nodetails/{id}) (Without the course details)

    public CourseResponseDto  retrieveCourseByIdWithNoDetails(Integer courseId){
        return courseRepository.findById(courseId).map(courseMapper::toCourseResponseDto).orElse(null);
    }

    // f.



    // g. Business logic to delete one course

    public void deleteOneCourse(Integer courseId){
        courseRepository.deleteById(courseId);
    }
}
