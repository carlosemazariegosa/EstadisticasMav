/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.PntcPropuesta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface PntcPropuestaFacadeLocal {

    void create(PntcPropuesta pntcPropuesta);

    void edit(PntcPropuesta pntcPropuesta);

    void remove(PntcPropuesta pntcPropuesta);

    PntcPropuesta find(Object id);

    List<PntcPropuesta> findAll();

    List<PntcPropuesta> findRange(int[] range);

    int count();

    public List<Object[]> PropuestaEstadistica(String SemesAno);
    
}
