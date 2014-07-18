/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.PntcPropuestaStatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface PntcPropuestaStatusFacadeLocal {

    void create(PntcPropuestaStatus pntcPropuestaStatus);

    void edit(PntcPropuestaStatus pntcPropuestaStatus);

    void remove(PntcPropuestaStatus pntcPropuestaStatus);

    PntcPropuestaStatus find(Object id);

    List<PntcPropuestaStatus> findAll();

    List<PntcPropuestaStatus> findRange(int[] range);

    int count();
    
}
