package dao;

import models.Zone;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class ZoneDao {

    public Zone findById(int id) {
        return HibernateUtil.getOpenSession().get(Zone.class, id);
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
        List<Zone> users = (List<Zone>) HibernateUtil.getOpenSession().createQuery("From Zone").list();
        return users;
    }
}
