package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {	
		//load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from the spring container
		CricketCoach coach = context.getBean("cricketCoach", CricketCoach.class);
		
		//call methods on the bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDiet());
		
		//method from the injected dependencies into the object
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getEmailAddress());
		System.out.println(coach.getTeam());
		//close the context
		context.close();
	}

}
