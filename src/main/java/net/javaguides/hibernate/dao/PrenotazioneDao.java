package net.javaguides.hibernate.dao;

import net.javaguides.hibernate.model.Auto;
import net.javaguides.hibernate.model.Prenotazione;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.hibernate.util.HibernateUtil;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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




    public List<Auto> getAutoByPrenotazioni(Date startDate, Date endDate){

        try {




            Session session = HibernateUtil.getSessionFactory().openSession();

            //not in (select Prenotazione.auto.id from Prenotazione where Prenotazione.dateEnd <= :dateS and Prenotazione.dateStart >= :dateE)
           // CriteriaBuilder cb = session.getCriteriaBuilder();
            //   CriteriaQuery<Prenotazione> cr = cb.createQuery(Prenotazione.class);
           // Root<Prenotazione> root = cr.from(Prenotazione.class);
           List<Auto> autoList = session.createQuery("from Auto a WHERE a.id not in (select p.auto.id from Prenotazione p where p.dateEnd >= :dateS and p.dateStart <= :dateE)")
                    .setParameter("dateE", endDate)
                    .setParameter("dateS", startDate)
                    .getResultList();
            return autoList;


            //cr.select(root);
            //cb.and(cb.greaterThanOrEqualTo(root.get("dateStart"), endDate),cb.lessThanOrEqualTo(root.get("dateEnd"), startDate));

/*
            //Query query = session.createQuery(cr);
            List<Prenotazione> results = query.getResultList();


            List<Integer> iDautoPrenotate = new ArrayList<>();

            for (Prenotazione prenotazione : results){
                Integer autoId = prenotazione.getAuto().getId();
                iDautoPrenotate.add(autoId);
            }

            CriteriaBuilder cb1 = session.getCriteriaBuilder();
            CriteriaQuery<Auto> cr1 = cb1.createQuery(Auto.class);
            Root<Auto> root1 = cr1.from(Auto.class);
            cr1.select(root1).where(cb1.not(cb1.in(root1.get("id")).value(iDautoPrenotate)));
           // cb1.in(root1.get("id")).value(iDautoPrenotate);
          //  cb1.not(cb1.in(root1.get("id")).value(iDautoPrenotate));

            Query query1 = session.createQuery(cr1);
            List <Auto> autoLibere = query1.getResultList();


            return autoLibere;

*/

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }




}














