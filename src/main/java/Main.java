import logic.MainService;
import models.*;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;

import javax.persistence.metamodel.EntityType;

import services.*;
import utils.HibernateUtil;

import java.util.logging.Level;

public class Main {

    public static void main(final String[] args) throws Exception {
        MainService mainService = new MainService();
        mainService.createDefaultData();
        mainService.clearScreen();
//        mainService.createParent();
//        mainService.createChild();
        mainService.changeAddress();
//        Смена адреса и школы
    }
}
