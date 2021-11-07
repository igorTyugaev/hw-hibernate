package dao;

import models.Address;
import models.Zone;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class ZoneDao {

    public Zone findById(int id) {
        Session session = HibernateUtil.getOpenSession();
        Zone zone = session.get(Zone.class, id);
        return zone;
    }

    public boolean checkExistById(int id) {
        Session session = HibernateUtil.getOpenSession();
        Zone zone = session.get(Zone.class, id);
        return (zone != null);
    }

    public boolean checkExistByName(String title) {
        Zone zone = findByName(title);
        return (zone != null);
    }

    public Zone findByName(String title) {
        Session session = HibernateUtil.getOpenSession();
        Query query = session.createQuery("from Zone where title=:title");
        query.setParameter("title", title);
        return (Zone) query.uniqueResult();
    }

    public void save(Zone zone) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.save(zone);
        tx1.commit();
        session.close();
    }

    public void update(Zone zone) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.update(zone);
        tx1.commit();
        session.close();
    }

    public void delete(Zone zone) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(zone);
        tx1.commit();
        session.close();
    }


    public List<Zone> findAll() {
        Session session = HibernateUtil.getOpenSession();
        List<Zone> users = (List<Zone>) session.createQuery("From Zone").list();
        return users;
    }
}
