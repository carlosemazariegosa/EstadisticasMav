/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.SisAccesos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface SisAccesosFacadeLocal {

    void create(SisAccesos sisAccesos);

    void edit(SisAccesos sisAccesos);

    void remove(SisAccesos sisAccesos);

    SisAccesos find(Object id);

    List<SisAccesos> findAll();

    List<SisAccesos> findRange(int[] range);

    int count();
    
}
