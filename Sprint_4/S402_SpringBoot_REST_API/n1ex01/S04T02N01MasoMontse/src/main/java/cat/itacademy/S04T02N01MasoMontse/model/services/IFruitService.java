package cat.itacademy.S04T02N01MasoMontse.model.services;

import java.util.List;

import cat.itacademy.S04T02N01MasoMontse.exceptions.FruitNotFoundException;
import cat.itacademy.S04T02N01MasoMontse.model.domain.Fruit;

public interface IFruitService {

	Fruit add(Fruit fruit);
	Fruit update(int id, Fruit updatedFruit);
	void delete(int id) throws FruitNotFoundException;
	Fruit getOne(int id);
	List<Fruit> getAll();
	
}
