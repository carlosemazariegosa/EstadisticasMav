/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.AcadCatedraticosObs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mmarvin
 */
@Stateless
public class AcadCatedraticosObsFacade extends AbstractFacade<AcadCatedraticosObs> implements AcadCatedraticosObsFacadeLocal {
    @PersistenceContext(unitName = "umg.edu.gt_MavEstadisticas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcadCatedraticosObsFacade() {
        super(AcadCatedraticosObs.class);
    }
    
}
