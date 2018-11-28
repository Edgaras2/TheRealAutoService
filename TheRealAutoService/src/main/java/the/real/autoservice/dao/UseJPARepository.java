package the.real.autoservice.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import the.real.autoservice.entity.User;

@Repository
public interface UseJPARepository extends JpaRepository<User, Long> {
	void deleteById(Long id);
	User getById(Long id);
	Optional<User> findByUserName(String username);
	Optional<User> findUserByUserName(String username);

}

