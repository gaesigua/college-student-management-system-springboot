package com.gasigwatin.college_student_management_system_springboot;

import jakarta.persistence.Column;

import java.time.LocalDate;

public record StudentDto(String firstName,
                         String lastName,
                         String email,
                         String phoneNumber,
                         LocalDate dateOfBirth,
                         String country) {
}
