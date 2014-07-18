/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.SisAccesos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mmarvin
 */
@Stateless
public class SisAccesosFacade extends AbstractFacade<SisAccesos> implements SisAccesosFacadeLocal {
    @PersistenceContext(unitName = "umg.edu.gt_MavEstadisticas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SisAccesosFacade() {
        super(SisAccesos.class);
    }
    
}
