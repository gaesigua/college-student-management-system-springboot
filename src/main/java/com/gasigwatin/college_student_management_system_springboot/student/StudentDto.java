package com.gasigwatin.college_student_management_system_springboot.student;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record StudentDto(
        @NotEmpty
        String firstName,

        @NotEmpty
        String lastName,

        String email,

        String phoneNumber,

        LocalDate dateOfBirth,

        String country) {
}
