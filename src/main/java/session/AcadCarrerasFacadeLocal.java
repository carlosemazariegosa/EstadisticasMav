/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.AcadCarreras;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface AcadCarrerasFacadeLocal {

    void create(AcadCarreras acadCarreras);

    void edit(AcadCarreras acadCarreras);

    void remove(AcadCarreras acadCarreras);

    AcadCarreras find(Object id);

    List<AcadCarreras> findAll();

    List<AcadCarreras> findRange(int[] range);

    int count();

    public List<AcadCarreras> BuscaCarrera(String Facultad);

    public List<Object[]> BuscaCarreraMadre();
    
}
