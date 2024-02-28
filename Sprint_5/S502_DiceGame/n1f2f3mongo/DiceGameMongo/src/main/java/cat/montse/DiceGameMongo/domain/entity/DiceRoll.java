package cat.montse.DiceGameMongo.domain.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "diceroll")
public class DiceRoll {

	@Id
	private String id;
	
	@DBRef
	private Player player;
	
	private int dice1;
	private int dice2;
	private boolean isWin;
	

	
	
	
}
