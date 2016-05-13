package by.bsuir.shop.dao;

import by.bsuir.shop.model.PlacedOrder;
import by.bsuir.shop.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<PlacedOrder> getOrders(User user) {
        Session session = getSessionFactory().openSession();
        List<PlacedOrder> orders = session.
                createCriteria(PlacedOrder.class).
                add(Restrictions.eq("user", user)).
                list();
        session.close();
        return orders;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
