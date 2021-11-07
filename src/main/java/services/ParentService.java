package services;

import dao.ParentDao;
import models.Address;
import models.Parent;

import java.util.List;

public class ParentService {
    private ParentDao parentDao = new ParentDao();

    public ParentService() {
    }

    public Parent findById(int id) {
        return parentDao.findById(id);
    }

    public void saveService(Parent parent) {
        parentDao.save(parent);
    }

    public void deleteService(Parent parent) {
        parentDao.delete(parent);
    }

    public void updateService(Parent parent) {
        parentDao.update(parent);
    }

    public List<Parent> findAllParents() {
        return parentDao.findAll();
    }
}
