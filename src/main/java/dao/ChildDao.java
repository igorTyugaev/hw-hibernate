package dao;

import models.Child;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class ChildDao {

    public Child findById(int id) {
        return HibernateUtil.getOpenSession().get(Child.class, id);
    }

    public void save(Child child) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.save(child);
        tx1.commit();
        session.close();
    }

    public void update(Child child) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.update(child);
        tx1.commit();
        session.close();
    }

    public void delete(Child child) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(child);
        tx1.commit();
        session.close();
    }


    public List<Child> findAll() {
        List<Child> users = (List<Child>) HibernateUtil.getOpenSession().createQuery("From Child").list();
        return users;
    }
}
