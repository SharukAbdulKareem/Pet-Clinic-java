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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author sharuk
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "MyVeterinary.searchByVetenarianName", query = "SELECT n FROM MyVeterinary n WHERE n.username = :username"),
    @NamedQuery(name = "MyVeterinary.searchByDoctorsName", query = "SELECT n FROM MyVeterinary n WHERE n.username = :username"),
    
})
public class MyVeterinary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    
    private Long id;
    private String username;
    private int contactnumber;
    private String email;
    private String gender;
    private String medicalid;
    private String expertise1;
    private String expertise2;
    private int password;
    private boolean is_approved;

    public MyVeterinary() {
    }

    public MyVeterinary(String username, int contactnumber, String email, String gender, String medicalid, String expertise1, String expertise2, int password, boolean is_approved) {
        this.username = username;
        this.contactnumber = contactnumber;
        this.email = email;
        this.gender = gender;
        this.medicalid = medicalid;
        this.expertise1 = expertise1;
        this.expertise2 = expertise2;
        this.password = password;
        this.is_approved = is_approved;
    }

    
    
    
    
    public MyVeterinary(Long id, String username, int contactnumber, String email, String gender, String medicalid, String expertise1, String expertise2, int password, boolean is_approved) {
        this.id = id;
        this.username = username;
        this.contactnumber = contactnumber;
        this.email = email;
        this.gender = gender;
        this.medicalid = medicalid;
        this.expertise1 = expertise1;
        this.expertise2 = expertise2;
        this.password = password;
        this.is_approved = is_approved;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(int contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMedicalid() {
        return medicalid;
    }

    public void setMedicalid(String medicalid) {
        this.medicalid = medicalid;
    }

    public String getExpertise1() {
        return expertise1;
    }

    public void setExpertise1(String expertise1) {
        this.expertise1 = expertise1;
    }

    public String getExpertise2() {
        return expertise2;
    }

    public void setExpertise2(String expertise2) {
        this.expertise2 = expertise2;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public boolean isIs_approved() {
        return is_approved;
    }

    public void setIs_approved(boolean is_approved) {
        this.is_approved = is_approved;
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
        if (!(object instanceof MyVeterinary)) {
            return false;
        }
        MyVeterinary other = (MyVeterinary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modal.MyVeterinary[ id=" + id + " ]";
    }
    
}
