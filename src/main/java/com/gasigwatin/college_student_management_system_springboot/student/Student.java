package com.gasigwatin.college_student_management_system_springboot.student;

import com.gasigwatin.college_student_management_system_springboot.course.Course;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "STUDENT_TABLE")
public class Student {

//    FIELDS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    private Integer id;

    @ManyToMany
    @JoinTable(name = "course-studied", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50)
    private String lastName;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 10)
    private String phoneNumber;

    @Column(name = "DATE_OF_BIRTH", updatable = false)
    private LocalDate dateOfBirth;

    @Column(name = "COUNTRY", length = 200)
    private String country;

//    CONSTRUCTOR WITH NO ARGUMENTS

    public Student(){}

//    CONSTRUCTOR WITH ARGUMENTS

    public Student(String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth, String country){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
    }

//    GETTER AND SETTER FOR ID

    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }

    //    GETTER AND SETTER FOR COURSE

    public void setCourse(List<Course> courses){
        this.courses = courses;
    }

    public List<Course> getCourse(){
        return courses;
    }

//    GETTER AND SETTER FOR FIRST NAME

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }

//    GETTER AND SETTER FOR LAST NAME

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }

//    GETTER AND SETTER FOR EMAIL

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

//    GETTER AND SETTER FOR PHONE NUMBER

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

//    GETTER AND SETTER FOR DATE OF BIRTH

    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }

//    GETTER AND SETTER FOR COUNTRY

    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return country;
    }

}
