/**
 * 
 */
package com.Anno.OTM;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;

public class OneToManyExam {

	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();		

	      Vendor v=new Vendor();
	      v.setVendorId(100);
	      v.setVendorName("java4s");

	      Customers c1=new Customers();
	      c1.setCustomerId(500);
	      c1.setCustomerName("customer1");

	      Customers c2=new Customers();
	      c2.setCustomerId(501);
	      c2.setCustomerName("customer2");

	      Set s=new HashSet();
	      s.add(c1);
	      s.add(c2);

	      v.setChildren(s);

	      Transaction tx=session.beginTransaction();
	           session.save(v);
	           tx.commit();

	   		session.close();
	   		System.out.println("One to Many Annotatios Done...!!!!!!");
	   		factory.close();
	   	}

	   }

	
