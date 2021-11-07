package services;

import dao.SchoolDao;
import models.Address;
import models.School;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class SchoolService {
    private SchoolDao schoolDao = new SchoolDao();

    public SchoolService() {
    }

    public School findById(int id) {
        return schoolDao.findById(id);
    }

    public List<School> findByZoneID(int id) {
        return schoolDao.findByZoneID(id);
    }


    public void saveService(School school) {
        schoolDao.save(school);
    }

    public void deleteService(School school) {
        schoolDao.delete(school);
    }

    public void updateService(School school) {
        schoolDao.update(school);
    }

    public List<School> findAllServices() {
        return schoolDao.findAll();
    }
}
