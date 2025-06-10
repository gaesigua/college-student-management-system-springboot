package com.gasigwatin.college_student_management_system_springboot.student;

import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto){
        var student = new Student();

        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        student.setPhoneNumber(dto.phoneNumber());
        student.setDateOfBirth(dto.dateOfBirth());
        student.setCountry(dto.country());

        return student;
    }

    public StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(student.getFirstName(), student.getLastName(), student.getCountry());
    }
}
