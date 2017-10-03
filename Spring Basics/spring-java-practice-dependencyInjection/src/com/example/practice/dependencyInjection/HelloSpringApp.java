package com.example.practice.dependencyInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		FootballCoach footballCoach = context.getBean("footballCoach",FootballCoach.class);
		
		System.out.println(footballCoach.getDailyFortune());
		System.out.println(footballCoach.getDailyFortune());
		System.out.println(footballCoach.getDailyFortune());
		System.out.println(footballCoach.getDailyWorkout());
		System.out.println(footballCoach.getDiet());

	}

}
