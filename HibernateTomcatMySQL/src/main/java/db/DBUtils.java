package db;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import product.Product;
import user.User;

public class DBUtils {
	public static User getUserByEmail(String email) {
		Session session = null;
		User user = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("FROM User WHERE email =: u_email");
			query.setParameter("u_email", email);
			user = (User) query.getSingleResult();
		}catch (Exception e){
			return null;
		}finally {
		  if (session != null && session.isOpen()) {
		      session.close();
		  }
		}
		
		return user;
	}
	
	public static User updateUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
        
		session.update(user);
		
		transaction.commit();
		session.close();
		return user;
	}
	
	public static User addUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
        
		session.save(user);
		
		transaction.commit();
		session.close();
		return user;
	}
	
	public static List<Product> getAllProducts() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//busses = session.createCriteria(Bus.class).list();
		List<Product> products = session.createQuery("FROM Product").list();
		
		session.close();
		return products;
	}
}
