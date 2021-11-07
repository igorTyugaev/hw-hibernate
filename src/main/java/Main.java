import logic.MainService;
import models.*;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;

import javax.persistence.metamodel.EntityType;

import services.*;
import utils.HibernateUtil;

import java.util.Scanner;
import java.util.logging.Level;

public class Main {

    public static void main(final String[] args) throws Exception {
        MainService mainService = new MainService();
        mainService.createDefaultData();
        mainService.clearScreen();

        while (true) {
            int command = mainService.showMenu();
            switch (command) {
                case 1:
                    //создать родителя
                    mainService.createParent();
                    break;
                case 2:
                    //создать ребенка
                    mainService.createChild();
                    break;
                case 3:
                    //сменить адресс родителя
                    mainService.changeAddress();
                    break;
                case 4:
                    //сменить школу ребенка
                    mainService.changeSchool();
                    break;
                default:
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }
}
