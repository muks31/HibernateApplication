package com.mukscode.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mukscode.hibernate.entity.Student;

public class RetrieveStudent {
	
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
			
			//create a student object
			System.out.println("Creating a new Student object");
			Student theStudent = new Student("Daffy", "Duck", "duck@yahoo.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the Student object");
			System.out.println(theStudent);
			session.save(theStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			//Find out the student's id: primary key
			System.out.println("Saved student. Generated id: "+theStudent.getId());
			
			//Code for retrieve student object
			//get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve the student based on id
			System.out.println("\nGetting Student with id: "+theStudent.getId());
			
			Student myStudent = session.get(Student.class, theStudent.getId());
			
			System.out.println("Get complete: "+myStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		}
		finally 
		{
			factory.close();
		}
		
	}


}
