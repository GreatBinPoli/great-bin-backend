package co.edu.poli.greatbin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.greatbin.model.User;
import co.edu.poli.greatbin.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controlador de usuario CRUD
 * 
 * @author Cristian Sanchez
 *
 */
@Api(tags = { "Class: UserController" })
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	public UserController() {
	}

	/**
	 * Insertar nuevo usuario
	 * 
	 * @param newUser
	 * @return
	 */
	@PostMapping("/users")
	public User postUser(@RequestBody User newUser) {
		
		boolean exists = userRepository.existsUserByDocumentId(newUser.getDocumentId());
		if (exists) {
			return null;
		} else {
			userRepository.save(newUser);
			return newUser;
		}
	}

	/**
	 * Insertar lista de usuarios
	 * 
	 * @param newusers
	 * @return
	 */
	@PostMapping("/userslist")
	public String postUser(@RequestBody List<User> newusers) {
		userRepository.saveAll(newusers);
		return "Users successfully saved!";
	}

	/**
	 * Listar Usuarios
	 * 
	 * @return
	 */
	@GetMapping("/users/all")
	@ApiOperation(value = "*** Service Method Get All User ***", notes = "*** Get All User from great\\\\WebApp ***")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "*** Error Get All User!!! ***") })
	@ResponseBody
	public List<User> getUsersList() {
		return userRepository.findAll();
	}

	/**
	 * Listar usuario por ID
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/users/uno/{id}")
	@ResponseBody
	public User getUsersById(@PathVariable("id") long id) {
		boolean exists = userRepository.existsUserByDocumentId(id);
		if (exists) {
			return userRepository.findByDocumentId(id);
		} else {
			return null;
		}
	}

	/**
	 * Listar usuario Por correo
	 * 
	 * @param email
	 * @return
	 */
	@GetMapping("/users/email/{email}")
	@ResponseBody
	public User getUsersByEmail(@PathVariable("email") String email) {

		return userRepository.findByEmail(email);

	}

	/**
	 * editar usuario por id
	 * 
	 * @param id
	 * @param user
	 * @return
	 */
	@PutMapping("/users/update/{id}")
	@ResponseBody
	public User updateUserById(@PathVariable("id") long id, @RequestBody User user) {
		boolean exists = userRepository.existsUserByDocumentId(id);
		if (exists) {
			User savedUser = userRepository.findByDocumentId(id);
			savedUser.setDocumentType(user.getDocumentType());
			savedUser.setFirstName(user.getFirstName());
			savedUser.setLastName(user.getLastName());
			savedUser.setEmail(user.getEmail());
			savedUser.setPassword(user.getPassword());
			savedUser.setRoles(user.getRoles());
			savedUser.setPhoneNumber(user.getPhoneNumber());
			savedUser.setAddress(user.getAddress());
			savedUser.setNeighbourhood(user.getNeighbourhood());
			savedUser.setBags(user.getBags());
			savedUser.setSms(user.getSms());
			userRepository.save(savedUser);
			return savedUser;
		} else {
			return null;
		}
	}

	/**
	 * Eliminar usuario por ID
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/users/delete/{id}")
	public User deleteUserById(@PathVariable("id") int id) {
		User user = userRepository.findByDocumentId(id);
		userRepository.delete(user);
		return user;
		/*
		 * boolean exists = userRepository.existsUserByDocumentId(id); if (exists) {
		 * userRepository.deleteByDocumentId(id); return exists; } return
		 * "User with the code " + id + " not found.";
		 */
	}

}
