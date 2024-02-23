package cat.itacademy.S05T01N01MasoMontse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import cat.itacademy.S05T01N01MasoMontse.model.dto.BranchDTO;
import cat.itacademy.S05T01N01MasoMontse.model.services.BranchService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchService branchService;

	public BranchController(BranchService branchService)
	{
		this.branchService = branchService;
	}
	
	
	@PostMapping("/save")
	public String add(@Valid @ModelAttribute BranchDTO branchDTO, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("title", "Add a Branch");
			model.addAttribute("newBranch", branchDTO);
			System.out.println("There are some errors in the form");
//			return "/views/branch/add";
			return "add";
		}
		
		branchService.add(branchDTO);
		System.out.println("Branch saved successfully");
		
//		return "redirect:/views/branch/getAllBranches";
		return "redirect:/branch/branches";
	}
	
	@GetMapping("/addBranch")
	public String getAddForm(Model model)
	{
		BranchDTO branchDTO = new BranchDTO();
		model.addAttribute("title", "Add a Branch");
		model.addAttribute("newBranch", branchDTO);
	
		return "add";
	}
	
	@PostMapping("/edit")
	public String update(@ModelAttribute BranchDTO branchDTO)
	{
		int id = branchDTO.getPk_BranchID();
        String name = branchDTO.getBranchName();
        String country = branchDTO.getBranchCountry();

        BranchDTO modifiedBranch = new BranchDTO(id, name, country);
        branchService.update(id, modifiedBranch);
		
//		return "redirect:/views/branch/getAllBranches";
		return "redirect:/branch/branches";
	}
	
	@GetMapping("/update/{id}")
	public String getUpdateForm(@PathVariable("id") int id, Model model)
	{
		BranchDTO branchDTO = null;
		if(id > 0)
		{
			branchDTO = branchService.getOne(id);
			
			if(branchDTO == null)
			{
				System.out.println("Error: Id doesn't exist");
//				return "redirect:/views/branch/getAllBranches";
				return "redirect:/branch/getAllBranches";
			}
		} else {
			System.out.println("Error with Branch Id");
//			return "redirect:/views/branch/getAllBranches";
			return "redirect:/branch/getAllBranches";
		}
		
		model.addAttribute("title", "Update a Branch");
		model.addAttribute("updatedBranch", branchDTO);
	
//		return "/views/branch/update";
		return "update";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteBranch(@PathVariable("id") int id)
	{
		branchService.delete(id);
		System.out.println("Branch deleted successfully");
	
		return "redirect:/branch/branches";
	}
	
	@GetMapping("/viewBranch/{id}")
	public String findById(@PathVariable int id, Model model)
	{
		BranchDTO searchedBranch = this.branchService.getOne(id);
		
		model.addAttribute("title", "Branch Office");
		model.addAttribute("viewBranch", searchedBranch);
		
		return "showBranch";
	}
	
	@GetMapping({"/branches","/"})
	public String listBranches(Model model)
	{
		List<BranchDTO> searchedBranches = this.branchService.getAll();
		
		model.addAttribute("title", "Branches List");
		model.addAttribute("branchesList", searchedBranches);

		return "branches";
	}
	
}
