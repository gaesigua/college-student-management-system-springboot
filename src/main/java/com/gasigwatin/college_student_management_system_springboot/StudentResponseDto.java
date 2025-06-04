package com.gasigwatin.college_student_management_system_springboot;

import java.time.LocalDate;

public record StudentResponseDto(String firstName,
                                 String lastName,
                                 String country
                                 ) {
}
