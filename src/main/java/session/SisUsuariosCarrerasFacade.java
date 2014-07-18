/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.SisUsuariosCarreras;
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
public class SisUsuariosCarrerasFacade extends AbstractFacade<SisUsuariosCarreras> implements SisUsuariosCarrerasFacadeLocal {

    @PersistenceContext(unitName = "umg.edu.gt_MavEstadisticas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SisUsuariosCarrerasFacade() {
        super(SisUsuariosCarreras.class);
    }

    @Override
    public List<Object[]> UserCarrProp(String Usuario) {
        List<Object[]> results = null;
        Query query = em.createNativeQuery("select a.id,a.id_sis_usuario,a.codcarr,b.nombre from sis_usuarios_carreras a "
                + "left join acad_carreras b on a.codcarr=b.carrera "
                + "left join sis_usuarios c on a.id_sis_usuario=c.id "
                + "where c.usuario= ?  order by a.fechasys ");
        query.setParameter(1, Usuario.trim().toUpperCase());
        results = query.getResultList();
        return results;

    }
    
    @Override
    public String InsertUserCarrProp(int idSisUsuario,String codcarr){
        Query query =em.createNativeQuery("insert into sis_usuarios_carreras(id_sis_usuario,codcarr)values(?,?) ");
        query.setParameter(1,idSisUsuario);
        query.setParameter(2,codcarr);
        query.executeUpdate();
        return "Se Agrego la Carrera "+codcarr;
     
    }

}
