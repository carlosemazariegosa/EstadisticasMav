/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.AcadCursosDet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface AcadCursosDetFacadeLocal {

    void create(AcadCursosDet acadCursosDet);

    void edit(AcadCursosDet acadCursosDet);

    void remove(AcadCursosDet acadCursosDet);

    AcadCursosDet find(Object id);

    List<AcadCursosDet> findAll();

    List<AcadCursosDet> findRange(int[] range);

    int count();

    public List<Object[]> BuscaCurso(String semesAno, String codCarr, String codcur, String seccion);

    public List<Object[]> BuscaCursoVal(String semesAno, String codCarr);
    
}
