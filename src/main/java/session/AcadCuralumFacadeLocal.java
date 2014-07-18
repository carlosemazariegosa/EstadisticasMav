/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.AcadCuralum;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface AcadCuralumFacadeLocal {

    void create(AcadCuralum acadCuralum);

    void edit(AcadCuralum acadCuralum);

    void remove(AcadCuralum acadCuralum);

    AcadCuralum find(Object id);

    List<AcadCuralum> findAll();

    List<AcadCuralum> findRange(int[] range);

    int count();

    public List<Object[]> InscripcionesAlumnos(String SemesAno, String Facultad, String Anio, String Carnet);

    public boolean InsertCursos(String SemesAno, String Facultad, String Anio, String Carnet, String Codcarr, String Codcur, String Seccion);
    
}
