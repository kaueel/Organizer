package Controllers;

import Models.Client;
import Models.Employee;
import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.*;

public class DataController {
    private Callable<?> callableObj = () -> { return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();  };
    private  static  SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private static DataController instance;
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private FutureTask futTask = new FutureTask(
            callableObj
    );

    private DataController() {

            executorService.submit(callableObj);

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

    public void deleteObject(Object data) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(data);
            executeTransaction(transaction);
            session.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void updateObject(Object data) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(data);
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
        return data.cast(retrievedObject);
    }


    public ObservableList<?> getAllObjectsOfType(Class data) {



        List<?> retrievedObjects = null;
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<?> criteria = builder.createQuery(data);
            Root<?> root = criteria.from(data);
            criteria.getSelection();
            Query query = session.createQuery(criteria);
            retrievedObjects = query.getResultList();
            executeTransaction(transaction);
            session.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        ObservableList<Object> objList = FXCollections.observableArrayList();

        assert retrievedObjects != null;
        for (Object obj: retrievedObjects){
            obj = data.cast(obj);
            objList.add(obj);
        }

        return objList;
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

