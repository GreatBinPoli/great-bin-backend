package co.edu.poli.greatbin.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
/**
 * Modelo para crear el desperdicio para agregar su basura 
 * @author Nicolás Pinzón
 *
 */
@Entity
@Table(name = "waste")
public class Waste {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idWaste;

    private String name;

    private String description;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "bag_id")
    private Bag bag;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recycling_code")
    @JsonManagedReference
    private Recycling Recycling;
    
    public Waste() {
    	
    }

    /**
     * Crea una Desperdicio para agregar a la basura con los siguientes paremetros 
     * @param idWaste id del desperdicio 
     * @param name   nombre del desperdicio 
     * @param description breve descripcion del desperdicio 
     * @param bag          a que tipo de bolsa pertenece 
     * @param recycling    si es reciclable o no 
     */
    public Waste(Integer idWaste, String name, String description, Bag bag, Recycling recycling) {
        this.idWaste = idWaste;
        this.name = name;
        this.description = description;
        this.bag = bag;
        this.Recycling = recycling;
    }

    /**
     * Get del id de desperdicios. 
     * @return
     */
    public Integer getIdWaste() {
        return idWaste;
    }
    /**
     * Set del id de desperdicios. 
     * @param idWaste
     */
    public void setIdWaste(Integer idWaste) {
        this.idWaste = idWaste;
    }
    /**
     * Get del nombre del desperdicio .
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * Set del nombre del desperdicio.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get de la descripcion del desperdicio. 
     * @return
     */
    public String getDescription() {
        return description;
    }
    /**
     * Set de la descripcion del desperdicio. 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Get del basura del desperdicio.
     * @return
     */
    public Bag getBag() {
        return bag;
    }
     /**
      * Set de basura del desperdicio.
      * @param bag
      */
    public void setBag(Bag bag) {
        this.bag = bag;
    }
    /**
     * Get de reciclable del desperdicio.
     * @return
     */
    public Recycling getRecycling() {
        return Recycling;
    }
    /**
     * Set de reciclable del desperdicio 
     * @param recycling
     */
    public void setRecycling(Recycling recycling) {
        this.Recycling = recycling;
    }

    @Override
    public String toString() {
        return "Waste [bag=" + bag + ", description=" + description + ", idWaste=" + idWaste + ", name=" + name
                + ", recycling=" + Recycling + "]";
    }
    
}
