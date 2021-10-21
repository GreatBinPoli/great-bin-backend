package co.edu.poli.greatbin.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "recycling")
public class Recycling {
    
    @Id
    private Integer code;

    private boolean isRecycling;

    @OneToOne(mappedBy = "recycling", cascade = CascadeType.ALL)
    @JsonBackReference
    private Waste waste;

    public Recycling(Integer code, boolean isRecycling, Waste waste) {
        this.code = code;
        this.isRecycling = isRecycling;
        this.waste = waste;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public boolean isRecycling() {
        return isRecycling;
    }

    public void setRecycling(boolean isRecycling) {
        this.isRecycling = isRecycling;
    }

    public Waste getWaste() {
        return waste;
    }

    public void setWaste(Waste waste) {
        this.waste = waste;
    }

    @Override
    public String toString() {
        return "Recycling [code=" + code + ", isRecycling=" + isRecycling + ", waste=" + waste + "]";
    }
    
    
}