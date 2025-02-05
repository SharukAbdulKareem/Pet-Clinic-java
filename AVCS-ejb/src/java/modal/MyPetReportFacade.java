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
public class MyPetReportFacade extends AbstractFacade<MyPetReport> {

    @PersistenceContext(unitName = "AVCS-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MyPetReportFacade() {
        super(MyPetReport.class);
    }
    
    
    public List<MyPetReport> searchByPetName(String s) {
        Query q = em.createNamedQuery("MyPetReport.searchByPetName");
        q.setParameter("petname", s);
        return q.getResultList();
    }
    
}
