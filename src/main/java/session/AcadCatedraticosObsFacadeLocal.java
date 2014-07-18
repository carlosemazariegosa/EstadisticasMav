/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.AcadCatedraticosObs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface AcadCatedraticosObsFacadeLocal {

    void create(AcadCatedraticosObs acadCatedraticosObs);

    void edit(AcadCatedraticosObs acadCatedraticosObs);

    void remove(AcadCatedraticosObs acadCatedraticosObs);

    AcadCatedraticosObs find(Object id);

    List<AcadCatedraticosObs> findAll();

    List<AcadCatedraticosObs> findRange(int[] range);

    int count();
    
}
