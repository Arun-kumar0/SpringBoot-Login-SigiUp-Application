package com.example.springbootloginpage.service;

import org.springframework.stereotype.Service;

import com.example.springbootloginpage.exception.StudentAlreadyExistsException;
import com.example.springbootloginpage.model.StudentModel;
import com.example.springbootloginpage.repository.StudentRepo;


@Service
public class StudentService {
	private final StudentRepo studentrepo;
	
	 public StudentService (StudentRepo studentrepo) {
		 this.studentrepo = studentrepo;
	 }
	 
	 public void savestudent(StudentModel model) {
		 
		// Check if email already exists
	        if (studentrepo.findByEmail(model.getEmail()).isPresent()) {
	            throw new StudentAlreadyExistsException("Email already registered");
	        }
	        
		 StudentModel student = new StudentModel();
		 student.setName(model.getName());
		 student.setEmail(model.getEmail());
		 student.setPassword(model.getPassword());
		 
		 studentrepo.save(student);
	 }
	 
	 public boolean validationuser(String email, String password) {
		 return studentrepo.findByEmail(email)
	                .map(student -> student.getPassword().equals(password))
	                .orElse(false);
	 }
}
