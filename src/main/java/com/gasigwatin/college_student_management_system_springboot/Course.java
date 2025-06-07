package com.gasigwatin.college_student_management_system_springboot;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "COURSE_TABLE")
public class Course {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToMany
    @JoinColumn(name = "student_id")
    private List<Student> student;

    @Column(name = "COURSE_NAME")
    private String name;

    @Column(name = "COURSE_CODE")
    private char code;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

//    EMPTY CONSTRUCTOR

    public Course(){}

//    CONSTRUCTOR WITH ARGUMENTS

    public Course(String name, char code, String description, List<Student> student){
        this.name = name;
        this.code = code;
        this.description = description;
        this.student = student;
    }

//    GETTER AND SETTER FOR NAME

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

//    GETTER AND SETTER FOR CODE

    public void setCode(char code){
        this.code = code;
    }

    public char getCode(){
        return code;
    }

//    GETTER AND SETTER FOR DESCRIPTION

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

//    GETTER AND SETTER FOR STUDENT

    public void setStudent(List<Student> student){
        this.student = student;
    }

    public List<Student> getStudent(){
        return student;
    }

}
