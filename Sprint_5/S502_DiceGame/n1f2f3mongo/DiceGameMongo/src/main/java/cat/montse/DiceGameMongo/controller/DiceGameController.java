package cat.montse.DiceGameMongo.controller;

import java.util.List;

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

import cat.montse.DiceGameMongo.domain.dto.DiceRollDTO;
import cat.montse.DiceGameMongo.domain.dto.PlayerDTO;
import cat.montse.DiceGameMongo.domain.entity.Player;
import cat.montse.DiceGameMongo.service.DiceRollService;
import cat.montse.DiceGameMongo.service.PlayerService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/players")
@RequiredArgsConstructor
public class DiceGameController {

	private final PlayerService playerService;
	private final DiceRollService diceRollService;
	

	
	@PostMapping
	public ResponseEntity<PlayerDTO> addPlayer(@RequestBody PlayerDTO playerDTO)
	{
		PlayerDTO savedPlayer = this.playerService.addPlayer(playerDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPlayer); 
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Player> modifyPlayerName(@PathVariable("id") String playerId, @RequestBody String name)
	{
		Player modifiedPlayer = this.playerService.modifyPlayerName(playerId, name);
		
		return ResponseEntity.status(HttpStatus.OK).body(modifiedPlayer);
	}
	
	
	@PostMapping("/{id}/games/")
	public ResponseEntity<DiceRollDTO> diceRoll(@PathVariable String id)
	{
		DiceRollDTO diceRoll = this.diceRollService.addDiceRoll(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(diceRoll);
	}
	
	
	@DeleteMapping("/{id}/games")
	public ResponseEntity<String> deletePlayerRolls(@PathVariable String id)
	{
		this.diceRollService.deleteAllDiceRolls(id);
		
		return ResponseEntity.ok("Dice rolls of player with id " + id + " deleted successfully");
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<PlayerDTO>> getAllPlayersWithAvgSuccessPercentage()
	{
		List<PlayerDTO> searchedPlayers = this.playerService.getAllPlayersWithAvgSuccessPercentage();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(searchedPlayers);
	}
	
	
	@GetMapping("/{id}/games")
	public ResponseEntity<List<DiceRollDTO>> getAllDiceRollsPlayer(@PathVariable String id, @RequestBody Player player)
	{
		List<DiceRollDTO> searchedDiceRolls = this.diceRollService.getAllDiceRolls(id);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(searchedDiceRolls);
	}
	
	
	@GetMapping("/ranking")
	public ResponseEntity<Double> getAverageRanking()
	{
		double averageSuccessPercentage = this.playerService.getAllPlayersAverageRanking();
	
		return new ResponseEntity<>(averageSuccessPercentage, HttpStatus.OK);
	}
	

	@GetMapping("/ranking/loser")
	public ResponseEntity<List<PlayerDTO>> getPlayerLowRanking()
	{
		List<PlayerDTO> losersDTO = this.playerService.getPlayerLowRanking();
		
		return ResponseEntity.status(HttpStatus.OK).body(losersDTO);
	}

	
	@GetMapping("/ranking/winner")
	public ResponseEntity<List<PlayerDTO>> getPlayerBestRanking()
	{
		List<PlayerDTO> winnersDTO = this.playerService.getPlayerLowRanking();
		
		return ResponseEntity.status(HttpStatus.OK).body(winnersDTO);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePlayer(@PathVariable String id)
	{
		this.playerService.deletePlayer(id);
		
		return ResponseEntity.ok("Player with id " + id + " deleted successfully");
	}
	
	
}
