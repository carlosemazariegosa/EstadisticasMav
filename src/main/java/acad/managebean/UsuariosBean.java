/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acad.managebean;

import acad.classes.md5;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import session.SisUsuariosFacadeLocal;

@SessionScoped
@Named(value = "UsuariosBean")
public class UsuariosBean implements Serializable {

    private  String usuario;
    private String contrasena;
    private boolean logeado = false;
    private static List<Object[]> SisAccesos;
    private String page;
    private static String titulo;
    private MenuModel model;
    @EJB
    private SisUsuariosFacadeLocal sisusuarios;

    public UsuariosBean() {

    }

    public void buscaLogin() {

        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;

        logeado = sisusuarios.SisUsuariosLogin(usuario, contrasena);
      
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid Al Sistema Acad", usuario);
        if (logeado) {

            logeado = true;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);

        } else {
            logeado = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Usuario o Contrasenia Son Incorrectas");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("estaLogeado", logeado);
        if (logeado) {
            CreaMenu();
            context.addCallbackParam("view", "http://localhost:8080/MavEstadisticas/estadisticas/index.xhtml");
            setEstaLogueado(true);

        }

    }

    //Metodo que Elimina la Sesion
    public void logout() throws IOException {
        logeado = false;
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        ec.redirect(ec.getRequestContextPath() + "/estadisticas/");

    }

    //Metodo que Crea el Menu Dinamico
    public void CreaMenu() {

        model = new DefaultMenuModel();
        DefaultSubMenu SubmenuMante = new DefaultSubMenu("Mantenimientos");
        SisAccesos = sisusuarios.SisAccesos(usuario);
        if (SisAccesos.size() > 0 || SisAccesos != null) {
            for (Object[] result : SisAccesos) {
                if (result[2].toString().matches("M")) {
                    DefaultMenuItem item1 = new DefaultMenuItem(result[0]);
                    String nomprog = result[1] + ".xhtml";
                    String titulo = (String) result[0];
                    if (!Compara("/estadisticas/" + nomprog)) {
                        nomprog = "Construccion.xhtml";
                    }
                    item1.setUrl("/estadisticas/" + nomprog);
                    SubmenuMante.addElement(item1);

                }
            }
            model.addElement(SubmenuMante);

            DefaultSubMenu SubmenuConsul = new DefaultSubMenu("Consultas");
            for (Object[] result : SisAccesos) {
                if (result[2].toString().matches("C")) {
                    DefaultMenuItem item2 = new DefaultMenuItem(result[0]);
                    String nomprog = result[1] + ".xhtml";
                    String titulo = (String) result[0];
                    if (!Compara("/estadisticas/" + nomprog)) {
                        nomprog = "Construccion.xhtml";
                    }
                    item2.setUrl("/estadisticas/" + nomprog);
                    SubmenuConsul.addElement(item2);

                }
            }
            model.addElement(SubmenuConsul);

            DefaultSubMenu SubmenuReport = new DefaultSubMenu("Reportes");
            for (Object[] result : SisAccesos) {
                if (result[2].toString().matches("R")) {
                    DefaultMenuItem item3 = new DefaultMenuItem(result[0]);
                    String nomprog = result[1] + ".xhtml";
                    String titulo = (String) result[0];

                    String Valprint = "";
                    if (nomprog.equals("imp_dir_tal.xhtml")) {
                        String param = md5.encriptaEnMD5(usuario.trim().toUpperCase());
                        Valprint = "/impresion/" + nomprog + "?Param1=" + param;
                      
                    } else {
                        Valprint = "/estadisticas/" + nomprog;
                    }
                    if (!Compara(Valprint)) {
                        nomprog = "Construccion.xhtml";
                    }
                    item3.setUrl(Valprint);
                    SubmenuReport.addElement(item3);

                }
            }
            model.addElement(SubmenuReport);

            DefaultSubMenu SubmenuMov = new DefaultSubMenu("Movimientos");
            for (Object[] result : SisAccesos) {
                if (result[2].toString().matches("V")) {
                    DefaultMenuItem item4 = new DefaultMenuItem(result[0]);
                    String nomprog = result[1] + ".xhtml";
                    String titulo = (String) result[0];
                    if (!Compara("/estadisticas/" + nomprog)) {
                        nomprog = "Construccion.xhtml";
                    }
                    item4.setUrl("/estadisticas/" + nomprog);
                    SubmenuMov.addElement(item4);

                }
            }
            model.addElement(SubmenuMov);
        }

    }

    public void Creavar() {
        Map<String, List<String>> paramMap = new HashMap<String, List<String>>();
        List<String> valSetOne = new ArrayList<String>();
        valSetOne.add("mmarvin");
        paramMap.put("Usuario", valSetOne);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Impresion");
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }

    public List<Object[]> getSisAccesos() {
        return SisAccesos;
    }

    public void setSisAccesos(List<Object[]> SisAccesos) {
        this.SisAccesos = SisAccesos;
    }

    public boolean getEstaLogeado() {
        return logeado;
    }

    public void setEstaLogueado(boolean logeado) {
        this.logeado = logeado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario.toUpperCase();
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        if (!Compara(page.trim())) {
            page = "Construccion.xhtml";
        }
        this.page = page;
        CreaMenu();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
      
        String Titulo = "";

        if (titulo.length() > 0 && titulo != null && !titulo.equals("")) {
            if (titulo.indexOf("/") != 0) {

                int pos = titulo.lastIndexOf("/");
                String cad1 = titulo.substring(pos + 1, titulo.length());
                if (cad1.length() > 0) {

                    String cad2 = cad1.substring(0, cad1.indexOf("."));
                    if (SisAccesos != null) {
                        for (Object[] result : SisAccesos) {
                            if (result[1].toString().matches(cad2)) {
                                Titulo = (String) result[0];
                            }
                        }

                    }
                }
            }
        }
       
        this.titulo = Titulo;
    }

    public List<String> getXhtmls() {
        return getResources("/", ".xhtml");
    }

    //Trae en un list Las paginas Existentes
    protected List<String> getResources(String path, String suffix) {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        Set<String> resources = context.getResourcePaths(path);
        List<String> filteredResources = new ArrayList<String>();
        for (String resource : resources) {
            if (resource.endsWith(suffix)) {
                filteredResources.add(resource);
            } else if (resource.endsWith("/")) {
                filteredResources.addAll(getResources(resource, suffix));
            }
        }
        return filteredResources;
    }

    //Compara si la pagina Existe
    public boolean Compara(String page) {
        List<String> xhtmls = getXhtmls();
        return xhtmls.contains(page);
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

}
