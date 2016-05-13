package by.bsuir.shop.service;

import by.bsuir.shop.dao.LaptopDao;
import by.bsuir.shop.model.Laptop;
import by.bsuir.shop.util.LaptopSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class LaptopServiceImpl implements LaptopService
{
    @Autowired
    private LaptopDao laptopDao;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Laptop> getAllLaptops() {
        return laptopDao.getAllLaptops();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Laptop> getLaptops(LaptopSample laptopSample) {
        return laptopDao.getLaptops(laptopSample);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Integer getLaptopCount() {
        return laptopDao.getLaptopCount();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Laptop> getLaptops(Integer offset) {
        return laptopDao.getLaptops(offset);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Laptop getLaptop(Long id) {
        return laptopDao.getLaptop(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Object saveLaptop(Laptop laptop) {
        return laptopDao.saveLaptop(laptop);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateLaptop(Laptop laptop) {
        laptopDao.updateLaptop(laptop);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteLaptop(Laptop laptop) {
        laptopDao.deleteLaptop(laptop);
    }

    public LaptopDao getLaptopDao() {
        return laptopDao;
    }

    public void setLaptopDao(LaptopDao laptopDao) {
        this.laptopDao = laptopDao;
    }
}
