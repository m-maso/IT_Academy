package cat.montse.DiceGame.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cat.montse.DiceGame.domain.dto.PlayerDTO;
import cat.montse.DiceGame.domain.entity.Player;
import cat.montse.DiceGame.exceptions.EntityAlreadyExistsException;
import cat.montse.DiceGame.exceptions.EntityNotFoundException;
import cat.montse.DiceGame.mapper.PlayerMapper;
import cat.montse.DiceGame.repository.PlayerRepository;
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
		
		List<PlayerDTO> playersRanking = allPlayers.stream()
	        .map(player -> {
	            PlayerDTO playerDTO = PlayerMapper.convertToDTO(player);
	            playerDTO.setSuccessPercentage(player.calculateSuccessPercentage());
	            return playerDTO; })
	        .collect(Collectors.toList());
		
		return playersRanking.stream()
				.filter(plDTO -> plDTO.getSuccessPercentage() != null)
				.sorted(Comparator.comparing(PlayerDTO::getSuccessPercentage).reversed())
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
	public List<PlayerDTO> getPlayerLowRanking() 
	{
		List<PlayerDTO> playersDTORanking = getAllPlayersWithAvgSuccessPercentage();
		
		double minScore = getAllPlayersWithAvgSuccessPercentage().stream()
				.min(Comparator.comparing(PlayerDTO::getSuccessPercentage))
				.map(PlayerDTO::getSuccessPercentage)
				.orElseThrow(NoSuchElementException::new);
		
		return playersDTORanking.stream()
				.filter(p -> p.getSuccessPercentage() == minScore)
				.toList();
	}

	
	@Override
	public List<PlayerDTO> getPlayerBestRanking() 
	{
		List<PlayerDTO> playersDTORanking = getAllPlayersWithAvgSuccessPercentage();
		
		double maxScore = getAllPlayersWithAvgSuccessPercentage().stream()
				.max(Comparator.comparing(PlayerDTO::getSuccessPercentage))
				.map(PlayerDTO::getSuccessPercentage)
				.orElseThrow(NoSuchElementException::new);
		
		return playersDTORanking.stream()
				.filter(p -> p.getSuccessPercentage() == maxScore)
				.toList();
	}

	
}
