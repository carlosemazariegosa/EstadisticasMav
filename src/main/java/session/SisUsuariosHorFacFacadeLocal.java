/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.SisUsuariosHorFac;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface SisUsuariosHorFacFacadeLocal {

    void create(SisUsuariosHorFac sisUsuariosHorFac);

    void edit(SisUsuariosHorFac sisUsuariosHorFac);

    void remove(SisUsuariosHorFac sisUsuariosHorFac);

    SisUsuariosHorFac find(Object id);

    List<SisUsuariosHorFac> findAll();

    List<SisUsuariosHorFac> findRange(int[] range);

    int count();

    public List<Object[]> UserCarrHorarios(String Usuario);

    public String InsertUserCarrHor(int idSisUsuario, String codcarr);
    
}
