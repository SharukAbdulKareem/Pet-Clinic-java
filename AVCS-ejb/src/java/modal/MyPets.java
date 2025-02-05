/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author sharuk
 */
@Entity
public class MyPets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
    private String ownername;
    private String icnumber;
    private String address;
    private int contact;
    private String email;
    
    private String petname;
    
    private String breed;
    private String sex;

    public MyPets() {
    }

    public MyPets(String ownername, String icnumber, String address, int contact, String email, String petname, String breed, String sex) {
        this.ownername = ownername;
        this.icnumber = icnumber;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.petname = petname;
        this.breed = breed;
        this.sex = sex;
    }

    public MyPets(Long id, String ownername, String icnumber, String address, int contact, String email, String petname, String breed, String sex) {
        this.id = id;
        this.ownername = ownername;
        this.icnumber = icnumber;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.petname = petname;
        this.breed = breed;
        this.sex = sex;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getIcnumber() {
        return icnumber;
    }

    public void setIcnumber(String icnumber) {
        this.icnumber = icnumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
    
    



 
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MyPets)) {
            return false;
        }
        MyPets other = (MyPets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modal.MyPets[ id=" + id + " ]";
    }
    
}
