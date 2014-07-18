/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.AcadCursosDet;
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
public class AcadCursosDetFacade extends AbstractFacade<AcadCursosDet> implements AcadCursosDetFacadeLocal {

    @PersistenceContext(unitName = "umg.edu.gt_MavEstadisticas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcadCursosDetFacade() {
        super(AcadCursosDet.class);
    }

    @Override
    public List<Object[]> BuscaCurso(String semesAno, String codCarr, String Codcur, String Seccion) {
        List<Object[]> results = null;
        Query query = em.createNativeQuery("select a.id,a.nombre from acad_cursos_det a "
                + "where a.semes_ano=? and a.codcarr=? and a.codcur=? and a.seccion=? ");
        query.setParameter(1, semesAno.trim());
        query.setParameter(2, codCarr.trim());
        query.setParameter(3, Codcur.trim());
        query.setParameter(4, Seccion.toUpperCase());
        results = query.getResultList();
        return results;

    }
    
    @Override
    public List<Object[]> BuscaCursoVal(String semesAno, String codCarr) {
        List<Object[]> results = null;
        Query query = em.createNativeQuery("select a.semes_ano,a.codcarr,a.codcur,a.seccion,a.nombre from acad_cursos_det a " +
                                           "where a.semes_ano = ? and a.codcarr= ? and ciclo='01' ");
        query.setParameter(1, semesAno.trim());
        query.setParameter(2, codCarr.trim());
        results = query.getResultList();
        return results;

    }

}
