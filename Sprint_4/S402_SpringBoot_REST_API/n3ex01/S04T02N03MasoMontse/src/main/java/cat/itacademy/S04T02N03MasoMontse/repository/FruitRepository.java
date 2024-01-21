package cat.itacademy.S04T02N03MasoMontse.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;

import cat.itacademy.S04T02N03MasoMontse.domain.Fruit;


public interface FruitRepository extends MongoRepository<Fruit, ObjectId> {

	Optional<Fruit> findByNameIgnoreCase(String name);
	
}
