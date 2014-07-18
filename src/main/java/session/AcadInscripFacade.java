/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.AcadInscrip;
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
public class AcadInscripFacade extends AbstractFacade<AcadInscrip> implements AcadInscripFacadeLocal {

    @PersistenceContext(unitName = "umg.edu.gt_MavEstadisticas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcadInscripFacade() {
        super(AcadInscrip.class);
    }

    //inscripciones CC 
    @Override
    public int InscripcionesCC(String semesAno) {
        int resultado = 0;
        Query query = em.createNativeQuery("select count(*) from acad_inscrip a "
                + "inner  join acad_carreras b on a.facultad=b.carrera "
                + "where a.semes_ano=? and b.depto=' '");
        query.setParameter(1, semesAno);
        resultado = (int) query.getSingleResult();

        return resultado;
    }

    //Inscripciones Centros
    @Override
    public int InscripcionesCentros(String semesAno) {
        int resultado = 0;
        Query query = em.createNativeQuery("select count(*) from acad_inscrip a "
                + "inner  join acad_carreras b on a.facultad=b.carrera "
                + "where a.semes_ano=? and b.depto <>' '");
        query.setParameter(1, semesAno);
        resultado = (int) query.getSingleResult();
        return resultado;
    }

    //Inscripciones por tipo campus central
    @Override
    public List<Object[]> InscripcionesTipoCC(String semesAno, Date fecha) {
        List<Object[]> results = null;
        Query query = em.createNativeQuery("SELECT iif(b.ingles='T','INGLES,FRANCES Y ALEMAN',c.descripcion)as descripcion,count(a.carrera) as numalum "
                + "FROM acad_inscrip a "
                + "INNER JOIN acad_carreras b ON a.carrera = b.carrera "
                + "LEFT JOIN acad_tipo_carrera c on b.id_tipo_carrera=c.id "
                + "where  a.semes_ano= ? and b.depto = ' ' and a.fecha <= ? group by 1 ");
        query.setParameter(1, semesAno);
        query.setParameter(2, fecha);
        results = query.getResultList();
        return results;

    }

    //Inscripciones por tipo Centros Departamentales
    @Override
    public List<Object[]> InscripcionesTipoCentros(String semesAno, Date fecha) {
        List<Object[]> results = null;
        Query query = em.createNativeQuery("SELECT iif(b.ingles='T','INGLES,FRANCES Y ALEMAN',c.descripcion)as descripcion,count(a.carrera) as numalum "
                + "FROM acad_inscrip a "
                + "INNER JOIN acad_carreras b ON a.carrera = b.carrera "
                + "LEFT JOIN acad_tipo_carrera c on b.id_tipo_carrera=c.id "
                + "where  a.semes_ano=? and b.depto<>' ' and a.fecha <= ? group by 1 ");
        query.setParameter(1, semesAno);
        query.setParameter(2, fecha);
        results = query.getResultList();
        return results;
    }

    //Obtiene la Fecha Actual
    @Override
    public Date FechaActual() {
        Date result = null;
        Query query = em.createNativeQuery("SELECT CURRENT_DATE AS FECHA FROM RDB$DATABASE ");
        result = (Date) query.getSingleResult();
        return result;

    }

    //Inscripciones Generales Campus Central
    @Override
    public List<Object[]> InscripCampusCenGen(String semesAno, Date fecha) {

        List<Object[]> results = null;
        Query query = em.createNativeQuery("SELECT a.carrera,b.nombre as nomcarr,iif(b.ingles='T','INGLES,FRANCES Y ALEMAN',c.descripcion)as descripcion,d.nombre as depto,count(a.carrera) as numalum "
                + "FROM acad_inscrip a "
                + "INNER JOIN acad_carreras b ON a.carrera = b.carrera "
                + "LEFT JOIN acad_tipo_carrera c on b.id_tipo_carrera=c.id "
                + "LEFT JOIN sis_municipios d on b.depto= d.codigo "
                + "WHERE a.semes_ano =? and b.depto=' ' and a.fecha <= ? GROUP BY 1,2,3,4  ");
        query.setParameter(1, semesAno);
        query.setParameter(2, fecha);
        results = query.getResultList();
        return results;

    }

