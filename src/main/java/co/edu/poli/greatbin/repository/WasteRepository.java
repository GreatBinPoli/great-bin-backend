package co.edu.poli.greatbin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.greatbin.model.Bag;
import co.edu.poli.greatbin.model.Waste;

public interface WasteRepository extends JpaRepository<Waste, String> {
	
	List<Waste> findByBag(Bag bag);

}
