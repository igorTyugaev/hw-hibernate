package logic;

import models.*;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.query.Query;
import services.*;
import utils.HibernateUtil;

import javax.persistence.metamodel.EntityType;
import java.util.*;


//    Родители (ФИО, адрес, дети).
//    Ребенок (ФИО, родители, возраст, учебное учреждение).
//    Учебное учреждение (Адрес, номер).
//    Район (список адресов).
public class MainService {

    public static void changeAddress() {
        ZoneService zoneService = new ZoneService();
        AddressService addressService = new AddressService();
        ParentService parentService = new ParentService();

        Scanner in = new Scanner(System.in);

        System.out.println("-----------------------------");
        System.out.println("Метод смены адреса проживания");
        System.out.println("-----------------------------");

        System.out.println("\n|Шаг 1|");
        System.out.println("Выберите взрослого для смены адреса по его id");
        System.out.println("id | title");
        System.out.println("--------------------");
        for (Parent parent : parentService.findAllParents()) {
            System.out.print(parent.getId() + " | ");
            System.out.println(parent.getFullName());
        }
        System.out.print("Введите id роодителя -> ");
        int addressID = in.nextInt();
    }

    public static void createParent() {
        ZoneService zoneService = new ZoneService();
        AddressService addressService = new AddressService();
        ParentService parentService = new ParentService();

        Scanner in = new Scanner(System.in);

        System.out.println("--------------------------");
        System.out.println("Метод по созданию родителя");
        System.out.println("--------------------------");

        System.out.println("\n|Шаг 1|");
        System.out.print("Введите ФИО родителя -> ");
        String fullNameParent = in.nextLine();

        System.out.println("\n|Шаг 2|");
        System.out.println("Выберите район по его id");
        System.out.println("id | title");
        System.out.println("--------------------");
        for (Zone zone : zoneService.findAllServices()) {
            System.out.print(" " + zone.getId() + " | ");
            System.out.println(zone.getTitle());
        }
        System.out.println("--------------------");
        System.out.print("Введите id района -> ");
        int zoneID = in.nextInt();

        System.out.println("\n|Шаг 3|");
        System.out.println("Выберите адрес по его id");
        System.out.println("id | title");
        System.out.println("--------------------");
        for (Address address : addressService.findByZoneID(zoneID)) {
            System.out.print(address.getId() + " | ");
            System.out.println(address.getTitle());
        }
        System.out.print("Введите id адреса -> ");
        int addressID = in.nextInt();
        in.close();

        Address addressParent = addressService.findByIdService(addressID);
        Parent parent = new Parent(fullNameParent, addressParent);
        parentService.saveService(parent);
        System.out.println("\nРодитель успешно создан");
        System.out.print(parent.getFullName());
        System.out.print(", ");
        System.out.println(parent.getAddress().getTitle());
    }

    public static void createChild() {
//        Ребенок (ФИО, родители, возраст, учебное учреждение)
        ParentService parentService = new ParentService();
        ChildService childService = new ChildService();
        SchoolService schoolService = new SchoolService();

        Scanner in = new Scanner(System.in);
        Set<Parent> parents = new HashSet<>();
        int parentIDFirst = -1;
        int parentIDSecond = -1;
        Zone parentZone = null;

        System.out.println("-------------------------");
        System.out.println("Метод по созданию ребенка");
        System.out.println("-------------------------");

        System.out.println("\n|Шаг 1|");
        System.out.print("Введите ФИО ребенка -> ");
        String fullNameChild = in.nextLine();

        System.out.println("\n|Шаг 2|");
        System.out.print("Введите возраст ребенка -> ");
        int ageChild = in.nextInt();

        System.out.println("\n|Шаг 3|");
        System.out.println("Выберите родителя по его id");
        System.out.println("id | full name");
        System.out.println("--------------------");
        for (Parent parent : parentService.findAllParents()) {
            System.out.print(" " + parent.getId() + " | ");
            System.out.println(parent.getFullName());
        }
        System.out.println("--------------------");
        System.out.print("Введите id родителя №1 -> ");
        parentIDFirst = in.nextInt();

        System.out.println("\nХотите указать 2-го родителя?");
        System.out.print("Введите 1 - да или 0 - нет -> ");
        int isSecondParent = in.nextInt();

        if (isSecondParent == 1) {
            System.out.print("Введите id родителя №2 -> ");
            parentIDSecond = in.nextInt();
        }

        if (parentIDFirst != -1) {
            Parent parent = parentService.findById(parentIDFirst);
            parentZone = parent.getAddress().getZone();
            parents.add(parent);
        }

        if (parentIDSecond != -1)
            parents.add(parentService.findById(parentIDSecond));

        System.out.println("\nУказанные родители ребенка");
        for (Parent parent : parents) {
            System.out.print(" " + parent.getId() + " | ");
            System.out.println(parent.getFullName());
        }

        System.out.println("\n|Шаг 4|");
        System.out.println("Выберите школу для ребенка");
        System.out.println(parentZone.getTitle() + " район - автоматический подбор");
        System.out.println("id | school");
        System.out.println("--------------------");
        for (School school : schoolService.findByZoneID(parentZone.getId())) {
            System.out.print(" " + school.getId() + " | ");
            System.out.print("Школа №");
            System.out.println(school.getNum());
        }
        System.out.println("--------------------");
        System.out.print("Введите id школы -> ");
        int schoolID = in.nextInt();

        School school = schoolService.findById(schoolID);
        Child child = new Child(fullNameChild, ageChild, school, parents);
        childService.saveService(child);

        System.out.println("\nРебенок успешно создан");
        System.out.println("ФИО: " + child.getFullName());
        System.out.println("Возраст: " + child.getAge());
        System.out.println("Родители: ");
        for (Parent parent : child.getParents()) {
            System.out.println("- " + parent.getFullName());
        }
        System.out.println("Школа: №" + child.getSchool().getNum());
    }

    public static void createDefaultData() {
        String[] zones = new String[]{
                "Заводской",
                "Ленинский",
                "Московский",
                "Октябрьский",
                "Партизанский",
                "Первомайский",
                "Советский",
                "Фрунзенский",
                "Центральный"
        };

        ZoneService zoneService = new ZoneService();
        boolean isExistZone = zoneService.checkExistByName(zones[0]);
        if (isExistZone) {
            System.out.println("Default value already exist!");
            return;
        }

        AddressService addressService = new AddressService();
        SchoolService schoolService = new SchoolService();
        for (String zoneName : zones) {
            Zone zone = new Zone(zoneName);
            zoneService.saveService(zone);

            String streetName = zoneName.substring(0, zoneName.length() - 2).concat("ая ");
            for (int i = 0; i < 10; i++) {
                String addressName = streetName.concat(String.valueOf(i));
                Address address = new Address(addressName, zone);
                addressService.saveService(address);
                if (i % 2 == 0) {
                    int numSchool = (i + 1) * zone.getId();
                    School school = new School(numSchool, address);
                    schoolService.saveService(school);
                }
            }
        }
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

    public static void clearScreen() {
        System.out.println(new String(new char[25]).replace("\0", "\r\n"));
    }
}
