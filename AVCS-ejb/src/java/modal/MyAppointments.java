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
    @NamedQuery(name = "MyAppointments.searchByVet", query = "SELECT n FROM MyAppointments n WHERE n.vetAssigned = :vetAssigned"),
    @NamedQuery(name = "MyAppointments.searchByVetId", query = "SELECT n FROM MyAppointments n WHERE n.ownerId = :ownerId"),
    @NamedQuery(name = "MyAppointments.findByVetDateAndTime", query = "SELECT a FROM MyAppointments a WHERE a.vetAssigned = :vetAssigned AND a.appointmentDate = :appointmentDate AND a.appointmentTime = :appointmentTime"),
    

})
public class MyAppointments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    
    private Long id;
    private Long ownerId;
    private String owner;
    private String petname;
    private String breed;
    private String sex;
    private String appointmentDate;
    private String appointmentTime;
    private String vetAssigned;

    public MyAppointments() {
    }

   

    public MyAppointments(Long ownerId, String owner,String petname, String breed, String sex, String appointmentDate,String appointmentTime, String vetAssigned) {
        this.ownerId = ownerId;
        this.owner = owner;
        this.petname = petname;
        this.breed = breed;
        this.sex = sex;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.vetAssigned = vetAssigned;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
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

    

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getVetAssigned() {
        return vetAssigned;
    }

    public void setVetAssigned(String vetAssigned) {
        this.vetAssigned = vetAssigned;
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
        if (!(object instanceof MyAppointments)) {
            return false;
        }
        MyAppointments other = (MyAppointments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modal.MyAppointments[ id=" + id + " ]";
    }
    
}
