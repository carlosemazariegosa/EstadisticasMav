/*
 * To change this template, choose Tools | Templates
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
@Table(name = "SIS_USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SisUsuarios.findAll", query = "SELECT s FROM SisUsuarios s"),
    @NamedQuery(name = "SisUsuarios.findById", query = "SELECT s FROM SisUsuarios s WHERE s.id = :id"),
    @NamedQuery(name = "SisUsuarios.findByGrupo", query = "SELECT s FROM SisUsuarios s WHERE s.grupo = :grupo"),
    @NamedQuery(name = "SisUsuarios.findByUsuario", query = "SELECT s FROM SisUsuarios s WHERE s.usuario = :usuario"),
    @NamedQuery(name = "SisUsuarios.findByNombre", query = "SELECT s FROM SisUsuarios s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SisUsuarios.findByApellido", query = "SELECT s FROM SisUsuarios s WHERE s.apellido = :apellido"),
    @NamedQuery(name = "SisUsuarios.findByPuesto", query = "SELECT s FROM SisUsuarios s WHERE s.puesto = :puesto"),
    @NamedQuery(name = "SisUsuarios.findBySucursal", query = "SELECT s FROM SisUsuarios s WHERE s.sucursal = :sucursal"),
    @NamedQuery(name = "SisUsuarios.findByClave", query = "SELECT s FROM SisUsuarios s WHERE s.clave = :clave"),
    @NamedQuery(name = "SisUsuarios.findByCambiar", query = "SELECT s FROM SisUsuarios s WHERE s.cambiar = :cambiar"),
    @NamedQuery(name = "SisUsuarios.findByNextlogon", query = "SELECT s FROM SisUsuarios s WHERE s.nextlogon = :nextlogon"),
    @NamedQuery(name = "SisUsuarios.findByVence", query = "SELECT s FROM SisUsuarios s WHERE s.vence = :vence"),
    @NamedQuery(name = "SisUsuarios.findByFechavence", query = "SELECT s FROM SisUsuarios s WHERE s.fechavence = :fechavence"),
    @NamedQuery(name = "SisUsuarios.findByDiaslleva", query = "SELECT s FROM SisUsuarios s WHERE s.diaslleva = :diaslleva"),
    @NamedQuery(name = "SisUsuarios.findByNotas", query = "SELECT s FROM SisUsuarios s WHERE s.notas = :notas"),
    @NamedQuery(name = "SisUsuarios.findByBitacora", query = "SELECT s FROM SisUsuarios s WHERE s.bitacora = :bitacora"),
    @NamedQuery(name = "SisUsuarios.findBySupervisor", query = "SELECT s FROM SisUsuarios s WHERE s.supervisor = :supervisor"),
    @NamedQuery(name = "SisUsuarios.findByPolitica", query = "SELECT s FROM SisUsuarios s WHERE s.politica = :politica"),
    @NamedQuery(name = "SisUsuarios.findByStatusProp", query = "SELECT s FROM SisUsuarios s WHERE s.statusProp = :statusProp"),
    @NamedQuery(name = "SisUsuarios.findByPropPagotes", query = "SELECT s FROM SisUsuarios s WHERE s.propPagotes = :propPagotes"),
    @NamedQuery(name = "SisUsuarios.findByLvalidapensum", query = "SELECT s FROM SisUsuarios s WHERE s.lvalidapensum = :lvalidapensum"),
    @NamedQuery(name = "SisUsuarios.findByHabilitado", query = "SELECT s FROM SisUsuarios s WHERE s.habilitado = :habilitado"),
    @NamedQuery(name = "SisUsuarios.findByCorreo", query = "SELECT s FROM SisUsuarios s WHERE s.correo = :correo"),
    @NamedQuery(name = "SisUsuarios.findByIngreLogin", query = "SELECT s FROM SisUsuarios s WHERE s.ingreLogin = :ingreLogin"),
    @NamedQuery(name = "SisUsuarios.findByFechasys", query = "SELECT s FROM SisUsuarios s WHERE s.fechasys = :fechasys")})
public class SisUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "GRUPO")
    private Integer grupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USUARIO")
    private String usuario;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PUESTO")
    private int puesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUCURSAL")
    private int sucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CLAVE")
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAMBIAR")
    private char cambiar;
    @Column(name = "NEXTLOGON")
    private Character nextlogon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VENCE")
    private char vence;
    @Column(name = "FECHAVENCE")
    @Temporal(TemporalType.DATE)
    private Date fechavence;
    @Column(name = "DIASLLEVA")
    private Short diaslleva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOTAS")
    private char notas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BITACORA")
    private char bitacora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUPERVISOR")
    private char supervisor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POLITICA")
    private int politica;
    @Column(name = "STATUS_PROP")
    private Short statusProp;
    @Column(name = "PROP_PAGOTES")
    private Character propPagotes;
    @Column(name = "LVALIDAPENSUM")
    private Character lvalidapensum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HABILITADO")
    private char habilitado;
    @Size(max = 80)
    @Column(name = "CORREO")
    private String correo;
    @Size(max = 20)
    @Column(name = "INGRE_LOGIN")
    private String ingreLogin;
    @Column(name = "FECHASYS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasys;
    
    @OneToMany(mappedBy = "usuario",fetch=FetchType.LAZY)
    private Collection<SisAccesos> SisAccesosCollection;

    public Collection<SisAccesos> getSisAccesosCollection() {
        return SisAccesosCollection;
    }

    public void setSisAccesosCollection(Collection<SisAccesos> SisAccesosCollection) {
        this.SisAccesosCollection = SisAccesosCollection;
    }
    
    

    public SisUsuarios() {
    }

    public SisUsuarios(Integer id) {
        this.id = id;
    }

    public SisUsuarios(Integer id, String usuario, int puesto, int sucursal, String clave, char cambiar, char vence, char notas, char bitacora, char supervisor, int politica, char habilitado) {
        this.id = id;
        this.usuario = usuario;
        this.puesto = puesto;
        this.sucursal = sucursal;
        this.clave = clave;
        this.cambiar = cambiar;
        this.vence = vence;
        this.notas = notas;
        this.bitacora = bitacora;
        this.supervisor = supervisor;
        this.politica = politica;
        this.habilitado = habilitado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrupo() {
        return grupo;
    }

    public void setGrupo(Integer grupo) {
        this.grupo = grupo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public char getCambiar() {
        return cambiar;
    }

    public void setCambiar(char cambiar) {
        this.cambiar = cambiar;
    }

    public Character getNextlogon() {
        return nextlogon;
    }

    public void setNextlogon(Character nextlogon) {
        this.nextlogon = nextlogon;
    }

    public char getVence() {
        return vence;
    }

    public void setVence(char vence) {
        this.vence = vence;
    }

    public Date getFechavence() {
        return fechavence;
    }

    public void setFechavence(Date fechavence) {
        this.fechavence = fechavence;
    }

    public Short getDiaslleva() {
        return diaslleva;
    }

    public void setDiaslleva(Short diaslleva) {
        this.diaslleva = diaslleva;
    }

    public char getNotas() {
        return notas;
    }

    public void setNotas(char notas) {
        this.notas = notas;
    }

    public char getBitacora() {
        return bitacora;
    }

    public void setBitacora(char bitacora) {
        this.bitacora = bitacora;
    }

    public char getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(char supervisor) {
        this.supervisor = supervisor;
    }

    public int getPolitica() {
        return politica;
    }

    public void setPolitica(int politica) {
        this.politica = politica;
    }

    public Short getStatusProp() {
        return statusProp;
    }

    public void setStatusProp(Short statusProp) {
        this.statusProp = statusProp;
    }

    public Character getPropPagotes() {
        return propPagotes;
    }

    public void setPropPagotes(Character propPagotes) {
        this.propPagotes = propPagotes;
    }

    public Character getLvalidapensum() {
        return lvalidapensum;
    }

    public void setLvalidapensum(Character lvalidapensum) {
        this.lvalidapensum = lvalidapensum;
    }

    public char getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(char habilitado) {
        this.habilitado = habilitado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIngreLogin() {
        return ingreLogin;
    }

    public void setIngreLogin(String ingreLogin) {
        this.ingreLogin = ingreLogin;
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
        if (!(object instanceof SisUsuarios)) {
            return false;
        }
        SisUsuarios other = (SisUsuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acad.entity.SisUsuarios[ id=" + id + " ]";
    }
    
}
