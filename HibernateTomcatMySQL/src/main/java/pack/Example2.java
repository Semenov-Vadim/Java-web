package pack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import user.User;
import product.Product;

import java.util.List;

public class Example2 {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();

        Example2 exampleRunner = new Example2();

        //System.out.println("Adding users to the database");
        //Integer developerId1 = Example2Runner.addDeveloper("Proselyte", "Developer", "Java Developer", 2);
        //Integer developerId2 = developerRunner.addDeveloper("Some", "Developer", "C++ Developer", 2);
        //Integer developerId3 = developerRunner.addDeveloper("Peter", "Team Lead", "Java Team Lead", 6);

        //System.out.println("List of Developers:");
        //Example2Runner.listDevelopers();

        /*System.out.println("Removing \'Some Developer\' and updating \'Proselyte Developer\''s experience:");
        developerRunner.removeDeveloper(developerId2);
        developerRunner.updateDeveloper(developerId1, 3);

        System.out.println("Final list of Developers:");
        developerRunner.listDevelopers(); */
        
        
        //Example2Runner.printUsers();
        //System.out.println("\nadding\n");
        //Example2Runner.addUser("Adam", "Newser", "Bewser@gmail.com", "09930478485", "pass");
        
        
        exampleRunner.printUsers();
        exampleRunner.printProducts();
        sessionFactory.close();
        System.out.println("Done");        
    }
    
    public void printUsers () {
    	Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<User> users = session.createQuery("FROM User").list();
        for (User user : users) {
            System.out.println(user);
            System.out.println("\n================\n");
        }
        transaction.commit();
        session.close();
    }
    
    public void printProducts () {
    	Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<Product> products = session.createQuery("FROM Product").list();
        for (Product product : products) {
            System.out.println(product);
            System.out.println("\n================\n");
        }
        transaction.commit();
        session.close();
    }
    
    public Integer addUser(String name, String surname, String email, String phone, String password) {
    	Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer userId = null;

        transaction = session.beginTransaction();
        User user = new User(name, surname, email, phone, password);
        userId = (Integer) session.save(user);
        transaction.commit();
        session.close();
        return userId;
    }

    /*public Integer addDeveloper(String firstName, String lastName, String specialty, int experience) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer developerId = null;

        transaction = session.beginTransaction();
        User developer = new User(firstName, lastName, specialty, experience);
        developerId = (Integer) session.save(developer);
        transaction.commit();
        session.close();
        return developerId;
    }

    public void listDevelopers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List developers = session.createQuery("FROM Developer").list();
        for (Developer developer : developers) {
            System.out.println(developer);
            System.out.println("\n================\n");
        }
        session.close();
    }

    public void updateDeveloper(int developerId, int experience) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Developer developer = (Developer) session.get(Developer.class, developerId);
        developer.setExperience(experience);
        session.update(developer);
        transaction.commit();
        session.close();
    }

    public void removeDeveloper(int developerId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Developer developer = (Developer) session.get(Developer.class, developerId);
        session.delete(developer);
        transaction.commit();
        session.close();
    }*/
}
