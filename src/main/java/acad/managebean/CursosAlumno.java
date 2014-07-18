/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acad.managebean;

import java.io.Serializable;

/**
 *
 * @author mmarvin
 */
public class CursosAlumno implements Serializable {
    
    private String codCarr;
    private String codCurso;
    private String seccion;
    private String nombre;
    
   public CursosAlumno(){
       
   }
   
   public CursosAlumno(String CodCarr,String CodCurso,String Seccion,String Nombre){
       this.codCarr=CodCarr;
       this.codCurso =CodCurso;
       this.seccion =Seccion;
       this.nombre =Nombre;
       
   }

    public String getCodCarr() {
        return codCarr;
    }

    public void setCodCarr(String codCarr) {
        this.codCarr = codCarr;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    
}