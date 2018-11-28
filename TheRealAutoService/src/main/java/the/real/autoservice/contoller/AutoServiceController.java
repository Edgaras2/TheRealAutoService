package the.real.autoservice.contoller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import the.real.autoservice.entity.AutoServices;
import the.real.autoservice.entity.Car;
import the.real.autoservice.service.AutoServicesService;
import the.real.autoservice.service.CarService;

@Controller
@RequestMapping("/service")
public class AutoServiceController {

	private CarService carService;
	private AutoServicesService autoService;
	private static Long cId;

	public AutoServiceController(CarService carService, AutoServicesService autoService) {
		this.carService = carService;
		this.autoService = autoService;
	}

	@GetMapping("/add/{id}")
	public String service(@PathVariable Long id, Model model) {
		cId = id;
		return "redirect:/service/auto";
	}

	@GetMapping("/auto")
	public String auto(Model model) {
		Car car = carService.getOneCar(cId);
		List<AutoServices> serv = autoService.getServices();
		model.addAttribute("car", car);
		model.addAttribute("service", serv);
		model.addAttribute("AutoServices", car.getService());
		return "service";
	}
	//add service to specific car
	@GetMapping("/save/{id}")
	public String saveService(@PathVariable Long id, Model model) {
		AutoServices autoserv = autoService.getById(id);
		Car one = carService.getOneCar(cId);
		autoService.saveService(one, autoserv);
		return "redirect:/service/auto";
	}

	// remove service
	@GetMapping("/delete/{id}")
	public String deleteCar(@PathVariable Long id, Model model) {
		Car one = carService.getOneCar(cId);
		one.removeService(autoService.getById(id));
		carService.getOneCar(cId).getService();
		return "redirect:/service/auto";
	}

}
