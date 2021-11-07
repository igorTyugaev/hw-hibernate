package dao;

import models.Address;
import models.Parent;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class AddressDao {

    public Address findById(int id) {
        Session session = HibernateUtil.getOpenSession();
        Address address = session.get(Address.class, id);
        return address;
    }


    public boolean checkExistById(int id) {
        Session session = HibernateUtil.getOpenSession();
        Address address = session.get(Address.class, id);
        session.close();
        return (address != null);
    }

    public boolean checkExistByName(String title) {
        Address address = findByName(title);
        return (address != null);
    }

    public Address findByName(String title) {
        Session session = HibernateUtil.getOpenSession();
        Query query = session.createQuery("from Address where title=:title");
        query.setParameter("title", title);
        session.close();
        return (Address) query.uniqueResult();
    }

    public List<Address> findByZoneID(int zoneId) {
        Session session = HibernateUtil.getOpenSession();
        Query query = session.createQuery("from Address where zone.id=:zoneId");
        query.setParameter("zoneId", zoneId);
        return (List<Address>) query.list();
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
        Session session = HibernateUtil.getOpenSession();
        List<Address> users = (List<Address>) session.createQuery("From Address").list();
        return users;
    }
}
