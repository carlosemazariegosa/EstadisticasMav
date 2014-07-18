/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.AcadTipoAutorizacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mmarvin
 */
@Stateless
public class AcadTipoAutorizacionFacade extends AbstractFacade<AcadTipoAutorizacion> implements AcadTipoAutorizacionFacadeLocal {
    @PersistenceContext(unitName = "umg.edu.gt_MavEstadisticas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcadTipoAutorizacionFacade() {
        super(AcadTipoAutorizacion.class);
    }
    
    @Override
    public List<AcadTipoAutorizacion> BuscaTipoAutorizacion() {      
        Query query = em.createQuery("select a from AcadTipoAutorizacion a ");   
        List<AcadTipoAutorizacion> result = query.getResultList();
        return result;
    }
    
}
