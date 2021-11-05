package services;

import dao.AddressDao;
import models.Address;

import java.util.List;

public class AddressService {
    private AddressDao addressDao = new AddressDao();

    public AddressService() {
    }

    public Address findService(int id) {
        return addressDao.findById(id);
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
