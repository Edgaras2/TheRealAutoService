package the.real.autoservice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "car")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "model")
	private String model;

	@Column(name = "car_plate")
	private String carPlate;

	@ManyToOne()
	@Cascade({ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade({ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name = "car_service", joinColumns = @JoinColumn(name = "car_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
	private List<AutoServices> service;

	
    public void removeService(AutoServices serv) {
    	service.remove(serv);
    }  
    
	// add service for car
	public void addServiceForCar(AutoServices tempService) {
		if (service == null) {
			service = new ArrayList<>();
		}
		service.add(tempService);
	}

	public Car() {
	}

	public Car(String model, String carPlate) {
		this.model = model;
		this.carPlate = carPlate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<AutoServices> getService() {
		return service;
	}

	public void setService(List<AutoServices> service) {
		this.service = service;
	}

	public String getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", carPlate=" + carPlate + ", user=" + user + "]";
	}

}
