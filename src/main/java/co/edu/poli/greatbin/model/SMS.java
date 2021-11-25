package co.edu.poli.greatbin.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Modulo para el envio de mensajes de SMS 
 * @author Johnny Masmela 
 *
 */
@Entity
@Table(name = "tab_sms")
public class SMS {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "message_id")
    @JsonManagedReference
    private Message message;

    @Column(name = "phone_number")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;
    
    //Prueba 
    private String body;

    public SMS() {
    }

    /**
     * Crear un registro de envio de SMS 
     * @param id
     * @param message
     * @param phoneNumber
     * @param user
     * @param body
     */
    public SMS(Integer id, Message message, String phoneNumber, User user, String body) {
		super();
		this.id = id;
		this.message = message;
		this.phoneNumber = phoneNumber;
		this.user = user;
		this.body = body;
	}

    /**
     * Get del Id De SMS
     * @return
     */
	public Integer getId() {
        return id;
    }
	 /**
	  * Set del Id De SMS
	  * @param id
	  */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Get mensaje del SMS
     * @return
     */
    public Message getMessage() {
        return message;
    }
    /**
     * Set mensaje del SMS
     * @param message
     */
    public void setMessage(Message message) {
        this.message = message;
    }
    /**
     * Get Numero Celular del SMS
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * Set Del Numero de celular del SMS
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * Get Del dato del Usuario para el SMS
     * @return
     */
    public User getUser() {
        return user;
    }
    /**
     * Set del dato del usuario para el SMS
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    

    public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
    public String toString() {
        return "SMS [id=" + id + ", message=" + message + ", phoneNumber=" + phoneNumber + ", user=" + user + "]";
    }

    
    
}