    //Inscripciones Generales Centros Departamentales
    @Override
    public List<Object[]> InscripCentrosDepGen(String semesAno, Date fecha) {

        List<Object[]> results = null;
        Query query = em.createNativeQuery("SELECT a.carrera,b.nombre as nomcarr,iif(b.ingles='T','INGLES,FRANCES Y ALEMAN',c.descripcion)as descripcion,d.nombre as depto,count(a.carrera) as numalum "
                + "FROM acad_inscrip a "
                + "INNER JOIN acad_carreras b ON a.carrera = b.carrera "
                + "LEFT JOIN acad_tipo_carrera c on b.id_tipo_carrera=c.id "
                + "LEFT JOIN sis_municipios d on b.depto= d.codigo "
                + "WHERE a.semes_ano =? and b.depto<>' ' and a.fecha <= ? GROUP BY 1,2,3,4  ");
        query.setParameter(1, semesAno);
        query.setParameter(2, fecha);
        results = query.getResultList();
        return results;

    }

    //Inscripciones por Departamento Campus Central
    @Override
    public List<Object[]> InscripcionesDeptoCC(String semesAno, Date fecha) {
        List<Object[]> results = null;
        Query query = em.createNativeQuery("SELECT c.nombre,count(a.carrera) as numalum "
                + "FROM acad_inscrip a "
                + "INNER JOIN acad_carreras b ON a.carrera = b.carrera "
                + "LEFT JOIN sis_municipios c on c.codigo=b.depto "
                + "where  a.semes_ano=? and b.depto=' ' and a.fecha <=? group by 1 ");
        query.setParameter(1, semesAno);
        query.setParameter(2, fecha);
        results = query.getResultList();
        return results;

    }

    //Inscripciones por Departamento Centros Departamentales
    @Override
    public List<Object[]> InscripcionesDeptoCentros(String semesAno, Date fecha) {
        List<Object[]> results = null;
        Query query = em.createNativeQuery("SELECT c.nombre,count(a.carrera) as numalum "
                + "FROM acad_inscrip a "
                + "INNER JOIN acad_carreras b ON a.carrera = b.carrera "
                + "LEFT JOIN sis_municipios c on c.codigo=b.depto "
                + "where  a.semes_ano=? and b.depto<>' ' and a.fecha <=? group by 1 ");
        query.setParameter(1, semesAno);
        query.setParameter(2, fecha);
        results = query.getResultList();
        return results;

    }

    //Inscripciones por Centro Campus Central
    @Override
    public List<Object[]> InscripcionesCentroCC(String semesAno, Date fecha) {
        List<Object[]> results = null;
        Query query = em.createNativeQuery("SELECT  c.nombre as centro,b.carrera,b.nombre,count(a.carrera) as numalum,cast(0 as int) as prim "
                + "         FROM acad_inscrip a "
                + "         INNER JOIN acad_carreras b ON a.carrera = b.carrera "
                + "         left join sis_municipios c on b.depto=c.codigo "
                + "         where  a.semes_ano= ? and b.depto=' ' and a.fecha <= ? group by 1,2,3  order by 1,2 ");
        query.setParameter(1, semesAno);
        query.setParameter(2, fecha);
        results = query.getResultList();
        return results;
    }

    //Inscripciones por Centro Centros Departamentales
    @Override
    public List<Object[]> InscripcionesCentroCentrosDep(String semesAno, Date fecha) {
        List<Object[]> results = null;
        Query query = em.createNativeQuery("SELECT  c.nombre as centro,b.carrera,b.nombre,count(a.carrera) as numalum,cast(0 as int) as prim "
                + "         FROM acad_inscrip a "
                + "         INNER JOIN acad_carreras b ON a.carrera = b.carrera "
                + "         left join sis_municipios c on b.depto=c.codigo "
                + "         where  a.semes_ano= ? and b.depto<>' ' and a.fecha <= ? group by 1,2,3  order by 1,2 ");
        query.setParameter(1, semesAno);
        query.setParameter(2, fecha);
        results = query.getResultList();
        return results;
    }

    //Inscripciones por Carrera Madre
    @Override
    public List<Object[]> InscripcionesCodMadre(String semesAno, Date fecha, String codMadre) {

        List<Object[]> results = null;
        Query query = em.createNativeQuery("select b.carrera,b.nombre,count(*) from acad_inscrip a "
                + "inner  join acad_carreras b on a.facultad=b.carrera "
                + "where a.semes_ano=? and a.fecha <=? and b.cod_madre=? group by 1,2 ");
        query.setParameter(1, semesAno);
        query.setParameter(2, fecha);
        query.setParameter(3, codMadre);
        results = query.getResultList();
        return results;
    }

