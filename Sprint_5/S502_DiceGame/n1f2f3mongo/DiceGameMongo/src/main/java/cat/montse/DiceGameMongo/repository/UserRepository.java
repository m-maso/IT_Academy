package cat.montse.DiceGameMongo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import cat.montse.DiceGameMongo.domain.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

	Optional<User> findByEmail(String email);
	
}
