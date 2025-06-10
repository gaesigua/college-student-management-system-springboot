package com.gasigwatin.college_student_management_system_springboot.course;

import org.springframework.stereotype.Service;

@Service
public class CourseMapper {

//    Let's convert a CourseDto (request DTO) to a Course entity. This method is used when creating or updating a Course.

    public Course toCourse(CourseDto dto){

        var course = new Course();

        course.setName(dto.name());
        course.setCode(dto.code());
        course.setDescription(dto.description());
        return course;

    }

//    Let's now convert a Course entity to a CourseResponseDto (response DTO). This method is used when sending course details back in a response.

    public CourseResponseDto toCourseResponseDto(Course course){
        return new CourseResponseDto(course.getId(),course.getName(), course.getCode());
    }
}
