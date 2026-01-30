package com.example.springbootloginpage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootloginpage.model.StudentModel;


@Repository
public interface StudentRepo extends JpaRepository<StudentModel, Long>{
	StudentModel findByEmail(String email);
}
