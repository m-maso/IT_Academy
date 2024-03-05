package cat.montse.DiceGame.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "player")
public class Player implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(nullable = false)
	@CreationTimestamp(source = SourceType.DB)
	private Date registerDate;
	
	private Double successPercentage;
	private int diceRollsWon;
	private int totalDiceRolls;
	
	@OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<DiceRoll> playerDiceRolls;
	
	
	
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
		if (playerDiceRolls.isEmpty() || playerDiceRolls == null) 
		{
           return 0d;
	    }
		
		double successPerc = (double) ((diceRollsWon * 100) / totalDiceRolls);
		
		setSuccessPercentage(successPerc);
		
		return successPercentage;
	}
	
}
