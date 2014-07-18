/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acad.managebean;


import wrapper.CursosDetModel;
import wrapper.CuralumModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import session.AcadCuralumFacadeLocal;
import session.AcadCursosDetFacadeLocal;

/**
 *
 * @author mmarvin
 */
@Named(value = "inscripMntAlumnos")
@javax.faces.view.ViewScoped
public class InscripMntAlumnos implements Serializable {

    private String semes;
    private String anio;
    private String facultad;
    private String anioCar;
    private String carnet;
    private String codCarrera;
    private String codcur;
    private String seccion;
    private String nomCur;
    private String muestraForm;
    private List<CuralumModel> ListCuralum;
    @EJB
    private AcadCuralumFacadeLocal acadCuralum;
    @EJB
    private AcadCursosDetFacadeLocal acadCursosDet;

    public InscripMntAlumnos() {
        muestraForm = "false";
    }

    public void onProcesadata() {

        ListCuralum = new ArrayList<CuralumModel>();
        List<Object[]> InscripcionesAlumnos = acadCuralum.InscripcionesAlumnos(semes + anio, facultad, anioCar, carnet);
        for (Object[] result : InscripcionesAlumnos) {
            ListCuralum.add(new CuralumModel((String) result[0], (String) result[1], (String) result[2], (String) result[3], semes + anio));

        }
        muestraForm = "true";

    }

    public void onNomcurso() {
        boolean existe = false;
        List<Object[]> BuscaCurso = acadCursosDet.BuscaCurso(semes + anio, codCarrera, codcur, seccion);
        for (CuralumModel val : ListCuralum) {
            if (val.getSemesAno().trim().equals(semes + anio) && val.getCodcarr().trim().equals(codCarrera.trim()) && val.getCodcur().trim().equals(codcur.trim()) && val.getSeccion().trim().toUpperCase().equals(seccion.trim().toUpperCase())) {
                existe = true;
            }
        }
        if (!existe) {
            if (BuscaCurso.size() > 0) {
                for (Object[] result : BuscaCurso) {
                    setNomCur((String) result[1]);
                }
                boolean InsertCursos = acadCuralum.InsertCursos(semes + anio, facultad, anioCar, carnet, codCarrera, codcur, seccion);
                RequestContext context = RequestContext.getCurrentInstance();
                context.addCallbackParam("Actualizado", InsertCursos);
                context.addCallbackParam("view", "mnt_inscripciones.xhtml");
                setSemes(semes);
                setAnio(anio);
                setFacultad(facultad);
                setAnioCar(anioCar);
                setCarnet(carnet);
                onProcesadata();
                setCodCarrera("");
                setCodcur("");
                setSeccion("");
                setNomCur("");

            } else {
                setNomCur("Curso No Existe");
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Curso No Existe.");
                RequestContext.getCurrentInstance().showMessageInDialog(message);
                setCodCarrera("");
                setCodcur("");
                setSeccion("");
                setNomCur("");
            }
        } else {
            setNomCur("Curso ya Existe en el Detalle");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Curso Ya Existe en el Detalle.");
            RequestContext.getCurrentInstance().showMessageInDialog(message);
            setCodCarrera("");
            setCodcur("");
            setSeccion("");
            setNomCur("");
        }
    }

    public void onBuscaCurso() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("draggable", true);
        options.put("resizable", false);
        options.put("contentHeight", 320);
        Map<String, List<String>> paramMap = new HashMap<String, List<String>>();
        List<String> valSetOne = new ArrayList<String>();
        valSetOne.add(semes + anio);
        paramMap.put("Semes", valSetOne);
        List<String> valSetOne2 = new ArrayList<String>();
        valSetOne2.add(facultad);
        paramMap.put("Carrera", valSetOne2);

        RequestContext.getCurrentInstance().openDialog("buscaCursosDet", options, paramMap);

    }

    public void onCarChosen(SelectEvent event) {
        CursosDetModel curdet = (CursosDetModel) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso Seleccionado", "Curso:" + curdet.getCodcarr() + curdet.getCodcur() + curdet.getSeccion());
        FacesContext.getCurrentInstance().addMessage(null, message);
        setCodCarrera(curdet.getCodcarr());
        setCodcur(curdet.getCodcur());
        setSeccion(curdet.getSeccion());
        onNomcurso();
       
    }

    public String getSemes() {
        return semes;
    }

    public void setSemes(String semes) {
        this.semes = semes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getAnioCar() {
        return anioCar;
    }

    public void setAnioCar(String anioCar) {
        this.anioCar = anioCar;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public List<CuralumModel> getListCuralum() {
        return ListCuralum;
    }

    public void setListCuralum(List<CuralumModel> ListCuralum) {
        this.ListCuralum = ListCuralum;
    }

    public String getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(String codCarrera) {
        this.codCarrera = codCarrera;
    }

    public String getCodcur() {
        return codcur;
    }

    public void setCodcur(String codcur) {
        this.codcur = codcur;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getNomCur() {
        return nomCur;
    }

    public void setNomCur(String nomCur) {
        this.nomCur = nomCur;
    }

    public AcadCuralumFacadeLocal getAcadCuralum() {
        return acadCuralum;
    }

    public void setAcadCuralum(AcadCuralumFacadeLocal acadCuralum) {
        this.acadCuralum = acadCuralum;
    }

    public String getMuestraForm() {
        return muestraForm;
    }

    public void setMuestraForm(String muestraForm) {
        this.muestraForm = muestraForm;
    }

    public void selectCarFromDialog(CursosDetModel curDet) {
        RequestContext.getCurrentInstance().closeDialog(curDet);
    }

}
