package cat.itacademy.S05T01N01MasoMontse.model.dto;

import java.util.Arrays;
import java.util.List;

public class BranchDTO {

	private int pk_BranchID;
	private String branchName;
	private String branchCountry;
	private String branchType;
	private final List<String> euCountries = Arrays.asList("austria","belgium","bulgaria","croatia","cyprus","czech republic","denmark","estonia","finland","france","germany","greece","hungary","ireland","italy","latvia","lithuania","luxembourg","malta","netherlands","poland","portugal","romania","slovakia","slovenia","spain","sweden");
	
	public BranchDTO() {}
	
	public BranchDTO(int pk_BranchID, String branchName, String branchCountry) 
	{
		this.pk_BranchID = pk_BranchID;
		this.branchName = branchName;
		this.branchCountry = branchCountry;
		this.branchType = createBranchType(branchCountry);
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
	public String getBranchType() {
		return branchType;
	}
	
	public void setPk_BranchID(int pk_BranchID) {
		this.pk_BranchID = pk_BranchID;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public void setBranchCountry(String branchCountry) {
		this.branchCountry = branchCountry;
	}
	public void setBranchType(String branchType) {
		this.branchType = branchType;
	}
	
	
	
	public String createBranchType(String branchCountry)
	{
		String type = (euCountries.contains(branchCountry.toLowerCase())) ?  "EU" : "Outside EU";
		return type;
	}
	
	
	
	
	public String toString()
	{
		return "BranchDTO -> Id: " +  this.pk_BranchID + ", Name: " + this.branchName + ", Country: " +  this.branchCountry + ", Type: " + this.branchType;
	}
	
}
