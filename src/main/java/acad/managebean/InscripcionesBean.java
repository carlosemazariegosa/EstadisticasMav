/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acad.managebean;

import wrapper.InscripModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import session.AcadInscripFacadeLocal;

/**
 *
 * @author mmarvin
 */
@Named(value = "inscripcionesBean")
@RequestScoped

public class InscripcionesBean implements Serializable {

    private CartesianChartModel categoryModel;
    private String semesAno;
    private int minimo;
    private int maximo;
    private Date Fecha;
    private String SemesAno1;
    private String SemesAno2;
    private String SemesAno3;
    private List<Object[]> InscripTipoCC1;
    private List<Object[]> InscripTipoCC2;
    private List<Object[]> InscripTipoCC3;
    private List<Object[]> InscripTipoCen1;
    private List<Object[]> InscripTipoCen2;
    private List<Object[]> InscripTipoCen3;
    private List<InscripModel> listInscripCc1;
    private List<InscripModel> listInscripCen1;
    private List<InscripModel> listInscripCc2;
    private List<InscripModel> listInscripCen2;
    private List<InscripModel> listInscripCc3;
    private List<InscripModel> listInscripCen3;
    private String grafica;
    private String barras;
    private String barras2;
    private String lineas;

    private int var1Cc;
    private int var2Cc;
    private int var3Cc;
    private int var1Cent;
    private int var2Cent;
    private int var3Cent;
    @EJB
    private AcadInscripFacadeLocal acadInscrip;

    public InscripcionesBean() {
        createCategoryModel();
    }

    public CartesianChartModel getCategoryModel() {
        return categoryModel;
    }

    @PostConstruct
    public void Init() {
        if (Fecha == null) {
            Fecha = acadInscrip.FechaActual();
        }
    }
    
    

