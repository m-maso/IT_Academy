package cat.montse.DiceGameMongo.service;

import java.util.List;

import cat.montse.DiceGameMongo.domain.dto.DiceRollDTO;

public interface DiceRollService {

	DiceRollDTO addDiceRoll(String playerId);
	void deleteAllDiceRolls(String playerId);
	List<DiceRollDTO> getAllDiceRolls(String playerId);
	
}
