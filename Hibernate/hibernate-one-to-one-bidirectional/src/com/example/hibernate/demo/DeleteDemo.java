package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.entity.Instructor;
import com.example.hibernate.entity.InstructorDetail;
import com.example.hibernate.entity.Student;

public class DeleteDemo {
	
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
			//start a transaction
			session.beginTransaction();
			
			//get the instructor by id
			int id= 1;
			
			//get the instructor object from session
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println("the instructor is "+instructor);
			
			if(instructor!=null)
			{
				//Will also delete the instructor details bcoz of cascadeType.ALL
				session.delete(instructor);
			}
			
			//commit transaction
			System.out.println("Commiting the transaction");
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
