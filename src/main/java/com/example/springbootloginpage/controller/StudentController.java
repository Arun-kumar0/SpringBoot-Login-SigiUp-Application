package com.example.springbootloginpage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springbootloginpage.model.StudentModel;
import com.example.springbootloginpage.service.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentController {
	
	@Autowired
    public StudentService studentservice;


    @GetMapping("/")
    public String showform(Model model) {
        model.addAttribute("studentModel", new StudentModel());
        return "login";
    }

    @PostMapping("/login")
    public String submitform(
            @Valid @ModelAttribute("studentModel") StudentModel studentmodel,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "login";
        }
        
        
        //save to databases
        studentservice.savestudent(studentmodel);

        model.addAttribute("msg", "Login Successfully");
        return "redirect:/";
    }
    
    @GetMapping("/signin")
    public String signinform(Model model) {
    	model.addAttribute("studentModel", new StudentModel());
    	return "signin";
    }
    
    @PostMapping("/signin")
    public String signin(@ModelAttribute StudentModel studentModel, Model model) {
    	
    	boolean valid = studentservice.validationuser(
    			studentModel.getEmail(),
    			studentModel.getPassword());
    	if (valid) {
            return "home";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "signin";
        }
    
    }

    // this code also same as getting the data into sql but in thymeleafe we dont to th:object 
//    @PostMapping("/signin")
//    public String signin(
//    		@RequestParam String email,
//    		@RequestParam String password,
//    		Model model) {
//    	
//    	boolean isValid = studentservice.validationuser(email, password);
//    	if (isValid) {
//            return "home"; // success page
//        } else {
//            model.addAttribute("error", "Invalid email or password");
//            return "signin";
//        }
//    
//    }
    
} 

