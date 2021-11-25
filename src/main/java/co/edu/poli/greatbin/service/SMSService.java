package co.edu.poli.greatbin.service;

import com.twilio.rest.api.v2010.account.Message;

import co.edu.poli.greatbin.model.*;

/**
 * Servicio de envio de SMS 
 * @author Johnny Masmela 
 *
 */
public interface SMSService {
	
	public Message sendSMS(SMS sms);

}
