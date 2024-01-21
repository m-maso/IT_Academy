package cat.itacademy.S04T02N01MasoMontse.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.S04T02N01MasoMontse.model.domain.Fruit;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Integer> {
	// or extends CrudRepository 

	Optional<Fruit> findByNameIgnoreCase(String name);
	
	 /* Now we can use JpaRepository's methods:
	  * save(), findOne(), findById(), findAll(), count(), delete(), deleteById ... without implementing these methods
	  * */
}
