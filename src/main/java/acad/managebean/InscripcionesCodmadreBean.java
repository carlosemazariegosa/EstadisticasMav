/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acad.managebean;

import wrapper.InscripModel;
import wrapper.CarrerasModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import session.AcadCarrerasFacadeLocal;
import session.AcadInscripFacadeLocal;

/**
 *
 * @author mmarvin
 */
@Named(value = "inscripcionesCodmadreBean")
@javax.faces.view.ViewScoped
public class InscripcionesCodmadreBean implements Serializable {

    private CarrerasModel selectedCodMadre;
    private List<CarrerasModel> ListCodMadre;
    private String Semes;
    private String Anio;
    private Date Fecha;
    private String codmadre;
    private int Total;
    private List<InscripModel> ListInscripCodmadre;
    @EJB
    AcadCarrerasFacadeLocal carreras;
    @EJB
    AcadInscripFacadeLocal acadInscrip;

    public InscripcionesCodmadreBean() {
    }

    @PostConstruct
    public void Init() {
        if (Fecha == null) {
            Fecha = acadInscrip.FechaActual();
        }

        ListCodMadre = new ArrayList<CarrerasModel>();
        List<Object[]> BuscaCarreraMadre = carreras.BuscaCarreraMadre();
        for (Object[] result : BuscaCarreraMadre) {
            ListCodMadre.add(new CarrerasModel((String) result[0], (String) result[1]));

        }

    }

    public void onProcesadata() {
        Total=0;
        if (Fecha == null) {
            Fecha = acadInscrip.FechaActual();
        }
        ListInscripCodmadre = new ArrayList<InscripModel>();
        List<Object[]> InscripcionesCodMadre = acadInscrip.InscripcionesCodMadre(Semes+Anio, Fecha, codmadre);
        for (Object[] result : InscripcionesCodMadre) {
            ListInscripCodmadre.add(new InscripModel((String) result[0], (String) result[1], (int) result[2]));
           Total = Total + (int) result[2];
        }
    }

    public CarrerasModel getSelectedCodMadre() {
        return selectedCodMadre;
    }

    public void setSelectedCodMadre(CarrerasModel selectedCodMadre) {
        this.selectedCodMadre = selectedCodMadre;
    }

    public List<CarrerasModel> getListCodMadre() {
        return ListCodMadre;
    }

    public void setListCodMadre(List<CarrerasModel> ListCodMadre) {
        this.ListCodMadre = ListCodMadre;
    }

    public String getCodmadre() {
        return codmadre;
    }

    public void setCodmadre(String codmadre) {
        this.codmadre = codmadre;
    }

    public String getSemes() {
        return Semes;
    }

    public void setSemes(String Semes) {
        this.Semes = Semes;
    }

    public String getAnio() {
        return Anio;
    }

    public void setAnio(String Anio) {
        this.Anio = Anio;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public List<InscripModel> getListInscripCodmadre() {
        return ListInscripCodmadre;
    }

    public void setListInscripCodmadre(List<InscripModel> ListInscripCodmadre) {
        this.ListInscripCodmadre = ListInscripCodmadre;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }
    
    

}
