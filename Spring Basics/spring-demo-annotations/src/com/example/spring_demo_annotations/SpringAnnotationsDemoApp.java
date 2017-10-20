package com.example.spring_demo_annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnotationsDemoApp {
	

	public static void main(String[] args) {
		
		//read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the bean from the spring container
		ChessCoach coach = context.getBean("chessCoach", ChessCoach.class);
		
		System.out.println(coach.getEmail());
		
		System.out.println(coach.getPhoneNo());
		
		//call the method on the bean
		System.out.println(coach.getDailyWorkout());
		
		System.out.println(coach.getDailyFortune());
		
		//close the context
		context.close();

	}

}
