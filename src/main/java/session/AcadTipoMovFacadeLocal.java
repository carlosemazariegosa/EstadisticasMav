/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.AcadTipoMov;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface AcadTipoMovFacadeLocal {

    void create(AcadTipoMov acadTipoMov);

    void edit(AcadTipoMov acadTipoMov);

    void remove(AcadTipoMov acadTipoMov);

    AcadTipoMov find(Object id);

    List<AcadTipoMov> findAll();

    List<AcadTipoMov> findRange(int[] range);

    int count();
    
}
