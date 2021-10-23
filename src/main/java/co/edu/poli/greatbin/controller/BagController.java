package co.edu.poli.greatbin.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.greatbin.model.Bag;
import co.edu.poli.greatbin.model.User;
import co.edu.poli.greatbin.repository.BagRepository;
import co.edu.poli.greatbin.repository.UserRepository;
import io.swagger.annotations.Api;

@Api(tags = {"Class: BagController"})
@Transactional
@RestController
@RequestMapping("/api/v1")
public class BagController {
	
	@Autowired    
    private BagRepository bagRepository;
	
	@Autowired    
	private UserRepository userRepository; 
	
	public BagController() {
		
	}
	
	@PostMapping("/users/{id}/bag")
	public Bag postBagByUserId(@PathVariable("id") long id, @RequestBody Bag newBag) {
		User user = userRepository.findByDocumentId(id);
		newBag.setUser(user);
		bagRepository.save(newBag);		
		return newBag;
		
	}
	
	@PostMapping("/users/{id}/bags")
	public List<Bag> postBagListByUserId(@PathVariable("id") long id, @RequestBody List<Bag> newBags) {
		User user = userRepository.findByDocumentId(id);
		for (Iterator<Bag> iterator = newBags.iterator(); iterator.hasNext();) {
			Bag bag = (Bag) iterator.next();
			bag.setUser(user);
		}
		bagRepository.saveAll(newBags);		
		return newBags;
		
	}
	
	

}
