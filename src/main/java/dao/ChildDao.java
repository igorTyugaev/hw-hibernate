package dao;

import models.Child;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class ChildDao {

    public Child findById(int id) {
        Session session = HibernateUtil.getOpenSession();
        Child child = session.get(Child.class, id);
        return child;
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

    public void merge(Child child) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(child);
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
        Session session = HibernateUtil.getOpenSession();
        List<Child> users = (List<Child>) session.createQuery("From Child").list();
        return users;
    }
}
