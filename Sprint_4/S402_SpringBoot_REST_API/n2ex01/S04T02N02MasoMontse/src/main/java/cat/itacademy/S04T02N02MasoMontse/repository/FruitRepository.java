package cat.itacademy.S04T02N02MasoMontse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.S04T02N02MasoMontse.domain.Fruit;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Integer> {

	Optional<Fruit> findByNameIgnoreCase(String name);
}
