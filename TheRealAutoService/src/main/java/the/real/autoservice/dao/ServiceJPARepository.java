package the.real.autoservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import the.real.autoservice.entity.AutoServices;

@Repository
public interface ServiceJPARepository extends JpaRepository<AutoServices, Long> {
	AutoServices getById(Long id);
	void deleteById(Long id);
	
}
