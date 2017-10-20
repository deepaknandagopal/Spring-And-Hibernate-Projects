package com.example.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TryController {
	
	//need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showFomr() {
		return "helloworld-form";
	}

}
