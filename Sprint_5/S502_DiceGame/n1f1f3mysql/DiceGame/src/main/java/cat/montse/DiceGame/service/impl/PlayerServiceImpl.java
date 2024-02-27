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
		
		List<PlayerDTO> allPlayersDTO = allPlayers.stream()
	        .map(player -> {
	            PlayerDTO playerDTO = PlayerMapper.convertToDTO(player);
	            playerDTO.setSuccessPercentage(player.calculateSuccessPercentatge());
	            player.setSuccessPercentage(player.calculateSuccessPercentatge());
	            return playerDTO;
	        })
	        .collect(Collectors.toList());
				
		return allPlayersDTO;
	}

	
	@Override
	public Double getAllPlayersAverageRanking() 
	{
		List<Player> allPlayers = playerRepository.findAll();
		
		return allPlayers.stream()
				.mapToDouble(Player::calculateSuccessPercentatge)
				.average()
				.orElse(0);
	}

	
	@Override
	public PlayerDTO getPlayerLowRanking() 
	{		
		List<Player> allPlayers = playerRepository.findAll();
		
		Player loser = allPlayers.stream()
			.filter(player -> player.getSuccessPercentage() != null)
		   	.min(Comparator.comparingDouble(Player::calculateSuccessPercentatge))
			.orElseThrow(() -> new EntityNotFoundException("Loser player not found"));
		
		return PlayerMapper.convertToDTO(loser);	
	}

	@Override
	public PlayerDTO getPlayerBestRanking() 
	{
		List<Player> allPlayers = playerRepository.findAll();
		
		Player winner = allPlayers.stream()
			.filter(player -> player.getSuccessPercentage() != null)
			.max(Comparator.comparingDouble(Player::calculateSuccessPercentatge))
			.orElseThrow(() -> new EntityNotFoundException("Winner player not found"));
		
		return PlayerMapper.convertToDTO(winner);	
	}

	

	
}
