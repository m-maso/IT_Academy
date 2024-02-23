package cat.itacademy.S05T01N01MasoMontse.model.services;

import cat.itacademy.S05T01N01MasoMontse.model.domain.Branch;
import cat.itacademy.S05T01N01MasoMontse.model.dto.BranchDTO;

public class Mapper {

	public static Branch convertToEntity(BranchDTO branchDTO)
	{
		Branch branch = new Branch();
		
		branch.setPk_BranchID(branchDTO.getPk_BranchID());
		branch.setName(branchDTO.getBranchName());
		branch.setBranchCountry(branchDTO.getBranchCountry());
		
		return branch;
	}
	
	public static BranchDTO convertToDTO(Branch branch)
	{
		BranchDTO branchDTO = new BranchDTO();
		
		branchDTO.setPk_BranchID(branch.getPk_BranchID());
		branchDTO.setBranchName(branch.getBranchName());
		branchDTO.setBranchCountry(branch.getBranchCountry());
		branchDTO.setBranchType(branchDTO.createBranchType(branch.getBranchCountry()));
		return branchDTO;
	}
	
}
