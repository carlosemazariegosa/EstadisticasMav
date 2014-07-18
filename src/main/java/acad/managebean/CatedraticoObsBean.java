/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acad.managebean;

import wrapper.CatedraticosModel;
import entity.AcadCatedraticos;
import entity.AcadCatedraticosObs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.inject.Named;
import session.AcadCatedraticosFacadeLocal;

/**
 *
 * @author mmarvin
 */
@Named(value = "catedraticoObsBean")
@javax.faces.view.ViewScoped
public class CatedraticoObsBean implements Serializable {

    private List<CatedraticosModel> ListCatedraticosObs;
    private CatedraticosModel selectedCateObs;
    private List<CatedraticosModel> filteredCateObs;
    @EJB
    AcadCatedraticosFacadeLocal catedraticos;

    public CatedraticoObsBean() {
    }

    public void onProcesadata() {
        
        List<AcadCatedraticos> CatedraticosObs = catedraticos.CatedraticosObs();
        /*for (AcadCatedraticos val : CatedraticosObs) {
            System.out.println(val.getNombre() + " " + val.getCodcat());

            for (AcadCatedraticosObs val2 : val.getAcadCatedraticosObsCollection()) {
                System.out.println(val2.getObservacion() + " " + val.getCodcat());
            }

        }*/
         ListCatedraticosObs = new ArrayList<CatedraticosModel>();
         List<Object[]> CatedraticosObsN = catedraticos.CatedraticosObsN();
         for (Object[] result : CatedraticosObsN) {
         ListCatedraticosObs.add(new CatedraticosModel((String) result[0], (String) result[1], (String) result[2], (String) result[3], (String) result[4], (Date) result[5]));
         }
    }
    

    public List<CatedraticosModel> getListCatedraticosObs() {
        return ListCatedraticosObs;
    }

    public void setListCatedraticosObs(List<CatedraticosModel> ListCatedraticosObs) {
        this.ListCatedraticosObs = ListCatedraticosObs;
    }

    public CatedraticosModel getSelectedCateObs() {
        return selectedCateObs;
    }

    public void setSelectedCateObs(CatedraticosModel selectedCateObs) {
        this.selectedCateObs = selectedCateObs;
    }

    public List<CatedraticosModel> getFilteredCateObs() {
        return filteredCateObs;
    }

    public void setFilteredCateObs(List<CatedraticosModel> filteredCateObs) {
        this.filteredCateObs = filteredCateObs;
    }

}
