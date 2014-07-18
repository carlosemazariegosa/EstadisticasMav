/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.AcadEstcta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface AcadEstctaFacadeLocal {

    void create(AcadEstcta acadEstcta);

    void edit(AcadEstcta acadEstcta);

    void remove(AcadEstcta acadEstcta);

    AcadEstcta find(Object id);

    List<AcadEstcta> findAll();

    List<AcadEstcta> findRange(int[] range);

    int count();

    public List<Object[]> AcadEstcta(String facultad, String anio, String Carnet);
    
}
