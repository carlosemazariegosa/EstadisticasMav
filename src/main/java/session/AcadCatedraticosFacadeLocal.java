/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.AcadCatedraticos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface AcadCatedraticosFacadeLocal {

    void create(AcadCatedraticos acadCatedraticos);

    void edit(AcadCatedraticos acadCatedraticos);

    void remove(AcadCatedraticos acadCatedraticos);

    AcadCatedraticos find(Object id);

    List<AcadCatedraticos> findAll();

    List<AcadCatedraticos> findRange(int[] range);

    int count();

    public List<AcadCatedraticos> CatedraticosObs();

    public List<Object[]> CatedraticosObsN();
    
}
