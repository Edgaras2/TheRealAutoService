package the.real.autoservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import the.real.autoservice.dao.CarJPARepository;
import the.real.autoservice.entity.Car;
import the.real.autoservice.entity.User;

@Service
@Transactional
public class CarService {

	private CarJPARepository carDAO;

	public CarService(CarJPARepository carDAO) {
		this.carDAO = carDAO;
	}

	// saving car
	public void saveCar(Car car, User user) {
		user.addCarForUser(car);
		carDAO.save(car);
	}

	// delete carById
	public void deleteCarById(Long id) {
		carDAO.deleteById(id);
	}
	//getting all cars 
	public List<Car> getAllCars() {
		return carDAO.findAll();
	}
	//getting car list by specific user
	public List<Car> getAllCarsForSpecificUser(User user) {
		return carDAO.findByUserId(user.getId());
	}
	public Car getOneCar(Long id) {
		return carDAO.getById(id);
	}
}
