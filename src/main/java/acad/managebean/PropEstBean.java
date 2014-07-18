/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acad.managebean;

import wrapper.PropEstModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import session.PntcPropuestaFacadeLocal;

/**
 *
 * @author mmarvin
 */
@Named(value = "propEstBean")
@javax.faces.view.ViewScoped
public class PropEstBean implements Serializable {

    private String Semes;
    private String Anio;
    private List<PropEstModel> ListPropuestaEst;
    @EJB
    private PntcPropuestaFacadeLocal Propuesta;

    public PropEstBean() {
    }

    public void onProcesadata() {
        ListPropuestaEst = new ArrayList<PropEstModel>();
        List<Object[]> PropuestaEst = Propuesta.PropuestaEstadistica(Semes + Anio);
        for (Object[] result : PropuestaEst) {
            ListPropuestaEst.add(new PropEstModel((int) result[0], (int) result[1], (String) result[2], (int) result[3]));

        }
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

    public List<PropEstModel> getListPropuestaEst() {
        return ListPropuestaEst;
    }

    public void setListPropuestaEst(List<PropEstModel> ListPropuestaEst) {
        this.ListPropuestaEst = ListPropuestaEst;
    }

}
