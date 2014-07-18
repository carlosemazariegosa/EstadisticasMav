/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acad.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import wrapper.DatAlumModel;
import wrapper.InscripcionesModel;

@Named
@javax.faces.view.ViewScoped
public class MntInscripcionesBean implements Serializable {

    private String semesAno;
    private String facultad;
    private String anio;
    private String carnet;
    private List<InscripcionesModel> listInscripciones;
    private List<InscripcionesModel> filteredIncrip;
    private String nombre;
    private String apellido;
    private String nomCarr;
    private List<InscripcionesModel> selectedInscrip;

    public MntInscripcionesBean() {

    }

    public void onBuscaDat() {
        int num = 0;
        Client clientAlum = ClientBuilder.newClient().register(DatAlumModel.class);
        List<DatAlumModel> ListDatAlum = clientAlum.target("http://localhost:8080/Rest3/webresources/entities.acadalumnos/Alumnos")
                .queryParam("Facultad", facultad)
                .queryParam("Anio", anio)
                .queryParam("Carnet", carnet)
                .request(MediaType.APPLICATION_JSON).get(new GenericType<List<DatAlumModel>>() {
                });
        if (ListDatAlum.size() > 0) {
            for (DatAlumModel valDat : ListDatAlum) {
                nombre = valDat.getNombre();
                apellido = valDat.getApellido();
                nomCarr = valDat.getNomCarr();
            }

            Client client = ClientBuilder.newClient().register(InscripcionesModel.class);
            List<InscripcionesModel> ListInscripciones = client.target("http://localhost:8080/Rest3/webresources/entities.acadcuralum/Inscripciones")
                    .queryParam("SemesAno", semesAno)
                    .queryParam("Facultad", facultad)
                    .queryParam("Anio", anio)
                    .queryParam("Carnet", carnet)
                    .request(MediaType.APPLICATION_JSON).get(new GenericType<List<InscripcionesModel>>() {
                    });

            if (ListInscripciones.size() > 0) {
                Random randomGenerator = new Random();

                listInscripciones = new ArrayList<InscripcionesModel>();
                for (InscripcionesModel val : ListInscripciones) {
                    int randomInt = randomGenerator.nextInt(1000000000);
                    listInscripciones.add(new InscripcionesModel(randomInt, val.getCodcarr(), val.getCodcur(), val.getNombre(),
                            val.getSeccion(), val.getCiclo(), val.getAula()));

                }
            } else {
                facultad = "";
                anio = "";
                carnet = "";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "No existen cursos en este Semestre");
                FacesContext.getCurrentInstance().addMessage(null, message);
                if (listInscripciones != null) {
                    listInscripciones.clear();
                }

            }
        } else {
            facultad = "";
            anio = "";
            carnet = "";
            nombre = "";
            apellido = "";
            nomCarr = "";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Alumno No Existe");
            FacesContext.getCurrentInstance().addMessage(null, message);
            if (listInscripciones != null) {
                listInscripciones.clear();
            }

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

    public List<InscripcionesModel> getListInscripciones() {
        return listInscripciones;
    }

    public void setListInscripciones(List<InscripcionesModel> listInscripciones) {
        this.listInscripciones = listInscripciones;
    }

    public List<InscripcionesModel> getFilteredIncrip() {
        return filteredIncrip;
    }

    public void setFilteredIncrip(List<InscripcionesModel> filteredIncrip) {
        this.filteredIncrip = filteredIncrip;
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

    public String getNomCarr() {
        return nomCarr;
    }

    public void setNomCarr(String nomCarr) {
        this.nomCarr = nomCarr;
    }

    public List<InscripcionesModel> getSelectedInscrip() {
        return selectedInscrip;
    }

    public void setSelectedInscrip(List<InscripcionesModel> selectedInscrip) {
        this.selectedInscrip = selectedInscrip;
    }

}
