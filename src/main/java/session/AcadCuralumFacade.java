/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import acad.classes.Padl;
import entity.AcadCuralum;
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
public class AcadCuralumFacade extends AbstractFacade<AcadCuralum> implements AcadCuralumFacadeLocal {

    @PersistenceContext(unitName = "umg.edu.gt_MavEstadisticas_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private Padl padl;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcadCuralumFacade() {
        super(AcadCuralum.class);
    }

    //Inscripciones Alumnos
    @Override
    public List<Object[]> InscripcionesAlumnos(String SemesAno,String Facultad,String Anio,String Carnet) {
       List<Object[]> results = null;
        padl = new Padl();
        Query query = em.createNativeQuery("select a.codcarr,a.codcur,a.seccion,b.nombre from acad_curalum a "
                + "left join acad_cursos_det b on a.semes_ano=b.semes_ano and a.codcarr=b.codcarr and a.codcur=b.codcur and a.seccion=b.seccion "
                + "where a.semes_ano= ? and a.facultad= ? and anio= ? and carnet= ? ");
        query.setParameter(1, SemesAno.trim());
        query.setParameter(2,Facultad.trim());
        query.setParameter(3,Anio.trim());
        query.setParameter(4, padl.Padl(Carnet, " ", 5));
        results = query.getResultList();
        return results;
    }
    
    
     @Override
    public boolean InsertCursos(String SemesAno,String Facultad,String Anio,String Carnet,String Codcarr,String Codcur,String Seccion){
        padl = new Padl();
        Query query =em.createNativeQuery("insert into acad_curalum(semes_ano,facultad,anio,carnet,codcarr,codcur,seccion)values(?,?,?,?,?,?,?) ");
        query.setParameter(1,SemesAno);
        query.setParameter(2,Facultad);
        query.setParameter(3,Anio);
        query.setParameter(4,padl.Padl(Carnet, " ", 5));
        query.setParameter(5,Codcarr);
        query.setParameter(6,Codcur);
        query.setParameter(7,Seccion.toUpperCase());
        query.executeUpdate();
        return true;
     
    }

}
