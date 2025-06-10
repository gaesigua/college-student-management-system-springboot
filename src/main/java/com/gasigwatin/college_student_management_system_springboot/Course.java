package com.gasigwatin.college_student_management_system_springboot;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "COURSE_TABLE")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(mappedBy = "course")
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

    public Course(String name, char code, String description){
        this.name = name;
        this.code = code;
        this.description = description;
    }

//    GETTER AND SETTER FOR ID

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

//    GETTER AND SETTER FOR STUDENT

    public void setStudent(List<Student> student){
        this.student = student;
    }

    public List<Student> getStudent(){
        return student;
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

}
