package cat.montse.DiceGame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.montse.DiceGame.domain.entity.DiceRoll;

public interface DiceRollRepository extends JpaRepository<DiceRoll, Long> {

	List<DiceRoll> findByPlayerId(Long id);
	void deleteAllByPlayerId(Long id);
	
}
