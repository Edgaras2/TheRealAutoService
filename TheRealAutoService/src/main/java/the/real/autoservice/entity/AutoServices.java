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
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "services")
public class AutoServices {
	// TODO make many to many connection with cascading

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "time")
	private String time;

	@Column(name = "price")
	private float price;

	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade({ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
//	@Cascade(CascadeType.ALL)
	@JoinTable(name = "car_service", joinColumns = @JoinColumn(name = "service_id"), inverseJoinColumns = @JoinColumn(name = "car_id"))
	private List<Car> cars;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "AutoServices [id=" + id + ", title=" + title + ", time=" + time + ", price=" + price + "]";
	}

//	public LocalDateTime getTime() {
//		return time;
//	}
//	public void setTime(LocalDateTime time) {
//		this.time = time;
//	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
