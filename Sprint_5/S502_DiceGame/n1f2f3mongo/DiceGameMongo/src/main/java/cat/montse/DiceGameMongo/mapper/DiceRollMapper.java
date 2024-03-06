package cat.montse.DiceGameMongo.mapper;

import cat.montse.DiceGameMongo.domain.dto.DiceRollDTO;
import cat.montse.DiceGameMongo.domain.entity.DiceRoll;

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
