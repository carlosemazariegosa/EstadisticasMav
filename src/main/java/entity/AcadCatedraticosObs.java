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
@Table(name = "ACAD_CATEDRATICOS_OBS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcadCatedraticosObs.findAll", query = "SELECT a FROM AcadCatedraticosObs a"),
    @NamedQuery(name = "AcadCatedraticosObs.findById", query = "SELECT a FROM AcadCatedraticosObs a WHERE a.id = :id"),
    @NamedQuery(name = "AcadCatedraticosObs.findByIdAcadCatedraticos", query = "SELECT a FROM AcadCatedraticosObs a WHERE a.idAcadCatedraticos = :idAcadCatedraticos"),
    @NamedQuery(name = "AcadCatedraticosObs.findByStatus", query = "SELECT a FROM AcadCatedraticosObs a WHERE a.status = :status"),
    @NamedQuery(name = "AcadCatedraticosObs.findByObservacion", query = "SELECT a FROM AcadCatedraticosObs a WHERE a.observacion = :observacion"),
    @NamedQuery(name = "AcadCatedraticosObs.findByObservacionAutorizado", query = "SELECT a FROM AcadCatedraticosObs a WHERE a.observacionAutorizado = :observacionAutorizado"),
    @NamedQuery(name = "AcadCatedraticosObs.findByExperiencia", query = "SELECT a FROM AcadCatedraticosObs a WHERE a.experiencia = :experiencia"),
    @NamedQuery(name = "AcadCatedraticosObs.findByUsuario", query = "SELECT a FROM AcadCatedraticosObs a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "AcadCatedraticosObs.findByFechasys", query = "SELECT a FROM AcadCatedraticosObs a WHERE a.fechasys = :fechasys")})
public class AcadCatedraticosObs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    //@Column(name = "ID_ACAD_CATEDRATICOS")
    //private Integer idAcadCatedraticos;
    @Column(name = "STATUS")
    private Character status;
    @Size(max = 250)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Size(max = 250)
    @Column(name = "OBSERVACION_AUTORIZADO")
    private String observacionAutorizado;
    @Size(max = 250)
    @Column(name = "EXPERIENCIA")
    private String experiencia;
    @Size(max = 10)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHASYS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasys;
    
    @JoinColumn(name = "ID_ACAD_CATEDRATICOS", referencedColumnName = "ID")
    @ManyToOne
    private AcadCatedraticos idAcadCatedraticos;

    public AcadCatedraticosObs() {
    }

    public AcadCatedraticosObs(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AcadCatedraticos getIdAcadCatedraticos() {
        return idAcadCatedraticos;
    }

    public void setIdAcadCatedraticos(AcadCatedraticos idAcadCatedraticos) {
        this.idAcadCatedraticos = idAcadCatedraticos;
    }

   /* public Integer getIdAcadCatedraticos() {
        return idAcadCatedraticos;
    }

    public void setIdAcadCatedraticos(Integer idAcadCatedraticos) {
        this.idAcadCatedraticos = idAcadCatedraticos;
    }*/

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacionAutorizado() {
        return observacionAutorizado;
    }

    public void setObservacionAutorizado(String observacionAutorizado) {
        this.observacionAutorizado = observacionAutorizado;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
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
        if (!(object instanceof AcadCatedraticosObs)) {
            return false;
        }
        AcadCatedraticosObs other = (AcadCatedraticosObs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AcadCatedraticosObs[ id=" + id + " ]";
    }
    
}
