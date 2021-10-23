package co.edu.poli.greatbin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.greatbin.model.Bag;

public interface BagRepository extends JpaRepository<Bag, Integer>{
	

}
