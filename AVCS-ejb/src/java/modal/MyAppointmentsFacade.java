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
import javax.persistence.TypedQuery;

/**
 *
 * @author sharuk
 */
@Stateless
public class MyAppointmentsFacade extends AbstractFacade<MyAppointments> {

    @PersistenceContext(unitName = "AVCS-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MyAppointmentsFacade() {
        super(MyAppointments.class);
    }
    
    
    // Method to find appointments by vet, date, and time
    public List<MyAppointments> findByVetDateAndTime(String vetAssigned, String appointmentDate, String appointmentTime) {
        TypedQuery<MyAppointments> query = em.createQuery(
                "SELECT a FROM MyAppointments a WHERE a.vetAssigned = :vetAssigned AND a.appointmentDate = :appointmentDate AND a.appointmentTime = :appointmentTime", MyAppointments.class);
        query.setParameter("vetAssigned", vetAssigned);
        query.setParameter("appointmentDate", appointmentDate);
        query.setParameter("appointmentTime", appointmentTime);
        return query.getResultList();
    }
    
    public List<MyAppointments> searchByVet(String s) {
        Query q = em.createNamedQuery("MyAppointments.searchByVet");
        q.setParameter("vetAssigned", s);
        return q.getResultList();
    }
    
//    public List<MyAppointments> searchByVetId(long vetId) {
//        Query q = em.createNamedQuery("MyAppointments.searchByVetId");
//        q.setParameter("vetId", vetId);
//        return q.getResultList();
//}
    
    
}
