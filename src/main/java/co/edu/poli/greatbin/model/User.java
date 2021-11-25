package co.edu.poli.greatbin.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * Modulo para la creacion y logueo del Usuario 
 * @author Cristian Sanchez
 *
 */
@Entity
@Table(name = "tab_user")
public class User {

    @Column(name = "document_id")
    @JsonProperty("document_id")
    @Id
    private long documentId;

    @Column(name = "document_type")
    @JsonProperty("document_type")
    @Enumerated(EnumType.ORDINAL)
    private DocumentType documentType;

    private boolean active;

    @Column(name = "first_name")
    @JsonProperty("first_name")
    private String firstName;

    @Column(name = "last_name")
    @JsonProperty("last_name")
    private String lastName;

    private String email;

    private String password;

    private String roles;    

    @Column(name = "phone_number")
    @JsonProperty("phone_number")
    private long phoneNumber;

    private String address;

    private String neighbourhood;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private Set<Bag> bags;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference
    private SMS sms;

    public User() {
    }
    /**
     * Se crea un usuario con los siguientes parametros 
     * @param active    para saber si el usuario esta activo o inactivo 
     * @param documentType tipo de documento 
     * @param documentId   id del modelo y el numero del documento del usuario 
     * @param firstName    nombre del usuario
     * @param lastName     apellido del usuario
     * @param email        correo electronico del usuario 
     * @param password     contraseña del usuario 
     * @param roles        rol que va compartir el usuario 
     * @param phoneNumber  numero telefonico del usuario 
     * @param address      dirrecion de vivienda del usuario 
     * @param neighbourhood barrio del usuario 
     */
    public User(boolean active, DocumentType documentType, long documentId, String firstName, String lastName,
            String email, String password, String roles, long phoneNumber, String address, String neighbourhood) {
        this.active = active;
        this.documentType = documentType;
        this.documentId = documentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.neighbourhood = neighbourhood;
    }
    /**
     * verifica si el usuario esta activo o inactivo 
     * @return
     */
    public boolean isActive() {
        return active;
    }
    /**
     * Set de Activo del usuario 
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }
    /**
     * Get del tipo de documento del usuario 
     * @return
     */
    public DocumentType getDocumentType() {
        return documentType;
    }
    /**
     * Set del tipo de documento del usuario 
     * @param documentType
     */
    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }
    /**
     * Get del numero de documento y id del usuario 
     * @return
     */
    public long getDocumentId() {
        return documentId;
    }
    /**
     * Set del numero de documento y el id del usuario
     * @param documentId
     */
    public void setDocumentId(long documentId) {
        this.documentId = documentId;
    }
    /**
     * Get del nombre del usuario
     * @return
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Set del nombre del usuario
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Get del apellido del usuario
     * @return
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Set del apellido del Usuario
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Get del Email del usuario 
     * @return
     */
    public String getEmail() {
        return email;
    }
    /**
     * Set del Email del usuario 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Get de la contraseña del usuario 
     * @return
     */
    public String getPassword() {
        return password;
    }
    /**
     * Set de la contraseña del usuario 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Get del tipo de rol del usuario
     * @return
     */
    public String getRoles() {
        return roles;
    }
    /**
     * Set del tipo de rol del usuario
     * @param roles
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }
    /**
     * Get del numero telefonico del usuario
     * @return
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * Set del numero telefonico del usuario
     * @param phoneNumber
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * Get de la dirrecion del usuario
     * @return
     */
    public String getAddress() {
        return address;
    }
    /**
     * Set de la dirrecion del usuario
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * Get del barrio del usuario 
     * @return
     */
    public String getNeighbourhood() {
        return neighbourhood;
    }
    /**
     * Set del barrio del usuario 
     * @param neighbourhood
     */
    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }
    /**
     * Get de las basuras que registra Usuario 
     * @return
     */
    public Set<Bag> getBags() {
        return bags;
    }
    /**
     * Set de las basuras que registra Usuario 
     * @param bags
     */
    public void setBags(Set<Bag> bags) {
        this.bags = bags;
    }
    /**
     * Gest de los SMS que Se envian al usuario
     * @return
     */
    public SMS getSms() {
        return sms;
    }
    /**
     * Set de los SMS que Se envian al usuario
     * @param sms
     */
    public void setSms(SMS sms) {
        this.sms = sms;
    }

    @Override
    public String toString() {
        return "User [active=" + active + ", address=" + address + ", bags=" + bags + ", documentId=" + documentId
                + ", documentType=" + documentType + ", email=" + email + ", firstName=" + firstName
                + ", lastName=" + lastName + ", neighbourhood=" + neighbourhood + ", password=" + password
                + ", phoneNumber=" + phoneNumber + ", roles=" + roles + ", sms=" + sms + "]";
    }
    
}