    public void onProcesaData() {
        Date Fecha2;
        Date Fecha3;
        if (Fecha == null) {
            Fecha = acadInscrip.FechaActual();
            Fecha2 = Fecha;
            Fecha3 = Fecha;
        }
        //Resta un año a la fecha2
        Calendar myCal2 = new GregorianCalendar();
        myCal2.setTime(Fecha);
        myCal2.add(Calendar.YEAR, - 1);
        Fecha2 = new java.sql.Date(myCal2.getTimeInMillis());

        //Resta dos año a la fecha2
        Calendar myCal3 = new GregorianCalendar();
        myCal3.setTime(Fecha);
        myCal3.add(Calendar.YEAR,-2);
        Fecha3 = new java.sql.Date(myCal3.getTimeInMillis());
        

        String Semes = semesAno.substring(0, 1);
        String Anio = semesAno.substring(1, 5);
        int numAnio1 = Integer.parseInt(Anio.trim());
        int numAnio2 = Integer.parseInt(Anio.trim()) - 1;
        int numAnio3 = Integer.parseInt(Anio.trim()) - 2;
        SemesAno1 = Semes + String.valueOf(numAnio1);
        SemesAno2 = Semes + String.valueOf(numAnio2);
        SemesAno3 = Semes + String.valueOf(numAnio3);
        //Tipo1
        listInscripCc1 = new ArrayList<InscripModel>();
        listInscripCen1 = new ArrayList<InscripModel>();
        InscripTipoCC1 = acadInscrip.InscripcionesTipoCC(SemesAno1, Fecha);
        for (Object[] result : InscripTipoCC1) {
            listInscripCc1.add(new InscripModel((String) result[0], (int) result[1]));
            var1Cc = var1Cc + (int) result[1];
        }

        InscripTipoCen1 = acadInscrip.InscripcionesTipoCentros(SemesAno1, Fecha);
        for (Object[] result : InscripTipoCen1) {
            listInscripCen1.add(new InscripModel((String) result[0], (int) result[1]));
            var1Cent = var1Cent + (int) result[1];
        }
        //Tipo2
        listInscripCc2 = new ArrayList<InscripModel>();
        listInscripCen2 = new ArrayList<InscripModel>();
        InscripTipoCC2 = acadInscrip.InscripcionesTipoCC(SemesAno2, Fecha2);
        for (Object[] result : InscripTipoCC2) {
            listInscripCc2.add(new InscripModel((String) result[0], (int) result[1]));
            var2Cc = var2Cc + (int) result[1];
        }

        InscripTipoCen2 = acadInscrip.InscripcionesTipoCentros(SemesAno2, Fecha2);
        for (Object[] result : InscripTipoCen2) {
            listInscripCen2.add(new InscripModel((String) result[0], (int) result[1]));
            var2Cent = var2Cent + (int) result[1];
        }
        //Tipo3
        listInscripCc3 = new ArrayList<InscripModel>();
        listInscripCen3 = new ArrayList<InscripModel>();
        InscripTipoCC3 = acadInscrip.InscripcionesTipoCC(SemesAno3, Fecha3);
        for (Object[] result : InscripTipoCC3) {
            listInscripCc3.add(new InscripModel((String) result[0], (int) result[1]));
            var3Cc = var3Cc + (int) result[1];
        }

        InscripTipoCen3 = acadInscrip.InscripcionesTipoCentros(SemesAno3, Fecha3);
        for (Object[] result : InscripTipoCen3) {
            listInscripCen3.add(new InscripModel((String) result[0], (int) result[1]));
            var3Cent = var3Cent + (int) result[1];
        }

        categoryModel = new CartesianChartModel();
        setMinimo(0);
        setMaximo(70000);

        ChartSeries CampusC = new ChartSeries();
        CampusC.setLabel("Campus Central");
        CampusC.set(SemesAno3, var3Cc);
        CampusC.set(SemesAno2, var2Cc);
        CampusC.set(SemesAno1, var1Cc);

        ChartSeries CentrosD = new ChartSeries();
        CentrosD.setLabel("Centros Departamentales");
        CentrosD.set(SemesAno3, var3Cent);
        CentrosD.set(SemesAno2, var2Cent);
        CentrosD.set(SemesAno1, var1Cent);
        categoryModel.addSeries(CampusC);
        categoryModel.addSeries(CentrosD);

        if (grafica.equals("barras")) {
            barras = "true";
            lineas = "false";
            barras2 = "false";
        }
        if (grafica.equals("lineas")) {
            lineas = "true";
            barras = "false";
            barras2 = "false";
        }
        if (grafica.equals("barras2")) {
            barras2 = "true";
            barras = "false";
            lineas = "false";
        }

    }

