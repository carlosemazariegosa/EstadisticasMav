/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acad.managebean;

import wrapper.InscripModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import session.AcadInscripFacadeLocal;

/**
 *
 * @author mmarvin
 */
@Named(value = "inscripcionesCentrosBean")
@javax.faces.view.ViewScoped
public class InscripcionesCentrosBean implements Serializable {

    private String Semes;
    private String Anio;
    private Date Fecha;
    private String Ubicacion;
    private List<InscripModel> ListInscripCentrosCC;
    private List<InscripModel> ListInscripCentrosDep;
    private List<InscripModel> ListModel;
    private String Titulo;
    private int Total;
    private int SubTotal;
    private int SubTotalPrim;
    private int SubTotalRein;
    private String tablaCC;
    private String tablaCentros;
    private List<Object[]> InsAgrup;
    private List<Object[]> InsAgrupPrim;
    private List<Object[]> InsAgrupRein;
    private List<InscripModel> filteredDepto;
    @EJB
    private AcadInscripFacadeLocal acadInscrip;

    public InscripcionesCentrosBean() {
    }

    @PostConstruct
    public void Init() {
        if (Fecha == null) {
            Fecha = acadInscrip.FechaActual();
        }
        ListModel = new ArrayList<InscripModel>();

    }

    public List<InscripModel> onProcesadata() {
        if (Fecha == null) {
            Fecha = acadInscrip.FechaActual();
        }
        if (Ubicacion.trim().equals("CampusCent")) {
            ListModel = new ArrayList<InscripModel>();
            ListModel = onCampusCentral();
        }
        if (Ubicacion.trim().equals("CentrosDep")) {
            ListModel = new ArrayList<InscripModel>();
            ListModel = onCentrosDep();
        }
        return ListModel;

    }

    public List<InscripModel> onCampusCentral() {
        tablaCC = "true";
        tablaCentros = "false";
        Total = 0;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(Fecha);
        Titulo = "Inscripciones por Centro por Carreras de Campus central hasta el " + fecha + " del " + Semes + Anio;
        ListInscripCentrosCC = new ArrayList<InscripModel>();
        List<Object[]> InscripcionesCentroCC = acadInscrip.InscripcionesCentroCC(Semes + Anio, Fecha);
        String anio = Anio.substring(2, 4);
        List<Object[]> InscripcionesCCPrimIngre = acadInscrip.InscripcionesCCPrimIngre(Semes + Anio, Fecha, anio);
        for (Object[] result : InscripcionesCentroCC) {
            for (Object[] resultPrim : InscripcionesCCPrimIngre) {
                if (result[1].toString().trim().equals(resultPrim[1].toString().trim())) {
                    result[4] = resultPrim[3];
                }
            }

            ListInscripCentrosCC.add(new InscripModel((String) result[0], (String) result[1], (String) result[2], (int) result[3], (int) result[4], ((int) result[3] - (int) result[4])));
            Total = Total + (int) result[3];
        }
        InsAgrup = acadInscrip.InscripcionesDeptoCC(Semes + Anio, Fecha);
        InsAgrupPrim = acadInscrip.InscripcionesCCPrimIngreTotales(Semes + Anio, Fecha, anio);
        InsAgrupRein = acadInscrip.InscripcionesCCReingresoTotales(Semes + Anio, Fecha, anio);
        return ListInscripCentrosCC;
    }

