package com.example.spring_demo_annotations;

import java.lang.annotation.Annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
	

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get the bean from the spring container
		SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
		
		//call the method on the bean
		System.out.println(coach.getDailyWorkout());
		
		System.out.println(coach.getDailyFortune());
		
		//get the injected values from property file
		System.out.println("Email : "+coach.getEmail());
		System.out.println("Phone no : "+coach.getTeam());
		
		//close the context
		context.close();

	}

}
