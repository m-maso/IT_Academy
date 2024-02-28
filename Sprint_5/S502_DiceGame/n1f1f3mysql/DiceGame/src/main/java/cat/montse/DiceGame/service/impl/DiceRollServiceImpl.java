package cat.montse.DiceGame.service.impl;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cat.montse.DiceGame.domain.dto.DiceRollDTO;
import cat.montse.DiceGame.domain.entity.DiceRoll;
import cat.montse.DiceGame.domain.entity.Player;
import cat.montse.DiceGame.exceptions.EntityNotFoundException;
import cat.montse.DiceGame.repository.DiceRollRepository;
import cat.montse.DiceGame.repository.PlayerRepository;
import cat.montse.DiceGame.service.DiceRollMapper;
import cat.montse.DiceGame.service.DiceRollService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiceRollServiceImpl implements DiceRollService {

	private final DiceRollRepository diceRollRepository;
	private final PlayerRepository playerRepository;
	
	

	@Override
	public DiceRollDTO addDiceRoll(Long id) {
		
		Player player = playerRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Player with id " + id + " not found"));
		
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
		
		player.calculateSuccessPercentage();
		diceRollRepository.save(diceRoll);
		
		return DiceRollMapper.convertToDTO(diceRoll);
	}

	@Override
	@Transactional
	public void deleteAllDiceRolls(Long playerId) 
	{
		diceRollRepository.deleteAllByPlayerId(playerId);
	}

	@Override
	public List<DiceRollDTO> getAllDiceRolls(Long id) 
	{
		List<DiceRoll> diceRolls = diceRollRepository.findByPlayerId(id);
		List<DiceRollDTO> diceRollsDTO = diceRolls.stream().map(DiceRollMapper::convertToDTO).collect(Collectors.toList());
	
		return diceRollsDTO;
	}
	
	
}
