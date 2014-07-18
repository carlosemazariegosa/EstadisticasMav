/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.PntcPropuestaDet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface PntcPropuestaDetFacadeLocal {

    void create(PntcPropuestaDet pntcPropuestaDet);

    void edit(PntcPropuestaDet pntcPropuestaDet);

    void remove(PntcPropuestaDet pntcPropuestaDet);

    PntcPropuestaDet find(Object id);

    List<PntcPropuestaDet> findAll();

    List<PntcPropuestaDet> findRange(int[] range);

    int count();
    
}
