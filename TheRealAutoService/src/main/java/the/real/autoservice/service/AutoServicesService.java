package the.real.autoservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import the.real.autoservice.dao.ServiceJPARepository;
import the.real.autoservice.entity.AutoServices;
import the.real.autoservice.entity.Car;
import the.real.autoservice.entity.User;

@Service
@Transactional
public class AutoServicesService {

	private ServiceJPARepository service;
	
	public AutoServicesService(ServiceJPARepository service) {
		this.service = service;
	}
	public List<AutoServices> getServices() {
		return service.findAll().stream()
				.collect(Collectors.toList());
	}
	public AutoServices getById(Long id) {
		return service.getById(id);
	}
	public void saveService(Car car, AutoServices serv) {
		car.addServiceForCar(serv);
		service.save(serv);
	}
	public void deleteAutoServiceById(Long id) {
		service.deleteById(id);
	}
}
