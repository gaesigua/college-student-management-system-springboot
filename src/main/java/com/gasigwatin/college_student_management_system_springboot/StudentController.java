package com.gasigwatin.college_student_management_system_springboot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

//    Create new student (POST /api/students)

    @PostMapping("/api/students")
    public StudentResponseDto createStudent(
            @RequestBody StudentDto studentDto){

        return studentService.createStudent(studentDto);
    }

}
