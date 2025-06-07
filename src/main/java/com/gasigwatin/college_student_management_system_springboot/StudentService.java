package com.gasigwatin.college_student_management_system_springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
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

    public ResponseEntity<Student> updateStudentById(@PathVariable("student-id") Integer studentId, @RequestBody StudentDto studentDto) {

        // 1. Let's first retrieve the existing student from the database/service based on the studentID, and if the student is not available we will print out the NotFound exception

        Student savedStudent = retrieveStudentById(studentId);

        if (savedStudent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // 2. Now that we have found the student, let's update their fields with new details (Here we are setting the details we can update).

        savedStudent.setFirstName(studentDto.firstName());
        savedStudent.setLastName(studentDto.lastName());
        savedStudent.setPhoneNumber(studentDto.phoneNumber());
        savedStudent.setDateOfBirth(studentDto.dateOfBirth());
        savedStudent.setCountry(studentDto.country());


        // 3. Let's save the updated student back to the database/service.

        Student updatedStudent = updateStudent(savedStudent);

        // 4. Return the updated user with an OK status (200).

        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    public Student updateStudent(Student student){
        Optional<Student> savedStudentOptional = studentRepository.findById(student.getId());

        if (savedStudentOptional.isPresent()){

            Student foundStudent = savedStudentOptional.get();

            //Now let's update the fields of the found student

            foundStudent.setFirstName(student.getFirstName());
            foundStudent.setLastName(student.getLastName());
            foundStudent.setCountry(student.getCountry());
        return studentRepository.save(foundStudent);

        }else {
            System.out.println("Student with ID: " + student.getId() + " was not found for update!");
            return null;
        }
    }

    public void deleteStudent(Integer studentId){
        studentRepository.deleteById(studentId);
    };

}
