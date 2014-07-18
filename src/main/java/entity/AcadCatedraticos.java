/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmarvin
 */
@Entity
@Table(name = "ACAD_CATEDRATICOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcadCatedraticos.findAll", query = "SELECT a FROM AcadCatedraticos a"),
    @NamedQuery(name = "AcadCatedraticos.findById", query = "SELECT a FROM AcadCatedraticos a WHERE a.id = :id"),
    @NamedQuery(name = "AcadCatedraticos.findByCodcat", query = "SELECT a FROM AcadCatedraticos a WHERE a.codcat = :codcat"),
    @NamedQuery(name = "AcadCatedraticos.findByNombre", query = "SELECT a FROM AcadCatedraticos a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "AcadCatedraticos.findByApellido", query = "SELECT a FROM AcadCatedraticos a WHERE a.apellido = :apellido"),
    @NamedQuery(name = "AcadCatedraticos.findByApellidoCas", query = "SELECT a FROM AcadCatedraticos a WHERE a.apellidoCas = :apellidoCas"),
    @NamedQuery(name = "AcadCatedraticos.findByAbrv", query = "SELECT a FROM AcadCatedraticos a WHERE a.abrv = :abrv"),
    @NamedQuery(name = "AcadCatedraticos.findByPin", query = "SELECT a FROM AcadCatedraticos a WHERE a.pin = :pin"),
    @NamedQuery(name = "AcadCatedraticos.findByDireccionRes", query = "SELECT a FROM AcadCatedraticos a WHERE a.direccionRes = :direccionRes"),
    @NamedQuery(name = "AcadCatedraticos.findByTelefonoRes", query = "SELECT a FROM AcadCatedraticos a WHERE a.telefonoRes = :telefonoRes"),
    @NamedQuery(name = "AcadCatedraticos.findByTelefonoCel", query = "SELECT a FROM AcadCatedraticos a WHERE a.telefonoCel = :telefonoCel"),
    @NamedQuery(name = "AcadCatedraticos.findByDireccionOf", query = "SELECT a FROM AcadCatedraticos a WHERE a.direccionOf = :direccionOf"),
    @NamedQuery(name = "AcadCatedraticos.findByTelefonoOf", query = "SELECT a FROM AcadCatedraticos a WHERE a.telefonoOf = :telefonoOf"),
    @NamedQuery(name = "AcadCatedraticos.findByTelefonoE", query = "SELECT a FROM AcadCatedraticos a WHERE a.telefonoE = :telefonoE"),
    @NamedQuery(name = "AcadCatedraticos.findBySexo", query = "SELECT a FROM AcadCatedraticos a WHERE a.sexo = :sexo"),
    @NamedQuery(name = "AcadCatedraticos.findByFechaNacimiento", query = "SELECT a FROM AcadCatedraticos a WHERE a.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "AcadCatedraticos.findByNumOrdenCedula", query = "SELECT a FROM AcadCatedraticos a WHERE a.numOrdenCedula = :numOrdenCedula"),
    @NamedQuery(name = "AcadCatedraticos.findByNumRegCedula", query = "SELECT a FROM AcadCatedraticos a WHERE a.numRegCedula = :numRegCedula"),
    @NamedQuery(name = "AcadCatedraticos.findByDpi", query = "SELECT a FROM AcadCatedraticos a WHERE a.dpi = :dpi"),
    @NamedQuery(name = "AcadCatedraticos.findByCorreoUmg", query = "SELECT a FROM AcadCatedraticos a WHERE a.correoUmg = :correoUmg"),
    @NamedQuery(name = "AcadCatedraticos.findByCorreo", query = "SELECT a FROM AcadCatedraticos a WHERE a.correo = :correo"),
    @NamedQuery(name = "AcadCatedraticos.findByNit", query = "SELECT a FROM AcadCatedraticos a WHERE a.nit = :nit"),
    @NamedQuery(name = "AcadCatedraticos.findByIgss", query = "SELECT a FROM AcadCatedraticos a WHERE a.igss = :igss"),
    @NamedQuery(name = "AcadCatedraticos.findByFechaIngreso", query = "SELECT a FROM AcadCatedraticos a WHERE a.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "AcadCatedraticos.findByNumeroColeg", query = "SELECT a FROM AcadCatedraticos a WHERE a.numeroColeg = :numeroColeg"),
    @NamedQuery(name = "AcadCatedraticos.findByTipoColeg", query = "SELECT a FROM AcadCatedraticos a WHERE a.tipoColeg = :tipoColeg"),
    @NamedQuery(name = "AcadCatedraticos.findByCargaAc", query = "SELECT a FROM AcadCatedraticos a WHERE a.cargaAc = :cargaAc"),
    @NamedQuery(name = "AcadCatedraticos.findByCargaAcAdmin", query = "SELECT a FROM AcadCatedraticos a WHERE a.cargaAcAdmin = :cargaAcAdmin"),
    @NamedQuery(name = "AcadCatedraticos.findByActualiza", query = "SELECT a FROM AcadCatedraticos a WHERE a.actualiza = :actualiza"),
    @NamedQuery(name = "AcadCatedraticos.findByClave", query = "SELECT a FROM AcadCatedraticos a WHERE a.clave = :clave"),
    @NamedQuery(name = "AcadCatedraticos.findByMoodle", query = "SELECT a FROM AcadCatedraticos a WHERE a.moodle = :moodle"),
    @NamedQuery(name = "AcadCatedraticos.findByUsuario", query = "SELECT a FROM AcadCatedraticos a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "AcadCatedraticos.findByFechasys", query = "SELECT a FROM AcadCatedraticos a WHERE a.fechasys = :fechasys"),
    @NamedQuery(name = "AcadCatedraticos.findByNombre1", query = "SELECT a FROM AcadCatedraticos a WHERE a.nombre1 = :nombre1"),
    @NamedQuery(name = "AcadCatedraticos.findByNombre2", query = "SELECT a FROM AcadCatedraticos a WHERE a.nombre2 = :nombre2"),
    @NamedQuery(name = "AcadCatedraticos.findByNombre3", query = "SELECT a FROM AcadCatedraticos a WHERE a.nombre3 = :nombre3"),
    @NamedQuery(name = "AcadCatedraticos.findByApellido1", query = "SELECT a FROM AcadCatedraticos a WHERE a.apellido1 = :apellido1"),
    @NamedQuery(name = "AcadCatedraticos.findByApellido2", query = "SELECT a FROM AcadCatedraticos a WHERE a.apellido2 = :apellido2"),
    @NamedQuery(name = "AcadCatedraticos.findByCalle", query = "SELECT a FROM AcadCatedraticos a WHERE a.calle = :calle"),
    @NamedQuery(name = "AcadCatedraticos.findByNumCasa", query = "SELECT a FROM AcadCatedraticos a WHERE a.numCasa = :numCasa"),
    @NamedQuery(name = "AcadCatedraticos.findByZona", query = "SELECT a FROM AcadCatedraticos a WHERE a.zona = :zona"),
    @NamedQuery(name = "AcadCatedraticos.findByColonia", query = "SELECT a FROM AcadCatedraticos a WHERE a.colonia = :colonia"),
    @NamedQuery(name = "AcadCatedraticos.findByFax", query = "SELECT a FROM AcadCatedraticos a WHERE a.fax = :fax"),
    @NamedQuery(name = "AcadCatedraticos.findByIdSisDepartamentosIgss", query = "SELECT a FROM AcadCatedraticos a WHERE a.idSisDepartamentosIgss = :idSisDepartamentosIgss"),
    @NamedQuery(name = "AcadCatedraticos.findByIdSisMunicipiosIgss", query = "SELECT a FROM AcadCatedraticos a WHERE a.idSisMunicipiosIgss = :idSisMunicipiosIgss"),
    @NamedQuery(name = "AcadCatedraticos.findByPlanilla", query = "SELECT a FROM AcadCatedraticos a WHERE a.planilla = :planilla"),
    @NamedQuery(name = "AcadCatedraticos.findByTitulo", query = "SELECT a FROM AcadCatedraticos a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "AcadCatedraticos.findByExtrangero", query = "SELECT a FROM AcadCatedraticos a WHERE a.extrangero = :extrangero"),
    @NamedQuery(name = "AcadCatedraticos.findByGrado", query = "SELECT a FROM AcadCatedraticos a WHERE a.grado = :grado"),
    @NamedQuery(name = "AcadCatedraticos.findByMoodleMae", query = "SELECT a FROM AcadCatedraticos a WHERE a.moodleMae = :moodleMae"),
    @NamedQuery(name = "AcadCatedraticos.findByPasaporte", query = "SELECT a FROM AcadCatedraticos a WHERE a.pasaporte = :pasaporte")})
public class AcadCatedraticos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 5)
    @Column(name = "CODCAT")
    private String codcat;
    @Size(max = 40)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 40)
    @Column(name = "APELLIDO")
    private String apellido;
    @Size(max = 30)
    @Column(name = "APELLIDO_CAS")
    private String apellidoCas;
    @Size(max = 5)
    @Column(name = "ABRV")
    private String abrv;
    @Size(max = 8)
    @Column(name = "PIN")
    private String pin;
    @Size(max = 150)
    @Column(name = "DIRECCION_RES")
    private String direccionRes;
    @Size(max = 10)
    @Column(name = "TELEFONO_RES")
    private String telefonoRes;
    @Size(max = 10)
    @Column(name = "TELEFONO_CEL")
    private String telefonoCel;
    @Size(max = 50)
    @Column(name = "DIRECCION_OF")
    private String direccionOf;
    @Size(max = 10)
    @Column(name = "TELEFONO_OF")
    private String telefonoOf;
    @Size(max = 10)
    @Column(name = "TELEFONO_E")
    private String telefonoE;
    @Column(name = "SEXO")
    private Character sexo;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 4)
    @Column(name = "NUM_ORDEN_CEDULA")
    private String numOrdenCedula;
    @Size(max = 11)
    @Column(name = "NUM_REG_CEDULA")
    private String numRegCedula;
    @Size(max = 20)
    @Column(name = "DPI")
    private String dpi;
    @Size(max = 80)
    @Column(name = "CORREO_UMG")
    private String correoUmg;
    @Size(max = 80)
    @Column(name = "CORREO")
    private String correo;
    @Size(max = 15)
    @Column(name = "NIT")
    private String nit;
    @Size(max = 15)
    @Column(name = "IGSS")
    private String igss;
    @Column(name = "FECHA_INGRESO")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Size(max = 10)
    @Column(name = "NUMERO_COLEG")
    private String numeroColeg;
    @Size(max = 50)
    @Column(name = "TIPO_COLEG")
    private String tipoColeg;
    @Column(name = "CARGA_AC")
    private Short cargaAc;
    @Column(name = "CARGA_AC_ADMIN")
    private Short cargaAcAdmin;
    @Column(name = "ACTUALIZA")
    private Character actualiza;
    @Column(name = "CLAVE")
    private Integer clave;
    @Column(name = "MOODLE")
    private Character moodle;
    @Size(max = 10)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHASYS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasys;
    @Size(max = 15)
    @Column(name = "NOMBRE1")
    private String nombre1;
    @Size(max = 15)
    @Column(name = "NOMBRE2")
    private String nombre2;
    @Size(max = 15)
    @Column(name = "NOMBRE3")
    private String nombre3;
    @Size(max = 15)
    @Column(name = "APELLIDO1")
    private String apellido1;
    @Size(max = 15)
    @Column(name = "APELLIDO2")
    private String apellido2;
    @Size(max = 25)
    @Column(name = "CALLE")
    private String calle;
    @Size(max = 10)
    @Column(name = "NUM_CASA")
    private String numCasa;
    @Size(max = 2)
    @Column(name = "ZONA")
    private String zona;
    @Size(max = 25)
    @Column(name = "COLONIA")
    private String colonia;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 10)
    @Column(name = "FAX")
    private String fax;
    @Column(name = "ID_SIS_DEPARTAMENTOS_IGSS")
    private Integer idSisDepartamentosIgss;
    @Column(name = "ID_SIS_MUNICIPIOS_IGSS")
    private Integer idSisMunicipiosIgss;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLANILLA")
    private char planilla;
    @Size(max = 50)
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "EXTRANGERO")
    private Character extrangero;
    @Size(max = 50)
    @Column(name = "GRADO")
    private String grado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOODLE_MAE")
    private char moodleMae;
    @Size(max = 25)
    @Column(name = "PASAPORTE")
    private String pasaporte;
    
    @OneToMany(mappedBy = "idAcadCatedraticos",fetch=FetchType.LAZY)
    private Collection<AcadCatedraticosObs> AcadCatedraticosObsCollection;

    public Collection<AcadCatedraticosObs> getAcadCatedraticosObsCollection() {
        return AcadCatedraticosObsCollection;
    }

    public void setAcadCatedraticosObsCollection(Collection<AcadCatedraticosObs> AcadCatedraticosObsCollection) {
        this.AcadCatedraticosObsCollection = AcadCatedraticosObsCollection;
    }
    
    

    public AcadCatedraticos() {
    }

    public AcadCatedraticos(Integer id) {
        this.id = id;
    }

    public AcadCatedraticos(Integer id, char planilla, char moodleMae) {
        this.id = id;
        this.planilla = planilla;
        this.moodleMae = moodleMae;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodcat() {
        return codcat;
    }

    public void setCodcat(String codcat) {
        this.codcat = codcat;
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

    public String getApellidoCas() {
        return apellidoCas;
    }

    public void setApellidoCas(String apellidoCas) {
        this.apellidoCas = apellidoCas;
    }

    public String getAbrv() {
        return abrv;
    }

    public void setAbrv(String abrv) {
        this.abrv = abrv;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getDireccionRes() {
        return direccionRes;
    }

    public void setDireccionRes(String direccionRes) {
        this.direccionRes = direccionRes;
    }

    public String getTelefonoRes() {
        return telefonoRes;
    }

    public void setTelefonoRes(String telefonoRes) {
        this.telefonoRes = telefonoRes;
    }

    public String getTelefonoCel() {
        return telefonoCel;
    }

    public void setTelefonoCel(String telefonoCel) {
        this.telefonoCel = telefonoCel;
    }

    public String getDireccionOf() {
        return direccionOf;
    }

    public void setDireccionOf(String direccionOf) {
        this.direccionOf = direccionOf;
    }

    public String getTelefonoOf() {
        return telefonoOf;
    }

    public void setTelefonoOf(String telefonoOf) {
        this.telefonoOf = telefonoOf;
    }

    public String getTelefonoE() {
        return telefonoE;
    }

    public void setTelefonoE(String telefonoE) {
        this.telefonoE = telefonoE;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumOrdenCedula() {
        return numOrdenCedula;
    }

    public void setNumOrdenCedula(String numOrdenCedula) {
        this.numOrdenCedula = numOrdenCedula;
    }

    public String getNumRegCedula() {
        return numRegCedula;
    }

    public void setNumRegCedula(String numRegCedula) {
        this.numRegCedula = numRegCedula;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getCorreoUmg() {
        return correoUmg;
    }

    public void setCorreoUmg(String correoUmg) {
        this.correoUmg = correoUmg;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getIgss() {
        return igss;
    }

    public void setIgss(String igss) {
        this.igss = igss;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getNumeroColeg() {
        return numeroColeg;
    }

    public void setNumeroColeg(String numeroColeg) {
        this.numeroColeg = numeroColeg;
    }

    public String getTipoColeg() {
        return tipoColeg;
    }

    public void setTipoColeg(String tipoColeg) {
        this.tipoColeg = tipoColeg;
    }

    public Short getCargaAc() {
        return cargaAc;
    }

    public void setCargaAc(Short cargaAc) {
        this.cargaAc = cargaAc;
    }

    public Short getCargaAcAdmin() {
        return cargaAcAdmin;
    }

    public void setCargaAcAdmin(Short cargaAcAdmin) {
        this.cargaAcAdmin = cargaAcAdmin;
    }

    public Character getActualiza() {
        return actualiza;
    }

    public void setActualiza(Character actualiza) {
        this.actualiza = actualiza;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public Character getMoodle() {
        return moodle;
    }

    public void setMoodle(Character moodle) {
        this.moodle = moodle;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFechasys() {
        return fechasys;
    }

    public void setFechasys(Date fechasys) {
        this.fechasys = fechasys;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getNombre3() {
        return nombre3;
    }

    public void setNombre3(String nombre3) {
        this.nombre3 = nombre3;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Integer getIdSisDepartamentosIgss() {
        return idSisDepartamentosIgss;
    }

    public void setIdSisDepartamentosIgss(Integer idSisDepartamentosIgss) {
        this.idSisDepartamentosIgss = idSisDepartamentosIgss;
    }

    public Integer getIdSisMunicipiosIgss() {
        return idSisMunicipiosIgss;
    }

    public void setIdSisMunicipiosIgss(Integer idSisMunicipiosIgss) {
        this.idSisMunicipiosIgss = idSisMunicipiosIgss;
    }

    public char getPlanilla() {
        return planilla;
    }

    public void setPlanilla(char planilla) {
        this.planilla = planilla;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Character getExtrangero() {
        return extrangero;
    }

    public void setExtrangero(Character extrangero) {
        this.extrangero = extrangero;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public char getMoodleMae() {
        return moodleMae;
    }

    public void setMoodleMae(char moodleMae) {
        this.moodleMae = moodleMae;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcadCatedraticos)) {
            return false;
        }
        AcadCatedraticos other = (AcadCatedraticos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AcadCatedraticos[ id=" + id + " ]";
    }
    
}
