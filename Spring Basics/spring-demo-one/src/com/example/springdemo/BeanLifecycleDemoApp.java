package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {
		
		//load the configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		//retrieve bean from the spring container
		Coach firstCoach = context.getBean("coach", Coach.class);
		
		System.out.println(firstCoach.getDailyWorkout());

		context.close();
	}

}
