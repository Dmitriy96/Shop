package by.bsuir.shop.dao;

import by.bsuir.shop.model.Role;
import by.bsuir.shop.model.User;


public interface UserDao {
	User getUserByUsername(String username);
    User getUserByEmail(String email);
    Object saveUser(User user);
    void deleteUser(User user);
    Role getUserRole();
    void updateUser(User user);
}