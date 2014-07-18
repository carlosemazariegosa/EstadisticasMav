/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.AcadCatedraticos;
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
public class AcadCatedraticosFacade extends AbstractFacade<AcadCatedraticos> implements AcadCatedraticosFacadeLocal {

    @PersistenceContext(unitName = "umg.edu.gt_MavEstadisticas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcadCatedraticosFacade() {
        super(AcadCatedraticos.class);
    }

    @Override
    public List<AcadCatedraticos> CatedraticosObs() {
        List<AcadCatedraticos> results;
        Query query = em.createQuery("select c from AcadCatedraticos c "
                + "inner join c.AcadCatedraticosObsCollection o "
                + "where o.status='B'  ");
        results = query.getResultList();
        return results;

    }

    @Override
    public List<Object[]> CatedraticosObsN() {
        List<Object[]> results;
        Query query = em.createNativeQuery("select b.abrv,b.codcat,b.nombre,b.apellido,a.observacion,cast(a.fechasys as date)as fechasys "
                + "from acad_catedraticos_obs a "
                + "left join acad_catedraticos b on a.id_acad_catedraticos  = b.id "
                + "where a.status='B'  ");
        results = query.getResultList();
        return results;

    }

}
