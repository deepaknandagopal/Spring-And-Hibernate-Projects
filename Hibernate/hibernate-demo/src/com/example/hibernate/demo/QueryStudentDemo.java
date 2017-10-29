package com.example.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.entity.Student;

public class QueryStudentDemo {
	
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
			
			//query student
			List<Student> students = session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudents(students);
			
			System.out.println("\n\nStudents who have lastname of Kumar");
			
			//query where lastname="kumar"
			students = session.createQuery("from Student s where s.lastName='Kumar'").getResultList();
			displayStudents(students);
			
			System.out.println("\n\nStudents who have lastname of Kumar or firstname of Jaspher");
			//query where lastname="kumar" or firstName="Jaspher"
			students = session.createQuery("from Student s where s.lastName='Kumar' OR s.firstName='jaspher'").getResultList();
			displayStudents(students);
			
			System.out.println("\n\nStudents whose email end with gmail.com");
			//query where email ends with gmail.com
			students = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			displayStudents(students);
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for(Student s:students)
		{
			System.out.println(s);
		}
	}

}
