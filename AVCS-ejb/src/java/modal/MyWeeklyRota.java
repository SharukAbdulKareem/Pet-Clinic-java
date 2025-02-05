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
public class MyWeeklyRota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    
    
    private String id;
    private String vet1;
    private String vet2;
    private String vet3;

    public MyWeeklyRota() {
    }

    public MyWeeklyRota(String id, String vet1, String vet2, String vet3) {
        this.id = id;
        this.vet1 = vet1;
        this.vet2 = vet2;
        this.vet3 = vet3;
    }

    public String getVet1() {
        return vet1;
    }

    public void setVet1(String vet1) {
        this.vet1 = vet1;
    }

    public String getVet2() {
        return vet2;
    }

    public void setVet2(String vet2) {
        this.vet2 = vet2;
    }

    public String getVet3() {
        return vet3;
    }

    public void setVet3(String vet3) {
        this.vet3 = vet3;
    }
    
    
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        if (!(object instanceof MyWeeklyRota)) {
            return false;
        }
        MyWeeklyRota other = (MyWeeklyRota) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modal.MyWeeklyRota[ id=" + id + " ]";
    }
    
}
