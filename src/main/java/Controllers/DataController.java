package Controllers;

import Models.Country;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

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
            Session session= sessionFactory.openSession();
            session.persist(data);
            Transaction transaction = session.beginTransaction();
            try{
                transaction.commit();
            }catch (HibernateException e){
                if (transaction != null){
                    transaction.rollback();
                }
                e.printStackTrace();
            }
            session.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


}
