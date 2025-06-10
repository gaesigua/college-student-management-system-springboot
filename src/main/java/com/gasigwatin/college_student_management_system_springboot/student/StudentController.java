package com.gasigwatin.college_student_management_system_springboot.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

//    a. Create new student (POST /api/students)

    @PostMapping("/api/students")
    public StudentResponseDto createStudent(
           @Valid @RequestBody StudentDto studentDto){

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

//    f. Update existing student (PUT /api/students/{student-id})

    @PutMapping("api/students/{student-id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable("student-id") Integer studentId, @RequestBody StudentDto studentDto) {

        return studentService.updateStudentById(studentId, studentDto);
    }

//    Let's handle the exception when the user forgets to enter their firstName or lastName (we made them @NotEmpty)

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){

        //        Here we are creating a Map that will hold two Strings for the Exception (one for the fieldName and one for the Message name)

        var errors =new HashMap<String, String>();

        exception.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((FieldError)error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }

//    g. delete one student (DELETE /api/students/{student-id})

    @DeleteMapping("/api/students/{student-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteStudent(@PathVariable("student-id") Integer studentId){

        studentService.deleteStudent(studentId);

    }



}
