package the.real.autoservice.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import the.real.autoservice.entity.User;

@Repository
public interface AuthJpaRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserNameAndPassword(String username, String password);
	Optional<User> findByUserName(String username);
}
