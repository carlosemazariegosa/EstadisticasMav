/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.AcadCarreras;
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
public class AcadCarrerasFacade extends AbstractFacade<AcadCarreras> implements AcadCarrerasFacadeLocal {

    @PersistenceContext(unitName = "umg.edu.gt_MavEstadisticas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcadCarrerasFacade() {
        super(AcadCarreras.class);
    }

    @Override
    public List<AcadCarreras> BuscaCarrera(String Facultad) {
        List<AcadCarreras> results;
        Query query = em.createQuery("select c from AcadCarreras c where c.carrera=:facultad");
        query.setParameter("facultad", Facultad);
        results = query.getResultList();
        return results;

    }

    //Codigos Madre
    @Override
    public List<Object[]> BuscaCarreraMadre() {
        List<Object[]> results = null;
        Query query = em.createNativeQuery("select distinct cod_madre,(select nombre from acad_carreras b where b.carrera=a.cod_madre) "
                + "from acad_carreras a "
                + "where cod_madre not in('0001','0003','0004','0008','0009','9998','ACRD','    ')  order by 2 ");
        results = query.getResultList();
        return results;
    }

}
