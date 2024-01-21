package cat.itacademy.S04T02N02MasoMontse.services;

import java.util.List;
import cat.itacademy.S04T02N02MasoMontse.domain.Fruit;
import cat.itacademy.S04T02N02MasoMontse.exceptions.FruitNotFoundException;

public interface IFruitService {

	Fruit add(Fruit fruit);
	Fruit update(int id, Fruit updatedFruit);
	void delete(int id) throws FruitNotFoundException;
	Fruit getOne(int id);
	List<Fruit> getAll();
	
}
