package by.bsuir.shop.dao;

import by.bsuir.shop.model.PlacedOrder;
import by.bsuir.shop.model.User;

import java.util.List;


public interface OrderDao {
    List<PlacedOrder> getOrders(User user);
    Integer saveOrder(PlacedOrder placedOrder);
    void updateOrder(PlacedOrder placedOrder);
}
