package co.edu.poli.greatbin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.greatbin.model.User;
/**
 * Repositorio para el Usuario 
 * @author Cristian Sanchez
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByDocumentId(long id);

	User findByEmail(String email);

	boolean existsUserByDocumentId(long id);

	void deleteByDocumentId(long id);



}
