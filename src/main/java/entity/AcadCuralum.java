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
@Table(name = "ACAD_CURALUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcadCuralum.findAll", query = "SELECT a FROM AcadCuralum a"),
    @NamedQuery(name = "AcadCuralum.findById", query = "SELECT a FROM AcadCuralum a WHERE a.id = :id"),
    @NamedQuery(name = "AcadCuralum.findBySemesAno", query = "SELECT a FROM AcadCuralum a WHERE a.semesAno = :semesAno"),
    @NamedQuery(name = "AcadCuralum.findByFacultad", query = "SELECT a FROM AcadCuralum a WHERE a.facultad = :facultad"),
    @NamedQuery(name = "AcadCuralum.findByAnio", query = "SELECT a FROM AcadCuralum a WHERE a.anio = :anio"),
    @NamedQuery(name = "AcadCuralum.findByCarnet", query = "SELECT a FROM AcadCuralum a WHERE a.carnet = :carnet"),
    @NamedQuery(name = "AcadCuralum.findByCodcarr", query = "SELECT a FROM AcadCuralum a WHERE a.codcarr = :codcarr"),
    @NamedQuery(name = "AcadCuralum.findByCodcur", query = "SELECT a FROM AcadCuralum a WHERE a.codcur = :codcur"),
    @NamedQuery(name = "AcadCuralum.findBySeccion", query = "SELECT a FROM AcadCuralum a WHERE a.seccion = :seccion"),
    @NamedQuery(name = "AcadCuralum.findByValida", query = "SELECT a FROM AcadCuralum a WHERE a.valida = :valida"),
    @NamedQuery(name = "AcadCuralum.findByPos", query = "SELECT a FROM AcadCuralum a WHERE a.pos = :pos"),
    @NamedQuery(name = "AcadCuralum.findByTraslape", query = "SELECT a FROM AcadCuralum a WHERE a.traslape = :traslape"),
    @NamedQuery(name = "AcadCuralum.findByPagaLab", query = "SELECT a FROM AcadCuralum a WHERE a.pagaLab = :pagaLab"),
    @NamedQuery(name = "AcadCuralum.findByParcial1", query = "SELECT a FROM AcadCuralum a WHERE a.parcial1 = :parcial1"),
    @NamedQuery(name = "AcadCuralum.findByExtraord1", query = "SELECT a FROM AcadCuralum a WHERE a.extraord1 = :extraord1"),
    @NamedQuery(name = "AcadCuralum.findByParcial2", query = "SELECT a FROM AcadCuralum a WHERE a.parcial2 = :parcial2"),
    @NamedQuery(name = "AcadCuralum.findByExtraord2", query = "SELECT a FROM AcadCuralum a WHERE a.extraord2 = :extraord2"),
    @NamedQuery(name = "AcadCuralum.findByActivi", query = "SELECT a FROM AcadCuralum a WHERE a.activi = :activi"),
    @NamedQuery(name = "AcadCuralum.findByActivi2", query = "SELECT a FROM AcadCuralum a WHERE a.activi2 = :activi2"),
    @NamedQuery(name = "AcadCuralum.findByZona", query = "SELECT a FROM AcadCuralum a WHERE a.zona = :zona"),
    @NamedQuery(name = "AcadCuralum.findByFinal1", query = "SELECT a FROM AcadCuralum a WHERE a.final1 = :final1"),
    @NamedQuery(name = "AcadCuralum.findByValretra", query = "SELECT a FROM AcadCuralum a WHERE a.valretra = :valretra"),
    @NamedQuery(name = "AcadCuralum.findByValret2", query = "SELECT a FROM AcadCuralum a WHERE a.valret2 = :valret2"),
    @NamedQuery(name = "AcadCuralum.findByRechazado", query = "SELECT a FROM AcadCuralum a WHERE a.rechazado = :rechazado"),
    @NamedQuery(name = "AcadCuralum.findByFecTrans", query = "SELECT a FROM AcadCuralum a WHERE a.fecTrans = :fecTrans"),
    @NamedQuery(name = "AcadCuralum.findByHorTrans", query = "SELECT a FROM AcadCuralum a WHERE a.horTrans = :horTrans"),
    @NamedQuery(name = "AcadCuralum.findByNotasIng", query = "SELECT a FROM AcadCuralum a WHERE a.notasIng = :notasIng"),
    @NamedQuery(name = "AcadCuralum.findByNoPreP2", query = "SELECT a FROM AcadCuralum a WHERE a.noPreP2 = :noPreP2"),
    @NamedQuery(name = "AcadCuralum.findByNspF", query = "SELECT a FROM AcadCuralum a WHERE a.nspF = :nspF"),
    @NamedQuery(name = "AcadCuralum.findByNsp1", query = "SELECT a FROM AcadCuralum a WHERE a.nsp1 = :nsp1"),
    @NamedQuery(name = "AcadCuralum.findByNspE1", query = "SELECT a FROM AcadCuralum a WHERE a.nspE1 = :nspE1"),
    @NamedQuery(name = "AcadCuralum.findByNsp2", query = "SELECT a FROM AcadCuralum a WHERE a.nsp2 = :nsp2"),
    @NamedQuery(name = "AcadCuralum.findByNspE2", query = "SELECT a FROM AcadCuralum a WHERE a.nspE2 = :nspE2"),
    @NamedQuery(name = "AcadCuralum.findBySde", query = "SELECT a FROM AcadCuralum a WHERE a.sde = :sde"),
    @NamedQuery(name = "AcadCuralum.findByNi1", query = "SELECT a FROM AcadCuralum a WHERE a.ni1 = :ni1"),
    @NamedQuery(name = "AcadCuralum.findByM1", query = "SELECT a FROM AcadCuralum a WHERE a.m1 = :m1"),
    @NamedQuery(name = "AcadCuralum.findByNiE1", query = "SELECT a FROM AcadCuralum a WHERE a.niE1 = :niE1"),
    @NamedQuery(name = "AcadCuralum.findByME1", query = "SELECT a FROM AcadCuralum a WHERE a.mE1 = :mE1"),
    @NamedQuery(name = "AcadCuralum.findByNi2", query = "SELECT a FROM AcadCuralum a WHERE a.ni2 = :ni2"),
    @NamedQuery(name = "AcadCuralum.findByM2", query = "SELECT a FROM AcadCuralum a WHERE a.m2 = :m2"),
    @NamedQuery(name = "AcadCuralum.findByNiE2", query = "SELECT a FROM AcadCuralum a WHERE a.niE2 = :niE2"),
    @NamedQuery(name = "AcadCuralum.findByME2", query = "SELECT a FROM AcadCuralum a WHERE a.mE2 = :mE2"),
    @NamedQuery(name = "AcadCuralum.findByNiF", query = "SELECT a FROM AcadCuralum a WHERE a.niF = :niF"),
    @NamedQuery(name = "AcadCuralum.findByMF", query = "SELECT a FROM AcadCuralum a WHERE a.mF = :mF"),
    @NamedQuery(name = "AcadCuralum.findByNiR", query = "SELECT a FROM AcadCuralum a WHERE a.niR = :niR"),
    @NamedQuery(name = "AcadCuralum.findByMR", query = "SELECT a FROM AcadCuralum a WHERE a.mR = :mR"),
    @NamedQuery(name = "AcadCuralum.findByNiR2", query = "SELECT a FROM AcadCuralum a WHERE a.niR2 = :niR2"),
    @NamedQuery(name = "AcadCuralum.findByMR2", query = "SELECT a FROM AcadCuralum a WHERE a.mR2 = :mR2"),
    @NamedQuery(name = "AcadCuralum.findByNspR2", query = "SELECT a FROM AcadCuralum a WHERE a.nspR2 = :nspR2"),
    @NamedQuery(name = "AcadCuralum.findByNspR", query = "SELECT a FROM AcadCuralum a WHERE a.nspR = :nspR"),
    @NamedQuery(name = "AcadCuralum.findByMkE1", query = "SELECT a FROM AcadCuralum a WHERE a.mkE1 = :mkE1"),
    @NamedQuery(name = "AcadCuralum.findByMkE2", query = "SELECT a FROM AcadCuralum a WHERE a.mkE2 = :mkE2"),
    @NamedQuery(name = "AcadCuralum.findByRetrazada", query = "SELECT a FROM AcadCuralum a WHERE a.retrazada = :retrazada"),
    @NamedQuery(name = "AcadCuralum.findByMkR2", query = "SELECT a FROM AcadCuralum a WHERE a.mkR2 = :mkR2"),
    @NamedQuery(name = "AcadCuralum.findByRetMedic", query = "SELECT a FROM AcadCuralum a WHERE a.retMedic = :retMedic"),
    @NamedQuery(name = "AcadCuralum.findByMoodle", query = "SELECT a FROM AcadCuralum a WHERE a.moodle = :moodle"),
    @NamedQuery(name = "AcadCuralum.findByUsuario", query = "SELECT a FROM AcadCuralum a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "AcadCuralum.findByFechasys", query = "SELECT a FROM AcadCuralum a WHERE a.fechasys = :fechasys")})
public class AcadCuralum implements Serializable {
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
    @Size(max = 4)
    @Column(name = "CODCARR")
    private String codcarr;
    @Size(max = 3)
    @Column(name = "CODCUR")
    private String codcur;
    @Column(name = "SECCION")
    private Character seccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALIDA")
    private char valida;
    @Size(max = 2)
    @Column(name = "POS")
    private String pos;
    @Size(max = 30)
    @Column(name = "TRASLAPE")
    private String traslape;
    @Column(name = "PAGA_LAB")
    private Character pagaLab;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PARCIAL1")
    private BigDecimal parcial1;
    @Column(name = "EXTRAORD1")
    private BigDecimal extraord1;
    @Column(name = "PARCIAL2")
    private BigDecimal parcial2;
    @Column(name = "EXTRAORD2")
    private BigDecimal extraord2;
    @Column(name = "ACTIVI")
    private BigDecimal activi;
    @Column(name = "ACTIVI2")
    private BigDecimal activi2;
    @Column(name = "ZONA")
    private BigDecimal zona;
    @Column(name = "FINAL")
    private BigDecimal final1;
    @Column(name = "VALRETRA")
    private BigDecimal valretra;
    @Column(name = "VALRET2")
    private BigDecimal valret2;
    @Column(name = "RECHAZADO")
    private Character rechazado;
    @Column(name = "FEC_TRANS")
    @Temporal(TemporalType.DATE)
    private Date fecTrans;
    @Column(name = "HOR_TRANS")
    @Temporal(TemporalType.TIME)
    private Date horTrans;
    @Column(name = "NOTAS_ING")
    private Character notasIng;
    @Column(name = "NO_PRE_P2")
    private Character noPreP2;
    @Column(name = "NSP_F")
    private Character nspF;
    @Column(name = "NSP_1")
    private Character nsp1;
    @Column(name = "NSP_E1")
    private Character nspE1;
    @Column(name = "NSP_2")
    private Character nsp2;
    @Column(name = "NSP_E2")
    private Character nspE2;
    @Column(name = "SDE")
    private Character sde;
    @Column(name = "NI_1")
    private Character ni1;
    @Column(name = "M_1")
    private Character m1;
    @Column(name = "NI_E1")
    private Character niE1;
    @Column(name = "M_E1")
    private Character mE1;
    @Column(name = "NI_2")
    private Character ni2;
    @Column(name = "M_2")
    private Character m2;
    @Column(name = "NI_E2")
    private Character niE2;
    @Column(name = "M_E2")
    private Character mE2;
    @Column(name = "NI_F")
    private Character niF;
    @Column(name = "M_F")
    private Character mF;
    @Column(name = "NI_R")
    private Character niR;
    @Column(name = "M_R")
    private Character mR;
    @Column(name = "NI_R2")
    private Character niR2;
    @Column(name = "M_R2")
    private Character mR2;
    @Column(name = "NSP_R2")
    private Character nspR2;
    @Column(name = "NSP_R")
    private Character nspR;
    @Column(name = "MK_E1")
    private Character mkE1;
    @Column(name = "MK_E2")
    private Character mkE2;
    @Column(name = "RETRAZADA")
    private Character retrazada;
    @Column(name = "MK_R2")
    private Character mkR2;
    @Column(name = "RET_MEDIC")
    private Character retMedic;
    @Column(name = "MOODLE")
    private Character moodle;
    @Size(max = 10)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHASYS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasys;

    public AcadCuralum() {
    }

    public AcadCuralum(Integer id) {
        this.id = id;
    }

    public AcadCuralum(Integer id, char valida) {
        this.id = id;
        this.valida = valida;
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

    public String getCodcarr() {
        return codcarr;
    }

    public void setCodcarr(String codcarr) {
        this.codcarr = codcarr;
    }

    public String getCodcur() {
        return codcur;
    }

    public void setCodcur(String codcur) {
        this.codcur = codcur;
    }

    public Character getSeccion() {
        return seccion;
    }

    public void setSeccion(Character seccion) {
        this.seccion = seccion;
    }

    public char getValida() {
        return valida;
    }

    public void setValida(char valida) {
        this.valida = valida;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getTraslape() {
        return traslape;
    }

    public void setTraslape(String traslape) {
        this.traslape = traslape;
    }

    public Character getPagaLab() {
        return pagaLab;
    }

    public void setPagaLab(Character pagaLab) {
        this.pagaLab = pagaLab;
    }

    public BigDecimal getParcial1() {
        return parcial1;
    }

    public void setParcial1(BigDecimal parcial1) {
        this.parcial1 = parcial1;
    }

    public BigDecimal getExtraord1() {
        return extraord1;
    }

    public void setExtraord1(BigDecimal extraord1) {
        this.extraord1 = extraord1;
    }

    public BigDecimal getParcial2() {
        return parcial2;
    }

    public void setParcial2(BigDecimal parcial2) {
        this.parcial2 = parcial2;
    }

    public BigDecimal getExtraord2() {
        return extraord2;
    }

    public void setExtraord2(BigDecimal extraord2) {
        this.extraord2 = extraord2;
    }

    public BigDecimal getActivi() {
        return activi;
    }

    public void setActivi(BigDecimal activi) {
        this.activi = activi;
    }

    public BigDecimal getActivi2() {
        return activi2;
    }

    public void setActivi2(BigDecimal activi2) {
        this.activi2 = activi2;
    }

    public BigDecimal getZona() {
        return zona;
    }

    public void setZona(BigDecimal zona) {
        this.zona = zona;
    }

    public BigDecimal getFinal1() {
        return final1;
    }

    public void setFinal1(BigDecimal final1) {
        this.final1 = final1;
    }

    public BigDecimal getValretra() {
        return valretra;
    }

    public void setValretra(BigDecimal valretra) {
        this.valretra = valretra;
    }

    public BigDecimal getValret2() {
        return valret2;
    }

    public void setValret2(BigDecimal valret2) {
        this.valret2 = valret2;
    }

    public Character getRechazado() {
        return rechazado;
    }

    public void setRechazado(Character rechazado) {
        this.rechazado = rechazado;
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

    public Character getNotasIng() {
        return notasIng;
    }

    public void setNotasIng(Character notasIng) {
        this.notasIng = notasIng;
    }

    public Character getNoPreP2() {
        return noPreP2;
    }

    public void setNoPreP2(Character noPreP2) {
        this.noPreP2 = noPreP2;
    }

    public Character getNspF() {
        return nspF;
    }

    public void setNspF(Character nspF) {
        this.nspF = nspF;
    }

    public Character getNsp1() {
        return nsp1;
    }

    public void setNsp1(Character nsp1) {
        this.nsp1 = nsp1;
    }

    public Character getNspE1() {
        return nspE1;
    }

    public void setNspE1(Character nspE1) {
        this.nspE1 = nspE1;
    }

    public Character getNsp2() {
        return nsp2;
    }

    public void setNsp2(Character nsp2) {
        this.nsp2 = nsp2;
    }

    public Character getNspE2() {
        return nspE2;
    }

    public void setNspE2(Character nspE2) {
        this.nspE2 = nspE2;
    }

    public Character getSde() {
        return sde;
    }

    public void setSde(Character sde) {
        this.sde = sde;
    }

    public Character getNi1() {
        return ni1;
    }

    public void setNi1(Character ni1) {
        this.ni1 = ni1;
    }

    public Character getM1() {
        return m1;
    }

    public void setM1(Character m1) {
        this.m1 = m1;
    }

    public Character getNiE1() {
        return niE1;
    }

    public void setNiE1(Character niE1) {
        this.niE1 = niE1;
    }

    public Character getME1() {
        return mE1;
    }

    public void setME1(Character mE1) {
        this.mE1 = mE1;
    }

    public Character getNi2() {
        return ni2;
    }

    public void setNi2(Character ni2) {
        this.ni2 = ni2;
    }

    public Character getM2() {
        return m2;
    }

    public void setM2(Character m2) {
        this.m2 = m2;
    }

    public Character getNiE2() {
        return niE2;
    }

    public void setNiE2(Character niE2) {
        this.niE2 = niE2;
    }

    public Character getME2() {
        return mE2;
    }

    public void setME2(Character mE2) {
        this.mE2 = mE2;
    }

    public Character getNiF() {
        return niF;
    }

    public void setNiF(Character niF) {
        this.niF = niF;
    }

    public Character getMF() {
        return mF;
    }

    public void setMF(Character mF) {
        this.mF = mF;
    }

    public Character getNiR() {
        return niR;
    }

    public void setNiR(Character niR) {
        this.niR = niR;
    }

    public Character getMR() {
        return mR;
    }

    public void setMR(Character mR) {
        this.mR = mR;
    }

    public Character getNiR2() {
        return niR2;
    }

    public void setNiR2(Character niR2) {
        this.niR2 = niR2;
    }

    public Character getMR2() {
        return mR2;
    }

    public void setMR2(Character mR2) {
        this.mR2 = mR2;
    }

    public Character getNspR2() {
        return nspR2;
    }

    public void setNspR2(Character nspR2) {
        this.nspR2 = nspR2;
    }

    public Character getNspR() {
        return nspR;
    }

    public void setNspR(Character nspR) {
        this.nspR = nspR;
    }

    public Character getMkE1() {
        return mkE1;
    }

    public void setMkE1(Character mkE1) {
        this.mkE1 = mkE1;
    }

    public Character getMkE2() {
        return mkE2;
    }

    public void setMkE2(Character mkE2) {
        this.mkE2 = mkE2;
    }

    public Character getRetrazada() {
        return retrazada;
    }

    public void setRetrazada(Character retrazada) {
        this.retrazada = retrazada;
    }

    public Character getMkR2() {
        return mkR2;
    }

    public void setMkR2(Character mkR2) {
        this.mkR2 = mkR2;
    }

    public Character getRetMedic() {
        return retMedic;
    }

    public void setRetMedic(Character retMedic) {
        this.retMedic = retMedic;
    }

    public Character getMoodle() {
        return moodle;
    }

    public void setMoodle(Character moodle) {
        this.moodle = moodle;
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
        if (!(object instanceof AcadCuralum)) {
            return false;
        }
        AcadCuralum other = (AcadCuralum) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AcadCuralum[ id=" + id + " ]";
    }
    
}
