package Controllers;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DataController {
    private static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private static DataController instance;


    private DataController() {

    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static synchronized DataController getInstance() {
        if (instance == null) {
            instance = new DataController();
        }
        return instance;
    }

    public void saveObject(Object data) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(data);
            executeTransaction(transaction);
            session.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public Object getObjectById(Class data,  Integer id) {
        Object retrievedObject = null;
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            retrievedObject = session.get(data, id);
            executeTransaction(transaction);
            session.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return retrievedObject;
    }

    private void executeTransaction(Transaction transaction) {
        try {
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}

