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
@Table(name = "ACAD_INSCRIP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcadInscrip.findAll", query = "SELECT a FROM AcadInscrip a"),
    @NamedQuery(name = "AcadInscrip.findById", query = "SELECT a FROM AcadInscrip a WHERE a.id = :id"),
    @NamedQuery(name = "AcadInscrip.findBySemesAno", query = "SELECT a FROM AcadInscrip a WHERE a.semesAno = :semesAno"),
    @NamedQuery(name = "AcadInscrip.findByFacultad", query = "SELECT a FROM AcadInscrip a WHERE a.facultad = :facultad"),
    @NamedQuery(name = "AcadInscrip.findByAnio", query = "SELECT a FROM AcadInscrip a WHERE a.anio = :anio"),
    @NamedQuery(name = "AcadInscrip.findByCarnet", query = "SELECT a FROM AcadInscrip a WHERE a.carnet = :carnet"),
    @NamedQuery(name = "AcadInscrip.findByCarrera", query = "SELECT a FROM AcadInscrip a WHERE a.carrera = :carrera"),
    @NamedQuery(name = "AcadInscrip.findByJornada", query = "SELECT a FROM AcadInscrip a WHERE a.jornada = :jornada"),
    @NamedQuery(name = "AcadInscrip.findByCiclo", query = "SELECT a FROM AcadInscrip a WHERE a.ciclo = :ciclo"),
    @NamedQuery(name = "AcadInscrip.findByPPrivado", query = "SELECT a FROM AcadInscrip a WHERE a.pPrivado = :pPrivado"),
    @NamedQuery(name = "AcadInscrip.findByPTesis", query = "SELECT a FROM AcadInscrip a WHERE a.pTesis = :pTesis"),
    @NamedQuery(name = "AcadInscrip.findByPagoMen", query = "SELECT a FROM AcadInscrip a WHERE a.pagoMen = :pagoMen"),
    @NamedQuery(name = "AcadInscrip.findByPagoIns", query = "SELECT a FROM AcadInscrip a WHERE a.pagoIns = :pagoIns"),
    @NamedQuery(name = "AcadInscrip.findByFotCarne", query = "SELECT a FROM AcadInscrip a WHERE a.fotCarne = :fotCarne"),
    @NamedQuery(name = "AcadInscrip.findByLaborato", query = "SELECT a FROM AcadInscrip a WHERE a.laborato = :laborato"),
    @NamedQuery(name = "AcadInscrip.findByCursos", query = "SELECT a FROM AcadInscrip a WHERE a.cursos = :cursos"),
    @NamedQuery(name = "AcadInscrip.findByNumlab", query = "SELECT a FROM AcadInscrip a WHERE a.numlab = :numlab"),
    @NamedQuery(name = "AcadInscrip.findByFecha", query = "SELECT a FROM AcadInscrip a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "AcadInscrip.findByTalTesor", query = "SELECT a FROM AcadInscrip a WHERE a.talTesor = :talTesor"),
    @NamedQuery(name = "AcadInscrip.findByNumpol", query = "SELECT a FROM AcadInscrip a WHERE a.numpol = :numpol"),
    @NamedQuery(name = "AcadInscrip.findByClinicas", query = "SELECT a FROM AcadInscrip a WHERE a.clinicas = :clinicas"),
    @NamedQuery(name = "AcadInscrip.findByValcli", query = "SELECT a FROM AcadInscrip a WHERE a.valcli = :valcli"),
    @NamedQuery(name = "AcadInscrip.findByPagoTran", query = "SELECT a FROM AcadInscrip a WHERE a.pagoTran = :pagoTran"),
    @NamedQuery(name = "AcadInscrip.findByRechazado", query = "SELECT a FROM AcadInscrip a WHERE a.rechazado = :rechazado"),
    @NamedQuery(name = "AcadInscrip.findByActCarnet", query = "SELECT a FROM AcadInscrip a WHERE a.actCarnet = :actCarnet"),
    @NamedQuery(name = "AcadInscrip.findByFPagBco", query = "SELECT a FROM AcadInscrip a WHERE a.fPagBco = :fPagBco"),
    @NamedQuery(name = "AcadInscrip.findByTIns040", query = "SELECT a FROM AcadInscrip a WHERE a.tIns040 = :tIns040"),
    @NamedQuery(name = "AcadInscrip.findByExonBeca", query = "SELECT a FROM AcadInscrip a WHERE a.exonBeca = :exonBeca"),
    @NamedQuery(name = "AcadInscrip.findByExonLab", query = "SELECT a FROM AcadInscrip a WHERE a.exonLab = :exonLab"),
    @NamedQuery(name = "AcadInscrip.findByExonDes", query = "SELECT a FROM AcadInscrip a WHERE a.exonDes = :exonDes"),
    @NamedQuery(name = "AcadInscrip.findByExonValdes", query = "SELECT a FROM AcadInscrip a WHERE a.exonValdes = :exonValdes"),
    @NamedQuery(name = "AcadInscrip.findByNumReasigna", query = "SELECT a FROM AcadInscrip a WHERE a.numReasigna = :numReasigna"),
    @NamedQuery(name = "AcadInscrip.findByExtraord1", query = "SELECT a FROM AcadInscrip a WHERE a.extraord1 = :extraord1"),
    @NamedQuery(name = "AcadInscrip.findByExtraord2", query = "SELECT a FROM AcadInscrip a WHERE a.extraord2 = :extraord2"),
    @NamedQuery(name = "AcadInscrip.findByUsuario", query = "SELECT a FROM AcadInscrip a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "AcadInscrip.findByFechasys", query = "SELECT a FROM AcadInscrip a WHERE a.fechasys = :fechasys"),
    @NamedQuery(name = "AcadInscrip.findByLcarnet", query = "SELECT a FROM AcadInscrip a WHERE a.lcarnet = :lcarnet")})
