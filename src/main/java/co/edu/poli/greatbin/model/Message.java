package co.edu.poli.greatbin.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * @author Johnny Masmela
 *
 */
@Entity
@Table(name = "tab_message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String body;

    @OneToOne(mappedBy = "message", cascade = CascadeType.ALL)
    @JsonBackReference
    private SMS sms;
    /**
     * Crear el cuerpo del mensaje para SMS
     * @param body
     */
    public Message(String body) {
        this.body = body;
    }
    /**
     * Get del id del Mensaje 
     * @return
     */
    public Integer getId() {
        return id;
    }
    /**
     * Set Del id del Mensaje
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Get del cuerpo del mensaje 
     * @return
     */
    public String getBody() {
        return body;
    }
    /**
     * Set del cuerpo del mensaje 
     * @param body
     */
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Message [body=" + body + ", id=" + id + "]";
    }
    

}
