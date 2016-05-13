package by.bsuir.shop.service;

import by.bsuir.shop.dao.UserDao;
import by.bsuir.shop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User getUserByUsername(String username)
    {
        return userDao.getUserByUsername(username);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Object saveUser(User user)
    {
        return userDao.saveUser(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(User user) {
        user.setAvailable(false);
        userDao.deleteUser(user);
    }
}
