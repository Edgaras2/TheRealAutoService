package the.real.autoservice.contoller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import the.real.autoservice.entity.AutoServices;
import the.real.autoservice.entity.Car;
import the.real.autoservice.entity.User;
import the.real.autoservice.security.AuthService;
import the.real.autoservice.service.AutoServicesService;
import the.real.autoservice.service.CarService;
import the.real.autoservice.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {
	
	private UserService userService;
	private CarService carService;
	private AuthService authService;
	private AutoServicesService service;
	private PasswordEncoder passwordEncoder;
	
	public UserController(UserService userService, CarService carService, AuthService authService,
			AutoServicesService service, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.carService = carService;
		this.authService = authService;
		this.service = service;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/register")
	public String registrationForm(Model model) {
		model.addAttribute(new User());
		return "register";
	}

	// Registration
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "register";
		}
		authService.registerUser(user);
		return "redirect:/";
	}

	@GetMapping("/main") 
	public String mainPage(@SessionAttribute("user") User user, Car car, Model model) {
		List<AutoServices> allServices = service.getServices();
		List<Car> carz = carService.getAllCarsForSpecificUser(user);
		model.addAttribute("service" , allServices);
		model.addAttribute("car", carz);
		model.addAttribute("user", user);
	
		return "main-page";
	}

	// delete user
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "redirect:/";
	}

	// edit and save
	@PostMapping("/edit")
	public String editForm(@ModelAttribute User user, Model model) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.saveUser(user);
		return "redirect:/main";
	}

	// edit user
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable Long id, Model model) {
		User tempUser = userService.getUserByid(id);
		model.addAttribute("user", tempUser);
		return "edit";
	}

}
