package com.gasigwatin.college_student_management_system_springboot;

import org.springframework.stereotype.Service;

@Service
public class CourseMapper {

    public Course toCourseDto(CourseDto dto){
        var course = new Course();

        course.setName(dto.name());
        course.setCode(dto.code());
        course.setDescription(dto.description());

        var student = new Student();

        student.setId(dto.studentId());

        course.setStudent(student);

        return course;

    }

    public CourseResponseDto toCourseResponseDto(Course course){
        return new CourseResponseDto(course.getName(),course.getCode());

    }
}
