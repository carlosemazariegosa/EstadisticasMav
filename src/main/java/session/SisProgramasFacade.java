/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.SisProgramas;
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
public class SisProgramasFacade extends AbstractFacade<SisProgramas> implements SisProgramasFacadeLocal {
    @PersistenceContext(unitName = "umg.edu.gt_MavEstadisticas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SisProgramasFacade() {
        super(SisProgramas.class);
    }
    
    @Override
    public String TituloProg(String Nombre) {
        String resultado = "";
        Query query = em.createNativeQuery("select a.titulo from sis_programas a where a.nombre_web =? ");
        query.setParameter(1,Nombre.trim());
        resultado = (String) query.getSingleResult();
        return resultado;
    }
    
   
    
    
}
