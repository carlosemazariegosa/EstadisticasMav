/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;


import entity.SisUsuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface SisUsuariosFacadeLocal {

    void create(SisUsuarios sisUsuarios);

    void edit(SisUsuarios sisUsuarios);

    void remove(SisUsuarios sisUsuarios);

    SisUsuarios find(Object id);

    List<SisUsuarios> findAll();

    List<SisUsuarios> findRange(int[] range);

    int count();

    public boolean SisUsuariosLogin(String usuario, String contrasena);

    public List<Object[]> SisAccesos(String usuario);

    public boolean BuscaUsuario(String usuario);

    public List<SisUsuarios> IdUsuario(String usuario);

   
    
}
