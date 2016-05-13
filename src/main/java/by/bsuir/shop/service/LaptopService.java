package by.bsuir.shop.service;

import by.bsuir.shop.model.Laptop;
import by.bsuir.shop.util.LaptopSample;

import java.util.List;


public interface LaptopService {
    List<Laptop> getAllLaptops();
    List<Laptop> getLaptops(LaptopSample laptopSample);
    Integer getLaptopCount();
    List<Laptop> getLaptops(Integer offset);
    Laptop getLaptop(Long id);
    Object saveLaptop(Laptop laptop);
    void deleteLaptop(Laptop laptop);
}
