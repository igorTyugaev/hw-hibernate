package logic;

import models.*;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.query.Query;
import services.*;
import utils.HibernateUtil;

import javax.persistence.metamodel.EntityType;

//    Родители (ФИО, адрес, дети).
//    Ребенок (ФИО, родители, возраст, учебное учреждение).
//    Учебное учреждение (Адрес, номер).
//    Район (список адресов).
public class MainService {
    public static void createParent(String fullName, String addressTitle, String zoneTitle) {
        ZoneService zoneService = new ZoneService();
        boolean isExistZone = zoneService.checkExistByName(zoneTitle);
        Zone zone = isExistZone ? zoneService.findByNameService(zoneTitle) : new Zone(zoneTitle);
        if (!isExistZone) zoneService.saveService(zone);

        AddressService addressService = new AddressService();
        boolean isExistAddress = addressService.checkExistByName(addressTitle);
        Address address = isExistAddress ? addressService.findByNameService(addressTitle) : new Address(addressTitle, zone);
        if (!isExistAddress) addressService.saveService(address);

        ParentService parentService = new ParentService();
        Parent parent = new Parent(fullName, address);
        parentService.saveService(parent);
    }


    public static void createChild(String fullName, int aga) {
        Child child = new Child(fullName, aga);
    }

    public static void getEntities() {
        final Session session = HibernateUtil.getOpenSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}
