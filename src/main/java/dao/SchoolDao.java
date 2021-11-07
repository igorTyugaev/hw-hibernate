package dao;

import models.School;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class SchoolDao {

    public School findById(int id) {
        Session session = HibernateUtil.getOpenSession();
        School school = session.get(School.class, id);
        return school;
    }

    public List<School> findByZoneID(int zoneId) {
        Session session = HibernateUtil.getOpenSession();
        Query query = session.createQuery("from School where address.zone.id=:zoneId");
        query.setParameter("zoneId", zoneId);
        return (List<School>) query.list();
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

    public void merge(School school) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(school);
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
        Session session = HibernateUtil.getOpenSession();
        List<School> users = (List<School>) session.createQuery("From School").list();
        return users;
    }
}