    //Inscripciones por Centro Centros Departamentales primer Ingreso
    @Override
    public List<Object[]> InscripcionesCentroCentrosDepPrimIngre(String semesAno, Date fecha, String Anio) {
        List<Object[]> results = null;
        Query query = em.createNativeQuery("SELECT  c.nombre as centro,b.carrera,b.nombre,count(a.carrera) as numalum "
                + "         FROM acad_inscrip a "
                + "         INNER JOIN acad_carreras b ON a.carrera = b.carrera "
                + "         left join sis_municipios c on b.depto=c.codigo "
                + "         where  a.semes_ano= ? and b.depto<>' ' and a.fecha <= ? and a.anio=? group by 1,2,3  order by 1,2 ");
        query.setParameter(1, semesAno);
        query.setParameter(2, fecha);
        query.setParameter(3, Anio);
        results = query.getResultList();
        return results;
    }

    // Totales Inscripciones por Centro Centros Departamentales primer Ingreso
    @Override
    public List<Object[]> InscripcionesCentroCentrosDepPrimIngreTotales(String semesAno, Date fecha, String Anio) {
        List<Object[]> results = null;
        Query query = em.createNativeQuery("SELECT  c.nombre as centro,count(a.carrera) as numalum "
                + "FROM acad_inscrip a "
                + "INNER JOIN acad_carreras b ON a.carrera = b.carrera "
                + "left join sis_municipios c on b.depto=c.codigo "
                + "where  a.semes_ano= ? and b.depto<>' ' and a.fecha <= ? and a.anio=? group by 1  order by 1,2 ");
        query.setParameter(1, semesAno);
        query.setParameter(2, fecha);
        query.setParameter(3, Anio);
        results = query.getResultList();
        return results;
    }
    
     // Totales Inscripciones por Centro Centros Departamentales Reingreso
    @Override
    public List<Object[]> InscripcionesCentroCentrosDepReingresoTotales(String semesAno, Date fecha, String Anio) {
        List<Object[]> results = null;
        Query query = em.createNativeQuery("SELECT  c.nombre as centro,count(a.carrera) as numalum "
                + "FROM acad_inscrip a "
                + "INNER JOIN acad_carreras b ON a.carrera = b.carrera "
                + "left join sis_municipios c on b.depto=c.codigo "
                + "where  a.semes_ano= ? and b.depto<>' ' and a.fecha <= ? and a.anio<>? group by 1  order by 1,2 ");
        query.setParameter(1, semesAno);
        query.setParameter(2, fecha);
        query.setParameter(3, Anio);
        results = query.getResultList();
        return results;
    }
    
    
    //Inscripciones por Campus Central primer Ingreso
    @Override
    public List<Object[]> InscripcionesCCPrimIngre(String semesAno, Date fecha, String Anio) {
        List<Object[]> results = null;
        Query query = em.createNativeQuery("SELECT  c.nombre as centro,b.carrera,b.nombre,count(a.carrera) as numalum "
                + "         FROM acad_inscrip a "
                + "         INNER JOIN acad_carreras b ON a.carrera = b.carrera "
                + "         left join sis_municipios c on b.depto=c.codigo "
                + "         where  a.semes_ano= ? and b.depto=' ' and a.fecha <= ? and a.anio=? group by 1,2,3  order by 1,2 ");
        query.setParameter(1, semesAno);
        query.setParameter(2, fecha);
        query.setParameter(3, Anio);
        results = query.getResultList();
        return results;
    }
    
    // Totales Inscripciones por Centro Centros Departamentales primer Ingreso
    @Override
    public List<Object[]> InscripcionesCCPrimIngreTotales(String semesAno, Date fecha, String Anio) {
        List<Object[]> results = null;
        Query query = em.createNativeQuery("SELECT  c.nombre as centro,count(a.carrera) as numalum "
                + "FROM acad_inscrip a "
                + "INNER JOIN acad_carreras b ON a.carrera = b.carrera "
                + "left join sis_municipios c on b.depto=c.codigo "
                + "where  a.semes_ano= ? and b.depto=' ' and a.fecha <= ? and a.anio=? group by 1  order by 1,2 ");
        query.setParameter(1, semesAno);
        query.setParameter(2, fecha);
        query.setParameter(3, Anio);
        results = query.getResultList();
        return results;
    }
    
     @Override
    public List<Object[]> InscripcionesCCReingresoTotales(String semesAno, Date fecha, String Anio) {
        List<Object[]> results = null;
        Query query = em.createNativeQuery("SELECT  c.nombre as centro,count(a.carrera) as numalum "
                + "FROM acad_inscrip a "
                + "INNER JOIN acad_carreras b ON a.carrera = b.carrera "
                + "left join sis_municipios c on b.depto=c.codigo "
                + "where  a.semes_ano= ? and b.depto=' ' and a.fecha <= ? and a.anio<>? group by 1  order by 1,2 ");
        query.setParameter(1, semesAno);
        query.setParameter(2, fecha);
        query.setParameter(3, Anio);
        results = query.getResultList();
        return results;
    }

}
