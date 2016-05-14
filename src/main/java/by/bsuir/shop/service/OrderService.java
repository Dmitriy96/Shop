package by.bsuir.shop.service;

import by.bsuir.shop.model.PlacedOrder;
import by.bsuir.shop.model.User;

import java.util.List;


public interface OrderService {
    List<PlacedOrder> getOrders(User user);
    Integer saveOrder(PlacedOrder placedOrder);
    void updateOrder(PlacedOrder placedOrder);
}
