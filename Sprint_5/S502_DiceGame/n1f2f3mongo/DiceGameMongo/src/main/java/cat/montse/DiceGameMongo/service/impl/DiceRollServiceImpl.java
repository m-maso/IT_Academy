package cat.montse.DiceGameMongo.service.impl;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cat.montse.DiceGameMongo.domain.dto.DiceRollDTO;
import cat.montse.DiceGameMongo.domain.entity.DiceRoll;
import cat.montse.DiceGameMongo.domain.entity.Player;
import cat.montse.DiceGameMongo.exceptions.EntityNotFoundException;
import cat.montse.DiceGameMongo.repository.DiceRollRepository;
import cat.montse.DiceGameMongo.repository.PlayerRepository;
import cat.montse.DiceGameMongo.service.DiceRollMapper;
import cat.montse.DiceGameMongo.service.DiceRollService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiceRollServiceImpl implements DiceRollService {

	private final DiceRollRepository diceRollRepository;
	private final PlayerRepository playerRepository;
	
	

	@Override
	public DiceRollDTO addDiceRoll(String playerId) 
	{
		Player player = playerRepository.findById(playerId).orElseThrow(
				() -> new EntityNotFoundException("Player with id " + playerId + " not found")); 
				
		
		Random random = new Random();
		int dice1 = random.nextInt(6) + 1;
		int dice2 = random.nextInt(6) + 1;
		int winnerValue = 7;
		boolean isWin = (dice1 + dice2) == winnerValue;
		
		DiceRoll diceRoll = new DiceRoll();
		diceRoll.setPlayer(player);
		diceRoll.setDice1(dice1);
		diceRoll.setDice2(dice2);
		diceRoll.setWin(isWin);
		
		player.addDiceRoll(diceRoll);
		
		if(isWin == true)
		{
			player.addRollsWon();
		}

		player.setSuccessPercentage(player.calculateSuccessPercentage());
//		playerRepository.save(player);
		diceRollRepository.save(diceRoll);
		
		return DiceRollMapper.convertToDTO(diceRoll);
	}

	
	@Override
	public void deleteAllDiceRolls(String playerId) 
	{
		Player player = playerRepository.findById(playerId).orElseThrow(
				() -> new EntityNotFoundException("Player with id " + playerId + " not found"));
		
		player.deleteAllDiceRolls();
		diceRollRepository.deleteAllByPlayerId(playerId);
	}

	
	@Override
	public List<DiceRollDTO> getAllDiceRolls(String playerId) 
	{		
		List<DiceRoll> allDiceRolls = diceRollRepository.findByPlayerId(playerId);
		return allDiceRolls.stream()
					.map(DiceRollMapper::convertToDTO)
					.collect(Collectors.toList());
	}

	
}
