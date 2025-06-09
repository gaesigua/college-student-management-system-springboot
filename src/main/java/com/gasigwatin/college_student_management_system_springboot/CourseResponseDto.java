package com.gasigwatin.college_student_management_system_springboot;

import java.util.List;

public record CourseResponseDto(
        String name,
        List<Student> student) {
}
