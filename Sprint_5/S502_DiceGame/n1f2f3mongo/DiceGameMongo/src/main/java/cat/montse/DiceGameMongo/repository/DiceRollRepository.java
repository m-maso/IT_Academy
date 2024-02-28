package cat.montse.DiceGameMongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cat.montse.DiceGameMongo.domain.entity.DiceRoll;

public interface DiceRollRepository extends MongoRepository<DiceRoll, String> {

	List<DiceRoll> findByPlayerId(String id);
	void deleteAllByPlayerId(String id);
	
}
