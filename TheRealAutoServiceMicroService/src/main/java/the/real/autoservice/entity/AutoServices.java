package the.real.autoservice.entity;

import java.time.LocalTime;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class AutoServices {
	
	private long id;
	private String title;
	private String time;
	private float price;
	
	public AutoServices supplyProduct(Supplier<AutoServices> sp) {
		return sp.get();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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

	
	public boolean emptyProduct(Predicate<AutoServices> pr) {
		return pr.test(this);
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	

}
