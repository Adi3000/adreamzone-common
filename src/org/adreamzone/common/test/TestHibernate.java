package org.adreamzone.common.test;

import org.hibernate.Session;

import engine.common.database.session.HibernateUtils;

import model.users.User;

public class TestHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
		User user = new User();
		
		user.setLogin("Adi3000");
		user.setPassword("123465");
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		System.out.println("!!!END!!!");

	}

}
