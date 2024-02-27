package cat.montse.DiceGame.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.montse.DiceGame.domain.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	Optional<Player> findByNameIgnoreCase(String name);
	
}
