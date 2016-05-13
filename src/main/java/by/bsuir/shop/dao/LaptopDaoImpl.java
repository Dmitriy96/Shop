package by.bsuir.shop.dao;

import by.bsuir.shop.model.Laptop;
import by.bsuir.shop.util.LaptopSample;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class LaptopDaoImpl implements LaptopDao {
    @Autowired
    private SessionFactory sessionFactory;
    private final Integer LAPTOPS_PER_PAGE = 30;

    @Override
    public List<Laptop> getAllLaptops() {
        Session session = getSessionFactory().openSession();
        List<Laptop> laptops = session.createCriteria(Laptop.class).list();
        session.close();
        return laptops;
    }

    @Override
    public List<Laptop> getLaptops(LaptopSample laptopSample) {
        Session session = getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Laptop.class);
        criteria.add(laptopSample.buildHibernateCriterion());
        List<Laptop> laptops = criteria.list();
        session.close();
        return laptops;
    }

    @Override
    public Integer getLaptopCount() {
        Session session = getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Laptop.class);
        Integer size = criteria.list().size();
        session.close();
        return size;
    }

    @Override
    public List<Laptop> getLaptops(Integer offset) {
        Session session = getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Laptop.class);
        List<Laptop> laptops = criteria.setFirstResult(LAPTOPS_PER_PAGE * offset).setMaxResults(LAPTOPS_PER_PAGE).list();
        session.close();
        return laptops;
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
        laptop.getInStock().setAvailable(true);
        Laptop id = (Laptop) session.save(laptop);
        session.flush();
        session.close();
        return id;
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
