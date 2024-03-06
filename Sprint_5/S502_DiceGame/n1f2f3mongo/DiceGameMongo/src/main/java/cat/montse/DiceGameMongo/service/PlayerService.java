package cat.montse.DiceGameMongo.service;

import java.util.List;

import cat.montse.DiceGameMongo.domain.dto.PlayerDTO;
import cat.montse.DiceGameMongo.domain.entity.Player;

public interface PlayerService {

	PlayerDTO addPlayer(PlayerDTO playerDTO);
	Player modifyPlayerName(String playerId, String name);
	void deletePlayer(String playerId);
	
	List<PlayerDTO> getAllPlayersWithAvgSuccessPercentage();
	Double getAllPlayersAverageRanking();
	List<PlayerDTO> getPlayerLowRanking();
	List<PlayerDTO> getPlayerBestRanking();
	
}
