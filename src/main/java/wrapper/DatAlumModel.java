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
public class DatAlumModel implements Serializable {
    private String nombre;
    private String apellido;
    private String nomCarr;
    
    public DatAlumModel(){
        
    }
    public DatAlumModel(String Nombre,String Apellido,String NomCarr){
      this.nombre=Nombre;
      this.apellido =Apellido;
      this.nomCarr =NomCarr;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNomCarr() {
        return nomCarr;
    }

    public void setNomCarr(String nomCarr) {
        this.nomCarr = nomCarr;
    }
    
    
}
