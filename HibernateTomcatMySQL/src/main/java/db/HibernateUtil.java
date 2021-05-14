package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistryBuilder;
 
/*public class HibernateUtil {
    //private static final SessionFactory sessionFactory = configureSessionFactory();
    //private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory = configureSessionFactory();
	
    //private static SessionFactory configureSessionFactory() throws HibernateException {
	private static SessionFactory configureSessionFactory() {
    	sessionFactory = new Configuration().configure().buildSessionFactory();
    	return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    
}*/

public class HibernateUtil {
  private static final SessionFactory sessionFactory;
    static {
      try {
        sessionFactory = new Configuration().configure().buildSessionFactory();
      } catch (Throwable ex) {
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
      }
    }

    public static SessionFactory getSessionFactory() {
      return sessionFactory;
    }
}