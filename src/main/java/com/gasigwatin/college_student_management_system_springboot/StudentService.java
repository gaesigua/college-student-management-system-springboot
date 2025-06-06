package com.gasigwatin.college_student_management_system_springboot;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper){
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;

    }

    public StudentResponseDto createStudent(StudentDto studentDto){

        var student = studentMapper.toStudent(studentDto);
        var savedStudent = studentRepository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public List<Student> retrieveAllStudents(){
        return studentRepository.findAll();
    }

    public List<StudentResponseDto> retrieveAllStudentsWithNoDetails(){
        return studentRepository.findAll().stream().map(studentMapper::toStudentResponseDto).collect(Collectors.toList());
    }

    public Student retrieveStudentById(Integer studentId){
        return studentRepository.findById(studentId).orElse(new Student());
    }

    public StudentResponseDto retrieveStudentByIdWithNoDetails(Integer studentId){
        return studentRepository.findById(studentId).map(studentMapper::toStudentResponseDto).orElse(null);
    }
}
