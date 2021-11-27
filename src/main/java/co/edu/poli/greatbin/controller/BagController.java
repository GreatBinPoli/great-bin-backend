package co.edu.poli.greatbin.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.greatbin.model.Bag;
import co.edu.poli.greatbin.model.User;
import co.edu.poli.greatbin.repository.BagRepository;
import co.edu.poli.greatbin.repository.UserRepository;
import io.swagger.annotations.Api;

/**
 * 
 * @author Nicolás Pinzón
 *
 */
@Api(tags = { "Class: BagController" })
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

	/**
	 * Insertar una Basura
	 * 
	 * @param id
	 * @param newBag
	 * @return
	 */
	@PostMapping("/users/{id}/bag")
	public Bag postBagByUserId(@PathVariable("id") long id, @RequestBody Bag newBag) {
		boolean exists = userRepository.existsUserByDocumentId(id);
		if (exists) {
			User user = userRepository.findByDocumentId(id);
			newBag.setUser(user);
			bagRepository.save(newBag);
			return newBag;
		} else {
			return null;
		}

	}

	/**
	 * Insertar Basuras
	 * 
	 * @param id
	 * @param newBags
	 * @return
	 */
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

	/**
	 * Listar basuras
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/users/{id}/bags")
	@ResponseBody
	public List<Bag> getBagsByUser(@PathVariable("id") long id) {
		boolean exists = userRepository.existsUserByDocumentId(id);
		if (exists) {
			User user = userRepository.findByDocumentId(id);
			return bagRepository.findByUser(user);
		} else {
			return null;
		}
	}

	/**
	 * Editar basuras por id
	 * 
	 * @param idUser
	 * @param idBag
	 * @return
	 */
	@PutMapping("/users/{id_user}/bags/{id_bag}")
	public String updateBagById(@PathVariable("id_user") long idUser, @PathVariable("id_bag") Integer idBag,
								@RequestBody Bag bag) {		
		Bag _bag = bagRepository.findById(idBag).get();
		_bag.setType(bag.getType());
		return null;
	}

	/**
	 * Eliminar basuras por id
	 * 
	 * @param idUser
	 * @param idBag
	 * @return
	 */
	@DeleteMapping("/users/{id_user}/bags/{idBag}")
	public String deleteBagById(@PathVariable("id_user") long idUser, @PathVariable("id_bag") Integer idBag) {
		return null;
	}

}
