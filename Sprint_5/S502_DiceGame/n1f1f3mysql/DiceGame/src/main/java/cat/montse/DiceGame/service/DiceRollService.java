package cat.montse.DiceGame.service;

import java.util.List;

import cat.montse.DiceGame.domain.dto.DiceRollDTO;

public interface DiceRollService {

	DiceRollDTO addDiceRoll(Long id);
	void deleteAllDiceRolls(Long id);
	List<DiceRollDTO> getAllDiceRolls(Long id);
}
