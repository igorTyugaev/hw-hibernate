package services;

import dao.ZoneDao;
import dao.ZoneDao;
import models.Zone;

import java.util.List;

public class ZoneService {
    private ZoneDao zoneDao = new ZoneDao();

    public ZoneService() {
    }

    public Zone findByIdService(int id) {
        return zoneDao.findById(id);
    }

    public Zone findByNameService(String title) {
        return zoneDao.findByName(title);
    }

    public boolean checkExistService(int id) {
        return zoneDao.checkExistById(id);
    }

    public boolean checkExistByName(String title) {
        return zoneDao.checkExistByName(title);
    }

    public void saveService(Zone zone) {
        zoneDao.save(zone);
    }

    public void deleteService(Zone zone) {
        zoneDao.delete(zone);
    }

    public void updateService(Zone zone) {
        zoneDao.update(zone);
    }

    public List<Zone> findAllServices() {
        return zoneDao.findAll();
    }
}
