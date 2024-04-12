package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository sr;

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return sr.save(student);
	}

	@Override
	public Student getStudentById(Long studentId) {
		// TODO Auto-generated method stub
		Optional<Student> opt = sr.findById(studentId);
		return opt.get();
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		Student existStudent = sr.findById(student.getId()).get();
		existStudent.setName(student.getName());
		existStudent.setEmail(student.getEmail());
		Student update = sr.save(existStudent);
		return  update;
	}

	@Override
	public void deleteStudent(Long studentId) {
		// TODO Auto-generated method stub
		sr.deleteById(studentId);
		
	}
	
	
}
