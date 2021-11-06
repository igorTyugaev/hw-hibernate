package dao;

import models.Address;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class AddressDao {

    public Address findById(int id) {
        return HibernateUtil.getOpenSession().get(Address.class, id);
    }


    public boolean checkExistById(int id) {
        Address address = HibernateUtil.getOpenSession().get(Address.class, id);
        return (address != null);
    }

    public boolean checkExistByName(String title) {
        Address address = findByName(title);
        return (address != null);
    }

    public Address findByName(String title) {
        Query query = HibernateUtil.getOpenSession().
                createQuery("from Address where title=:title");
        query.setParameter("title", title);
        return (Address) query.uniqueResult();
    }

    public void save(Address address) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.save(address);
        tx1.commit();
        session.close();
    }

    public void update(Address address) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.update(address);
        tx1.commit();
        session.close();
    }

    public void delete(Address address) {
        Session session = HibernateUtil.getOpenSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(address);
        tx1.commit();
        session.close();
    }


    public List<Address> findAll() {
        List<Address> users = (List<Address>) HibernateUtil.getOpenSession().createQuery("From Address").list();
        return users;
    }
}
