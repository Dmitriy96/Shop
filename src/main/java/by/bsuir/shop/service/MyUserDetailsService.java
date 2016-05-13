package by.bsuir.shop.service;

import by.bsuir.shop.dao.UserDao;
import by.bsuir.shop.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

	static Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);
    @Autowired
	private UserDao userDao;

	@Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        by.bsuir.shop.model.User user = userDao.getUserByUsername(username);
		Set<String> roles = new HashSet<String>();
        for (Role role : user.getUserRoles()) {
            roles.add(role.getRole());
        }
		Set<GrantedAuthority> authorities = buildUserAuthority(roles);
		return new User(user.getUsername(), user.getPassword(), user.isAvailable(), true, true, true, authorities);
	}

	private Set<GrantedAuthority> buildUserAuthority(Set<String> userRoles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		for (String userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole));
		}
		return setAuths;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}