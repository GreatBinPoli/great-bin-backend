package co.edu.poli.greatbin.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * modelo para las basuras 
 * @author Nicolás Pinzón
 *
 */
@Entity
@Table(name = "bag")
public class Bag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id_bag;

    @Enumerated(EnumType.STRING)
    private BagType type;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "bag", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Waste> wastes;
    
    public Bag() {
    	
    }
    /**
     * Crear la basura usando los siguietes parametros 
     * @param id_bag
     * @param type
     * @param user
     * @param wastes
     */
    public Bag(Integer id_bag, BagType type, User user, List<Waste> wastes) {
        this.id_bag = id_bag;
        this.type = type;
        this.user = user;
        this.wastes = wastes;
    }
    /**
     * Get del id para basuras 
     * @return
     */
    public Integer getId_bag() {
        return id_bag;
    }
    /**
     * Set del id para basuras 
     * @param id_bag
     */
    public void setId_bag(Integer id_bag) {
        this.id_bag = id_bag;
    }
    /**
     * Get del tipo de basuras 
     * @return
     */
    public BagType getType() {
        return type;
    }
    /**
     * Set del tipo de basuras 
     * @param type
     */
    public void setType(BagType type) {
        this.type = type;
    }
    /**
     * Get del usuario para la basuras 
     * @return
     */
    public User getUser() {
        return user;
    }
    /**
     * Set del usuario para la basuras 
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }
    /**
     * Get para la lista de los desperdicios
     * @return
     */
    public List<Waste> getWastes() {
        return wastes;
    }
    /**
     * Set para la lista de los desperdicios 
     * @param wastes
     */
    public void setWastes(List<Waste> wastes) {
        this.wastes = wastes;
    }

    @Override
    public String toString() {
        return "Bag [id_bag=" + id_bag + ", type=" + type + ", user=" + user + ", wastes=" + wastes + "]";
    }

    
}
