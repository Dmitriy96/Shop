package by.bsuir.shop.dao;

import by.bsuir.shop.model.PlacedOrder;
import by.bsuir.shop.model.User;

import java.util.List;


public interface OrderDao {
    public List<PlacedOrder> getOrders(User user);
}
