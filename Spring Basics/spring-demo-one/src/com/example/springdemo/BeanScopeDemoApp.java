package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load the configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//retrieve bean from the spring container
		Coach firstCoach = context.getBean("coach", Coach.class);
		
		Coach secondCoach = context.getBean("coach", Coach.class);
		
		//check if they are same bean
		boolean result = (firstCoach == secondCoach);
		
		System.out.println("\nPointing to same object: "+ result);
		System.out.println("\n Memory loaction for the first coach: "+firstCoach);
		System.out.println("\n Memory loaction for the second coach: "+secondCoach);

	}

}
