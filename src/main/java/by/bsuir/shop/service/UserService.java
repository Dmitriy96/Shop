package by.bsuir.shop.service;

import by.bsuir.shop.model.Role;
import by.bsuir.shop.model.User;


public interface UserService {
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    Object saveUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    Role getUserRole();
}
