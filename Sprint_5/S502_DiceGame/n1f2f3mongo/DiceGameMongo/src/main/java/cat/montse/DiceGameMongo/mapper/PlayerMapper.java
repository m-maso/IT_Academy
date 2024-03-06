package cat.montse.DiceGameMongo.mapper;

import cat.montse.DiceGameMongo.domain.dto.PlayerDTO;
import cat.montse.DiceGameMongo.domain.entity.Player;

public class PlayerMapper {

	public static Player convertToEntity(PlayerDTO playerDTO)
	{
		Player player = new Player();
		
		player.setId(playerDTO.getPlayerId());
		player.setName(playerDTO.getPlayerName());
		player.setRegisterDate(playerDTO.getRegisterDate());
		player.setSuccessPercentage(playerDTO.getSuccessPercentage());
	
		return player;
	}
	
	
	public static PlayerDTO convertToDTO(Player player)
	{
		PlayerDTO playerDTO = new PlayerDTO();
		
		playerDTO.setPlayerId(player.getId());
		playerDTO.setPlayerName(player.getName());
		playerDTO.setRegisterDate(player.getRegisterDate());
		playerDTO.setSuccessPercentage(player.getSuccessPercentage());
	
		return playerDTO;
	}
}
