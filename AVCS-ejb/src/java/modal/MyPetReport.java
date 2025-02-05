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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author sharuk
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "MyPetReport.searchByPetName", query = "SELECT n FROM MyPetReport n WHERE n.appointments.petname = :petname"),
    
})
public class MyPetReport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    
    private Long id;
    private String diagnosis;
    private String prognosis;
    

    public MyPetReport() {
    }

    
    
    public MyPetReport(String diagnosis, String prognosis, MyAppointments appointments) {
        this.diagnosis = diagnosis;
        this.prognosis = prognosis;
        
        this.appointments = appointments;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrognosis() {
        return prognosis;
    }

    public void setPrognosis(String prognosis) {
        this.prognosis = prognosis;
    }



   
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    @ManyToOne
    @JoinColumn(name = "appointmentId")  
    private MyAppointments appointments;
    
    public MyAppointments getAppointments() {
        return appointments;
    }

    public void setAppointments(MyAppointments appointments) {
        this.appointments = appointments;
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
        if (!(object instanceof MyPetReport)) {
            return false;
        }
        MyPetReport other = (MyPetReport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modal.MyPetReport[ id=" + id + " ]";
    }
    
}
