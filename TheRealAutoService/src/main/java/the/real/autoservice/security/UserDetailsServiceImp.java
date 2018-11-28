package the.real.autoservice.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import the.real.autoservice.dao.UseJPARepository;
import the.real.autoservice.entity.Roles;
import the.real.autoservice.entity.User;

public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
	private UseJPARepository userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		/*
		 * Here we are using dummy data, you need to load user data from database or
		 * other third party application
		 */
		User user = findUserbyUsername(username);

		UserBuilder builder = null;
		if (user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(user.getPassword());
			List<String> strings = user
					.getRoles()
					.stream()
					.map(Roles::toString)
					.collect(Collectors.toList());
			String[] strArr = new String[strings.size()];
			strArr = strings.toArray(strArr);
			builder.roles(strArr);
		} else {
			throw new UsernameNotFoundException("User not found.");
		}

		return builder.build();
	}

	private User findUserbyUsername(String username) {
		return userDao.findByUserName(username).orElseThrow();
	}
}
