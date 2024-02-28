package cat.montse.DiceGameMongo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import cat.montse.DiceGameMongo.domain.entity.Player;

public interface PlayerRepository extends MongoRepository<Player, String> {

	Optional<Player> findByNameIgnoreCase(String name);
	
}
