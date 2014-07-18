/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "ACAD_ALUMNOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcadAlumnos.findAll", query = "SELECT a FROM AcadAlumnos a"),
    @NamedQuery(name = "AcadAlumnos.findById", query = "SELECT a FROM AcadAlumnos a WHERE a.id = :id"),
    @NamedQuery(name = "AcadAlumnos.findByFacultad", query = "SELECT a FROM AcadAlumnos a WHERE a.facultad = :facultad"),
    @NamedQuery(name = "AcadAlumnos.findByAnio", query = "SELECT a FROM AcadAlumnos a WHERE a.anio = :anio"),
    @NamedQuery(name = "AcadAlumnos.findByCarnet", query = "SELECT a FROM AcadAlumnos a WHERE a.carnet = :carnet"),
    @NamedQuery(name = "AcadAlumnos.findByNombre", query = "SELECT a FROM AcadAlumnos a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "AcadAlumnos.findByApellido", query = "SELECT a FROM AcadAlumnos a WHERE a.apellido = :apellido"),
    @NamedQuery(name = "AcadAlumnos.findByApellidoCas", query = "SELECT a FROM AcadAlumnos a WHERE a.apellidoCas = :apellidoCas"),
    @NamedQuery(name = "AcadAlumnos.findByDireccionRes", query = "SELECT a FROM AcadAlumnos a WHERE a.direccionRes = :direccionRes"),
    @NamedQuery(name = "AcadAlumnos.findByTelefonoRes", query = "SELECT a FROM AcadAlumnos a WHERE a.telefonoRes = :telefonoRes"),
    @NamedQuery(name = "AcadAlumnos.findByTelefonoCel", query = "SELECT a FROM AcadAlumnos a WHERE a.telefonoCel = :telefonoCel"),
    @NamedQuery(name = "AcadAlumnos.findByDireccionOf", query = "SELECT a FROM AcadAlumnos a WHERE a.direccionOf = :direccionOf"),
    @NamedQuery(name = "AcadAlumnos.findByTelefonoOf", query = "SELECT a FROM AcadAlumnos a WHERE a.telefonoOf = :telefonoOf"),
    @NamedQuery(name = "AcadAlumnos.findBySexo", query = "SELECT a FROM AcadAlumnos a WHERE a.sexo = :sexo"),
    @NamedQuery(name = "AcadAlumnos.findByFechaNacimiento", query = "SELECT a FROM AcadAlumnos a WHERE a.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "AcadAlumnos.findByNumOrdenCedula", query = "SELECT a FROM AcadAlumnos a WHERE a.numOrdenCedula = :numOrdenCedula"),
    @NamedQuery(name = "AcadAlumnos.findByNumRegCedula", query = "SELECT a FROM AcadAlumnos a WHERE a.numRegCedula = :numRegCedula"),
    @NamedQuery(name = "AcadAlumnos.findByNumDpi", query = "SELECT a FROM AcadAlumnos a WHERE a.numDpi = :numDpi"),
    @NamedQuery(name = "AcadAlumnos.findByCorreo", query = "SELECT a FROM AcadAlumnos a WHERE a.correo = :correo"),
    @NamedQuery(name = "AcadAlumnos.findByFechaIngreso", query = "SELECT a FROM AcadAlumnos a WHERE a.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "AcadAlumnos.findByCuaderno", query = "SELECT a FROM AcadAlumnos a WHERE a.cuaderno = :cuaderno"),
    @NamedQuery(name = "AcadAlumnos.findByDire", query = "SELECT a FROM AcadAlumnos a WHERE a.dire = :dire"),
    @NamedQuery(name = "AcadAlumnos.findByIdPensum", query = "SELECT a FROM AcadAlumnos a WHERE a.idPensum = :idPensum"),
    @NamedQuery(name = "AcadAlumnos.findByMoodle", query = "SELECT a FROM AcadAlumnos a WHERE a.moodle = :moodle"),
    @NamedQuery(name = "AcadAlumnos.findByMoodleMae", query = "SELECT a FROM AcadAlumnos a WHERE a.moodleMae = :moodleMae"),
    @NamedQuery(name = "AcadAlumnos.findByFicha", query = "SELECT a FROM AcadAlumnos a WHERE a.ficha = :ficha"),
    @NamedQuery(name = "AcadAlumnos.findByUsuario", query = "SELECT a FROM AcadAlumnos a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "AcadAlumnos.findByFechasys", query = "SELECT a FROM AcadAlumnos a WHERE a.fechasys = :fechasys")})
public class AcadAlumnos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 4)
    @Column(name = "FACULTAD")
    private String facultad;
    @Size(max = 2)
    @Column(name = "ANIO")
    private String anio;
    @Size(max = 5)
    @Column(name = "CARNET")
    private String carnet;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 30)
    @Column(name = "APELLIDO")
    private String apellido;
    @Size(max = 15)
    @Column(name = "APELLIDO_CAS")
    private String apellidoCas;
    @Size(max = 50)
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
    @Size(max = 17)
    @Column(name = "TELEFONO_OF")
    private String telefonoOf;
    @Column(name = "SEXO")
    private Character sexo;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 5)
    @Column(name = "NUM_ORDEN_CEDULA")
    private String numOrdenCedula;
    @Size(max = 11)
    @Column(name = "NUM_REG_CEDULA")
    private String numRegCedula;
    @Size(max = 15)
    @Column(name = "NUM_DPI")
    private String numDpi;
    @Size(max = 80)
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "FECHA_INGRESO")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "CUADERNO")
    private Character cuaderno;
    @Column(name = "DIRE")
    private Character dire;
    @Column(name = "ID_PENSUM")
    private Integer idPensum;
    @Column(name = "MOODLE")
    private Character moodle;
    @Column(name = "MOODLE_MAE")
    private Character moodleMae;
    @Column(name = "FICHA")
    private Character ficha;
    @Size(max = 10)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHASYS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasys;

    public AcadAlumnos() {
    }

    public AcadAlumnos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNumDpi() {
        return numDpi;
    }

    public void setNumDpi(String numDpi) {
        this.numDpi = numDpi;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Character getCuaderno() {
        return cuaderno;
    }

    public void setCuaderno(Character cuaderno) {
        this.cuaderno = cuaderno;
    }

    public Character getDire() {
        return dire;
    }

    public void setDire(Character dire) {
        this.dire = dire;
    }

    public Integer getIdPensum() {
        return idPensum;
    }

    public void setIdPensum(Integer idPensum) {
        this.idPensum = idPensum;
    }

    public Character getMoodle() {
        return moodle;
    }

    public void setMoodle(Character moodle) {
        this.moodle = moodle;
    }

    public Character getMoodleMae() {
        return moodleMae;
    }

    public void setMoodleMae(Character moodleMae) {
        this.moodleMae = moodleMae;
    }

    public Character getFicha() {
        return ficha;
    }

    public void setFicha(Character ficha) {
        this.ficha = ficha;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcadAlumnos)) {
            return false;
        }
        AcadAlumnos other = (AcadAlumnos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AcadAlumnos[ id=" + id + " ]";
    }
    
}
