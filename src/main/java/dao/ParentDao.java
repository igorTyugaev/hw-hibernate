package dao;

import models.Parent;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class ParentDao {

    public Parent findById(int id) {
        Session session = HibernateUtil.getOpenSession();
        Parent parent = session.get(Parent.class, id);
        return parent;
    }

    public void save(Parent parent) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.save(parent);
        tx1.commit();
        session.close();
    }

    public void update(Parent parent) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.update(parent);
        tx1.commit();
        session.close();
    }

    public void merge(Parent parent) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(parent);
        tx1.commit();
        session.close();
    }

    public void delete(Parent parent) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(parent);
        tx1.commit();
        session.close();
    }


    public List<Parent> findAll() {
        Session session = HibernateUtil.getOpenSession();
        List<Parent> parents = (List<Parent>) session.createQuery("From Parent").list();
        return parents;
    }
}
