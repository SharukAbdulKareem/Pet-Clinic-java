/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sharuk
 */
@Stateless
public class MyStaffFacade extends AbstractFacade<MyStaff> {

    @PersistenceContext(unitName = "AVCS-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MyStaffFacade() {
        super(MyStaff.class);
    }
    
    
    public MyStaff searchByUsername(String s){
        Query q = em.createNamedQuery("MyStaff.searchByUsername");
        q.setParameter("username", s);
        List<MyStaff> result = q.getResultList();
        if(result.size()>0){
            return result.get(0);
        }
        return null;
    }
    
    public List<MyStaff> searchByStaffName(String s) {
        Query q = em.createNamedQuery("MyStaff.searchByStaffName");
        q.setParameter("username", s);
        return q.getResultList();
    }
    
}
