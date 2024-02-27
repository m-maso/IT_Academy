package cat.montse.DiceGame.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.montse.DiceGame.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
	
}
