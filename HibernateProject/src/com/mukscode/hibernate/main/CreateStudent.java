package com.mukscode.hibernate.main;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mukscode.hibernate.entity.Student;

public class CreateStudent {

	public static void main(String[] args) throws ParseException {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try 
		{
			//read the DOB
			String theDOB = "10/01/1996";
			Date theDateOB = DateUtils.parseDate(theDOB);
			
			//create a student object
			System.out.println("Creating a new Student object");
			Student theStudent = new Student("Johny", "Walker", "walkerJohn@yahoo.com",theDateOB);
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the Student object");
			session.save(theStudent);
			
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
