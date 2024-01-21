package cat.itacademy.S04T02N03MasoMontse.services;

import java.util.List;

import org.bson.types.ObjectId;

import cat.itacademy.S04T02N03MasoMontse.domain.Fruit;
import cat.itacademy.S04T02N03MasoMontse.exceptions.FruitNotFoundException;


public interface IFruitService {

	Fruit add(Fruit fruit);
	Fruit update(ObjectId id, Fruit updatedFruit);
	void delete(ObjectId id) throws FruitNotFoundException;
	Fruit getOne(ObjectId id);
	List<Fruit> getAll();
}
