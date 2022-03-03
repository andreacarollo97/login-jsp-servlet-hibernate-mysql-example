package net.javaguides.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.hibernate.model.User;
import net.javaguides.hibernate.util.HibernateUtil;

public class UserDao {

    public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public int validate(String userName, String password) {

        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = (User) session.createQuery("From User U WHERE U.username = :userName").setParameter("userName", userName).uniqueResult();

            if (user != null && user.getPassword().equals(password) && user.getStatus() == 0) {
                return 0;
            }
            else if (user != null && user.getPassword().equals(password) && user.getStatus() == 1) {
                return 1;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return 3;
    }



}