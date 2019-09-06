/*
 * Controller
 */
package com.metacube.Student.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.Student.model.Student;
import com.metacube.Student.utils.ListStudent;

@Controller
public class StudentController {
	
	private static final Logger log = LoggerFactory.getLogger(StudentController.class);
	
	@Value("${home.message}")
	private String message;
	
	/**
	 * Mapping for home page
	 * @param model to pass values to view
	 * @return name of view
	 */
	@GetMapping("/home")
	public String home(Model model){
		model.addAttribute("message",message);
		return "home";
	}
	
	/**
	 * Get Mapping for Student Detail page
	 * @param model to pass values to view
	 * @return name of view
	 */
	@GetMapping("/StudentDetail")
	public String studentDetail(Model model){
		model.addAttribute(new Student());
		return "StudentDetail";
	}
	
	/**
	 * Post Mapping for Student Detail page
	 * @param student to be validated
	 * @param bindingResult contains errors
	 * @return name of view
	 */
	@PostMapping("/StudentDetail")
	public String addStudentDetail(@Validated Student student,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "StudentDetail";
		}else{
			log.info(student.getFirstName());
			log.info(student.getLastName());
			log.info(student.getFatherName());
			log.info(student.getEmail());
			log.info(student.getStudentClass());
			log.info(student.getAge());
			return "redirect:/home";
		}
	}
	
	/**
	 * Get Mapping to show student
	 * @param model to pass values to view
	 * @return name of view
	 */
	@GetMapping("/ShowStudent")
	public String showStudent(Model model){
		List<Student> students = new ArrayList<Student>();
        students.add(ListStudent.s1);
        students.add(ListStudent.s2);
        students.add(ListStudent.s3);
        students.add(ListStudent.s4);
        students.add(ListStudent.s5);
        model.addAttribute("students",students);
		return "showStudent";
	}
}