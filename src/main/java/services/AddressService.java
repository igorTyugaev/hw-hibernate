package services;

import dao.AddressDao;
import models.Address;

import java.util.List;

public class AddressService {
    private AddressDao addressDao = new AddressDao();

    public AddressService() {
    }

    public Address findById(int id) {
        return addressDao.findById(id);
    }

    public List<Address> findByZoneID(int zone_id) {
        return addressDao.findByZoneID(zone_id);
    }

    public Address findByNameService(String title) {
        return addressDao.findByName(title);
    }

    public boolean checkExistService(int id) {
        return addressDao.checkExistById(id);
    }

    public boolean checkExistByName(String title) {
        return addressDao.checkExistByName(title);
    }

    public void saveService(Address address) {
        addressDao.save(address);
    }

    public void deleteService(Address address) {
        addressDao.delete(address);
    }

    public void updateService(Address address) {
        addressDao.update(address);
    }

    public List<Address> findAllServices() {
        return addressDao.findAll();
    }
}
