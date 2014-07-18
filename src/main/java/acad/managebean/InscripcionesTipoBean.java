
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
@Named(value = "inscripcionesTipoBean")
@javax.faces.view.ViewScoped
public class InscripcionesTipoBean implements Serializable {

    private String Semes;
    private String Anio;
    private Date Fecha;
    private String Ubicacion;
    private String Tipo;
    private String Titulo;
    private String Tabla;
    private String SubTabla;
    private String SubTablaCen;
    private int Total;
    private int SubTotal;
    private List<InscripModel> ListInscripCampusCenGen;
    private List<InscripModel> ListInscripCenGen;
    private List<InscripModel> ListModel;
    private List<InscripModel> ListDiplo;
    private List<Object[]> InsAgrup;
    @EJB
    private AcadInscripFacadeLocal acadInscrip;

    public InscripcionesTipoBean() {

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

        if (Tipo.trim().equals("General")) {
            Tabla = "true";
            SubTabla = "false";
            SubTablaCen="false";
            Total = 0;
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
            String fecha = sdf.format(Fecha);
            Titulo = "Inscripciones Generales por carrera de campus central hasta el " + fecha + " del " + Semes + Anio;
            ListInscripCampusCenGen = new ArrayList<InscripModel>();
            List<Object[]> InscripCampusCenGen = acadInscrip.InscripCampusCenGen(Semes + Anio, Fecha);
            for (Object[] result : InscripCampusCenGen) {
                ListInscripCampusCenGen.add(new InscripModel((String) result[0], (String) result[1], (String) result[2], (String) result[3], (int) result[4]));
                Total = Total + (int) result[4];
            }
        }
        if (Tipo.trim().equals("Tipo")) {
            Tabla = "false";
            SubTabla = "true";
            SubTablaCen="false";
            Total = 0;
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
            String fecha = sdf.format(Fecha);
            Titulo = "Inscripciones por Tipo campus central hasta el " + fecha + " del " + Semes + Anio;
            ListInscripCampusCenGen = new ArrayList<InscripModel>();
            List<Object[]> InscripCampusCenGen = acadInscrip.InscripCampusCenGen(Semes + Anio, Fecha);
            for (Object[] result : InscripCampusCenGen) {
                ListInscripCampusCenGen.add(new InscripModel((String) result[0], (String) result[1], (String) result[2], (String) result[3], (int) result[4]));
                Total = Total + (int) result[4];

            }
            InsAgrup = acadInscrip.InscripcionesTipoCC(Semes + Anio, Fecha);

        }
        if (Tipo.trim().equals("Centro")) {
            Tabla = "false";
            SubTabla = "false";
            SubTablaCen="true";
            Total = 0;
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
            String fecha = sdf.format(Fecha);
            Titulo = "Inscripciones por Departamento al " + fecha + " del " + Semes + Anio;
            ListInscripCampusCenGen = new ArrayList<InscripModel>();
            List<Object[]> InscripCampusCenGen = acadInscrip.InscripcionesDeptoCC(Semes + Anio, Fecha);
            for (Object[] result : InscripCampusCenGen) {
                ListInscripCampusCenGen.add(new InscripModel((String) result[0], (int) result[1]));
                
                Total = Total + (int) result[1];

            }
           

        }
        return ListInscripCampusCenGen;
    }

    public List<InscripModel> onCentrosDep() {
        if (Tipo.trim().equals("General")) {
            Tabla = "true";
            SubTabla = "false";
            SubTablaCen="false";
            Total = 0;
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
            String fecha = sdf.format(Fecha);
            Titulo = "Inscripciones Generales por carrera de Centros Departamentales hasta el " + fecha + " del " + Semes + Anio;
            ListInscripCenGen = new ArrayList<InscripModel>();
            List<Object[]> InscripCenGen = acadInscrip.InscripCentrosDepGen(Semes + Anio, Fecha);
            for (Object[] result : InscripCenGen) {
                ListInscripCenGen.add(new InscripModel((String) result[0], (String) result[1], (String) result[2], (String) result[3], (int) result[4]));
                Total = Total + (int) result[4];
            }

        }
        if (Tipo.trim().equals("Tipo")) {
            Tabla = "false";
            SubTabla = "true";
            SubTablaCen="false";
            Total = 0;
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
            String fecha = sdf.format(Fecha);
            Titulo = "Inscripciones Por Tipo de Centros Departamentales hasta el " + fecha + " del " + Semes + Anio;
            ListInscripCenGen = new ArrayList<InscripModel>();
            ListDiplo = new ArrayList<InscripModel>();
            List<Object[]> InscripCenGen = acadInscrip.InscripCentrosDepGen(Semes + Anio, Fecha);
            for (Object[] result : InscripCenGen) {
                ListInscripCenGen.add(new InscripModel((String) result[0], (String) result[1], (String) result[2], (String) result[3], (int) result[4]));
                Total = Total + (int) result[4];
            }

            InsAgrup = acadInscrip.InscripcionesTipoCentros(Semes + Anio, Fecha);

        }
        if (Tipo.trim().equals("Centro")) {
            Tabla = "false";
            SubTabla = "false";
            SubTablaCen="true";
            Total = 0;
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
            String fecha = sdf.format(Fecha);
            Titulo = "Inscripciones por Departamento al  " + fecha + " del " + Semes + Anio;
            ListInscripCenGen = new ArrayList<InscripModel>();
            ListDiplo = new ArrayList<InscripModel>();
            List<Object[]> InscripCenGen = acadInscrip.InscripcionesDeptoCentros(Semes + Anio, Fecha);
            for (Object[] result : InscripCenGen) {
                ListInscripCenGen.add(new InscripModel((String) result[0], (int) result[1]));
                 Total = Total + (int) result[1];
            }

        }
        return ListInscripCenGen;
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

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
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

    public String getTabla() {
        return Tabla;
    }

    public void setTabla(String Tabla) {
        this.Tabla = Tabla;
    }

    public String getSubTabla() {
        return SubTabla;
    }

    public void setSubTabla(String SubTabla) {
        this.SubTabla = SubTabla;
    }

    public String getSubTablaCen() {
        return SubTablaCen;
    }

    public void setSubTablaCen(String SubTablaCen) {
        this.SubTablaCen = SubTablaCen;
    }
    

    public List<InscripModel> getListInscripCampusCenGen() {
        return ListInscripCampusCenGen;
    }

    public void setListInscripCampusCenGen(List<InscripModel> ListInscripCampusCenGen) {
        this.ListInscripCampusCenGen = ListInscripCampusCenGen;
    }

    public List<InscripModel> getListModel() {
        return ListModel;
    }

    public void setListModel(List<InscripModel> ListModel) {
        this.ListModel = ListModel;
    }

    public List<InscripModel> getListDiplo() {
        return ListDiplo;
    }

    public void setListDiplo(List<InscripModel> ListDiplo) {
        this.ListDiplo = ListDiplo;
    }

    public int getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(int SubTotal) {
        this.SubTotal = SubTotal;
    }

    public void calculateTotal(Object o) {
        for (Object[] result : InsAgrup) {
            if (result[0].toString().trim().equals(o.toString().trim())) {
                SubTotal = (int) result[1];
            }

        }

    }

}
