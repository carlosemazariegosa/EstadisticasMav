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
public class InscripcionesModel implements Serializable {
    
    private String codcarr;
    private String codcur;
    private String nombre;
    private String seccion;
    private String ciclo;
    private String aula;
    private String nomAlum;
    private String apellido;
    private String nomCarr;
    private int id;
    
    public InscripcionesModel(){
        
    }
    
    public InscripcionesModel(String Codcarr,String Codcur,String Nombre,String Seccion,String Ciclo,String Aula,String NomAlum,String Apellido,String NomCarr){
     this.codcarr=Codcarr;
     this.codcur=Codcur;
     this.nombre=Nombre;
     this.seccion=Seccion;
     this.ciclo=Ciclo;
     this.aula =Aula;
     this.nomAlum =NomAlum;
     this.apellido =Apellido;
     this.nomCarr =NomCarr;
        
        
    }
    
    public InscripcionesModel(String Codcarr,String Codcur,String Nombre,String Seccion,String Ciclo,String Aula){
     this.codcarr=Codcarr;
     this.codcur=Codcur;
     this.nombre=Nombre;
     this.seccion=Seccion;
     this.ciclo=Ciclo;
     this.aula =Aula;
      
    }
    
     public InscripcionesModel(int Id, String Codcarr,String Codcur,String Nombre,String Seccion,String Ciclo,String Aula){
     this.id =Id;    
     this.codcarr=Codcarr;
     this.codcur=Codcur;
     this.nombre=Nombre;
     this.seccion=Seccion;
     this.ciclo=Ciclo;
     this.aula =Aula;
      
    }

    public String getCodcarr() {
        return codcarr;
    }

    public void setCodcarr(String codcarr) {
        this.codcarr = codcarr;
    }

    public String getCodcur() {
        return codcur;
    }

    public void setCodcur(String codcur) {
        this.codcur = codcur;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getNomAlum() {
        return nomAlum;
    }

    public void setNomAlum(String nomAlum) {
        this.nomAlum = nomAlum;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    
}
