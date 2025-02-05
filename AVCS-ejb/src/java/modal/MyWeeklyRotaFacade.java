/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sharuk
 */
@Stateless
public class MyWeeklyRotaFacade extends AbstractFacade<MyWeeklyRota> {

    @PersistenceContext(unitName = "AVCS-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MyWeeklyRotaFacade() {
        super(MyWeeklyRota.class);
    }
    
}
