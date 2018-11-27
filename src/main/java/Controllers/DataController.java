package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.InstantiationException;
import java.util.List;
import java.util.concurrent.*;

public class DataController {
    private static SessionFactory sessionFactory = null;
    private static DataController instance;
    private Callable<?> callableObj = () -> {
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    };
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private FutureTask futTask;

    private DataController() {

        futTask = (FutureTask) executorService.submit(callableObj);

    }

    public static synchronized DataController getInstance() {
        if (instance == null) {
            instance = new DataController();
        }
        return instance;
    }

    public void getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = (SessionFactory) futTask.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                getSessionFactory();
            }
        }
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

    public Object getObjectById(Class data, Integer id) {

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

        getSessionFactory();

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
        for (Object obj : retrievedObjects) {
            obj = data.cast(obj);
            objList.add(obj);
        }

        return objList;
    }


    public Object getObjectWithValue(Class objectClass, String fieldName, String value) {
        Object object = null;
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(objectClass);
            object = criteria.add(Restrictions.eq(fieldName, value)).uniqueResult();
            executeTransaction(transaction);
            session.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return object;
    }

        private void executeTransaction (Transaction transaction){
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

