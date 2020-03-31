package pl.jaceksysiak;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.entity.Address;
import pl.jaceksysiak.entity.Employee;

public class MainClass {
	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.addAnnotatedClass(Address.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			
		//-----------Employee	
			Employee tmpEmployee1=new Employee();
		//	tmpEmployee.setId(1);
			tmpEmployee1.setName("Jack");
			
			Employee tmpEmployee2=new Employee();
		//	tmpEmployee.setId(2);
			tmpEmployee2.setName("Marian");
			
		//----------- Address
			Address address1 = new Address(); //(1, "Warzawa", "Poland");
			address1.setCity("Warzawa");
			address1.setCountry("Poland");
			
			Address address2 = new Address(); //(2, "Washington", "USA");
			address2.setCity("Washington");
			address2.setCountry("USA");
			
			// save the courses
			session.save(tmpEmployee1);
			session.save(tmpEmployee2);
			session.save(address1);
			session.save(address2);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			
			// add clean up code
			session.close();			
			factory.close();
		}
	}
}
