package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.entity.Student;

public class CreateStudentDemo {
	
	public static void main(String[] args) {
		//create a session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		System.out.println("Connection Successful");
		
		try {
			//use the session object to save Java object
			System.out.println("Creating new Student object");
			Student student = new Student("Deepak", "Kumar", "deepaknandagopal@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the object");
			session.save(student);
			
			//commit transaction
			System.out.println("Commiting the transaction");
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
