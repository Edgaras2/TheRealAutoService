package the.real.autoservice.security;

import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import the.real.autoservice.dao.UseJPARepository;
import the.real.autoservice.entity.Roles;
import the.real.autoservice.entity.User;

@Service
@Transactional
public class AuthService {

	private UseJPARepository userDao;
	private PasswordEncoder passwordEncoder;

	public AuthService(UseJPARepository userDao, PasswordEncoder passwordEncoder) {
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
	}

	public boolean authenticateUser(String username, String password) {

		return false;
	}

	public boolean registerUser(User user) {
		if (userDao.findByUserName(user.getUserName()).isPresent()) {
			return false;
		} else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setRoles(Set.of(Roles.CUSTOMER));
			userDao.save(user);
			return true;
		}

	}

}
