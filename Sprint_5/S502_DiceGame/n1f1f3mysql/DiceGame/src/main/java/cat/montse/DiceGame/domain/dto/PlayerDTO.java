package cat.montse.DiceGame.domain.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {

	private Long playerId;
	private String playerName;
	private Date registerDate;
	private Double successPercentage;

	
	public PlayerDTO(String playerName)
	{
		this.playerName = playerName;
	}

	
	@Override
	public String toString() {
		return "PlayerDTO [playerId=" + playerId + ", playerName=" + playerName + ", registerDate=" + registerDate
				+ ", successPercentage=" + successPercentage + "]";
	}
	
	
	
}
