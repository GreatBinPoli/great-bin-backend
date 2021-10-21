package co.edu.poli.greatbin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.greatbin.model.User;
import co.edu.poli.greatbin.repository.UserRepository;

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
    
}

