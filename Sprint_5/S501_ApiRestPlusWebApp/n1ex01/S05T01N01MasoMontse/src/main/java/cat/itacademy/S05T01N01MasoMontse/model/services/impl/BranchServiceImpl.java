package cat.itacademy.S05T01N01MasoMontse.model.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.S05T01N01MasoMontse.exceptions.BranchAlreadyExistsException;
import cat.itacademy.S05T01N01MasoMontse.exceptions.BranchNotFoundException;
import cat.itacademy.S05T01N01MasoMontse.model.domain.Branch;
import cat.itacademy.S05T01N01MasoMontse.model.dto.BranchDTO;
import cat.itacademy.S05T01N01MasoMontse.model.repository.BranchRepository;
import cat.itacademy.S05T01N01MasoMontse.model.services.BranchService;
import cat.itacademy.S05T01N01MasoMontse.model.services.Mapper;


@Service
public class BranchServiceImpl implements BranchService {
	
	@Autowired
	private BranchRepository branchRepository;
	
	public BranchServiceImpl(BranchRepository branchRepository)
	{
		this.branchRepository = branchRepository;
	}
	
	
	
	@Override
	public void add(BranchDTO branchDTO) 
	{
		String branchName = branchDTO.getBranchName();
		this.branchRepository.findByBranchNameIgnoreCase(branchName)
		.ifPresent(b -> {
			throw new BranchAlreadyExistsException("It already exists a branch with name " + branchDTO.getBranchName());
		});
		
		Branch branch = Mapper.convertToEntity(branchDTO);
		
		this.branchRepository.save(branch);
	}

	@Override
	public Branch update(int id, BranchDTO updatedBranchDTO) 
	{
		Optional<Branch> searchedBranchDb = this.branchRepository.findById(id);
		
		if(searchedBranchDb.isPresent())
		{
			Branch newBranchDb = searchedBranchDb.get();
			newBranchDb.setName(updatedBranchDTO.getBranchName()); 
			newBranchDb.setBranchCountry(updatedBranchDTO.getBranchCountry());
			return this.branchRepository.save(newBranchDb);
		} else {
			throw new BranchNotFoundException("Branch with Id " + id + " is not found");
		}
	}

	@Override
	public void delete(int id) 
	{
		Branch branchFound = this.branchRepository.findById(id).orElseThrow(
				() -> {
					throw new BranchNotFoundException("Branch with Id " + id + " is not found");
				});
		this.branchRepository.deleteById(branchFound.getPk_BranchID());
	}

	// getOne is @Deprecated, I use findById() instead	
	@Override
	public BranchDTO getOne(int id) 
	{
		return this.branchRepository.findById(id)
				.map(branch -> Mapper.convertToDTO(branch))
				.orElseThrow( () -> {
					throw new BranchNotFoundException("Branch with Id " + id + " is not found");
				});
	}

	@Override
	public List<BranchDTO> getAll() 
	{
		List<Branch> branches = this.branchRepository.findAll();
		List<BranchDTO> branchesDTO = branches.stream().map(Mapper::convertToDTO).collect(Collectors.toList());
	
		return branchesDTO;
	}

}
