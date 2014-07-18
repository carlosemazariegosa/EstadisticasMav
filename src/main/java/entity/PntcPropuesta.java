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
import javax.persistence.Lob;
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
@Table(name = "PNTC_PROPUESTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PntcPropuesta.findAll", query = "SELECT p FROM PntcPropuesta p"),
    @NamedQuery(name = "PntcPropuesta.findById", query = "SELECT p FROM PntcPropuesta p WHERE p.id = :id"),
    @NamedQuery(name = "PntcPropuesta.findBySemesAno", query = "SELECT p FROM PntcPropuesta p WHERE p.semesAno = :semesAno"),
    @NamedQuery(name = "PntcPropuesta.findByCodcarr", query = "SELECT p FROM PntcPropuesta p WHERE p.codcarr = :codcarr"),
    @NamedQuery(name = "PntcPropuesta.findByFechaPropuesta", query = "SELECT p FROM PntcPropuesta p WHERE p.fechaPropuesta = :fechaPropuesta"),
    @NamedQuery(name = "PntcPropuesta.findByUsuario", query = "SELECT p FROM PntcPropuesta p WHERE p.usuario = :usuario"),
    @NamedQuery(name = "PntcPropuesta.findByFechasys", query = "SELECT p FROM PntcPropuesta p WHERE p.fechasys = :fechasys")})
public class PntcPropuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 5)
    @Column(name = "SEMES_ANO")
    private String semesAno;
    @Size(max = 4)
    @Column(name = "CODCARR")
    private String codcarr;
    @Column(name = "FECHA_PROPUESTA")
    @Temporal(TemporalType.DATE)
    private Date fechaPropuesta;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Size(max = 10)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHASYS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasys;

    public PntcPropuesta() {
    }

    public PntcPropuesta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSemesAno() {
        return semesAno;
    }

    public void setSemesAno(String semesAno) {
        this.semesAno = semesAno;
    }

    public String getCodcarr() {
        return codcarr;
    }

    public void setCodcarr(String codcarr) {
        this.codcarr = codcarr;
    }

    public Date getFechaPropuesta() {
        return fechaPropuesta;
    }

    public void setFechaPropuesta(Date fechaPropuesta) {
        this.fechaPropuesta = fechaPropuesta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
        if (!(object instanceof PntcPropuesta)) {
            return false;
        }
        PntcPropuesta other = (PntcPropuesta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PntcPropuesta[ id=" + id + " ]";
    }
    
}
