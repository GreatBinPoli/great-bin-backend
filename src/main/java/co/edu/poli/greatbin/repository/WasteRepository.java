package co.edu.poli.greatbin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.greatbin.model.Waste;

public interface WasteRepository extends JpaRepository<Waste, String> {

}