    private void createCategoryModel() {
        categoryModel = new CartesianChartModel();
        setMinimo(0);
        setMaximo(70000);

        ChartSeries CampusC = new ChartSeries();
        CampusC.setLabel("Campus Central");
        CampusC.set("", 0);
        CampusC.set("", 0);
        CampusC.set("", 0);

        ChartSeries CentrosD = new ChartSeries();
        CentrosD.setLabel("Centros Departamentales");
        CentrosD.set("", 0);
        CentrosD.set("", 0);
        CentrosD.set("", 0);
        categoryModel.addSeries(CampusC);
        categoryModel.addSeries(CentrosD);

    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public String getSemesAno() {
        return semesAno;
    }

    public void setSemesAno(String semesAno) {
        this.semesAno = semesAno;
    }

    public AcadInscripFacadeLocal getAcadInscrip() {
        return acadInscrip;
    }

    public void setAcadInscrip(AcadInscripFacadeLocal acadInscrip) {
        this.acadInscrip = acadInscrip;
    }

    public String getSemesAno1() {
        return SemesAno1;
    }

    public void setSemesAno1(String SemesAno1) {
        this.SemesAno1 = SemesAno1;
    }

    public String getSemesAno2() {
        return SemesAno2;
    }

    public void setSemesAno2(String SemesAno2) {
        this.SemesAno2 = SemesAno2;
    }

    public String getSemesAno3() {
        return SemesAno3;
    }

    public void setSemesAno3(String SemesAno3) {
        this.SemesAno3 = SemesAno3;
    }

    public List<Object[]> getInscripTipoCC1() {
        return InscripTipoCC1;
    }

    public void setInscripTipoCC1(List<Object[]> InscripTipoCC1) {
        this.InscripTipoCC1 = InscripTipoCC1;
    }

    public List<Object[]> getInscripTipoCC2() {
        return InscripTipoCC2;
    }

    public void setInscripTipoCC2(List<Object[]> InscripTipoCC2) {
        this.InscripTipoCC2 = InscripTipoCC2;
    }

    public List<Object[]> getInscripTipoCC3() {
        return InscripTipoCC3;
    }

    public void setInscripTipoCC3(List<Object[]> InscripTipoCC3) {
        this.InscripTipoCC3 = InscripTipoCC3;
    }

    public List<Object[]> getInscripTipoCen1() {
        return InscripTipoCen1;
    }

    public void setInscripTipoCen1(List<Object[]> InscripTipoCen1) {
        this.InscripTipoCen1 = InscripTipoCen1;
    }

    public List<Object[]> getInscripTipoCen2() {
        return InscripTipoCen2;
    }

    public void setInscripTipoCen2(List<Object[]> InscripTipoCen2) {
        this.InscripTipoCen2 = InscripTipoCen2;
    }

    public List<Object[]> getInscripTipoCen3() {
        return InscripTipoCen3;
    }

    public void setInscripTipoCen3(List<Object[]> InscripTipoCen3) {
        this.InscripTipoCen3 = InscripTipoCen3;
    }

    public List<InscripModel> getListInscripCc1() {
        return listInscripCc1;
    }

    public void setListInscripCc1(List<InscripModel> listInscripCc1) {
        this.listInscripCc1 = listInscripCc1;
    }

    public List<InscripModel> getListInscripCen1() {
        return listInscripCen1;
    }

    public void setListInscripCen1(List<InscripModel> listInscripCen1) {
        this.listInscripCen1 = listInscripCen1;
    }

    public List<InscripModel> getListInscripCc2() {
        return listInscripCc2;
    }

    public void setListInscripCc2(List<InscripModel> listInscripCc2) {
        this.listInscripCc2 = listInscripCc2;
    }

    public List<InscripModel> getListInscripCen2() {
        return listInscripCen2;
    }

    public void setListInscripCen2(List<InscripModel> listInscripCen2) {
        this.listInscripCen2 = listInscripCen2;
    }

    public List<InscripModel> getListInscripCc3() {
        return listInscripCc3;
    }

    public void setListInscripCc3(List<InscripModel> listInscripCc3) {
        this.listInscripCc3 = listInscripCc3;
    }

    public List<InscripModel> getListInscripCen3() {
        return listInscripCen3;
    }

    public void setListInscripCen3(List<InscripModel> listInscripCen3) {
        this.listInscripCen3 = listInscripCen3;
    }

    public String getGrafica() {
        return grafica;
    }

    public void setGrafica(String grafica) {
        this.grafica = grafica;
    }

    public String getBarras() {
        return barras;
    }

    public void setBarras(String barras) {
        this.barras = barras;
    }

    public String getLineas() {
        return lineas;
    }

    public void setLineas(String lineas) {
        this.lineas = lineas;
    }

    public String getBarras2() {
        return barras2;
    }

    public void setBarras2(String barras2) {
        this.barras2 = barras2;
    }

    public int getVar1Cc() {
        return var1Cc;
    }

    public void setVar1Cc(int var1Cc) {
        this.var1Cc = var1Cc;
    }

    public int getVar2Cc() {
        return var2Cc;
    }

    public void setVar2Cc(int var2Cc) {
        this.var2Cc = var2Cc;
    }

    public int getVar3Cc() {
        return var3Cc;
    }

    public void setVar3Cc(int var3Cc) {
        this.var3Cc = var3Cc;
    }

    public int getVar1Cent() {
        return var1Cent;
    }

    public void setVar1Cent(int var1Cent) {
        this.var1Cent = var1Cent;
    }

    public int getVar2Cent() {
        return var2Cent;
    }

    public void setVar2Cent(int var2Cent) {
        this.var2Cent = var2Cent;
    }

    public int getVar3Cent() {
        return var3Cent;
    }

    public void setVar3Cent(int var3Cent) {
        this.var3Cent = var3Cent;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

}

