package acad.managebean;

import entity.AcadAlumnos;
import entity.AcadCarreras;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.context.RequestContext;
import session.AcadAlumnosFacadeLocal;
import session.AcadCarrerasFacadeLocal;

@Named
@javax.faces.view.ViewScoped
public class DatAlumBean implements Serializable {

    @EJB
    private AcadAlumnosFacadeLocal datAlumnos;
    @EJB
    private AcadCarrerasFacadeLocal datCarreras;
    private List<AcadAlumnos> ListAlumnos;
    private String nombre;
    private String apellido;
    private String direccionRes;
    private String direccionOf;
    private String telRes;
    private String telOf;
    private String telCel;
    private Date fecIngre;
    private Date fecNac;
    private String facultad;
    private String anio;
    private String Carnet;
    private String nomcarrera;
    private List<AcadCarreras> ListCarreras;
    private int id;
    private String ContextPath;

    //variables impresion
    static char normal = (char) 18;
    final String xcompr = Character.toString((char) 15);
    final char pica = (char) 18;
    final char elite = (char) 27 + ':';
    final char pag51 = (char) 27 + 'C' + (char) 51;
    final char pag66 = (char) 27 + 'C' + (char) 66;
    final char pag14 = (char) 27 + 'C' + (char) 14;
    final char pag33 = (char) 27 + 'C' + (char) 33;
    final char pag22 = (char) 27 + 'C' + (char) 22;
    final char pag44 = (char) 27 + 'C' + (char) 44;
    final String xbold = Character.toString((char) 27) + "E";
    final String xnobold = Character.toString((char) 27) + "F";
    final String xspacer = Character.toString((char) 32);
    final char octavos = (char) 27 + '0';
    final char sextos = (char) 27 + '2';
    final char cpi15 = (char) 27 + (char) 103;
    final String xcpi12 = Character.toString((char) 27) + Character.toString((char) 77) + Character.toString((char) 15);
    final String xcpi10 = Character.toString((char) 27) + Character.toString((char) 80);
    final String x14 = Character.toString((char) 14);
    final String x15 = Character.toString((char) 15);
    final String x18 = Character.toString((char) 18);
    //--------------------//

    public DatAlumBean() {

    }

    @PostConstruct
    public void Init() {
        UsuariosBean user = new UsuariosBean();
        user.setTitulo("");
        FacesContext fc = FacesContext.getCurrentInstance();
        String Usuario = fc.getExternalContext().getRequestParameterMap().get("Param1");

        if (user.getUsuario() == null || Usuario == null) {
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            try {

                response.sendRedirect("http://localhost:8080/EstadisticasUmg-war/estadisticas/Login.xhtml");
            } catch (IOException ex) {

            }
        }
    }

