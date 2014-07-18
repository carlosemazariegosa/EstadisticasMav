/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import acad.classes.Padl;
import entity.AcadAutorizaciones;
import entity.AcadTipoAutorizacion;
import java.util.Date;
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
public class AcadAutorizacionesFacade extends AbstractFacade<AcadAutorizaciones> implements AcadAutorizacionesFacadeLocal {

    @PersistenceContext(unitName = "umg.edu.gt_MavEstadisticas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcadAutorizacionesFacade() {
        super(AcadAutorizaciones.class);
    }

    @Override
    public List<AcadAutorizaciones> BuscaAutorizaciones(String SemesAno, String Facultad, String Anio, String Carnet) {
        Padl padl = new Padl();
        Query query = em.createQuery("select a from AcadAutorizaciones a "
                + "where a.semesAno=:SemesAno and a.facultad= :Facultad and a.anio=:Anio and a.carnet=:Carnet order by a.id ");
        query.setParameter("SemesAno", SemesAno);
        query.setParameter("Facultad", Facultad);
        query.setParameter("Anio", Anio);
        query.setParameter("Carnet", padl.Padl(Carnet, " ", 5));
        List<AcadAutorizaciones> result = query.getResultList();
        return result;

    }

    @Override
    public boolean InsertAutorizacion(int IdTipoAut, String SemesAno, String Facultad, String Anio, String Carnet, Date FechaIni, Date FechaFin) {
        Padl padl = new Padl();
        /*AcadAutorizaciones auto = new AcadAutorizaciones();
         auto.setSemesAno(SemesAno);
         auto.setFacultad(Facultad);
         auto.setAnio(Anio);
         auto.setCarnet(padl.Padl(Carnet, " ", 5));
         auto.setFechaInicio(FechaIni);
         auto.setFechaFinal(FechaFin);
         create(auto);*/
        Query query = em.createNativeQuery(" insert into acad_autorizaciones(id_tipo_autorizacion,semes_ano,facultad,anio,carnet,fecha_inicio,fecha_final)values(?,?,?,?,?,?,?)");
        query.setParameter(1, IdTipoAut);
        query.setParameter(2, SemesAno);
        query.setParameter(3, Facultad);
        query.setParameter(4, Anio);
        query.setParameter(5, padl.Padl(Carnet, " ", 5));
        query.setParameter(6, FechaIni);
        query.setParameter(7, FechaFin);
        query.executeUpdate();

        return true;

    }

}
