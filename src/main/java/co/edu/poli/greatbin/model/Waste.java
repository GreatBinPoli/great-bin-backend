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
    private Recycling recycling;

    public Waste(Integer idWaste, String name, String description, Bag bag, Recycling recycling) {
        this.idWaste = idWaste;
        this.name = name;
        this.description = description;
        this.bag = bag;
        this.recycling = recycling;
    }

    public Integer getIdWaste() {
        return idWaste;
    }

    public void setIdWaste(Integer idWaste) {
        this.idWaste = idWaste;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public Recycling getRecycling() {
        return recycling;
    }

    public void setRecycling(Recycling recycling) {
        this.recycling = recycling;
    }

    @Override
    public String toString() {
        return "Waste [bag=" + bag + ", description=" + description + ", idWaste=" + idWaste + ", name=" + name
                + ", recycling=" + recycling + "]";
    }
    
}
