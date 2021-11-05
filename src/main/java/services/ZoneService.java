package services;

import dao.ZoneDao;
import dao.ZoneDao;
import models.Zone;

import java.util.List;

public class ZoneService {
    private ZoneDao zoneDao = new ZoneDao();

    public ZoneService() {
    }

    public Zone findService(int id) {
        return zoneDao.findById(id);
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
