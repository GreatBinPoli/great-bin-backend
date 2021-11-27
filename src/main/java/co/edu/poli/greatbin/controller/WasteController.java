package co.edu.poli.greatbin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.greatbin.repository.BagRepository;
import co.edu.poli.greatbin.repository.UserRepository;
import co.edu.poli.greatbin.repository.WasteRepository;
import io.swagger.annotations.Api;

/**
 * 
 * @author Nicolás Pinzón
 *
 */
@Api(tags = { "Class: WasteController" })
@Transactional
@RestController
@RequestMapping("/api/v1")
public class WasteController {
	
	@Autowired
	private BagRepository bagRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private WasteRepository wasteRepository;

}
