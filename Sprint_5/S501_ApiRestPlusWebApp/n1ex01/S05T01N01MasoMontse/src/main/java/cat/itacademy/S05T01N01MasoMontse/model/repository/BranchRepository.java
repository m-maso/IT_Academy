package cat.itacademy.S05T01N01MasoMontse.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.S05T01N01MasoMontse.model.domain.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {

	Optional<Branch> findByBranchNameIgnoreCase(String branchName);
	
}
