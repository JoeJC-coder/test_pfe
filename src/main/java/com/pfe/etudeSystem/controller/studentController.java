package com.pfe.etudeSystem.controller;

import com.pfe.etudeSystem.model.Student;
import com.pfe.etudeSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class studentController {
    @Autowired
    private StudentService studentService;
    private BCryptPasswordEncoder passwordEncoder;
    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "New student added";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return  studentService.getAllStudents();
    }

    @GetMapping("/get/{id}")
    public Optional<Student> getStudentsbyid(@PathVariable int id, Student student){
        if (!studentService.getStudentbyid(id).isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return studentService.getStudentbyid(id);
    }

    @GetMapping("/delete/{id}")
    public String deleteStudentsbyid(@PathVariable int id){
        if (!studentService.getStudentbyid(id).isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        studentService.deleteStudentbyid(id);
        return "Student has been deleted";
    }

    @PutMapping("/update/{id}")
    public String update(@RequestBody Student student, @PathVariable int id) {
        student.setId(id);
        studentService.updateStudentbyid(student);
        return "user updated";
    }

    @GetMapping("/encodage")
    public String test(){
        String password = "admin@admin";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return "Encoded password is " + passwordEncoder.encode(password);
    }
}
