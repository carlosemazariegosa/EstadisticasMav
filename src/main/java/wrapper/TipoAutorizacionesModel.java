/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wrapper;

import java.io.Serializable;

/**
 *
 * @author mmarvin
 */
public class TipoAutorizacionesModel implements Serializable {
    
    private int id;
    private String nombre;
    
    public TipoAutorizacionesModel(){
        
    }
    
    public TipoAutorizacionesModel(int Id,String Nombre){
        this.id=Id;
        this.nombre=Nombre;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
