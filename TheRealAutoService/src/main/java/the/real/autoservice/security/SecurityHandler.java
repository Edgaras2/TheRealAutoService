package the.real.autoservice.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import the.real.autoservice.entity.User;
import the.real.autoservice.service.UserService;

@Component
public class SecurityHandler implements AuthenticationSuccessHandler {

	@Autowired
	private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		System.out.println("========Success handler==========");

		User user = userService.getUserByUserName(authentication.getName());

		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		response.sendRedirect(request.getContextPath() + "/main");

	}

}
