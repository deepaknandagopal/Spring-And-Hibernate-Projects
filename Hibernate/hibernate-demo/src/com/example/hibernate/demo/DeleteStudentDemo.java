package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.entity.Student;

public class DeleteStudentDemo {
	
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
			//start a transaction
			session.beginTransaction();
			
			int studentId = 1;
			//use the session object to save Java object
			System.out.println("Creating new Student object");
			Student student = session.get(Student.class, studentId);
			
			session.delete(student);
			
			//commit transaction
			System.out.println("Commiting the transaction");
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			//start a transaction
			session.beginTransaction();
			
			session.createQuery("delete from Student s where s.id=2").executeUpdate();
			
			//commit transaction
			System.out.println("Commiting the transaction");
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

}