public class AcadInscrip implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 5)
    @Column(name = "SEMES_ANO")
    private String semesAno;
    @Size(max = 2)
    @Column(name = "ANIO")
    private String anio;
    @Size(max = 5)
    @Column(name = "CARNET")
    private String carnet;
    @Size(max = 4)
    @Column(name = "CARRERA")
    private String carrera;
    @Column(name = "JORNADA")
    private Short jornada;
    @Size(max = 2)
    @Column(name = "CICLO")
    private String ciclo;
    @Column(name = "P_PRIVADO")
    private Short pPrivado;
    @Column(name = "P_TESIS")
    private Short pTesis;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PAGO_MEN")
    private BigDecimal pagoMen;
    @Column(name = "PAGO_INS")
    private BigDecimal pagoIns;
    @Column(name = "FOT_CARNE")
    private Character fotCarne;
    @Column(name = "LABORATO")
    private BigDecimal laborato;
    @Column(name = "CURSOS")
    private Short cursos;
    @Column(name = "NUMLAB")
    private Short numlab;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "TAL_TESOR")
    private Character talTesor;
    @Size(max = 10)
    @Column(name = "NUMPOL")
    private String numpol;
    @Column(name = "CLINICAS")
    private Short clinicas;
    @Column(name = "VALCLI")
    private BigDecimal valcli;
    @Column(name = "PAGO_TRAN")
    private BigDecimal pagoTran;
    @Column(name = "RECHAZADO")
    private Character rechazado;
    @Column(name = "ACT_CARNET")
    private Character actCarnet;
    @Column(name = "F_PAG_BCO")
    @Temporal(TemporalType.DATE)
    private Date fPagBco;
    @Column(name = "T_INS_040")
    private Character tIns040;
    @Column(name = "EXON_BECA")
    private Character exonBeca;
    @Column(name = "EXON_LAB")
    private Character exonLab;
    @Column(name = "EXON_DES")
    private Character exonDes;
    @Column(name = "EXON_VALDES")
    private BigDecimal exonValdes;
    @Column(name = "NUM_REASIGNA")
    private Short numReasigna;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXTRAORD1")
    private char extraord1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXTRAORD2")
    private char extraord2;
    @Size(max = 20)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHASYS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasys;
    @Column(name = "LCARNET")
    private Character lcarnet;
    @Size(max = 4)
    private String facultad;

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public AcadInscrip() {
    }

    public AcadInscrip(Integer id) {
        this.id = id;
    }

    public AcadInscrip(Integer id, char extraord1, char extraord2) {
        this.id = id;
        this.extraord1 = extraord1;
        this.extraord2 = extraord2;
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

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Short getJornada() {
        return jornada;
    }

    public void setJornada(Short jornada) {
        this.jornada = jornada;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Short getPPrivado() {
        return pPrivado;
    }

    public void setPPrivado(Short pPrivado) {
        this.pPrivado = pPrivado;
    }

    public Short getPTesis() {
        return pTesis;
    }

    public void setPTesis(Short pTesis) {
        this.pTesis = pTesis;
    }

    public BigDecimal getPagoMen() {
        return pagoMen;
    }

    public void setPagoMen(BigDecimal pagoMen) {
        this.pagoMen = pagoMen;
    }

    public BigDecimal getPagoIns() {
        return pagoIns;
    }

    public void setPagoIns(BigDecimal pagoIns) {
        this.pagoIns = pagoIns;
    }

    public Character getFotCarne() {
        return fotCarne;
    }

    public void setFotCarne(Character fotCarne) {
        this.fotCarne = fotCarne;
    }

    public BigDecimal getLaborato() {
        return laborato;
    }

    public void setLaborato(BigDecimal laborato) {
        this.laborato = laborato;
    }

    public Short getCursos() {
        return cursos;
    }

    public void setCursos(Short cursos) {
        this.cursos = cursos;
    }

    public Short getNumlab() {
        return numlab;
    }

    public void setNumlab(Short numlab) {
        this.numlab = numlab;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Character getTalTesor() {
        return talTesor;
    }

    public void setTalTesor(Character talTesor) {
        this.talTesor = talTesor;
    }

    public String getNumpol() {
        return numpol;
    }

    public void setNumpol(String numpol) {
        this.numpol = numpol;
    }

    public Short getClinicas() {
        return clinicas;
    }

    public void setClinicas(Short clinicas) {
        this.clinicas = clinicas;
    }

    public BigDecimal getValcli() {
        return valcli;
    }

    public void setValcli(BigDecimal valcli) {
        this.valcli = valcli;
    }

    public BigDecimal getPagoTran() {
        return pagoTran;
    }

    public void setPagoTran(BigDecimal pagoTran) {
        this.pagoTran = pagoTran;
    }

    public Character getRechazado() {
        return rechazado;
    }

    public void setRechazado(Character rechazado) {
        this.rechazado = rechazado;
    }

    public Character getActCarnet() {
        return actCarnet;
    }

    public void setActCarnet(Character actCarnet) {
        this.actCarnet = actCarnet;
    }

    public Date getFPagBco() {
        return fPagBco;
    }

    public void setFPagBco(Date fPagBco) {
        this.fPagBco = fPagBco;
    }

    public Character getTIns040() {
        return tIns040;
    }

    public void setTIns040(Character tIns040) {
        this.tIns040 = tIns040;
    }

    public Character getExonBeca() {
        return exonBeca;
    }

    public void setExonBeca(Character exonBeca) {
        this.exonBeca = exonBeca;
    }

    public Character getExonLab() {
        return exonLab;
    }

    public void setExonLab(Character exonLab) {
        this.exonLab = exonLab;
    }

    public Character getExonDes() {
        return exonDes;
    }

    public void setExonDes(Character exonDes) {
        this.exonDes = exonDes;
    }

    public BigDecimal getExonValdes() {
        return exonValdes;
    }

    public void setExonValdes(BigDecimal exonValdes) {
        this.exonValdes = exonValdes;
    }

    public Short getNumReasigna() {
        return numReasigna;
    }

    public void setNumReasigna(Short numReasigna) {
        this.numReasigna = numReasigna;
    }

    public char getExtraord1() {
        return extraord1;
    }

    public void setExtraord1(char extraord1) {
        this.extraord1 = extraord1;
    }

    public char getExtraord2() {
        return extraord2;
    }

    public void setExtraord2(char extraord2) {
        this.extraord2 = extraord2;
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

    public Character getLcarnet() {
        return lcarnet;
    }

    public void setLcarnet(Character lcarnet) {
        this.lcarnet = lcarnet;
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
        if (!(object instanceof AcadInscrip)) {
            return false;
        }
        AcadInscrip other = (AcadInscrip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AcadInscrip[ id=" + id + " ]";
    }
    
}
