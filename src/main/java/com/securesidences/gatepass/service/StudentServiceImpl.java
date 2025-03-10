package com.securesidences.gatepass.service;

import com.securesidences.gatepass.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student registerStudent(Student student){
        return studentRepository.save(student);
    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public student getStudentByID(Long id) {
        return studentRepository.findById(id)
                .orElseThrow (() -> new RuntimeException ("Details of the student not found."));
    }
}
