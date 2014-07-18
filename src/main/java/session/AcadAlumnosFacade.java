/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import acad.classes.Padl;
import entity.AcadAlumnos;
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
public class AcadAlumnosFacade extends AbstractFacade<AcadAlumnos> implements AcadAlumnosFacadeLocal {

    @PersistenceContext(unitName = "umg.edu.gt_MavEstadisticas_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private Padl padl;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcadAlumnosFacade() {
        super(AcadAlumnos.class);
    }

    @Override
    public List<AcadAlumnos> DatAlumnos(String Facultad, String Anio, String Carnet) {

        padl = new Padl();
        List<AcadAlumnos> results;
        Query query = em.createQuery("select a from AcadAlumnos a where a.facultad=:facultad and a.anio=:anio and a.carnet=:carnet");
        query.setParameter("facultad", Facultad);
        query.setParameter("anio", Anio);
        query.setParameter("carnet", padl.Padl(Carnet, " ", 5));
        results = query.getResultList();
        return results;

    }

    @Override
    public boolean EdtAlumnos(Integer id, String nombre, String apellido, String telcel) {

        Query query = em.createQuery("UPDATE AcadAlumnos a SET a.nombre = :nombre,a.apellido=:apellido,a.telefonoCel=:telcel WHERE a.id = :id ");
        query.setParameter("nombre", nombre);
        query.setParameter("apellido", apellido);
        query.setParameter("telcel", telcel);
        query.setParameter("id", id);
        query.executeUpdate();
        return true;
    }

    @Override
    public String AgregaAlumnos(String facultad, String nombre, String apellido, Date fecnac) {

        String anio = "";
        int carnet = 0;
        String mensaje = "";
        padl = new Padl();

        Query query = em.createNativeQuery("select * from mantenimiento_alumnos(?)");
        query.setParameter(1, facultad);
        List<Object[]> results = query.getResultList();
        for (Object[] result : results) {
            mensaje = (String) result[1];
            if (mensaje.trim().equals("0")) {
                carnet = (int) result[0];
                anio = (String) result[2];
                mensaje = "Carnet :" + facultad + "-" + anio + "-" + carnet;
                AcadAlumnos alumnos = new AcadAlumnos();
                alumnos.setFacultad(facultad);
                alumnos.setAnio(anio);
                alumnos.setCarnet(Integer.toString(carnet));
                alumnos.setNombre(nombre.toUpperCase().trim());
                alumnos.setApellido(apellido.toUpperCase().trim());
                /*em.getTransaction().begin();
                 em.persist(alumnos);
                 em.getTransaction().commit();*/
                create(alumnos);

            } else {
                mensaje = "Carrera No Existe";
            }
        }

        return mensaje;
    }

    @Override
    public void create(AcadAlumnos alumnos) {
        super.create(alumnos);
    }

    @Override
    public String InsertAlumnos(String facultad, String nombre, String apellido, Date fecnac) {
        padl = new Padl();
        String anio = "";
        int carnet = 0;
        String mensaje = "";
        Query query = em.createNativeQuery("select * from mantenimiento_alumnos(?)");
        query.setParameter(1, facultad);
        List<Object[]> results = query.getResultList();
        for (Object[] result : results) {
            mensaje = (String) result[1];
            if (mensaje.trim().equals("0")) {
                carnet = (int) result[0];
                anio = (String) result[2];

                mensaje = "Carnet :" + facultad + "-" + anio + "-" + carnet;
                Query queryI = em.createNativeQuery(" insert into acad_alumnos(facultad,anio,carnet,nombre,apellido,fecha_nacimiento)values(?,?,?,?,?,?)");
                queryI.setParameter(1, facultad);
                queryI.setParameter(2, anio);
                queryI.setParameter(3, padl.Padl(Integer.toString(carnet), " ", 5));
                queryI.setParameter(4, nombre.toUpperCase().trim());
                queryI.setParameter(5, apellido.toUpperCase().trim());
                queryI.setParameter(6, fecnac);
                queryI.executeUpdate();
            } else {
                mensaje = "Carrera No Existe";
            }
        }
        return mensaje;

    }
}
