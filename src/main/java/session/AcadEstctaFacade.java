/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import acad.classes.Padl;
import entity.AcadEstcta;
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
public class AcadEstctaFacade extends AbstractFacade<AcadEstcta> implements AcadEstctaFacadeLocal {
    @PersistenceContext(unitName = "umg.edu.gt_MavEstadisticas_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private static List<Object[]> results;
    private Padl padl;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcadEstctaFacade() {
        super(AcadEstcta.class);
    }
    
     @Override
      public List<Object[]> AcadEstcta(String facultad, String anio, String Carnet) {
        
            padl = new Padl();
            Query query = em.createNativeQuery("select * from estado_de_cuenta(?,?,?)");
            query.setParameter(1, facultad.trim());
            query.setParameter(2, anio.trim());
            query.setParameter(3, padl.Padl(Carnet, " ", 5));
            results = query.getResultList();
            return results;
        

    }
    
}
