package cat.montse.DiceGame.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiceRollDTO {

	private Long id;
	private Long playerId;
	private int dice1;
	private int dice2;
	private boolean isWin;
	

	@Override
	public String toString() {
		return "DiceRollDTO [Id=" + id + ", player=" + playerId + ", dice1=" + dice1 + ", dice2=" + dice2
				+ ", isWin=" + isWin + "]";
	}
	
	
}
