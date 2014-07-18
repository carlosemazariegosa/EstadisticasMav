/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.AcadAlumnos;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface AcadAlumnosFacadeLocal {

    void create(AcadAlumnos acadAlumnos);

    void edit(AcadAlumnos acadAlumnos);

    void remove(AcadAlumnos acadAlumnos);

    AcadAlumnos find(Object id);

    List<AcadAlumnos> findAll();

    List<AcadAlumnos> findRange(int[] range);

    int count();

    public List<AcadAlumnos> DatAlumnos(String Facultad, String Anio, String Carnet);

    public boolean EdtAlumnos(Integer id, String nombre, String apellido, String telcel);

    public String AgregaAlumnos(String facultad, String nombre, String apellido, Date fecnac);

    public String InsertAlumnos(String facultad, String nombre, String apellido, Date fecnac);
    
}
