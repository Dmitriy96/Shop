package by.bsuir.shop.dao;

import by.bsuir.shop.model.PlacedOrder;
import by.bsuir.shop.model.Role;
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

import java.util.List;
import java.util.Set;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    @Autowired
	private SessionFactory sessionFactory;

	public User getUserByUsername(String username) {
        Session session = getSessionFactory().openSession();
        StringBuilder sb = new StringBuilder("SELECT u FROM User u WHERE u.username = :username AND u.available is true");
        Query query = session.createQuery(sb.toString());
        query.setParameter("username", username);
        User user = (User) query.uniqueResult();
        if (user != null) {
            Hibernate.initialize(user.getUserRoles());
            Hibernate.initialize(user.getLaptopList());
            Hibernate.initialize(user.getPlacedOrders());
            for (PlacedOrder placedOrder : user.getPlacedOrders()) {
                Hibernate.initialize(placedOrder.getLaptopList());
            }
        }
        session.close();
        return user;
	}

    public User getUserByEmail(String email) {
        Session session = getSessionFactory().openSession();
        StringBuilder sb = new StringBuilder("SELECT u FROM User u WHERE u.email = :email AND u.available is true");
        Query query = session.createQuery(sb.toString());
        query.setParameter("email", email);
        User user = (User) query.uniqueResult();
        if (user != null)
            Hibernate.initialize(user.getUserRoles());
        session.close();
        return user;
    }

    public Object saveUser(User user) {
        Session session = getSessionFactory().openSession();
        Object id = session.save(user);
        session.flush();
        session.close();
        return id;
    }

    public void updateUser(User user) {
        Session session = getSessionFactory().openSession();
        session.merge(user);
        session.flush();
        session.close();
    }

    public void deleteUser(User user) {
        Session session = getSessionFactory().openSession();
        session.update(user);
        session.close();
    }

    public Role getUserRole() {
        Session session = getSessionFactory().openSession();
        StringBuilder sb = new StringBuilder("SELECT r FROM Role r WHERE r.role = :role");
        Query query = session.createQuery(sb.toString());
        query.setParameter("role", "ROLE_USER");
        Role user = (Role) query.uniqueResult();
        session.close();
        return user;
    }

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}