package cat.montse.DiceGame.service;

import cat.montse.DiceGame.domain.dto.DiceRollDTO;
import cat.montse.DiceGame.domain.entity.DiceRoll;

public class DiceRollMapper {
	
	public static DiceRollDTO convertToDTO(DiceRoll diceRoll)
	{
		DiceRollDTO diceRollDTO = new DiceRollDTO();
		
		diceRollDTO.setId(diceRoll.getId());
		diceRollDTO.setPlayerId(diceRoll.getPlayer().getId());
		diceRollDTO.setDice1(diceRoll.getDice1());
		diceRollDTO.setDice2(diceRoll.getDice2());
		diceRollDTO.setWin(diceRoll.isWin());
		
		return diceRollDTO;
	}
	
}
