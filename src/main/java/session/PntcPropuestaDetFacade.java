/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.PntcPropuestaDet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mmarvin
 */
@Stateless
public class PntcPropuestaDetFacade extends AbstractFacade<PntcPropuestaDet> implements PntcPropuestaDetFacadeLocal {
    @PersistenceContext(unitName = "umg.edu.gt_MavEstadisticas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PntcPropuestaDetFacade() {
        super(PntcPropuestaDet.class);
    }
    
}
