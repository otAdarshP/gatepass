package com.securesidences.gatepass.service;

public interface StudentService {

    Student registerStudent = (Student student);

    Student registerStudent(Student student);

    List<Student> getAllStudents();
    student getStudentByID (Long id);
}