    public void onDatAlum() {
        UsuariosBean user = new UsuariosBean();
        user.setTitulo("/imp_dir_tal.xhtml");
        ListAlumnos = datAlumnos.DatAlumnos(facultad, anio, Carnet);

        if (ListAlumnos.size() > 0) {
            for (AcadAlumnos val : ListAlumnos) {
                setNombre(val.getNombre());
                setApellido(val.getApellido());
                setDireccionRes(val.getDireccionRes());
                setDireccionOf(val.getDireccionOf());
                setTelOf(val.getTelefonoOf());
                setTelRes(val.getTelefonoRes());
                setTelCel(val.getTelefonoCel());
                setFecIngre(val.getFechaIngreso());
                setFecNac(val.getFechaNacimiento());
                setId(val.getId());
            }
        } else {
            setNombre("");
            setApellido("");
            setDireccionRes("");
            setDireccionOf("");
            setTelOf("");
            setTelRes("");
            setTelCel("");
            setId(0);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Alumno No Existe");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void onDir() {
        String contextPath = FacesContext.getCurrentInstance().getExternalContext().getContextName();
        System.out.println(contextPath);
        String xcarnet = "0900-00-70";
        String nomcarr = "Ingenieria en Sistemas";
        String jornada = "Matutina";
        String ciclo = "01";
        int numcarnet = xcarnet.length();
        String espcarnet = Repetir(xspacer, 20 - numcarnet);
        Double total = 550.00;
        String apellido_cas = "";
        String semes = "1";
        String direccion = "septima Av. 3-90";
        String telefono_res = "24111899";
        String fecha_inscrip = "29/01/2011";
        String Nombre = "Efrain Eliseo";
        String Apellido = "Canastuj canu";
        String email = "ecanastuj@umg.edu.gt";
        String clave_email = "123456";

        //genera la cadena para el dire
        String cadena1 = xcpi12 + xcompr + "\n" + xcompr + "\n" + xspacer + x14 + "DATOS DEL ALUMNO" + xcompr + " " + "INSCRIPCION" + x18 + xcompr + "       Fecha  Impresion: " + "fechasys" + "\n"
                + xbold + "Carnet    :" + xspacer + xnobold + xcarnet + espcarnet + xbold + "Carrera : " + xnobold + nomcarr + "\n"
                + xspacer + xbold + "Nombre    :" + xspacer + xnobold + Nombre + xbold + "Jornada  : " + xnobold + jornada + " \n"
                + xspacer + xbold + "Apellidos :" + xspacer + xnobold + Apellido + xbold + "Ciclo    : " + xnobold + ciclo + Repetir(xspacer, 32) + xbold + x14 + "MENSUAL   Q+" + xnobold + total + x15 + "\n"
                + xspacer + xbold + "Ape+casada:" + xspacer + xnobold + apellido_cas + xbold + "Semestre : " + xnobold + semes + "o+ \n"
                + xspacer + xbold + "Dire+ Casa:" + xspacer + xnobold + direccion + xbold + "Tel: " + xnobold + telefono_res + xbold + "               Fecha Asig: " + xnobold + fecha_inscrip + " \n"
                + xspacer + "---------------------------------------------------------------- D E T A L L E--------------------------------------------------------------------------- \n"
                + xspacer + xbold + "Fac+  Cod+  Nombre del Curso                         Horario                                                       Aula       Sec" + xnobold + "\n"
                + xspacer + "--------------------------------------------------------------------------------------------------------------------------------------------------------- \n"
                + xspacer;
        String cadenaOk = xspacer + "CORREO ELECTRÓNICO:" + email + " Password :" + clave_email + "\n"
                + xspacer + "OBSERVACION: Cualquier cambio a esta asignación debe realizarla con el DIRE III durante el período de reasignacion. \n"
                + xspacer + "INSTRUCCIONES: 1) Lea detenidamente este documento y revise que los cursos asignados estén de acuerdo con la copia del DIRE I-A.  2) Si esta de acuerdo con el \n"
                + xspacer + "contenido, firme este documento, pues usted el unico responsable de su asignación. 3.)Deje la copias  del DIRE I-BC que corresponde  al Centro Universitario, \n"
                + xspacer + "y conserve su original para cualquier tr mite. SI EXISTEN ERRORES DE OPERACION:   Indique con lapicero rojo lo que debe aparecer en el DIRE I-B  para que sea \n"
                + xspacer + "rectificado y entreguelo en la oficina del Centro Universitario. SI DESEA CAMBIOS DE ASIGNACION: A).Solicite en la oficina del Centro Universitario un DIRE III \n"
                + xspacer + "de reasignación y llenelo. B.)Pague el costo del tramite (Q. 100.00) en la agencia del Banco. C) Entregue el DIRE I-BC anterior y una copia  del DIRE III con \n"
                + xspacer + "su boleta de pago, en la Oficina del Centro Universitario. D)Espere recibir su DIRE I-BC ya corregido. E) SI USTED. Recibe sus cursos en otra sección que no \n"
                + xspacer + "sea la descrita en este documento, no se le podran ingresar sus notas. \n"
                + xspacer + xbold + "EL COSTO DE REPOSICION DE ESTE DOCUMENTO ES DE Q.10.00 EN SU OFICINA REGIONAL " + xbold + "\n"
                + xspacer + "                                                                                            Firma Alumno: _____________________________"
                + ""
                + x18 + xcpi10;
        RequestContext context = RequestContext.getCurrentInstance();
        context.addCallbackParam("view", cadena1 + cadenaOk);
    }

    public void onTal() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.addCallbackParam("view", "esta es una prueba");
        String contextPath = FacesContext.getCurrentInstance().getExternalContext().getContextName();
    }

    public String Repetir(String Caracter, int num) {
        String Cadena = "";
        for (int i = 0; i < num; i++) {
            Cadena = Cadena + Caracter;
        }

        return Cadena;
    }

    public AcadAlumnosFacadeLocal getDatAlumnos() {
        return datAlumnos;
    }

    public void setDatAlumnos(AcadAlumnosFacadeLocal datAlumnos) {
        this.datAlumnos = datAlumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<AcadAlumnos> getListAlumnos() {
        return ListAlumnos;
    }

    public void setListAlumnos(List<AcadAlumnos> ListAlumnos) {
        this.ListAlumnos = ListAlumnos;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccionRes() {
        return direccionRes;
    }

    public void setDireccionRes(String direccionRes) {
        this.direccionRes = direccionRes;
    }

    public String getDireccionOf() {
        return direccionOf;
    }

    public void setDireccionOf(String direccionOf) {
        this.direccionOf = direccionOf;
    }

    public String getTelRes() {
        return telRes;
    }

    public void setTelRes(String telRes) {
        this.telRes = telRes;
    }

    public String getTelOf() {
        return telOf;
    }

    public void setTelOf(String telOf) {
        this.telOf = telOf;
    }

    public String getTelCel() {
        return telCel;
    }

    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }

    public Date getFecIngre() {
        return fecIngre;
    }

    public void setFecIngre(Date fecIngre) {
        this.fecIngre = fecIngre;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
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
        return Carnet;
    }

    public void setCarnet(String Carnet) {
        this.Carnet = Carnet;
    }

    public void onNomCarrera() {
        ListCarreras = datCarreras.BuscaCarrera(facultad);
        for (AcadCarreras val : ListCarreras) {
            setNomcarrera(val.getNombre());

        }
    }

    public String getNomcarrera() {
        return nomcarrera;
    }

    public void setNomcarrera(String nomcarrera) {
        this.nomcarrera = nomcarrera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContextPath() {
        return ContextPath;
    }

    public void setContextPath(String ContextPath) {
        this.ContextPath = ContextPath;
    }

}
