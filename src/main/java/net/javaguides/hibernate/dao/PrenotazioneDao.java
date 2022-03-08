package net.javaguides.hibernate.dao;

import net.javaguides.hibernate.model.Prenotazione;
import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.hibernate.model.User;
import net.javaguides.hibernate.util.HibernateUtil;

import java.util.List;

public class PrenotazioneDao {

    public void savePrenotazione(Prenotazione prenotazione) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            session.save(prenotazione);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

        public void updatePrenotazione(Prenotazione prenotazione) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // start a transaction
                transaction = session.beginTransaction();

                session.update(prenotazione);
                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }

    public void deletePrenotazione(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();


            Prenotazione prenotazione = session.get(Prenotazione.class, id);
            if (prenotazione != null) {
                session.delete(prenotazione);
                System.out.println("Prenotazione Cancellata");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get Prenotazione By ID
     * @param id
     * @return
     */
    public Prenotazione getPrenotazione(int id) {

        Transaction transaction = null;
        Prenotazione prenotazione = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            prenotazione = session.get(Prenotazione.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return prenotazione;
    }

    /**
     * Get all Prenotazioni
     * @return
     */
    @SuppressWarnings("unchecked")
    public List< Prenotazione > getAllPrenotazione() {

        Transaction transaction = null;
        List < Prenotazione > listOfPrenotazione = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();


            listOfPrenotazione = session.createQuery("from Prenotazione ").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfPrenotazione;
    }




}














