/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.PntcCatedraticosBajas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface PntcCatedraticosBajasFacadeLocal {

    void create(PntcCatedraticosBajas pntcCatedraticosBajas);

    void edit(PntcCatedraticosBajas pntcCatedraticosBajas);

    void remove(PntcCatedraticosBajas pntcCatedraticosBajas);

    PntcCatedraticosBajas find(Object id);

    List<PntcCatedraticosBajas> findAll();

    List<PntcCatedraticosBajas> findRange(int[] range);

    int count();
    
}
