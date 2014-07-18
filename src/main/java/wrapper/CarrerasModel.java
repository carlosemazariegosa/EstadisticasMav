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
public class CarrerasModel implements Serializable {
    private String codMadre;
    private String nombre;
    
    public CarrerasModel(){
        
    }
    public CarrerasModel(String CodMadre,String Nombre){
        this.codMadre=CodMadre;
        this.nombre =Nombre;
        
    }

    public String getCodMadre() {
        return codMadre;
    }

    public void setCodMadre(String codMadre) {
        this.codMadre = codMadre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
