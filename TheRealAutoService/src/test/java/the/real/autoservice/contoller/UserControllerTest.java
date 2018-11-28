package the.real.autoservice.contoller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import the.real.autoservice.entity.User;
import the.real.autoservice.security.AuthService;
import the.real.autoservice.service.AutoServicesService;
import the.real.autoservice.service.CarService;
import the.real.autoservice.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	
	private UserController controller;
	
	@Mock
	private UserService userService;
	@Mock
	private CarService carService;
	@Mock
	private AuthService authService;
	@Mock
	private AutoServicesService service;
	@Mock
	private PasswordEncoder passwordEncoder;
	private User user;
	
	
	@Before
	public void setUp() throws Exception {
		controller = new UserController(userService, carService, authService, service, passwordEncoder);
		user = new User("aaa", "aaa", "aaa", "aaa", "aaa");
		userService.saveUser(user);
	}

	@Test
	public void testRegistrationForm() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegisterUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testMainPage() {
		fail("Not yet implemented");
	}

	@Test
	public void givenUserId_whenDeleting_thenServiceDeletesUser() {
		//given
		Long id =user.getId();
		//when
		controller.deleteUser(id);
		//then
		verify(userService).deleteUserById(id);
		
	}

	@Test
	public void testEditForm() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditUser() {
		fail("Not yet implemented");
	}

}
