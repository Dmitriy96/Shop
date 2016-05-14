package by.bsuir.shop.dao;

import by.bsuir.shop.controller.UserController;
import by.bsuir.shop.model.Laptop;
import by.bsuir.shop.model.PlacedOrder;
import by.bsuir.shop.model.PlacedOrderLaptop;
import by.bsuir.shop.model.User;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class OrderDaoImpl implements OrderDao {
    private static Logger logger = LoggerFactory.getLogger(OrderDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private LaptopDao laptopDao;

    @Override
    public List<PlacedOrder> getOrders(User user) {
        Session session = getSessionFactory().openSession();
        List<PlacedOrder> orders = session.
                createCriteria(PlacedOrder.class).
                add(Restrictions.eq("user", user)).
                list();
        for (PlacedOrder placedOrder : orders) {
            List<Laptop> laptopList = new ArrayList<Laptop>();
            PlacedOrderLaptop placedOrderLaptop = new PlacedOrderLaptop();
            placedOrderLaptop.setPlacedOrder_idOrder(placedOrder.getIdOrder());
            StringBuilder sb = new StringBuilder("SELECT pol FROM PlacedOrderLaptop pol WHERE pol.PlacedOrder_idOrder = :pol");
            Query query = session.createQuery(sb.toString());
            query.setParameter("pol", placedOrder.getIdOrder());
            List<PlacedOrderLaptop> placedOrderLaptops = query.list();
            for (PlacedOrderLaptop placedOrderLaptop1 : placedOrderLaptops) {
                Laptop laptop = laptopDao.getLaptop(placedOrderLaptop1.getLaptopList_idLaptop());
                laptopList.add(laptop);
            }
            placedOrder.setLaptopList(laptopList);
        }
        session.close();
        return orders;
    }

    public Integer saveOrder(PlacedOrder placedOrder) {
        Session session = getSessionFactory().openSession();
        Integer id = (Integer) session.save(placedOrder);
        session.flush();
        session.close();
        return id;
    }

    public void updateOrder(PlacedOrder placedOrder) {
        Session session = getSessionFactory().openSession();
        logger.debug("===================updateOrder: {}, {}", placedOrder.getIdOrder(), placedOrder.getLaptopList().get(0).getIdLaptop());
        //session.merge(placedOrder);
        PlacedOrderLaptop placedOrderLaptop = new PlacedOrderLaptop();
        placedOrderLaptop.setPlacedOrder_idOrder(placedOrder.getIdOrder());
        placedOrderLaptop.setLaptopList_idLaptop(placedOrder.getLaptopList().get(0).getIdLaptop());
        session.save(placedOrderLaptop);
        session.flush();
        session.close();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
