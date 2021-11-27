package co.edu.poli.greatbin.service;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import co.edu.poli.greatbin.model.*;
/**
 * Servicoo de conexion para SMS con TWILIO
 * @author Johnny Masmela 
 *
 */
@Service
public class SMSServiceTwilio implements SMSService{
	
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "ACf8abe001923e8dcb181759762c2c3553";
    public static final String AUTH_TOKEN = "b137f17f458edd8d7ddf5cfb5a4af7f6";

    @Override
    public Message sendSMS(SMS sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(sms.getPhoneNumber()),
                new com.twilio.type.PhoneNumber("+15155856400"),//The Twilio phone number
                sms.getBody())//pide un metodo en string 
           .create();

        return message;
    }
    
}