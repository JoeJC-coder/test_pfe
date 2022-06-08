package com.pfe.etudeSystem.service;

import com.pfe.etudeSystem.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Optional<Student> getStudentbyid(int id);
    public void deleteStudentbyid(int id);
}
