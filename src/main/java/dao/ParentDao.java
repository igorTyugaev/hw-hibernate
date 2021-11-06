package dao;

import models.Parent;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class ParentDao {

    public Parent findById(int id) {
        return HibernateUtil.getOpenSession().get(Parent.class, id);
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

    public void delete(Parent parent) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(parent);
        tx1.commit();
        session.close();
    }


    public List<Parent> findAll() {
        List<Parent> parents = (List<Parent>) HibernateUtil.getOpenSession().createQuery("From Parent").list();
        return parents;
    }
}
