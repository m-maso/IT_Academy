package cat.montse.DiceGameMongo.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@Document(collection = "player")
public class Player {

	@Id
	private String id;
	
	private String name;
	private Date registerDate;
	private Double successPercentage;
	private int diceRollsWon;
	private int totalDiceRolls;
	
	@DBRef
	private List<DiceRoll> playerDiceRolls;
	
	@DBRef
	private User user;


	
	public Player(String name)
	{
		this.name = name;
		this.registerDate = new Date();
		this.successPercentage = null;
		this.diceRollsWon = 0;
		this.totalDiceRolls = 0;
	}
	
	



	public void addDiceRoll(DiceRoll diceRoll)
	{
		if(playerDiceRolls == null)
		{
			playerDiceRolls = new ArrayList<DiceRoll>();
		}
		playerDiceRolls.add(diceRoll);
		totalDiceRolls++;
	}
	
	public void deleteAllDiceRolls() 
	{
		successPercentage = null;
		diceRollsWon = 0;
		totalDiceRolls = 0;
	}
	
	public void addRollsWon() {
		diceRollsWon++;
	}
	
	public double calculateSuccessPercentage()
	{
		if (playerDiceRolls == null || playerDiceRolls.isEmpty()) 
		{
           return 0;
	    }
		
		double successPerc = (double) ((diceRollsWon * 100) / totalDiceRolls);
		
		setSuccessPercentage(successPerc);
		
		return successPercentage;
	}
}
