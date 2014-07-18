/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.AcadTipoAutorizacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface AcadTipoAutorizacionFacadeLocal {

    void create(AcadTipoAutorizacion acadTipoAutorizacion);

    void edit(AcadTipoAutorizacion acadTipoAutorizacion);

    void remove(AcadTipoAutorizacion acadTipoAutorizacion);

    AcadTipoAutorizacion find(Object id);

    List<AcadTipoAutorizacion> findAll();

    List<AcadTipoAutorizacion> findRange(int[] range);

    int count();

    public List<AcadTipoAutorizacion> BuscaTipoAutorizacion();
    
}
