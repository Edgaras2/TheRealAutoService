package the.real.autoservice.contoller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import the.real.autoservice.entity.AutoServices;
import the.real.autoservice.service.AutoservicesService;


@RestController
@RequestMapping("/services")
public class ServiceController {

	private final AutoservicesService service;

	public ServiceController(AutoservicesService service) {
		this.service = service;
	}

	@GetMapping
	@ResponseBody
	public List<AutoServices> getProductList() throws IOException {
		
		return service.loadServicesFromJson();
	}

}
