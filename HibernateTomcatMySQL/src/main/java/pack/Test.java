package pack;

import org.hibernate.Session;

import db.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		f();
	}
	
	public static void f () {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
		System.out.println("Done");
	}
}
