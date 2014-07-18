/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wrapper;

import java.io.Serializable;




public class InscripModel implements Serializable {
    private String Descripcion;
    private int Numero;
    private int NumeroPrim;
    private int NumeroReingre;
    private String Carrera;
    private String Nomcarr;
    private String Depto;
  
    
    public InscripModel(){
        
    }
    
    public InscripModel(String descripcion,int numero){
       
       this.Descripcion=descripcion;
       this.Numero=numero;
    }
    
    public InscripModel(String carrera,String nomcarr,String descripcion,String depto,int numero){
        this.Carrera=carrera;
        this.Nomcarr=nomcarr;
        this.Descripcion=descripcion;
        this.Depto=depto;
        this.Numero=numero;
        
        
    }
    
    public InscripModel(String depto,String carrera,String nombre,int numero){
        this.Depto=depto;
        this.Carrera=carrera;
        this.Nomcarr=nombre;
        this.Numero=numero;
        
    }
     public InscripModel(String depto,String carrera,String nombre,int numero,int numeroPrim,int NumeroReingre){
        this.Depto=depto;
        this.Carrera=carrera;
        this.Nomcarr=nombre;
        this.Numero=numero;
        this.NumeroPrim=numeroPrim;
        this.NumeroReingre =NumeroReingre;
        
    }
    
    public InscripModel(String carrera,String nombre,int numero){
        this.Carrera=carrera;
        this.Nomcarr=nombre;
        this.Numero=numero;
        
    }

    

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

    public String getNomcarr() {
        return Nomcarr;
    }

    public void setNomcarr(String Nomcarr) {
        this.Nomcarr = Nomcarr;
    }

    public String getDepto() {
        return Depto;
    }

    public void setDepto(String Depto) {
        this.Depto = Depto;
    }

    public int getNumeroPrim() {
        return NumeroPrim;
    }

    public void setNumeroPrim(int NumeroPrim) {
        this.NumeroPrim = NumeroPrim;
    }

    public int getNumeroReingre() {
        return NumeroReingre;
    }

    public void setNumeroReingre(int NumeroReingre) {
        this.NumeroReingre = NumeroReingre;
    }

   
    
}


