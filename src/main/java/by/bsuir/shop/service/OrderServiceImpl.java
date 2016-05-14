package by.bsuir.shop.service;

import by.bsuir.shop.dao.OrderDao;
import by.bsuir.shop.model.PlacedOrder;
import by.bsuir.shop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<PlacedOrder> getOrders(User user) {
        return orderDao.getOrders(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Integer saveOrder(PlacedOrder placedOrder) {
        return orderDao.saveOrder(placedOrder);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateOrder(PlacedOrder placedOrder) {
        orderDao.updateOrder(placedOrder);
    }
}
