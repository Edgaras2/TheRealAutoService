package the.real.autoservice.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import the.real.autoservice.dao.UseJPARepository;
import the.real.autoservice.entity.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	private UserService userServ;

	@Mock
	private UseJPARepository rep;
	private User user;

	@Before
	public void setUp() throws Exception {
		userServ = new UserService(rep);
		user = new User("aaa", "aaa", "aaa", "aaa", "aaa");
		user.setId(25L);
		rep.save(user);
	}

	@Test
	public void givenNewUser_whenSaving_thenUserSavedToDB() {

	}

	@Test
	public void givenUserId_whenGettingUser_thenUserIsReturned() {
		// given
		Long id = user.getId();
		// when
		when(rep.getById(user.getId())).thenReturn(user);
		User testUser = userServ.getUserByid(id);
		//then
		assertThat(testUser).isEqualToComparingFieldByField(user);
	}

	@Test
	public void givenUserId_whenDeletingUserById_thenUserIsDeleted() {
		//given
		Long id = user.getId();
		//when
		rep.deleteById(id);
		//then
		verify(rep).deleteById(id);
	}
	//TODO : fix test
	@Test
	public void givenUsername_whenGettingUser_thenUserIsReturned() {
		//given
		String username = user.getUserName();
		//when
		when(rep.findUserByUserName(username)).thenReturn(Optional.of(user));
		System.out.println();
		User testUser = userServ.getUserByUserName(username);
		System.out.println(testUser);
		//then
		assertThat(testUser).isEqualToComparingFieldByField(user);
		
	}

	@Test
	public void testGet11111() {
	}

}
