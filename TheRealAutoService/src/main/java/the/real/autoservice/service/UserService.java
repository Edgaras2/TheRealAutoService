package the.real.autoservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import the.real.autoservice.dao.UseJPARepository;
import the.real.autoservice.entity.User;

@Service
@Transactional
public class UserService {

	private UseJPARepository userDAO;

	public UserService(UseJPARepository userDAO) {
		this.userDAO = userDAO;
	}

	// save User
	public void saveUser(User user) {
		userDAO.save(user);
	}

	// get User by id
	public User getUserByid(Long id) {
		return userDAO.getById(id);
	}

	// delete user by id
	public void deleteUserById(Long id) {
		userDAO.deleteById(id);
	}
	//using in SeucirtyHandler class
	public User getUserByUserName(String userName) {
		return userDAO.findByUserName(userName).get();
	}
	

}
