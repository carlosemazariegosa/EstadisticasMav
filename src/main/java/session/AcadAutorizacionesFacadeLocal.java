/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.AcadAutorizaciones;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface AcadAutorizacionesFacadeLocal {

    void create(AcadAutorizaciones acadAutorizaciones);

    void edit(AcadAutorizaciones acadAutorizaciones);

    void remove(AcadAutorizaciones acadAutorizaciones);

    AcadAutorizaciones find(Object id);

    List<AcadAutorizaciones> findAll();

    List<AcadAutorizaciones> findRange(int[] range);

    int count();

    public List<AcadAutorizaciones> BuscaAutorizaciones(String SemesAno, String Facultad, String Anio, String Carnet);

    public boolean InsertAutorizacion(int IdTipoAut, String SemesAno, String Facultad, String Anio, String Carnet, Date FechaIni, Date FechaFin);
    
}
