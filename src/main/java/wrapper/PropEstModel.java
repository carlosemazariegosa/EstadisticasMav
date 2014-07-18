/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wrapper;

import java.io.Serializable;


public class PropEstModel implements Serializable {
    private int  nid;
    private int grupo;
    private String descripcion;
    private int cantidad;
    
    public PropEstModel(){
        
    }
    
    public PropEstModel(int Nid,int Grupo,String Descripcion,int Cantidad){
       this.nid=Nid;
       this.grupo=Grupo;
       this.descripcion=Descripcion;
       this.cantidad=Cantidad;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
