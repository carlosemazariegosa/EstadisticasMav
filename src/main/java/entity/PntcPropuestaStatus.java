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
@Table(name = "PNTC_PROPUESTA_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PntcPropuestaStatus.findAll", query = "SELECT p FROM PntcPropuestaStatus p"),
    @NamedQuery(name = "PntcPropuestaStatus.findById", query = "SELECT p FROM PntcPropuestaStatus p WHERE p.id = :id"),
    @NamedQuery(name = "PntcPropuestaStatus.findByIdPntcPropuestaDet", query = "SELECT p FROM PntcPropuestaStatus p WHERE p.idPntcPropuestaDet = :idPntcPropuestaDet"),
    @NamedQuery(name = "PntcPropuestaStatus.findByIdStatus", query = "SELECT p FROM PntcPropuestaStatus p WHERE p.idStatus = :idStatus"),
    @NamedQuery(name = "PntcPropuestaStatus.findByCondicion", query = "SELECT p FROM PntcPropuestaStatus p WHERE p.condicion = :condicion"),
    @NamedQuery(name = "PntcPropuestaStatus.findByObservacion", query = "SELECT p FROM PntcPropuestaStatus p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "PntcPropuestaStatus.findByUsuarioActualizado", query = "SELECT p FROM PntcPropuestaStatus p WHERE p.usuarioActualizado = :usuarioActualizado"),
    @NamedQuery(name = "PntcPropuestaStatus.findByFechaActualizado", query = "SELECT p FROM PntcPropuestaStatus p WHERE p.fechaActualizado = :fechaActualizado"),
    @NamedQuery(name = "PntcPropuestaStatus.findByFirmaElec", query = "SELECT p FROM PntcPropuestaStatus p WHERE p.firmaElec = :firmaElec"),
    @NamedQuery(name = "PntcPropuestaStatus.findByMkFb", query = "SELECT p FROM PntcPropuestaStatus p WHERE p.mkFb = :mkFb"),
    @NamedQuery(name = "PntcPropuestaStatus.findByMkFox", query = "SELECT p FROM PntcPropuestaStatus p WHERE p.mkFox = :mkFox"),
    @NamedQuery(name = "PntcPropuestaStatus.findByUsuario", query = "SELECT p FROM PntcPropuestaStatus p WHERE p.usuario = :usuario"),
    @NamedQuery(name = "PntcPropuestaStatus.findByFechasys", query = "SELECT p FROM PntcPropuestaStatus p WHERE p.fechasys = :fechasys")})
public class PntcPropuestaStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ID_PNTC_PROPUESTA_DET")
    private Integer idPntcPropuestaDet;
    @Column(name = "ID_STATUS")
    private Integer idStatus;
    @Size(max = 1)
    @Column(name = "CONDICION")
    private String condicion;
    @Size(max = 50)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Size(max = 10)
    @Column(name = "USUARIO_ACTUALIZADO")
    private String usuarioActualizado;
    @Column(name = "FECHA_ACTUALIZADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizado;
    @Column(name = "FIRMA_ELEC")
    private Character firmaElec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MK_FB")
    private char mkFb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MK_FOX")
    private char mkFox;
    @Size(max = 10)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHASYS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasys;

    public PntcPropuestaStatus() {
    }

    public PntcPropuestaStatus(Integer id) {
        this.id = id;
    }

    public PntcPropuestaStatus(Integer id, char mkFb, char mkFox) {
        this.id = id;
        this.mkFb = mkFb;
        this.mkFox = mkFox;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPntcPropuestaDet() {
        return idPntcPropuestaDet;
    }

    public void setIdPntcPropuestaDet(Integer idPntcPropuestaDet) {
        this.idPntcPropuestaDet = idPntcPropuestaDet;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getUsuarioActualizado() {
        return usuarioActualizado;
    }

    public void setUsuarioActualizado(String usuarioActualizado) {
        this.usuarioActualizado = usuarioActualizado;
    }

    public Date getFechaActualizado() {
        return fechaActualizado;
    }

    public void setFechaActualizado(Date fechaActualizado) {
        this.fechaActualizado = fechaActualizado;
    }

    public Character getFirmaElec() {
        return firmaElec;
    }

    public void setFirmaElec(Character firmaElec) {
        this.firmaElec = firmaElec;
    }

    public char getMkFb() {
        return mkFb;
    }

    public void setMkFb(char mkFb) {
        this.mkFb = mkFb;
    }

    public char getMkFox() {
        return mkFox;
    }

    public void setMkFox(char mkFox) {
        this.mkFox = mkFox;
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
        if (!(object instanceof PntcPropuestaStatus)) {
            return false;
        }
        PntcPropuestaStatus other = (PntcPropuestaStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PntcPropuestaStatus[ id=" + id + " ]";
    }
    
}
