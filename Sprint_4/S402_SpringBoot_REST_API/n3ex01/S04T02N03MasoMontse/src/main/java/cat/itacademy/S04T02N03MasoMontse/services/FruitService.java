package cat.itacademy.S04T02N03MasoMontse.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;


import cat.itacademy.S04T02N03MasoMontse.domain.Fruit;
import cat.itacademy.S04T02N03MasoMontse.exceptions.FruitAlreadyExistsException;
import cat.itacademy.S04T02N03MasoMontse.exceptions.FruitNotFoundException;
import cat.itacademy.S04T02N03MasoMontse.repository.FruitRepository;

public class FruitService implements IFruitService {

	@Autowired
	private FruitRepository fruitRepository;
	
	public FruitService(FruitRepository fruitRepository)
	{
		this.fruitRepository = fruitRepository;
	}
	
	
	@Override
	public Fruit add(Fruit fruit) 
	{
		fruitRepository.findByNameIgnoreCase(fruit.getName())
		.ifPresent(f -> {
			throw new FruitAlreadyExistsException("It already exists a fruit with name " + fruit.getName());
		});
	
		return fruitRepository.save(fruit);
	}

	@Override
	public Fruit update(ObjectId id, Fruit updatedFruit) 
	{
		Optional<Fruit> searchedFruitDb = fruitRepository.findById(id);

		if(searchedFruitDb.isPresent()) {
			Fruit newFruitDb = searchedFruitDb.get();
			newFruitDb.setName(updatedFruit.getName());
			newFruitDb.setKgs(updatedFruit.getKgs());
			return fruitRepository.save(newFruitDb);
		} else {
			throw new FruitNotFoundException("Fruit with Id " + id + " is not found");
		}
	}

	@Override
	public void delete(ObjectId id) 
	{
		Fruit fruitFound = fruitRepository.findById(id).orElseThrow(
				() -> {
					throw new FruitNotFoundException("Fruit with Id " + id + " is not found");
				});
		
		fruitRepository.deleteById(fruitFound.getId());
	}

	@Override
	public Fruit getOne(ObjectId id) {
		return fruitRepository.findById(id).orElseThrow(
				() -> {
				 throw new FruitNotFoundException("Fruit with Id " + id + " is not found");
				});
	}

	@Override
	public List<Fruit> getAll() {
		return (List<Fruit>) fruitRepository.findAll();
	}

}
