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

    public Bag(Integer id_bag, BagType type, User user, List<Waste> wastes) {
        this.id_bag = id_bag;
        this.type = type;
        this.user = user;
        this.wastes = wastes;
    }

    public Integer getId_bag() {
        return id_bag;
    }

    public void setId_bag(Integer id_bag) {
        this.id_bag = id_bag;
    }

    public BagType getType() {
        return type;
    }

    public void setType(BagType type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Waste> getWastes() {
        return wastes;
    }

    public void setWastes(List<Waste> wastes) {
        this.wastes = wastes;
    }

    @Override
    public String toString() {
        return "Bag [id_bag=" + id_bag + ", type=" + type + ", user=" + user + ", wastes=" + wastes + "]";
    }

    
}
