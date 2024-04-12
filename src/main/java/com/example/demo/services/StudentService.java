package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {

	Student createStudent(Student student);
	
	Student getStudentById(Long studentId);
	
	List<Student> getAllStudents();
	
	Student updateStudent(Student student);
	
	void deleteStudent(Long studentId);
}
