/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrapper;

import java.util.Date;

/**
 *
 * @author mmarvin
 */
public class AutorizacionesModel {

    private int id;
    private String nombre;
    private Date fechaIni;
    private Date fechaFin;

    public AutorizacionesModel() {

    }

    public AutorizacionesModel(int Id, String Nombre, Date FechaIni, Date FechaFin) {
        this.id = Id;
        this.nombre = Nombre;
        this.fechaIni = FechaIni;
        this.fechaFin = FechaFin;

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

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
