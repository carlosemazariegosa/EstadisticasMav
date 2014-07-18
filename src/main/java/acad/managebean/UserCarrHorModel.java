/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acad.managebean;

import java.io.Serializable;


public class UserCarrHorModel implements Serializable{
    private int id;
    private int idSisUsuario;
    private String codcarr;
    private String nombre;
    
    public UserCarrHorModel(){
        
    }

    UserCarrHorModel(int Id, int IdSisUsuario, String Codcarr, String Nombre) {
        this.id=Id;
        this.idSisUsuario=IdSisUsuario;
        this.codcarr=Codcarr;
        this.nombre=Nombre;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSisUsuario() {
        return idSisUsuario;
    }

    public void setIdSisUsuario(int idSisUsuario) {
        this.idSisUsuario = idSisUsuario;
    }

    public String getCodcarr() {
        return codcarr;
    }

    public void setCodcarr(String codcarr) {
        this.codcarr = codcarr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
