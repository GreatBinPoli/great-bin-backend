package co.edu.poli.greatbin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.rest.api.v2010.account.Message;

import co.edu.poli.greatbin.model.SMS;
import co.edu.poli.greatbin.service.SMSService;
import io.swagger.annotations.Api;

/**
 * Controlador de SMS
 * 
 * @author Johnny Masmela
 *
 */
@Api(tags = { "Class: SMSController" })
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class SMSController {

	@Autowired
	private SMSService smsService;

	/**
	 * Insertar un SMS
	 * 
	 * @param sms
	 * @return
	 */
	@PostMapping("/users/sms")
	public Message sendSMS(@RequestBody SMS sms) {
		return smsService.sendSMS(sms);
	}

}