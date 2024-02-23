package cat.itacademy.S05T01N01MasoMontse.model.services;

import java.util.List;

import cat.itacademy.S05T01N01MasoMontse.exceptions.BranchNotFoundException;
import cat.itacademy.S05T01N01MasoMontse.model.domain.Branch;
import cat.itacademy.S05T01N01MasoMontse.model.dto.BranchDTO;

public interface BranchService {

	public void add(BranchDTO branchDTO);
	public Branch update(int id, BranchDTO branchDTO);
	public void delete(int id) throws BranchNotFoundException;
	public BranchDTO getOne(int id);
	public List<BranchDTO> getAll();
	
}
