package com.example.spring_demo_annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
@ComponentScan("com.example.spring_demo_annotations")
//Comment @ComponentScan and run SwimJavaConfigDemoApp.java to avoid Annotation @ComponentScan
//and create a bean by config file
public class SportConfig {
	
	//define bean for our sad fortune service
	@Bean
	public  FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	//define bean for our swim coach and inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}
