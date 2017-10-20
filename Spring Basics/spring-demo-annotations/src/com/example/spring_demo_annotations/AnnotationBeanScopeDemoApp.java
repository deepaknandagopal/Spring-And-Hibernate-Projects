package com.example.spring_demo_annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean("chessCoach", Coach.class);
		
		Coach anotherCoach = context.getBean("chessCoach",Coach.class);
		
		boolean result = (coach==anotherCoach);
		
		System.out.println("\nPointing to the same object: "+result);
		
		System.out.println("\nMemory Location of the coach: "+coach);
		System.out.println("\nMemory Location of the coach: "+anotherCoach);
		
		//close the context
		context.close();

	}

}
