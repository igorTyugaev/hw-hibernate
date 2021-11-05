import models.*;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;

import javax.persistence.metamodel.EntityType;

import services.*;
import utils.HibernateUtil;

public class Main {
    public static void main(final String[] args) throws Exception {
        ZoneService zoneService = new ZoneService();
        AddressService addressService = new AddressService();
        SchoolService schoolService = new SchoolService();

        ParentService parentService = new ParentService();
        ChildService childService = new ChildService();


        Zone zone = new Zone("2");
        Address address = new Address("st. Mira 24");
        address.setZone(zone);

        Parent parent = new Parent("Papa Pety");
        parent.setAddress(address);
        Child child = new Child("Pety", 4);

        School school = new School(119);
        school.setAddress(address);

        child.addParent(parent);
        child.setSchool(school);

        zoneService.saveService(zone);
        addressService.saveService(address);
        schoolService.saveService(school);

        parentService.saveService(parent);
        childService.saveService(child);
    }

    public static void testHibernate() {
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
