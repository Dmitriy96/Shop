package by.bsuir.shop.service;

import by.bsuir.shop.model.PlacedOrder;
import by.bsuir.shop.model.User;

import java.util.List;


public interface OrderService {
    public List<PlacedOrder> getOrders(User user);
}
