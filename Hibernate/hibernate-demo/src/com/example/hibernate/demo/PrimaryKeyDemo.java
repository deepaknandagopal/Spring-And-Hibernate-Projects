package com.example.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.entity.Student;

public class PrimaryKeyDemo {

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
			//Create 3 student Objects
			System.out.println("Creating new Student object");
			Student tempStudent = new Student("michel", "jackson", "jackson@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the object");
			session.save(tempStudent);
			
			//commit transaction
			System.out.println("Commiting the transaction. Generated id: "+tempStudent.getId());
			session.getTransaction().commit();
			
			
			//now geta new session and start the trans
			session = factory.getCurrentSession();
			session.beginTransaction();
			//retreive the student
			System.out.println("\nGetting the Student with id:"+tempStudent.getId());
			
			Student student = session.get(Student.class,tempStudent.getId());
			
			System.out.println("Get Complete: "+student);
			//commit the transcation
			System.out.println("Retrieved");
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}
}
