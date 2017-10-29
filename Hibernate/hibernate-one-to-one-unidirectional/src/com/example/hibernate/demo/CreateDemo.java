package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.entity.Instructor;
import com.example.hibernate.entity.InstructorDetail;
import com.example.hibernate.entity.Student;

public class CreateDemo {
	
	public static void main(String[] args) {
		//create a session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		System.out.println("Connection Successful");
		
		try {
			//create the objects
			Instructor instructor = new Instructor("Jaspher", "Oswald", "jazoswald@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/jaz",
					"musics");
			//associate the objects	
			instructor.setInstructorDetail(instructorDetail);

			//start a transaction
			session.beginTransaction();
		
			//use the session object to save Java object
			//This will also save instructor detail objects because of cascadeType.ALL
			System.out.println("saving Instructor "+instructor);
			session.save(instructor);
			
			//commit transaction
			System.out.println("Commiting the transaction");
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
