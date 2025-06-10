package com.gasigwatin.college_student_management_system_springboot;

import java.util.List;

public record CourseDto(String name,
                        char code,
                        String description,
                        Integer studentId) {
}
