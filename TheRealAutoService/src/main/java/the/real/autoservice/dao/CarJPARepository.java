package the.real.autoservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import the.real.autoservice.entity.Car;

@Repository
public interface CarJPARepository extends JpaRepository<Car, Long> {
	void deleteById(Long id);
	Car getById(Long id);
	List<Car> findByUserId(Long id);
	
}
