package com.example.springdemo.mvc;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showFomr() {
		return "helloworld-form";
	}
	
	//need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//need a controlled method to read form data and
	//add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String addDatatoModel(HttpServletRequest httpServletRequest, Model model) {
		
		//read the request parameter from the HTML form
		String theName = httpServletRequest.getParameter("studentName");
		
		//convert the data to all uppercase
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Hello from Version 2"+theName + "!!!";
	
		//add the message to the model
		model.addAttribute("message",result);
		
		return "helloworld";
		
	}
	
	//need a controlled method to read form data and
	//add data to the model
	@RequestMapping("/processFormVersionThree")
	public String addDatatoModelVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		//convert the data to all upper case
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Hello from Version 3 "+theName + "!!!";
		
		//add the message to the model
		model.addAttribute("message",result);
		
		return "helloworld";
		
		}

}
