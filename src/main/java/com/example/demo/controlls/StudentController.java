package com.example.demo.controlls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService ss;
	
	@PostMapping("create")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		Student savedStudent = ss.createStudent(student);
		return new ResponseEntity<>(savedStudent,HttpStatus.CREATED);
	}
	
	@GetMapping("Students")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students = ss.getAllStudents();
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long Id){
		Student getById = ss.getStudentById(Id);
		return new ResponseEntity<>(getById,HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student){
		student.setId(id);
		Student update = ss.updateStudent(student);
		return new ResponseEntity<>(update,HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
		ss.deleteStudent(id);
		return new ResponseEntity<>("Student successfully deleted",HttpStatus.OK);
	}
	
}