    public List<InscripModel> onCentrosDep() {
        tablaCC = "false";
        tablaCentros = "true";
        Total = 0;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(Fecha);
        Titulo = "Inscripciones por Centro por Carreras de Centros Departamentales hasta el " + fecha + " del " + Semes + Anio;
        ListInscripCentrosDep = new ArrayList<InscripModel>();
        List<Object[]> InscripcionesCentroCentrosDep = acadInscrip.InscripcionesCentroCentrosDep(Semes + Anio, Fecha);
        String anio = Anio.substring(2, 4);

        List<Object[]> InscripcionesCentroCentrosDepPrimIngre = acadInscrip.InscripcionesCentroCentrosDepPrimIngre(Semes + Anio, Fecha, anio);
        for (Object[] result : InscripcionesCentroCentrosDep) {
            for (Object[] resultPrim : InscripcionesCentroCentrosDepPrimIngre) {
                if (result[1].toString().trim().equals(resultPrim[1].toString().trim())) {
                    result[4] = resultPrim[3];
                }

            }
            ListInscripCentrosDep.add(new InscripModel((String) result[0], (String) result[1], (String) result[2], (int) result[3], (int) result[4], ((int) result[3] - (int) result[4])));

            Total = Total + (int) result[3];
        }

        InsAgrup = acadInscrip.InscripcionesDeptoCentros(Semes + Anio, Fecha);
        InsAgrupPrim = acadInscrip.InscripcionesCentroCentrosDepPrimIngreTotales(Semes + Anio, Fecha, anio);
        InsAgrupRein = acadInscrip.InscripcionesCentroCentrosDepReingresoTotales(Semes + Anio, Fecha, anio);
        return ListInscripCentrosDep;

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

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public List<InscripModel> getListInscripCentrosCC() {
        return ListInscripCentrosCC;
    }

    public void setListInscripCentrosCC(List<InscripModel> ListInscripCentrosCC) {
        this.ListInscripCentrosCC = ListInscripCentrosCC;
    }

    public List<InscripModel> getListInscripCentrosDep() {
        return ListInscripCentrosDep;
    }

    public void setListInscripCentrosDep(List<InscripModel> ListInscripCentrosDep) {
        this.ListInscripCentrosDep = ListInscripCentrosDep;
    }

    public List<InscripModel> getListModel() {
        return ListModel;
    }

    public void setListModel(List<InscripModel> ListModel) {
        this.ListModel = ListModel;
    }

    public AcadInscripFacadeLocal getAcadInscrip() {
        return acadInscrip;
    }

    public void setAcadInscrip(AcadInscripFacadeLocal acadInscrip) {
        this.acadInscrip = acadInscrip;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    public int getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(int SubTotal) {
        this.SubTotal = SubTotal;
    }

    public String getTablaCC() {
        return tablaCC;
    }

    public void setTablaCC(String tablaCC) {
        this.tablaCC = tablaCC;
    }

    public String getTablaCentros() {
        return tablaCentros;
    }

    public void setTablaCentros(String tablaCentros) {
        this.tablaCentros = tablaCentros;
    }

    public List<InscripModel> getFilteredDepto() {
        return filteredDepto;
    }

    public void setFilteredDepto(List<InscripModel> filteredDepto) {
        this.filteredDepto = filteredDepto;
    }

    public int getSubTotalPrim() {
        return SubTotalPrim;
    }

    public void setSubTotalPrim(int SubTotalPrim) {
        this.SubTotalPrim = SubTotalPrim;
    }

    public List<Object[]> getInsAgrupPrim() {
        return InsAgrupPrim;
    }

    public void setInsAgrupPrim(List<Object[]> InsAgrupPrim) {
        this.InsAgrupPrim = InsAgrupPrim;
    }

    public List<Object[]> getInsAgrupRein() {
        return InsAgrupRein;
    }

    public void setInsAgrupRein(List<Object[]> InsAgrupRein) {
        this.InsAgrupRein = InsAgrupRein;
    }

    public int getSubTotalRein() {
        return SubTotalRein;
    }

    public void setSubTotalRein(int SubTotalRein) {
        this.SubTotalRein = SubTotalRein;
    }

    public void calculateTotal(Object o) {
        for (Object[] result : InsAgrup) {
            if (result[0].toString().trim().equals(o.toString().trim())) {
                SubTotal = (int) result[1];
                //if()
            }
        }

        for (Object[] result : InsAgrupPrim) {
            if (result[0].toString().trim().equals(o.toString().trim())) {
                SubTotalPrim = (int) result[1];

            }
        }

        for (Object[] result : InsAgrupRein) {
            if (result[0].toString().trim().equals(o.toString().trim())) {
                SubTotalRein = (int) result[1];

            }
        }
    }

}
