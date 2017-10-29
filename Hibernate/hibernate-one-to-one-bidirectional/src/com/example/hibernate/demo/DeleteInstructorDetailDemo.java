package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.entity.Instructor;
import com.example.hibernate.entity.InstructorDetail;
import com.example.hibernate.entity.Student;

public class DeleteInstructorDetailDemo {
	
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
			int id= 3;
			
			//get the instructor object from session
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			System.out.println("The Instructor is "+instructorDetail);
			System.out.println("The InstructorDetail is "+instructorDetail.getInstructor());
			
			if(instructorDetail!=null)
			{
				//remove the associated reference
				//break the bi directional link
				instructorDetail.getInstructor().setInstructorDetail(null);
				
				System.out.println("Deteling the InstructorDetails");
				//Will also delete the instructor details bcoz of cascadeType.ALL
				session.delete(instructorDetail);
			}
			
			
			
			//commit transaction
			System.out.println("Commiting the transaction");
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
