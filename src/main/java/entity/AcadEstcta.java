/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ACAD_ESTCTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcadEstcta.findAll", query = "SELECT a FROM AcadEstcta a"),
    @NamedQuery(name = "AcadEstcta.findById", query = "SELECT a FROM AcadEstcta a WHERE a.id = :id"),
    @NamedQuery(name = "AcadEstcta.findByFecha", query = "SELECT a FROM AcadEstcta a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "AcadEstcta.findByFacultad", query = "SELECT a FROM AcadEstcta a WHERE a.facultad = :facultad"),
    @NamedQuery(name = "AcadEstcta.findByAnio", query = "SELECT a FROM AcadEstcta a WHERE a.anio = :anio"),
    @NamedQuery(name = "AcadEstcta.findByCarnet", query = "SELECT a FROM AcadEstcta a WHERE a.carnet = :carnet"),
    @NamedQuery(name = "AcadEstcta.findByCodmov", query = "SELECT a FROM AcadEstcta a WHERE a.codmov = :codmov"),
    @NamedQuery(name = "AcadEstcta.findByTipomov", query = "SELECT a FROM AcadEstcta a WHERE a.tipomov = :tipomov"),
    @NamedQuery(name = "AcadEstcta.findBySemesAno", query = "SELECT a FROM AcadEstcta a WHERE a.semesAno = :semesAno"),
    @NamedQuery(name = "AcadEstcta.findByCargos", query = "SELECT a FROM AcadEstcta a WHERE a.cargos = :cargos"),
    @NamedQuery(name = "AcadEstcta.findByAbonos", query = "SELECT a FROM AcadEstcta a WHERE a.abonos = :abonos"),
    @NamedQuery(name = "AcadEstcta.findByPoliza", query = "SELECT a FROM AcadEstcta a WHERE a.poliza = :poliza"),
    @NamedQuery(name = "AcadEstcta.findByPos", query = "SELECT a FROM AcadEstcta a WHERE a.pos = :pos"),
    @NamedQuery(name = "AcadEstcta.findByDocumento", query = "SELECT a FROM AcadEstcta a WHERE a.documento = :documento"),
    @NamedQuery(name = "AcadEstcta.findByMes", query = "SELECT a FROM AcadEstcta a WHERE a.mes = :mes"),
    @NamedQuery(name = "AcadEstcta.findByCambioa", query = "SELECT a FROM AcadEstcta a WHERE a.cambioa = :cambioa"),
    @NamedQuery(name = "AcadEstcta.findByAgencia", query = "SELECT a FROM AcadEstcta a WHERE a.agencia = :agencia"),
    @NamedQuery(name = "AcadEstcta.findByReceptor", query = "SELECT a FROM AcadEstcta a WHERE a.receptor = :receptor"),
    @NamedQuery(name = "AcadEstcta.findByUsuario", query = "SELECT a FROM AcadEstcta a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "AcadEstcta.findByFecTrans", query = "SELECT a FROM AcadEstcta a WHERE a.fecTrans = :fecTrans"),
    @NamedQuery(name = "AcadEstcta.findByHorTrans", query = "SELECT a FROM AcadEstcta a WHERE a.horTrans = :horTrans"),
    @NamedQuery(name = "AcadEstcta.findByDocumWeb", query = "SELECT a FROM AcadEstcta a WHERE a.documWeb = :documWeb")})
public class AcadEstcta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 4)
    @Column(name = "FACULTAD")
    private String facultad;
    @Size(max = 2)
    @Column(name = "ANIO")
    private String anio;
    @Size(max = 5)
    @Column(name = "CARNET")
    private String carnet;
    @Size(max = 3)
    @Column(name = "CODMOV")
    private String codmov;
    @Column(name = "TIPOMOV")
    private Character tipomov;
    @Size(max = 5)
    @Column(name = "SEMES_ANO")
    private String semesAno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CARGOS")
    private BigDecimal cargos;
    @Column(name = "ABONOS")
    private BigDecimal abonos;
    @Size(max = 10)
    @Column(name = "POLIZA")
    private String poliza;
    @Size(max = 4)
    @Column(name = "POS")
    private String pos;
    @Column(name = "DOCUMENTO")
    private Integer documento;
    @Column(name = "MES")
    private Short mes;
    @Size(max = 4)
    @Column(name = "CAMBIOA")
    private String cambioa;
    @Size(max = 3)
    @Column(name = "AGENCIA")
    private String agencia;
    @Size(max = 5)
    @Column(name = "RECEPTOR")
    private String receptor;
    @Size(max = 20)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FEC_TRANS")
    @Temporal(TemporalType.DATE)
    private Date fecTrans;
    @Column(name = "HOR_TRANS")
    @Temporal(TemporalType.TIME)
    private Date horTrans;
    @Size(max = 16)
    @Column(name = "DOCUM_WEB")
    private String documWeb;

    public AcadEstcta() {
    }

    public AcadEstcta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public String getCodmov() {
        return codmov;
    }

    public void setCodmov(String codmov) {
        this.codmov = codmov;
    }

    public Character getTipomov() {
        return tipomov;
    }

    public void setTipomov(Character tipomov) {
        this.tipomov = tipomov;
    }

    public String getSemesAno() {
        return semesAno;
    }

    public void setSemesAno(String semesAno) {
        this.semesAno = semesAno;
    }

    public BigDecimal getCargos() {
        return cargos;
    }

    public void setCargos(BigDecimal cargos) {
        this.cargos = cargos;
    }

    public BigDecimal getAbonos() {
        return abonos;
    }

    public void setAbonos(BigDecimal abonos) {
        this.abonos = abonos;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public Short getMes() {
        return mes;
    }

    public void setMes(Short mes) {
        this.mes = mes;
    }

    public String getCambioa() {
        return cambioa;
    }

    public void setCambioa(String cambioa) {
        this.cambioa = cambioa;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecTrans() {
        return fecTrans;
    }

    public void setFecTrans(Date fecTrans) {
        this.fecTrans = fecTrans;
    }

    public Date getHorTrans() {
        return horTrans;
    }

    public void setHorTrans(Date horTrans) {
        this.horTrans = horTrans;
    }

    public String getDocumWeb() {
        return documWeb;
    }

    public void setDocumWeb(String documWeb) {
        this.documWeb = documWeb;
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
        if (!(object instanceof AcadEstcta)) {
            return false;
        }
        AcadEstcta other = (AcadEstcta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AcadEstcta[ id=" + id + " ]";
    }
    
}
