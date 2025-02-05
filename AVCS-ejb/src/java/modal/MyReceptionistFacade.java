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
public class MyReceptionistFacade extends AbstractFacade<MyReceptionist> {

    @PersistenceContext(unitName = "AVCS-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MyReceptionistFacade() {
        super(MyReceptionist.class);
    }
    
    public MyReceptionist searchByReceptionistUsername(String s){
        Query q = em.createNamedQuery("MyReceptionist.searchByRecepUsername");
        q.setParameter("username", s);
        List<MyReceptionist> result = q.getResultList();
        if(result.size()>0){
            return result.get(0);
        }
        return null;
    }
    
    
    public List<MyReceptionist> searchByReceptionistName(String s) {
        Query q = em.createNamedQuery("MyReceptionist.searchByReceptionistName");
        q.setParameter("username", s);
        return q.getResultList();
    }
}
