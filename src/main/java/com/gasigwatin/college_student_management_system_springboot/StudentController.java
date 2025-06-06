package com.gasigwatin.college_student_management_system_springboot;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;
    private final StudentRepository studentRepository;

    public StudentController(StudentService studentService,
                             StudentRepository studentRepository){
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

//    a. Create new student (POST /api/students)

    @PostMapping("/api/students")
    public StudentResponseDto createStudent(
            @RequestBody StudentDto studentDto){

        return studentService.createStudent(studentDto);
    }

//    b. Get all students (GET /api/students) (HERE WITH EACH STUDENT'S DETAILS EXPOSED)

    @GetMapping("/api/students")
    public List<Student> retrieveAllStudents(){

        return studentService.retrieveAllStudents();
    }

//    c. Get all students (Get /api/students) (HERE WITH ONLY FEW DETAILS EXPOSED)

    @GetMapping("/api/students-nodetails")
    public List<StudentResponseDto> retrieveAllStudentsWithNoDetails(){
        return studentService.retrieveAllStudentsWithNoDetails();
    }

//    d. Get student by ID (GET /api/students/{student-id})

    @GetMapping("/api/students/{student-id}")
    public Student retrieveStudentById(@PathVariable("student-id") Integer studentId){
        return studentService.retrieveStudentById(studentId);
    }

//    e. Get student by ID (GET /api/students-nodetails/{student-id})

    @GetMapping("/api/students-nodetails/{student-id}")
    public StudentResponseDto retrieveStudentByIdWithNoDetails(@PathVariable("student-id") Integer studentId){
        return studentService.retrieveStudentByIdWithNoDetails(studentId);
    }

}
