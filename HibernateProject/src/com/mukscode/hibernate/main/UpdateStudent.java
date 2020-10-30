package com.mukscode.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mukscode.hibernate.entity.Student;

public class UpdateStudent {
	
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
			
			int studentId = 3001;
		
			
			//Code for retrieve student object
			//get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve the student based on id
			System.out.println("\nGetting Student with id: "+studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating Student...");
			myStudent.setFirstName("Muks");
			
			//commit the transaction
			session.getTransaction().commit();
			
			//Update using HQL
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all student
			System.out.println("Updating email for all student");
			
			session.createQuery("update Student set email='blahblah@gmail.com' ")
			.executeUpdate();
			
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		}
		finally 
		{
			factory.close();
		}
		
	}


}
