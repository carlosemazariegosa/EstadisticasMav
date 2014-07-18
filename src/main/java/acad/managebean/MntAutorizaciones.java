/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acad.managebean;

import entity.AcadAlumnos;
import entity.AcadAutorizaciones;
import entity.AcadTipoAutorizacion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import session.AcadAlumnosFacadeLocal;
import session.AcadAutorizacionesFacadeLocal;
import session.AcadTipoAutorizacionFacadeLocal;
import wrapper.AutorizacionesModel;
import wrapper.TipoAutorizacionesModel;

@Named
@javax.faces.view.ViewScoped
public class MntAutorizaciones implements Serializable {

    private String semesAno;
    private String facultad;
    private String anio;
    private String carnet;
    private Date fechaIni;
    private Date fechaFin;
    private int idTipoAut;
    private String nombre;
    private String apellido;
    private String muestraBoton;
    @EJB
    private AcadAutorizacionesFacadeLocal Autorizaciones;
    @EJB
    private AcadTipoAutorizacionFacadeLocal TipoAut;
    @EJB
    private AcadAlumnosFacadeLocal DatAlumnos;
    private List<AutorizacionesModel> listAutorizacion;
    private List<TipoAutorizacionesModel> listTipoAut;
    private List<AcadAlumnos> ListAlumnos;

    public MntAutorizaciones() {

    }

    @PostConstruct
    public void Init() {
        listTipoAut = new ArrayList<TipoAutorizacionesModel>();
        List<AcadTipoAutorizacion> BuscaTipoAutorizacion = TipoAut.BuscaTipoAutorizacion();
        for (AcadTipoAutorizacion result : BuscaTipoAutorizacion) {
            listTipoAut.add(new TipoAutorizacionesModel(result.getId(), result.getNombre()));
        }
        muestraBoton = "false";
    }

    public void onBuscadat() {
        List<AcadAutorizaciones> BuscaAutorizaciones = Autorizaciones.BuscaAutorizaciones(semesAno, facultad, anio, carnet);
        if (BuscaAutorizaciones.size() > 0) {
            listAutorizacion = new ArrayList<AutorizacionesModel>();
            for (int i = 0; i < BuscaAutorizaciones.size(); i++) {
                AcadAutorizaciones Autorizacion = (AcadAutorizaciones) BuscaAutorizaciones.get(i);
                AcadTipoAutorizacion tipo = Autorizacion.getIdTipoAutorizacion();
                listAutorizacion.add(new AutorizacionesModel(Autorizacion.getId(), tipo.getNombre(), Autorizacion.getFechaInicio(), Autorizacion.getFechaFinal()));
            }
        } else {
            if (listAutorizacion != null ) {
                listAutorizacion.clear();
            }
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "No Existen Exepciones");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void onInsert() {
        boolean InsertAutorizacion = Autorizaciones.InsertAutorizacion(idTipoAut, semesAno, facultad, anio, carnet, fechaIni, fechaFin);
        RequestContext context = RequestContext.getCurrentInstance();
        context.addCallbackParam("Actualizado", InsertAutorizacion);
        context.addCallbackParam("view", "mnt_autorizaciones.xhtml");
        setSemesAno(semesAno);
        setFacultad(facultad);
        setAnio(anio);
        setCarnet(carnet);
        onBuscadat();
    }

    public void onDatAlum() {
        ListAlumnos = DatAlumnos.DatAlumnos(facultad, anio, carnet);
        if (ListAlumnos.size() > 0) {
            for (AcadAlumnos val : ListAlumnos) {
                setNombre(val.getNombre());
                setApellido(val.getApellido());
            }
            muestraBoton = "true";
            onBuscadat();

        } else {
            muestraBoton = "false";
            if (listAutorizacion != null || listAutorizacion.size() > 0) {
                listAutorizacion.clear();
            }
            setNombre("");
            setApellido("");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Alumno No Existe");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public String getSemesAno() {
        return semesAno;
    }

    public void setSemesAno(String semesAno) {
        this.semesAno = semesAno;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public List<AutorizacionesModel> getListAutorizacion() {
        return listAutorizacion;
    }

    public void setListAutorizacion(List<AutorizacionesModel> listAutorizacion) {
        this.listAutorizacion = listAutorizacion;
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

    public int getIdTipoAut() {
        return idTipoAut;
    }

    public void setIdTipoAut(int idTipoAut) {
        this.idTipoAut = idTipoAut;
    }

    public List<TipoAutorizacionesModel> getListTipoAut() {
        return listTipoAut;
    }

    public void setListTipoAut(List<TipoAutorizacionesModel> listTipoAut) {
        this.listTipoAut = listTipoAut;
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

    public String getMuestraBoton() {
        return muestraBoton;
    }

    public void setMuestraBoton(String muestraBoton) {
        this.muestraBoton = muestraBoton;
    }

}
