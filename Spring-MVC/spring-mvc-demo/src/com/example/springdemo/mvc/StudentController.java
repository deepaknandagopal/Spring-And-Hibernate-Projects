package com.example.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.org.apache.regexp.internal.recompile;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model model)
	{
		//create a student object
		Student student = new Student();
		
		model.addAttribute("student",student);
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student)
	{
		//log the input data
		System.out.println("the Student: "+ student.getFirstName()+" "+ student.getLastName());
		return "student-confirmation";
	}
	
}
