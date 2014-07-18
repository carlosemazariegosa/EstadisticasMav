/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acad.managebean;

import wrapper.CursosDetModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import session.AcadCursosDetFacadeLocal;

/**
 *
 * @author mmarvin
 */
@Named(value = "buscaCursosDet")
@javax.faces.view.ViewScoped
public class BuscaCursosDet implements Serializable {

    private List<CursosDetModel> ListCursosDet;
    @EJB
    private AcadCursosDetFacadeLocal cursosDet;

    public BuscaCursosDet() {

    }

    @PostConstruct
    public void Init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        String Semes = fc.getExternalContext().getRequestParameterMap().get("Semes");
        String Codcarr = fc.getExternalContext().getRequestParameterMap().get("Carrera");
        onProcesadata(Semes,Codcarr);
    }

    public void onProcesadata(String Semes,String Codcarr) {
        ListCursosDet = new ArrayList<CursosDetModel>();
        List<Object[]> BuscaCursoVal = cursosDet.BuscaCursoVal(Semes,Codcarr);
        for (Object[] result : BuscaCursoVal) {
            ListCursosDet.add(new CursosDetModel((String) result[0], (String) result[1], (String) result[2], (String) result[3], (String) result[4]));

        }

    }

    public List<CursosDetModel> getListCursosDet() {
        return ListCursosDet;
    }

    public void setListCursosDet(List<CursosDetModel> ListCursosDet) {
        this.ListCursosDet = ListCursosDet;
    }

}
