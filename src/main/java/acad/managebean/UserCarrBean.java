/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acad.managebean;



import wrapper.UserCarrPropModel;
import entity.AcadCarreras;
import entity.SisUsuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import session.AcadCarrerasFacadeLocal;
import session.SisUsuariosCarrerasFacadeLocal;
import session.SisUsuariosFacadeLocal;
import session.SisUsuariosHorFacFacadeLocal;



/**
 *
 * @author mmarvin
 */
@Named(value = "userCarrBean")
@javax.faces.view.ViewScoped
public class UserCarrBean implements Serializable {

    private String usuario;
    private String facultad;
    private String nomCarrera;
    private int idSisUsuario;
    private String muestraButton;
    private boolean chkProp;
    private boolean chkHor;
    private UserCarrPropModel selectedUserCarrProp;
    private UserCarrHorModel selectedUserCarrHor;
    private List<UserCarrPropModel> ListUserCarrProp;
    private List<UserCarrHorModel> ListUserCarrHor;
    private List<AcadCarreras> ListCarreras;
    @EJB
    SisUsuariosCarrerasFacadeLocal usuariosPropuestas;
    @EJB
    SisUsuariosHorFacFacadeLocal usuariosHorarios;
    @EJB
    private AcadCarrerasFacadeLocal datCarreras;
    @EJB
    private SisUsuariosFacadeLocal sisUsuarios;

    public UserCarrBean() {
        muestraButton = "false";
    }

    public void onBuscaUsuario() {
        boolean BuscaUsuario = sisUsuarios.BuscaUsuario(usuario);
        if (BuscaUsuario) {
            List<SisUsuarios> IdUsuario = sisUsuarios.IdUsuario(usuario);
            for (SisUsuarios val : IdUsuario) {
                setIdSisUsuario(val.getId());
            }

            onUserCarrProp();
            onUserCarrHor();

        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Usuario No Existe");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void onUserCarrProp() {
        ListUserCarrProp = new ArrayList<UserCarrPropModel>();
        List<Object[]> UserCarrProp = usuariosPropuestas.UserCarrProp(usuario);
        for (Object[] result : UserCarrProp) {
            ListUserCarrProp.add(new UserCarrPropModel((int) result[0], (int) result[1], (String) result[2], (String) result[3]));

        }

        muestraButton = "true";

    }

    public void onUserCarrHor() {
        ListUserCarrHor = new ArrayList<UserCarrHorModel>();
        List<Object[]> UserCarrHorarios = usuariosHorarios.UserCarrHorarios(usuario);
        for (Object[] result : UserCarrHorarios) {
            ListUserCarrHor.add(new UserCarrHorModel((int) result[0], (int) result[1], (String) result[2], (String) result[3]));
            setIdSisUsuario((int) result[1]);
        }
        muestraButton = "true";
    }

    public void onNomCarrera() {
        ListCarreras = datCarreras.BuscaCarrera(facultad);
        if (ListCarreras.size() > 0) {
            for (AcadCarreras val : ListCarreras) {
                setNomCarrera(val.getNombre());

            }
        } else {
            setNomCarrera("Carrera No Existe");
        }

    }

    public void onInsertCarrera() {
        if (chkProp) {
            onInsertProp();
        }
        if (chkHor) {
            onInsertHor();
        }
        if (!chkProp && !chkHor) {
            FacesMessage msg;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "No selecciono ninguna Opcion");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        if (!chkProp && chkHor) {
            boolean Actualizado = true;
            RequestContext context = RequestContext.getCurrentInstance();
            context.addCallbackParam("Actualizado", Actualizado);
            context.addCallbackParam("view", "usuarios_carreras.xhtml");
            setUsuario(usuario);
            onUserCarrHor();
            setFacultad("");
            setNomCarrera("");
            setChkProp(false);
            setChkHor(false);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        }

        if (chkProp && !chkHor) {
            boolean Actualizado = true;
            RequestContext context = RequestContext.getCurrentInstance();
            context.addCallbackParam("Actualizado", Actualizado);
            context.addCallbackParam("view", "usuarios_carreras.xhtml");
            setUsuario(usuario);
            onUserCarrProp();
            setFacultad("");
            setNomCarrera("");
            setChkProp(false);
            setChkHor(false);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        if (chkProp && chkHor) {
            boolean Actualizado = true;
            RequestContext context = RequestContext.getCurrentInstance();
            context.addCallbackParam("Actualizado", Actualizado);
            context.addCallbackParam("view", "usuarios_carreras.xhtml");
            setUsuario(usuario);
            onUserCarrHor();
            onUserCarrProp();
            setFacultad("");
            setNomCarrera("");
            setChkProp(false);
            setChkHor(false);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void onInsertProp() {

        boolean existe = false;
        if (ListCarreras.size() > 0) {

            for (UserCarrPropModel val : ListUserCarrProp) {
                if (val.getCodcarr().trim().equals(facultad.trim())) {
                    existe = true;
                }
            }
            if (existe) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Carrera en Usuario Propuesta Ya Existe");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                String InsertUserCarrProp = usuariosPropuestas.InsertUserCarrProp(idSisUsuario, facultad);
                
            }
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Carrera No Existe");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void onInsertHor() {
        boolean existe = false;
        if (ListCarreras.size() > 0) {

            for (UserCarrHorModel val : ListUserCarrHor) {
                if (val.getCodcarr().trim().equals(facultad.trim())) {
                    existe = true;
                }
            }
            if (existe) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Carrera en Usuario Horarios Ya Existe");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                String InsertUserCarrHor = usuariosHorarios.InsertUserCarrHor(idSisUsuario, facultad);

            }
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Carrera No Existe");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<UserCarrPropModel> getListUserCarrProp() {
        return ListUserCarrProp;
    }

    public void setListUserCarrProp(List<UserCarrPropModel> ListUserCarrProp) {
        this.ListUserCarrProp = ListUserCarrProp;
    }

    public List<UserCarrHorModel> getListUserCarrHor() {
        return ListUserCarrHor;
    }

    public void setListUserCarrHor(List<UserCarrHorModel> ListUserCarrHor) {
        this.ListUserCarrHor = ListUserCarrHor;
    }

    public UserCarrPropModel getSelectedUserCarrProp() {
        return selectedUserCarrProp;
    }

    public void setSelectedUserCarrProp(UserCarrPropModel selectedUserCarrProp) {
        this.selectedUserCarrProp = selectedUserCarrProp;
    }

    public UserCarrHorModel getSelectedUserCarrHor() {
        return selectedUserCarrHor;
    }

    public void setSelectedUserCarrHor(UserCarrHorModel selectedUserCarrHor) {
        this.selectedUserCarrHor = selectedUserCarrHor;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getNomCarrera() {
        return nomCarrera;
    }

    public void setNomCarrera(String nomCarrera) {
        this.nomCarrera = nomCarrera;
    }

    public int getIdSisUsuario() {
        return idSisUsuario;
    }

    public void setIdSisUsuario(int idSisUsuario) {
        this.idSisUsuario = idSisUsuario;
    }

    public String getMuestraButton() {
        return muestraButton;
    }

    public void setMuestraButton(String muestraButton) {
        this.muestraButton = muestraButton;
    }

    public boolean isChkProp() {
        return chkProp;
    }

    public void setChkProp(boolean chkProp) {
        this.chkProp = chkProp;
    }

    public boolean isChkHor() {
        return chkHor;
    }

    public void setChkHor(boolean chkHor) {
        this.chkHor = chkHor;
    }

}
