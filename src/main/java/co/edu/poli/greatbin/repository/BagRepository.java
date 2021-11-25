package co.edu.poli.greatbin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.greatbin.model.Bag;
import co.edu.poli.greatbin.model.User;
/**
 * Repositorio para la creacion de Bolsas 
 * @author Nicolás Pinzón
 *
 */
public interface BagRepository extends JpaRepository<Bag, Integer>{
	
	List<Bag> findByUser(User user);

}
