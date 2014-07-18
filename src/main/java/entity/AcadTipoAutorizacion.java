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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mmarvin
 */
@Entity
@Table(name = "ACAD_TIPO_AUTORIZACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcadTipoAutorizacion.findAll", query = "SELECT a FROM AcadTipoAutorizacion a"),
    @NamedQuery(name = "AcadTipoAutorizacion.findById", query = "SELECT a FROM AcadTipoAutorizacion a WHERE a.id = :id"),
    @NamedQuery(name = "AcadTipoAutorizacion.findByNombre", query = "SELECT a FROM AcadTipoAutorizacion a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "AcadTipoAutorizacion.findByUsuario", query = "SELECT a FROM AcadTipoAutorizacion a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "AcadTipoAutorizacion.findByFechasys", query = "SELECT a FROM AcadTipoAutorizacion a WHERE a.fechasys = :fechasys")})
public class AcadTipoAutorizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 10)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHASYS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasys;
    @OneToMany(mappedBy = "idTipoAutorizacion")
    private Collection<AcadAutorizaciones> acadAutorizacionesCollection;

    public AcadTipoAutorizacion() {
    }

    public AcadTipoAutorizacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @XmlTransient
    public Collection<AcadAutorizaciones> getAcadAutorizacionesCollection() {
        return acadAutorizacionesCollection;
    }

    public void setAcadAutorizacionesCollection(Collection<AcadAutorizaciones> acadAutorizacionesCollection) {
        this.acadAutorizacionesCollection = acadAutorizacionesCollection;
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
        if (!(object instanceof AcadTipoAutorizacion)) {
            return false;
        }
        AcadTipoAutorizacion other = (AcadTipoAutorizacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AcadTipoAutorizacion[ id=" + id + " ]";
    }
    
}
