package the.real.autoservice.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import the.real.autoservice.dao.UseJPARepository;
import the.real.autoservice.entity.Car;
import the.real.autoservice.entity.User;
import the.real.autoservice.service.CarService;
import the.real.autoservice.service.UserService;

@Controller
public class CarController {

	private CarService carService;
	private UseJPARepository userDao;
	private UserService userService;

	public CarController(CarService carService, UseJPARepository userDao, UserService userService) {
		this.carService = carService;
		this.userDao = userDao;
		this.userService = userService;
	}

	// save new car
	@PostMapping("/car")
	public String openCarPage(@SessionAttribute("user") User user2, @ModelAttribute Car car, Model model) {
		User user = userService.getUserByid(user2.getId());
		carService.saveCar(car, user);
		return "redirect:/main";
	}

	@GetMapping("/car")
	public String car(Model model) {
		return "redirect:/main";
	}

	// create new car
	@GetMapping("/car/{id}")
	public String addNewCar(@SessionAttribute("user") User user2, @PathVariable Long id, Model model) {
		User user = userService.getUserByid(user2.getId());
		model.addAttribute("car", new Car());
		model.addAttribute("user", user);
		return "car";
	}
	// delete carById
	@GetMapping("/car/delete/{id}")
	public String deleteCar(@PathVariable Long id, Model model) {
		carService.deleteCarById(id);
		return "redirect:/car";
	}

}
