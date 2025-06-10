package com.gasigwatin.college_student_management_system_springboot;

import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public CourseResponseDto createCourse(CourseDto courseDto){
        var course = courseMapper.toCourseDto(courseDto);
        var savedCourse = courseRepository.save(course);
        return courseMapper.toCourseResponseDto(savedCourse);
    }


}
