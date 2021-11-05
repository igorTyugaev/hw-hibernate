package services;

import dao.ChildDao;
import models.Child;

import java.util.List;

public class ChildService {
    private ChildDao childDao = new ChildDao();

    public ChildService() {
    }

    public Child findService(int id) {
        return childDao.findById(id);
    }

    public void saveService(Child child) {
        childDao.save(child);
    }

    public void deleteService(Child child) {
        childDao.delete(child);
    }

    public void updateService(Child child) {
        childDao.update(child);
    }

    public List<Child> findAllServices() {
        return childDao.findAll();
    }
}
