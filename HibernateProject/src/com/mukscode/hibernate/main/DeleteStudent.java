package com.mukscode.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mukscode.hibernate.entity.Student;

public class DeleteStudent {
	
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
			
			/*//Delete the student
			System.out.println("Deleting the student");
			session.delete(myStudent);*/
			
			//Delete Using HQL
			System.out.println("Deleting the student");
			session.createQuery("delete from Student where id='3004' ").executeUpdate();
			
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
