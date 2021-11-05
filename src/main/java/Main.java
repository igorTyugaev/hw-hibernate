import models.Address;
import models.Zone;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;

import javax.persistence.metamodel.EntityType;

import services.AddressService;
import services.ZoneService;
import utils.HibernateUtil;

public class Main {
    public static void main(final String[] args) throws Exception {
        ZoneService zoneService = new ZoneService();
        AddressService addressService = new AddressService();

        Zone zone = new Zone("21");
        Address address = new Address("st. Pushkina");
        address.setZone(zone);

        zoneService.saveService(zone);
        addressService.saveService(address);
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
