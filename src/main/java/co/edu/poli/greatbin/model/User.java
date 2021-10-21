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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(long documentId) {
        this.documentId = documentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public Set<Bag> getBags() {
        return bags;
    }

    public void setBags(Set<Bag> bags) {
        this.bags = bags;
    }

    public SMS getSms() {
        return sms;
    }

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
