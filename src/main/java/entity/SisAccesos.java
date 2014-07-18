/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SIS_ACCESOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SisAccesos.findAll", query = "SELECT s FROM SisAccesos s"),
    @NamedQuery(name = "SisAccesos.findById", query = "SELECT s FROM SisAccesos s WHERE s.id = :id"),
    @NamedQuery(name = "SisAccesos.findByUsuario", query = "SELECT s FROM SisAccesos s WHERE s.usuario = :usuario"),
    @NamedQuery(name = "SisAccesos.findByEmpresa", query = "SELECT s FROM SisAccesos s WHERE s.empresa = :empresa"),
    @NamedQuery(name = "SisAccesos.findByModulo", query = "SELECT s FROM SisAccesos s WHERE s.modulo = :modulo"),
    @NamedQuery(name = "SisAccesos.findByPrograma", query = "SELECT s FROM SisAccesos s WHERE s.programa = :programa"),
    @NamedQuery(name = "SisAccesos.findByAcceso", query = "SELECT s FROM SisAccesos s WHERE s.acceso = :acceso"),
    @NamedQuery(name = "SisAccesos.findByAgregar", query = "SELECT s FROM SisAccesos s WHERE s.agregar = :agregar"),
    @NamedQuery(name = "SisAccesos.findByEditar", query = "SELECT s FROM SisAccesos s WHERE s.editar = :editar"),
    @NamedQuery(name = "SisAccesos.findByEliminar", query = "SELECT s FROM SisAccesos s WHERE s.eliminar = :eliminar"),
    @NamedQuery(name = "SisAccesos.findByNivel", query = "SELECT s FROM SisAccesos s WHERE s.nivel = :nivel"),
    @NamedQuery(name = "SisAccesos.findByIngreLogin", query = "SELECT s FROM SisAccesos s WHERE s.ingreLogin = :ingreLogin"),
    @NamedQuery(name = "SisAccesos.findByFechasys", query = "SELECT s FROM SisAccesos s WHERE s.fechasys = :fechasys")})
public class SisAccesos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "EMPRESA")
    private Integer empresa;
    @Column(name = "MODULO")
    private Integer modulo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCESO")
    private char acceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AGREGAR")
    private char agregar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EDITAR")
    private char editar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ELIMINAR")
    private char eliminar;
    @Size(max = 9)
    @Column(name = "NIVEL")
    private String nivel;
    @Size(max = 20)
    @Column(name = "INGRE_LOGIN")
    private String ingreLogin;
    @Column(name = "FECHASYS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasys;
    
    @JoinColumn(name = "USUARIO", referencedColumnName = "ID")
    @ManyToOne
    private SisUsuarios usuario;
    
    @JoinColumn(name = "PROGRAMA", referencedColumnName = "ID")
    @ManyToOne
    private SisProgramas programa;

    public SisProgramas getPrograma() {
        return programa;
    }

    public void setPrograma(SisProgramas programa) {
        this.programa = programa;
    }
    
    

    public SisUsuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(SisUsuarios usuario) {
        this.usuario = usuario;
    }

    public SisAccesos() {
    }

    public SisAccesos(Integer id) {
        this.id = id;
    }

    public SisAccesos(Integer id, char acceso, char agregar, char editar, char eliminar) {
        this.id = id;
        this.acceso = acceso;
        this.agregar = agregar;
        this.editar = editar;
        this.eliminar = eliminar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    public Integer getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Integer empresa) {
        this.empresa = empresa;
    }

    public Integer getModulo() {
        return modulo;
    }

    public void setModulo(Integer modulo) {
        this.modulo = modulo;
    }

   

    public char getAcceso() {
        return acceso;
    }

    public void setAcceso(char acceso) {
        this.acceso = acceso;
    }

    public char getAgregar() {
        return agregar;
    }

    public void setAgregar(char agregar) {
        this.agregar = agregar;
    }

    public char getEditar() {
        return editar;
    }

    public void setEditar(char editar) {
        this.editar = editar;
    }

    public char getEliminar() {
        return eliminar;
    }

    public void setEliminar(char eliminar) {
        this.eliminar = eliminar;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
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
        if (!(object instanceof SisAccesos)) {
            return false;
        }
        SisAccesos other = (SisAccesos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acad.entity.SisAccesos[ id=" + id + " ]";
    }
    
}
