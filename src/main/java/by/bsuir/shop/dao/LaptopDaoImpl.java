package by.bsuir.shop.dao;

import by.bsuir.shop.model.Laptop;
import by.bsuir.shop.model.User;
import by.bsuir.shop.util.LaptopSample;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class LaptopDaoImpl implements LaptopDao {
    @Autowired
    private SessionFactory sessionFactory;
    private final Integer LAPTOPS_PER_PAGE = 12;

    @Override
    public List<Laptop> getAllLaptops() {
        Session session = getSessionFactory().openSession();
        StringBuilder sb = new StringBuilder("SELECT l FROM Laptop l WHERE l.available is true");
        Query query = session.createQuery(sb.toString());
        List<Laptop> laptopList = query.list();
        session.close();
        return laptopList;
    }

    @Override
    public List<Laptop> getLaptops(LaptopSample laptopSample) {
        Session session = getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Laptop.class);
        criteria.add(laptopSample.buildHibernateCriterion());
        List<Laptop> laptops = criteria.list();
        List<Laptop> availableLaptops = new ArrayList<Laptop>();
        for (Laptop laptop : laptops) {
            if (laptop.isAvailable())
                availableLaptops.add(laptop);
        }
        session.close();
        return availableLaptops;
    }

    @Override
    public Integer getLaptopCount() {
        Session session = getSessionFactory().openSession();
        StringBuilder sb = new StringBuilder("SELECT l FROM Laptop l WHERE l.available is true");
        Query query = session.createQuery(sb.toString());
        List<Laptop> laptopList = query.list();
        session.close();
        return laptopList.size();
    }

    @Override
    public List<Laptop> getLaptops(Integer offset) {
        Session session = getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Laptop.class);
        List<Laptop> laptops = criteria.setFirstResult(LAPTOPS_PER_PAGE * offset).setMaxResults(LAPTOPS_PER_PAGE).list();
        List<Laptop> availableLaptops = new ArrayList<Laptop>();
        for (Laptop laptop : laptops) {
            if (laptop.isAvailable())
                availableLaptops.add(laptop);
        }
        session.close();
        return availableLaptops;
    }

    @Override
    public Laptop getLaptop(Long id) {
        Session session = getSessionFactory().openSession();
        Laptop laptop = (Laptop)getSessionFactory().openSession().get(Laptop.class, id);
        session.close();
        return laptop;
    }

    @Override
    public Object saveLaptop(Laptop laptop) {
        Session session = getSessionFactory().openSession();
        laptop.setAvailable(true);
        Long id = (Long) session.save(laptop);
        session.flush();
        session.close();
        return id;
    }

    @Override
    public void updateLaptop(Laptop laptop) {
        Session session = getSessionFactory().openSession();
        session.merge(laptop);
        session.flush();
        session.close();
    }

    @Override
    public void deleteLaptop(Laptop laptop) {
        Session session = getSessionFactory().openSession();
        session.delete(laptop);
        session.close();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
