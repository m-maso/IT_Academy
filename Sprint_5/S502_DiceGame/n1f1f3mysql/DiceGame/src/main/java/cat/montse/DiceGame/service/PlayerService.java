package cat.montse.DiceGame.service;

import java.util.List;

import cat.montse.DiceGame.domain.dto.PlayerDTO;
import cat.montse.DiceGame.domain.entity.Player;

public interface PlayerService {

	PlayerDTO addPlayer(PlayerDTO playerDTO);
	Player modifyPlayerName(Long playerId, String name);
	void deletePlayer(Long playerId);
	
	List<PlayerDTO> getAllPlayersWithAvgSuccessPercentage();
	Double getAllPlayersAverageRanking();
	PlayerDTO getPlayerLowRanking();
	PlayerDTO getPlayerBestRanking();



	
	
	
	
	
	
}
