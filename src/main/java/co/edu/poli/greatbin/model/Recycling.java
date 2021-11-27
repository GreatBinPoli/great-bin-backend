package co.edu.poli.greatbin.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * @author Nicolás Pinzón
 *
 */
@Entity
@Table(name = "recycling")
public class Recycling {
    
    @Id
    private Integer code;

    private boolean isRecycling;

    @OneToOne(mappedBy = "Recycling", cascade = CascadeType.ALL)
    @JsonBackReference
    private Waste waste;
    /**
     * Crea el tipo de reciclaje de los desperdicios 
     * @param code
     * @param isRecycling
     * @param waste
     */
    
    public Recycling() {
    	
    }
    
    public Recycling(Integer code, boolean isRecycling, Waste waste) {
        this.code = code;
        this.isRecycling = isRecycling;
        this.waste = waste;
    }
    /**
     * Get Del codigo del reciclaje 
     * @return
     */
    public Integer getCode() {
        return code;
    }
    /**
     * Set del codigo de reciclaje
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }
    /**
     * get para afirmar si es reciclaje o no 
     * @return
     */
    public boolean isRecycling() {
        return isRecycling;
    }
    /**
     * Set para afirmar si es reciclaje o no 
     * @param isRecycling
     */
    public void setRecycling(boolean isRecycling) {
        this.isRecycling = isRecycling;
    }
    /**
     * Get para el desperdicio 
     * @return
     */
    public Waste getWaste() {
        return waste;
    }
    /**
     * Set para el desperdicio 
     * @param waste
     */
    public void setWaste(Waste waste) {
        this.waste = waste;
    }

    @Override
    public String toString() {
        return "Recycling [code=" + code + ", isRecycling=" + isRecycling + ", waste=" + waste + "]";
    }
    
    
}