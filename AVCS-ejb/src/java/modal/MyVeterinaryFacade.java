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
public class MyVeterinaryFacade extends AbstractFacade<MyVeterinary> {

    @PersistenceContext(unitName = "AVCS-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MyVeterinaryFacade() {
        super(MyVeterinary.class);
    }
    
    
    public MyVeterinary searchByDoctorsName(String y){
        Query q = em.createNamedQuery("MyVeterinary.searchByDoctorsName");
        q.setParameter("username", y);
        List<MyVeterinary> result = q.getResultList();
        if(result.size()>0){
            return result.get(0);
        }
        return null;
    }
    
    public List<MyVeterinary> searchByVetenarianName(String s) {
        Query q = em.createNamedQuery("MyVeterinary.searchByVetenarianName");
        q.setParameter("username", s);
        return q.getResultList();
    }
    
}
