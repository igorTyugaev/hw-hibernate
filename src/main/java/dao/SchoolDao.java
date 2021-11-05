package dao;

import models.School;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class SchoolDao {

    public School findById(int id) {
        return HibernateUtil.getOpenSession().get(School.class, id);
    }

    public void save(School school) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.save(school);
        tx1.commit();
        session.close();
    }

    public void update(School school) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.update(school);
        tx1.commit();
        session.close();
    }

    public void delete(School school) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(school);
        tx1.commit();
        session.close();
    }


    public List<School> findAll() {
        List<School> users = (List<School>) HibernateUtil.getOpenSession().createQuery("From School").list();
        return users;
    }
}
