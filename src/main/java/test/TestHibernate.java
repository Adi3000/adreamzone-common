package test;

import org.hibernate.Session;

import com.adreamzone.common.database.data.model.users.User;
import com.adreamzone.common.database.session.HibernateUtils;



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
		//session.getTransaction().commit();
		session.close();
		System.out.println("!!!END!!!");

	}

}
