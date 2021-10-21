package co.edu.poli.greatbin.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.greatbin.model.User;

public interface UserRepository extends JpaRepository<User, String>{  
    
    User findByDocumentId(long id);
        
    boolean existsUserByDocumentId(long id);

    
}
