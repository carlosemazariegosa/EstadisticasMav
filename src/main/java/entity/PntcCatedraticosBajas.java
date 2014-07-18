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
@Table(name = "PNTC_CATEDRATICOS_BAJAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PntcCatedraticosBajas.findAll", query = "SELECT p FROM PntcCatedraticosBajas p"),
    @NamedQuery(name = "PntcCatedraticosBajas.findById", query = "SELECT p FROM PntcCatedraticosBajas p WHERE p.id = :id"),
    @NamedQuery(name = "PntcCatedraticosBajas.findByIdPntcPropuestaDet", query = "SELECT p FROM PntcCatedraticosBajas p WHERE p.idPntcPropuestaDet = :idPntcPropuestaDet"),
    @NamedQuery(name = "PntcCatedraticosBajas.findBySemesAno", query = "SELECT p FROM PntcCatedraticosBajas p WHERE p.semesAno = :semesAno"),
    @NamedQuery(name = "PntcCatedraticosBajas.findByStatus", query = "SELECT p FROM PntcCatedraticosBajas p WHERE p.status = :status"),
    @NamedQuery(name = "PntcCatedraticosBajas.findByObservacion", query = "SELECT p FROM PntcCatedraticosBajas p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "PntcCatedraticosBajas.findByFechaBaja", query = "SELECT p FROM PntcCatedraticosBajas p WHERE p.fechaBaja = :fechaBaja"),
    @NamedQuery(name = "PntcCatedraticosBajas.findByStTesoreria", query = "SELECT p FROM PntcCatedraticosBajas p WHERE p.stTesoreria = :stTesoreria"),
    @NamedQuery(name = "PntcCatedraticosBajas.findByStRegistro", query = "SELECT p FROM PntcCatedraticosBajas p WHERE p.stRegistro = :stRegistro"),
    @NamedQuery(name = "PntcCatedraticosBajas.findByStCeprod", query = "SELECT p FROM PntcCatedraticosBajas p WHERE p.stCeprod = :stCeprod"),
    @NamedQuery(name = "PntcCatedraticosBajas.findByStPersonal", query = "SELECT p FROM PntcCatedraticosBajas p WHERE p.stPersonal = :stPersonal"),
    @NamedQuery(name = "PntcCatedraticosBajas.findByOperadoPlanilla", query = "SELECT p FROM PntcCatedraticosBajas p WHERE p.operadoPlanilla = :operadoPlanilla"),
    @NamedQuery(name = "PntcCatedraticosBajas.findByIdPntcCatedraticosBajasTipo", query = "SELECT p FROM PntcCatedraticosBajas p WHERE p.idPntcCatedraticosBajasTipo = :idPntcCatedraticosBajasTipo"),
    @NamedQuery(name = "PntcCatedraticosBajas.findByUsuario", query = "SELECT p FROM PntcCatedraticosBajas p WHERE p.usuario = :usuario"),
    @NamedQuery(name = "PntcCatedraticosBajas.findByFechasys", query = "SELECT p FROM PntcCatedraticosBajas p WHERE p.fechasys = :fechasys"),
    @NamedQuery(name = "PntcCatedraticosBajas.findByFecEntTesoreria", query = "SELECT p FROM PntcCatedraticosBajas p WHERE p.fecEntTesoreria = :fecEntTesoreria"),
    @NamedQuery(name = "PntcCatedraticosBajas.findByFecEntCeprod", query = "SELECT p FROM PntcCatedraticosBajas p WHERE p.fecEntCeprod = :fecEntCeprod"),
    @NamedQuery(name = "PntcCatedraticosBajas.findByFecEntRegistro", query = "SELECT p FROM PntcCatedraticosBajas p WHERE p.fecEntRegistro = :fecEntRegistro"),
    @NamedQuery(name = "PntcCatedraticosBajas.findByFecEntPersonal", query = "SELECT p FROM PntcCatedraticosBajas p WHERE p.fecEntPersonal = :fecEntPersonal")})
