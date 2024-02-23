package cat.itacademy.S05T01N01MasoMontse.model.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "branch")
public class Branch implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pk_BranchID;
	
	@NotEmpty
	private String branchName;
	
	@NotEmpty
	private String branchCountry;
	
	
	
	public Branch() {}
	
	public Branch(String branchName, String branchCountry) 
	{
		this.branchName = branchName;
		this.branchCountry = branchCountry;
	}
	
	public Branch(int pk_BranchID, String branchName, String branchCountry) 
	{
		this.pk_BranchID = pk_BranchID;
		this.branchName = branchName;
		this.branchCountry = branchCountry;
	}
	
	
	public int getPk_BranchID() {
		return pk_BranchID;
	}
	public String getBranchName() {
		return branchName;
	}
	public String getBranchCountry() {
		return branchCountry;
	}
	
	public void setPk_BranchID(int pk_BranchID) {
		this.pk_BranchID = pk_BranchID;
	}
	public void setName(String branchName) {
		this.branchName = branchName;
	}
	public void setBranchCountry(String branchCountry) {
		this.branchCountry = branchCountry;
	}
	
	
	public String toString()
	{
		return "Branch -> Id: " +  this.pk_BranchID + ", Name: " + this.branchName + ", Country: " +  this.branchCountry;
	}
	
}
