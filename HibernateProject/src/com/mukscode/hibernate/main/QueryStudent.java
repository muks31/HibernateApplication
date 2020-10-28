package com.mukscode.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mukscode.hibernate.entity.Student;

public class QueryStudent {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try 
		{
			
			//start a transaction
			session.beginTransaction();
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudents(theStudents);
			
			//query student: last name Doe
			theStudents = session.createQuery("from Student s where s.lastName='Doe' ").getResultList();
			
			//display the students
			System.out.println("\n\nStudents Who have last name of Doe");
			displayStudents(theStudents);
			
			//query student: lastName = "Doe" or First Name ="Daffy"
			theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy' ").getResultList();
			
			//display the students
			System.out.println("\n\nStudents Who have last name of Doe OR First Name is Daffy");
			displayStudents(theStudents);
			
			//query student: email id like hotmail.com
			theStudents = session.createQuery("from Student s where s.email LIKE '%hotmail.com' ").getResultList();
			
			//display the students
			System.out.println("\n\nStudents Whose email address is like hotmail.com");
			displayStudents(theStudents);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		}
		finally 
		{
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
