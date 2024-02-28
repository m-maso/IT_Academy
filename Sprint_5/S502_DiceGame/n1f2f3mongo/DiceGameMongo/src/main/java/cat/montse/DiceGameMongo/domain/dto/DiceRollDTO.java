package cat.montse.DiceGameMongo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiceRollDTO {

	private String id;
	private String playerId;
	private int dice1;
	private int dice2;
	private boolean isWin;
	
	
	@Override
	public String toString() {
		return "DiceRollDTO [id=" + id + ", playerId=" + playerId + ", dice1=" + dice1 + ", dice2=" + dice2 + ", isWin="
				+ isWin + "]";
	}
	
	
	
}
