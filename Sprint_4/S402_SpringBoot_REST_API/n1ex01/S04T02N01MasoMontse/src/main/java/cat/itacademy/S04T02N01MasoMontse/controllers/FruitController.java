package cat.itacademy.S04T02N01MasoMontse.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.S04T02N01MasoMontse.model.domain.Fruit;
import cat.itacademy.S04T02N01MasoMontse.model.services.FruitService;

/* To config. Localhost we can write it here with @CrossOrigin or configure port.server in application.properties file 
@CrossOrigin(origins = "http://localhost:8080")  */

@RestController
@RequestMapping("/fruit")
public class FruitController {

	@Autowired // It allows Spring to resolve and inject collaborating beans into our bean
	private final FruitService fruitService;
	
	FruitController(FruitService fruitService) {
		this.fruitService = fruitService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Fruit> add(@RequestBody Fruit fruit)
	{
		Fruit savedFruit = fruitService.add(fruit);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(savedFruit);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Fruit> update(@PathVariable("id") int id, @RequestBody Fruit fruit) 
	{
		Fruit modifiedFruit = fruitService.update(id, fruit);
		
		return ResponseEntity.status(HttpStatus.OK).body(modifiedFruit);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id)
	{
		fruitService.delete(id);
		
		return ResponseEntity.ok("Fruit with id " + id + " deleted successfully");
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Fruit> findById(@PathVariable("id") int id)
	{
		Fruit searchedFruit = fruitService.getOne(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(searchedFruit);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		List<Fruit> searchedFruits = fruitService.getAll();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(searchedFruits);
	}
	
}