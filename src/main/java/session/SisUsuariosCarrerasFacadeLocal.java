/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.SisUsuariosCarreras;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface SisUsuariosCarrerasFacadeLocal {

    void create(SisUsuariosCarreras sisUsuariosCarreras);

    void edit(SisUsuariosCarreras sisUsuariosCarreras);

    void remove(SisUsuariosCarreras sisUsuariosCarreras);

    SisUsuariosCarreras find(Object id);

    List<SisUsuariosCarreras> findAll();

    List<SisUsuariosCarreras> findRange(int[] range);

    int count();

    public List<Object[]> UserCarrProp(String Usuario);

    public String InsertUserCarrProp(int idSisUsuario, String codcarr);
    
}
