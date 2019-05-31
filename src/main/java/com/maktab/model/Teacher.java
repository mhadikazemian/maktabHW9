package com.maktab.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "teachers")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "teacher_code")
    private String teacherCode;

    @Column(name = "salary")
    private int salary;

    @Column(name = "birthday")
    private LocalDate birthday;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String teacherCode, int salary, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teacherCode = teacherCode;
        this.salary = salary;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teacherCode=" + teacherCode +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}//end of Teacher class
