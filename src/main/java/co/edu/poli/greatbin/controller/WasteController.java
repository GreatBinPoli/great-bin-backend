package co.edu.poli.greatbin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.greatbin.model.Bag;
import co.edu.poli.greatbin.model.Waste;
import co.edu.poli.greatbin.repository.BagRepository;
import co.edu.poli.greatbin.repository.UserRepository;
import co.edu.poli.greatbin.repository.WasteRepository;
import io.swagger.annotations.Api;

/**
 * 
 * @author Nicolás Pinzón
 *
 */
@Api(tags = { "Class: UserController" })
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class WasteController {

	@Autowired
	private BagRepository bagRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private WasteRepository wasteRepository;

	public WasteController() {

	}

	/**
	 * Insertar un desperdicio en una basura
	 * 
	 * @param id_user
	 * @param id_bag
	 * @param newWaste
	 * @return
	 */
	@PostMapping("/users/{id_user}/bag/{id_bag}/wastes/all")
	public Waste postWasteByIdBag(@PathVariable("id_user") long id_user, @PathVariable("id_bag") Integer id_bag,
			@RequestBody Waste newWaste) {
		boolean exists = userRepository.existsUserByDocumentId(id_user);
		if (exists) {
			// User user = userRepository.findByDocumentId(id_user);
			Bag bag = bagRepository.findById(id_bag).get();
			newWaste.setBag(bag);
			wasteRepository.save(newWaste);
			return newWaste;
		} else {
			return null;
		}

	}

	@GetMapping("/users/{id_user}/bag/{id_bag}/wastes")
	@ResponseBody
	public List<Waste> getBagsByUser(@PathVariable("id_user") long id_user, @PathVariable("id_bag") Integer id_bag) {
		boolean exists_user = userRepository.existsUserByDocumentId(id_user);
		boolean exists_bag = bagRepository.existsById(id_bag);
		if (exists_user && exists_bag) {
			Bag bag = bagRepository.findById(id_bag).get();
			return wasteRepository.findByBag(bag);
		} else {
			return null;
		}
	}

}
