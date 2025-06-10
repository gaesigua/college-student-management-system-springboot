package com.gasigwatin.college_student_management_system_springboot.course;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    // a. Business logic to Create new course (POST /api/courses)

    public CourseResponseDto createCourse(CourseDto courseDto){

        // Let's MAP the CourseDto TO our Course Entity

        var course = courseMapper.toCourse(courseDto);

        // Let's now save that new Course

        var savedCourse = courseRepository.save(course);

        // Let's now MAP the saved ENTITY back to the ResponseDto

        return courseMapper.toCourseResponseDto(savedCourse);
    }

    // b. Business logic to Get all courses (GET /api/courses) (With all the courses' details)

    public List<Course> retrieveAllCourses(){
        return courseRepository.findAll();
    }

    // c. Business logic to Get all courses (GET /api/courses-nodetails) (Without the courses' details)

    public List<CourseResponseDto> retrieveAllCoursesWithNoDetails(){
        return courseRepository.findAll().stream().map(courseMapper::toCourseResponseDto).collect(Collectors.toList());
    }

    // d. Business logic to Get course by ID (GET /api/courses/{id}) (With all the details)

    public Course retrieveCourseById(Integer courseId){
        return courseRepository.findById(courseId).orElse(new Course());
    }

    // e. Business logic to Get course by ID (GET /api/courses-nodetails/{id}) (Without the course details)

    public CourseResponseDto  retrieveCourseByIdWithNoDetails(Integer courseId){
        return courseRepository.findById(courseId).map(courseMapper::toCourseResponseDto).orElse(null);
    }

    // f. Business logic to Update existing course (PUT / api/courses/{id})

    public CourseResponseDto updateCourse(Integer courseId, CourseDto courseDto){

//        1. Let's first find the existing course

        Course existingCourse = courseRepository.findById(courseId).orElse(new Course());

//        2. Let's now update the fields of the existing entity with data from CourseDto

        existingCourse.setName(courseDto.name());
        existingCourse.setCode(courseDto.code());
        existingCourse.setDescription(courseDto.description());

//        3. Let's now save the updated entity

         Course updatedCourse = courseRepository.save(existingCourse);

//        4. Now Let's Map the updated entity back to a Response DTO

         return courseMapper.toCourseResponseDto(updatedCourse);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleResourceNotFoundException(MethodArgumentNotValidException exception){

       var errors = new HashMap<String, String>();

       exception.getBindingResult().getAllErrors().forEach(error->{
           var fieldName = ((FieldError)error).getField();
           var errorMessage = error.getDefaultMessage();
           errors.put(fieldName, errorMessage);
       });

       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // g. Business logic to delete one course

    public void deleteOneCourse(Integer courseId){
        courseRepository.deleteById(courseId);
    }
}
