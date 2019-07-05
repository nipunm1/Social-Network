package com.niit.backend.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niit.backend.config.dbconfig;
import com.niit.backend.model.User;

public class MyMain {

	public static void main(String[] args) {
		System.out.println("start");
		SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
        User user = new User();
        user.setUserAddress("PitamPura");
        user.setUserEmail("nipunmiglani.96@gmail.com");
        user.setUserEnabled(0);
        user.setUserName("nipun miglani");
        user.setUserNumber("9999664813");
        user.setUserPassword("1234");
        user.setUserRole("Admin");
        user.setUserStatus("no");
        session.save(user);
        System.out.println("ends");
	}

}
