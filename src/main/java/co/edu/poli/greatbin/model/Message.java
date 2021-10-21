package co.edu.poli.greatbin.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


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

    public Message(String body) {
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Message [body=" + body + ", id=" + id + "]";
    }
    

}
