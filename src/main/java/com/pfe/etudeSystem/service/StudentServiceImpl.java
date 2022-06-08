package com.pfe.etudeSystem.service;

import com.pfe.etudeSystem.model.Student;
import com.pfe.etudeSystem.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements  StudentService{
@Autowired
private studentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentbyid(int id) {
        return studentRepository.findById(id);
    }
    @Override
    public void deleteStudentbyid(int id) {
        studentRepository.deleteById(id);
    }
}
