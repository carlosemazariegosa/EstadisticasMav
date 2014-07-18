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
@Table(name = "ACAD_AUTORIZACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcadAutorizaciones.findAll", query = "SELECT a FROM AcadAutorizaciones a"),
    @NamedQuery(name = "AcadAutorizaciones.findById", query = "SELECT a FROM AcadAutorizaciones a WHERE a.id = :id"),
    @NamedQuery(name = "AcadAutorizaciones.findBySemesAno", query = "SELECT a FROM AcadAutorizaciones a WHERE a.semesAno = :semesAno"),
    @NamedQuery(name = "AcadAutorizaciones.findByFacultad", query = "SELECT a FROM AcadAutorizaciones a WHERE a.facultad = :facultad"),
    @NamedQuery(name = "AcadAutorizaciones.findByAnio", query = "SELECT a FROM AcadAutorizaciones a WHERE a.anio = :anio"),
    @NamedQuery(name = "AcadAutorizaciones.findByCarnet", query = "SELECT a FROM AcadAutorizaciones a WHERE a.carnet = :carnet"),
    @NamedQuery(name = "AcadAutorizaciones.findByFechaInicio", query = "SELECT a FROM AcadAutorizaciones a WHERE a.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "AcadAutorizaciones.findByFechaFinal", query = "SELECT a FROM AcadAutorizaciones a WHERE a.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "AcadAutorizaciones.findByUsuarios", query = "SELECT a FROM AcadAutorizaciones a WHERE a.usuarios = :usuarios"),
    @NamedQuery(name = "AcadAutorizaciones.findByFechasys", query = "SELECT a FROM AcadAutorizaciones a WHERE a.fechasys = :fechasys")})
public class AcadAutorizaciones implements Serializable {
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
    @Column(name = "FACULTAD")
    private String facultad;
    @Size(max = 2)
    @Column(name = "ANIO")
    private String anio;
    @Size(max = 5)
    @Column(name = "CARNET")
    private String carnet;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @Size(max = 10)
    @Column(name = "USUARIOS")
    private String usuarios;
    @Column(name = "FECHASYS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasys;
    @JoinColumn(name = "ID_TIPO_AUTORIZACION", referencedColumnName = "ID")
    @ManyToOne
    private AcadTipoAutorizacion idTipoAutorizacion;

    public AcadAutorizaciones() {
    }

    public AcadAutorizaciones(Integer id) {
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }

    public Date getFechasys() {
        return fechasys;
    }

    public void setFechasys(Date fechasys) {
        this.fechasys = fechasys;
    }

    public AcadTipoAutorizacion getIdTipoAutorizacion() {
        return idTipoAutorizacion;
    }

    public void setIdTipoAutorizacion(AcadTipoAutorizacion idTipoAutorizacion) {
        this.idTipoAutorizacion = idTipoAutorizacion;
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
        if (!(object instanceof AcadAutorizaciones)) {
            return false;
        }
        AcadAutorizaciones other = (AcadAutorizaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AcadAutorizaciones[ id=" + id + " ]";
    }
    
}
