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
    @NamedQuery(name = "MyStaff.searchByStaffName", query = "SELECT n FROM MyStaff n WHERE n.username = :username"),
    @NamedQuery(name = "MyStaff.searchByUsername", query = "SELECT n FROM MyStaff n WHERE n.username = :username"),
    
    
})
public class MyStaff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    
    
    private Long id;
    private String username;
    private int age;
    private int contactnumber;
    private String email;  
    private int password;

    public MyStaff() {
    }
    
    
    

    public MyStaff(Long id, String username, int age, int contactnumber, String email, int password) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.contactnumber = contactnumber;
        this.email = email;
        this.password = password;
    }

    public MyStaff(String username, int age, int contactnumber, String email, int password) {
        this.username = username;
        this.age = age;
        this.contactnumber = contactnumber;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
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
        if (!(object instanceof MyStaff)) {
            return false;
        }
        MyStaff other = (MyStaff) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modal.MyStaff[ id=" + id + " ]";
    }
    
}
