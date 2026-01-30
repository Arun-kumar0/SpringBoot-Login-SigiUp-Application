package com.example.springbootloginpage.service;

import org.springframework.stereotype.Service;

import com.example.springbootloginpage.model.StudentModel;
import com.example.springbootloginpage.repository.StudentRepo;


@Service
public class StudentService {

	private final StudentRepo studentrepo;
	
	 public StudentService (StudentRepo studentrepo) {
		 this.studentrepo = studentrepo;
	 }
	 
	 public void savestudent(StudentModel model) {
		 StudentModel student = new StudentModel();
		 student.setName(model.getName());
		 student.setEmail(model.getEmail());
		 student.setPassword(model.getPassword());
		 
		 studentrepo.save(student);
	 }
	 
	 public boolean validationuser(String email, String password) {
		 StudentModel studentmodel = studentrepo.findByEmail(email);
		 
		 if(studentmodel==null) {
			 return false;
		 }
		 return studentmodel.getPassword().equals(password);
	 }

}
