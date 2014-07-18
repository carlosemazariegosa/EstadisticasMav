/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wrapper;

import java.io.Serializable;
import java.util.Date;



public class CatedraticosModel implements Serializable {
    
    private String abrv;
    private String codcat;
    private String nombre;
    private String apellido;
    private String observacion;
    private Date fecha;
    
    public CatedraticosModel(){
        
    }
    
    public CatedraticosModel(String Abrv,String Codcat,String Nombre,String Apellido,String Observacion,Date fecha){
        this.abrv=Abrv;
        this.codcat=Codcat;
        this.nombre=Nombre;
        this.apellido=Apellido;
        this.observacion=Observacion;
        this.fecha=fecha;
        
    }

    public String getAbrv() {
        return abrv;
    }

    public void setAbrv(String abrv) {
        this.abrv = abrv;
    }

    public String getCodcat() {
        return codcat;
    }

    public void setCodcat(String codcat) {
        this.codcat = codcat;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String Observacion) {
        this.observacion = Observacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
