package com.pfe.etudeSystem.service;

import com.pfe.etudeSystem.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
}
