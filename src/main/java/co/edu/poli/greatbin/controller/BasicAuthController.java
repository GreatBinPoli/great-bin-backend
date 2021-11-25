package co.edu.poli.greatbin.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.greatbin.model.AuthenticationBean;
import io.swagger.annotations.Api;
/**
 * Controlador para la autenticacion del usuario 
 * @author Cristian Sanchez
 *
 */
@Api(tags = { "Class: SMSController" })
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class BasicAuthController {
	/**
	 * Listar datos de autenticacion 
	 * @return
	 */
	@GetMapping(path = "/basicauth")
	public AuthenticationBean basicauth() {
		return new AuthenticationBean("You are authenticated");
	}
}
