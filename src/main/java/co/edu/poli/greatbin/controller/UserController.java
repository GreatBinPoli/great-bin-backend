package co.edu.poli.greatbin.controller;

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

import co.edu.poli.greatbin.model.User;
import co.edu.poli.greatbin.repository.UserRepository;
import io.swagger.annotations.Api;

@Api(tags = {"Class: UserController"})
@Transactional
@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;    

    public UserController() {
    }

    @PostMapping("/user")
    public User postUser(@RequestBody User newUser) {
        boolean exists = userRepository.existsUserByDocumentId(newUser.getDocumentId());
        if (exists) {
            return null;
        } else {
            userRepository.save(newUser);
            return newUser;
        }        
    }

    @PostMapping("/users")
    public String postUser(@RequestBody List<User> newusers) {
        userRepository.saveAll(newusers);
        return "Users successfully saved!";      
    }

    @GetMapping("/users/all")
    @ResponseBody
    public List<User> getUsersList() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public User getUsersById(@PathVariable("id") long id) {
        boolean exists = userRepository.existsUserByDocumentId(id);
        if (exists) {
            return userRepository.findByDocumentId(id);
        } else {
            return null;
        }                       
    }
    
    @PutMapping("/users/{id}")
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
    
    
    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id") long id){
        boolean exists = userRepository.existsUserByDocumentId(id);
        if (exists) {
        	userRepository.deleteByDocumentId(id);
            return "User successfully deleted";
        }
        return "User with the code " + id + " not found.";
    }
    
}

