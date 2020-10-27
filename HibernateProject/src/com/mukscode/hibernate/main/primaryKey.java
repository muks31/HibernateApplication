package com.mukscode.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mukscode.hibernate.entity.Student;

public class primaryKey {

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

			//create 3 student objects
			System.out.println("Creating 3 new Student objects");
			Student theStudent1 = new Student("John", "Doe", "johndoe@hotmail.com");
			Student theStudent2 = new Student("Muks", "Rai", "muksr@gmail.com");
			Student theStudent3 = new Student("Drake", "Ramory", "drakeramory@hotmail.com");

			//start a transaction
			session.beginTransaction();

			//save the student object
			System.out.println("Saving the Student object");
			session.save(theStudent1);
			session.save(theStudent2);
			session.save(theStudent3);

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
