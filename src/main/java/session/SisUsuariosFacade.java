/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import acad.classes.md5;
import entity.SisUsuarios;
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
public class SisUsuariosFacade extends AbstractFacade<SisUsuarios> implements SisUsuariosFacadeLocal {

    @PersistenceContext(unitName = "umg.edu.gt_MavEstadisticas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SisUsuariosFacade() {
        super(SisUsuarios.class);
    }

    @Override
    public boolean SisUsuariosLogin(String usuario, String contrasena) {
        
        contrasena = md5.encriptaEnMD5(contrasena.trim().toUpperCase());
        Query query = em.createQuery("select c.usuario,c.clave from SisUsuarios c where c.usuario=:usuario and c.clave=:clave");
        query.setParameter("usuario", usuario.toUpperCase().trim());
        query.setParameter("clave", contrasena.trim());
        List<Object[]> results = query.getResultList();

        if (results.size() > 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<Object[]> SisAccesos(String usuario) {
        List<Object[]> results;
        Query query = em.createQuery("select p.titulo,p.nombreWeb,p.tipo,p.id from SisUsuarios u "
                + "                  left join u.SisAccesosCollection a "
                + "                 left join a.programa p "
                + "                 where u.usuario=:usuario and  p.nombreWeb<>' ' and a.acceso='T'  ");
        query.setParameter("usuario", usuario.toUpperCase().trim());
        results = query.getResultList();
        return results;

    }

    @Override
    public boolean BuscaUsuario(String usuario) {
        Query query = em.createQuery("select c.usuario from SisUsuarios c where c.usuario=:usuario ");
        query.setParameter("usuario", usuario.toUpperCase().trim());
        List<Object[]> results = query.getResultList();

        if (results.size() > 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<SisUsuarios> IdUsuario(String usuario) {
        List<SisUsuarios> results;
        Query query = em.createQuery("select c from SisUsuarios c where c.usuario=:usuario ");
        query.setParameter("usuario", usuario.toUpperCase().trim());
        results = query.getResultList();
        return results;

    }

}
