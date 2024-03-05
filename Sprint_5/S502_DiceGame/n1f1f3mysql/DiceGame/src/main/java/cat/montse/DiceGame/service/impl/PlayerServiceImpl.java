package cat.montse.DiceGame.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cat.montse.DiceGame.domain.dto.PlayerDTO;
import cat.montse.DiceGame.domain.entity.Player;
import cat.montse.DiceGame.exceptions.EntityAlreadyExistsException;
import cat.montse.DiceGame.exceptions.EntityNotFoundException;
import cat.montse.DiceGame.repository.PlayerRepository;
import cat.montse.DiceGame.service.PlayerMapper;
import cat.montse.DiceGame.service.PlayerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

	private final PlayerRepository playerRepository;
	

	@Override
	public PlayerDTO addPlayer(PlayerDTO playerDTO) 
	{
		String playerName = playerDTO.getPlayerName();
		
		if(playerName.isEmpty() || playerName == null)
		{
			playerDTO.setPlayerName("Anonymous");
		} 
		else {
			playerRepository.findByNameIgnoreCase(playerName)
				.ifPresent(p -> {
					throw new EntityAlreadyExistsException("The name " + playerName + " is already taken");
				});
		}
		
		Player player = PlayerMapper.convertToEntity(playerDTO);
		playerRepository.save(player);
		
		return PlayerMapper.convertToDTO(player); 
	}

	
	@Override
	@Transactional
	public Player modifyPlayerName(Long playerId, String updatedName) 
	{	
		Player player = playerRepository.findById(playerId).orElseThrow(
				() -> new EntityNotFoundException("Player with id " + playerId + " not found"));
		
		if(playerRepository.findByNameIgnoreCase(updatedName).isPresent())
		{
			throw new EntityAlreadyExistsException("Player's name " + updatedName + " is already taken");
		}
		
		player.setName(updatedName);
		
		return playerRepository.save(player);
	}

	
	@Override
	@Transactional
	public void deletePlayer(Long playerId) 
	{
		playerRepository.findById(playerId).orElseThrow(
				() -> {
					throw new EntityNotFoundException("Player with Id " + playerId + " is not found");
				});
		playerRepository.deleteById(playerId);
	}
	
	
	@Override
	public List<PlayerDTO> getAllPlayersWithAvgSuccessPercentage() 
	{
		List<Player> allPlayers = playerRepository.findAll();
		
		return allPlayers.stream()
	        .map(player -> {
	            PlayerDTO playerDTO = PlayerMapper.convertToDTO(player);
	            playerDTO.setSuccessPercentage(player.calculateSuccessPercentage());
	            return playerDTO; })
	        .collect(Collectors.toList());
	}

	
	@Override
	public Double getAllPlayersAverageRanking() 
	{
		List<Player> allPlayers = playerRepository.findAll();
		
		return allPlayers.stream()
				.filter(player -> player.getSuccessPercentage() != null)
				.mapToDouble(Player::getSuccessPercentage)
				.average()
				.orElse(0);
	}

	
	@Override
	public PlayerDTO getPlayerLowRanking() 
	{		
		List<PlayerDTO> playersSuccPercent = getAllPlayersWithAvgSuccessPercentage();
		
		return playersSuccPercent.stream()
				.filter(p -> p.getSuccessPercentage() != null)
				.min(Comparator.comparingDouble(PlayerDTO::getSuccessPercentage))
				.orElseThrow(() -> new EntityNotFoundException("Loser player not found"));
	}

	@Override
	public PlayerDTO getPlayerBestRanking() 
	{
		List<PlayerDTO> playersSuccPercent = getAllPlayersWithAvgSuccessPercentage();
		
		return playersSuccPercent.stream()
				.filter(p -> p.getSuccessPercentage() != null)
				.max(Comparator.comparingDouble(PlayerDTO::getSuccessPercentage))
				.orElseThrow(() -> new EntityNotFoundException("Loser player not found"));
	}

	

	
}
