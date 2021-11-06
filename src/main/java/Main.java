import logic.MainService;
import models.*;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;

import javax.persistence.metamodel.EntityType;

import services.*;
import utils.HibernateUtil;

public class Main {

    public static void main(final String[] args) throws Exception {
        MainService mainService = new MainService();
        mainService.createParent(
                "Мирошин Артём Павлович",
                "Кемеровская",
                "Центральный"
        );
    }
}
