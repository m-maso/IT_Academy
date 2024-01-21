package cat.itacademy.S04T02N02MasoMontse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import cat.itacademy.S04T02N02MasoMontse.domain.Fruit;
import cat.itacademy.S04T02N02MasoMontse.exceptions.FruitAlreadyExistsException;
import cat.itacademy.S04T02N02MasoMontse.exceptions.FruitNotFoundException;
import cat.itacademy.S04T02N02MasoMontse.repository.FruitRepository;

@Service
public class FruitService implements IFruitService {

	@Autowired
	private FruitRepository fruitRepository;
	
	public FruitService(FruitRepository fruitRepository)
	{
		this.fruitRepository = fruitRepository;
	}
	
	
	
	@Override
	@Transactional
	public Fruit add(Fruit fruit) 
	{
		fruitRepository.findByNameIgnoreCase(fruit.getName())
		.ifPresent(f -> {
			throw new FruitAlreadyExistsException("It already exists a fruit with name " + fruit.getName());
		});
	
		return fruitRepository.save(fruit);
	}

	@Override
	@Transactional
	public Fruit update(int id, Fruit updatedFruit) 
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
	@Transactional
	public void delete(int id) 
	{
		Fruit fruitFound = fruitRepository.findById(id).orElseThrow(
				() -> {
					throw new FruitNotFoundException("Fruit with Id " + id + " is not found");
				});
		
		fruitRepository.deleteById(fruitFound.getId());
	}

	//getOne is @Deprecated //use findById() instead
	@Override
	@Transactional(readOnly = true)
	public Fruit getOne(int id) 
	{
		return fruitRepository.findById(id).orElseThrow(
				() -> {
				 throw new FruitNotFoundException("Fruit with Id " + id + " is not found");
				});
	}

	@Override
	@Transactional(readOnly = true)
	public List<Fruit> getAll() 
	{
		return (List<Fruit>) fruitRepository.findAll();
	}

}
