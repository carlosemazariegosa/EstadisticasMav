/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acad.managebean;

import entity.AcadAlumnos;
import entity.AcadCarreras;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.PrinterName;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePrintServiceExporterConfiguration;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import session.AcadAlumnosFacadeLocal;
import session.AcadCarrerasFacadeLocal;
import session.AcadEstctaFacadeLocal;
import wrapper.EstctaModel;

/**
 *
 * @author mmarvin
 */
@Named
@javax.faces.view.ViewScoped
public class EstctaBean implements Serializable {

    @EJB
    private AcadEstctaFacadeLocal sisEstcta;
    @EJB
    private AcadAlumnosFacadeLocal datAlumnos;
    @EJB
    private AcadCarrerasFacadeLocal datCarreras;
    private List<EstctaModel> listEstcta;
    private List<Object[]> resultEstcta;
    private String facultad;
    private String anio;
    private String carnet;
    private String nombre;
    private String apellido;
    private String nomcarrera;
    private EstctaModel selectedEstcta;
    private List<AcadAlumnos> ListAlumnos;
    private List<AcadCarreras> ListCarreras;
    private List<EstctaModel> filteredEstcta;
    JasperPrint jasperprint;

    public EstctaBean() {
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

    public void onRestEstcta() {
        // Client client = ClientBuilder.newClient().register(EstctaModel.class);
        Client client = ClientBuilder.newClient().register(new Authenticator("usuario1", "usuario1"));
        List<EstctaModel> ListEstcta = client.target("http://localhost:8080/Rest3/webresources/entities.acadestcta/EstadoCuenta")
                .queryParam("Facultad", facultad)
                .queryParam("Anio", anio)
                .queryParam("Carnet", carnet)
                .request(MediaType.APPLICATION_JSON).get(new GenericType<List<EstctaModel>>() {
                });
        listEstcta = new ArrayList<EstctaModel>();
        for (EstctaModel val : ListEstcta) {
            listEstcta.add(new EstctaModel(val.getCodmov(), val.getFecha(), val.getTipomov(),
                    val.getAbreviatura(), val.getPoliza(), val.getSemesano(), val.getCargos(),
                    val.getAbonos(), val.getSaldo(), val.getMes(), val.getDocumento()));

        }
    }

    public void onRestDatSecurity() {
        Client client = ClientBuilder.newClient().register(new Authenticator("usuario1", "usuario1"));
        String xbase = client.target("http://localhost:8080/Rest3/webresources/entities.acadalumnos/factorial")
                .queryParam("base", 10)
                .request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(xbase);
    }

    public void onEstcta() {
        listEstcta = new ArrayList<EstctaModel>();
        resultEstcta = sisEstcta.AcadEstcta(facultad, anio, carnet);
        for (Object[] result : resultEstcta) {
            listEstcta.add(new EstctaModel((String) result[2], (Date) result[1], (String) result[3],
                    (String) result[4], (String) result[5], (String) result[6], (BigDecimal) result[7],
                    (BigDecimal) result[8], (BigDecimal) result[9], (int) result[10], (int) result[11]));
        }

    }

    public void onDatAlum() {
        ListAlumnos = datAlumnos.DatAlumnos(facultad, anio, carnet);
        if (ListAlumnos.size() > 0) {
            for (AcadAlumnos val : ListAlumnos) {
                setNombre(val.getNombre());
                setApellido(val.getApellido());
            }

        } else {
            setNombre("");
            setApellido("");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Alumno No Existe");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void onNomCarrera() {
        ListCarreras = datCarreras.BuscaCarrera(facultad);
        for (AcadCarreras val : ListCarreras) {
            setNomcarrera(val.getNombre());

        }
    }

    public void init() throws JRException {
        JRBeanCollectionDataSource beancollectionDataSource = new JRBeanCollectionDataSource(ListAlumnos);
        String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/report.jasper");
        jasperprint = JasperFillManager.fillReport(reportPath, new HashMap(), beancollectionDataSource);
    }

    public void onPDF() throws JRException, IOException {
        init();
        HttpServletResponse httServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httServletResponse.addHeader("Content-disposition", "attachment; filename=report.pdf");
        ServletOutputStream servletOutputStream = httServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperprint, servletOutputStream);
        FacesContext.getCurrentInstance().getResponseComplete();

    }

    public StreamedContent onImprime(String Tipo) throws JRException, IOException {
        String aplicacion = "";
        String nomArchivo = "";
        if (Tipo.equals("PDF")) {
            aplicacion = "application/pdf";
            nomArchivo = "archivo.pdf";
        }
        if (Tipo.equals("DOCX")) {
            aplicacion = "application/docx";
            nomArchivo = "archivo.docx";
        }
        if (Tipo.equals("XLSX")) {
            aplicacion = "application/xlsx";
            nomArchivo = "archivo.xlsx";
        }
        InputStream inputStream = null;
        ByteArrayOutputStream Teste = new ByteArrayOutputStream();

        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listEstcta);
        InputStream jasperReport = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/reports/estcta.jasper");
        JasperPrint print = JasperFillManager.fillReport(jasperReport, new HashMap(), beanCollectionDataSource);
        if (Tipo.equals("PDF")) {
            JRPdfExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();

            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, Teste);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.exportReport();
        }
        if (Tipo.equals("DOCX")) {
            JRDocxExporter exporter = new JRDocxExporter();
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, Teste);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.exportReport();
        }
        if (Tipo.equals("XLSX")) {
            JRXlsxExporter exporter = new JRXlsxExporter();
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, Teste);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.exportReport();
        }
        inputStream = new ByteArrayInputStream(Teste.toByteArray());
        StreamedContent file = new DefaultStreamedContent(inputStream, aplicacion, nomArchivo);
        return file;
    }

    public void onImprimeXXX() throws IOException, JRException {

        JRBeanCollectionDataSource beancollectionDataSource = new JRBeanCollectionDataSource(listEstcta);
        InputStream jasperReport = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/reports/estcta.jasper");
        JasperPrint print = JasperFillManager.fillReport(jasperReport, new HashMap(), beancollectionDataSource);
        File pdf = File.createTempFile("output.", ".pdf");
        JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
    }

    public List<EstctaModel> getEstctaModel() {
        return listEstcta;
    }

    public EstctaModel getSelectedEstcta() {
        return selectedEstcta;
    }

    public void setSelectedEstcta(EstctaModel selectedEstcta) {
        this.selectedEstcta = selectedEstcta;
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

    public String getNomcarrera() {
        return nomcarrera;
    }

    public void setNomcarrera(String nomcarrera) {
        this.nomcarrera = nomcarrera;
    }

    public List<EstctaModel> getFilteredEstcta() {
        return filteredEstcta;
    }

    public void setFilteredEstcta(List<EstctaModel> filteredEstcta) {
        this.filteredEstcta = filteredEstcta;
    }

    public List<EstctaModel> getListEstcta() {
        return listEstcta;
    }

    public void setListEstcta(List<EstctaModel> listEstcta) {
        this.listEstcta = listEstcta;
    }

}