public class PntcCatedraticosBajas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ID_PNTC_PROPUESTA_DET")
    private Integer idPntcPropuestaDet;
    @Size(max = 5)
    @Column(name = "SEMES_ANO")
    private String semesAno;
    @Column(name = "STATUS")
    private Character status;
    @Size(max = 100)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Column(name = "FECHA_BAJA")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    @Column(name = "ST_TESORERIA")
    private Short stTesoreria;
    @Column(name = "ST_REGISTRO")
    private Short stRegistro;
    @Column(name = "ST_CEPROD")
    private Short stCeprod;
    @Column(name = "ST_PERSONAL")
    private Short stPersonal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPERADO_PLANILLA")
    private char operadoPlanilla;
    @Column(name = "ID_PNTC_CATEDRATICOS_BAJAS_TIPO")
    private Integer idPntcCatedraticosBajasTipo;
    @Size(max = 10)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHASYS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasys;
    @Column(name = "FEC_ENT_TESORERIA")
    @Temporal(TemporalType.DATE)
    private Date fecEntTesoreria;
    @Column(name = "FEC_ENT_CEPROD")
    @Temporal(TemporalType.DATE)
    private Date fecEntCeprod;
    @Column(name = "FEC_ENT_REGISTRO")
    @Temporal(TemporalType.DATE)
    private Date fecEntRegistro;
    @Column(name = "FEC_ENT_PERSONAL")
    @Temporal(TemporalType.DATE)
    private Date fecEntPersonal;

    public PntcCatedraticosBajas() {
    }

    public PntcCatedraticosBajas(Integer id) {
        this.id = id;
    }

    public PntcCatedraticosBajas(Integer id, char operadoPlanilla) {
        this.id = id;
        this.operadoPlanilla = operadoPlanilla;
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

    public String getSemesAno() {
        return semesAno;
    }

    public void setSemesAno(String semesAno) {
        this.semesAno = semesAno;
    }

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

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Short getStTesoreria() {
        return stTesoreria;
    }

    public void setStTesoreria(Short stTesoreria) {
        this.stTesoreria = stTesoreria;
    }

    public Short getStRegistro() {
        return stRegistro;
    }

    public void setStRegistro(Short stRegistro) {
        this.stRegistro = stRegistro;
    }

    public Short getStCeprod() {
        return stCeprod;
    }

    public void setStCeprod(Short stCeprod) {
        this.stCeprod = stCeprod;
    }

    public Short getStPersonal() {
        return stPersonal;
    }

    public void setStPersonal(Short stPersonal) {
        this.stPersonal = stPersonal;
    }

    public char getOperadoPlanilla() {
        return operadoPlanilla;
    }

    public void setOperadoPlanilla(char operadoPlanilla) {
        this.operadoPlanilla = operadoPlanilla;
    }

    public Integer getIdPntcCatedraticosBajasTipo() {
        return idPntcCatedraticosBajasTipo;
    }

    public void setIdPntcCatedraticosBajasTipo(Integer idPntcCatedraticosBajasTipo) {
        this.idPntcCatedraticosBajasTipo = idPntcCatedraticosBajasTipo;
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

    public Date getFecEntTesoreria() {
        return fecEntTesoreria;
    }

    public void setFecEntTesoreria(Date fecEntTesoreria) {
        this.fecEntTesoreria = fecEntTesoreria;
    }

    public Date getFecEntCeprod() {
        return fecEntCeprod;
    }

    public void setFecEntCeprod(Date fecEntCeprod) {
        this.fecEntCeprod = fecEntCeprod;
    }

    public Date getFecEntRegistro() {
        return fecEntRegistro;
    }

    public void setFecEntRegistro(Date fecEntRegistro) {
        this.fecEntRegistro = fecEntRegistro;
    }

    public Date getFecEntPersonal() {
        return fecEntPersonal;
    }

    public void setFecEntPersonal(Date fecEntPersonal) {
        this.fecEntPersonal = fecEntPersonal;
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
        if (!(object instanceof PntcCatedraticosBajas)) {
            return false;
        }
        PntcCatedraticosBajas other = (PntcCatedraticosBajas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PntcCatedraticosBajas[ id=" + id + " ]";
    }
    
}
