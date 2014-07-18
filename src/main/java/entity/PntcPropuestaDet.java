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
@Table(name = "PNTC_PROPUESTA_DET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PntcPropuestaDet.findAll", query = "SELECT p FROM PntcPropuestaDet p"),
    @NamedQuery(name = "PntcPropuestaDet.findById", query = "SELECT p FROM PntcPropuestaDet p WHERE p.id = :id"),
    @NamedQuery(name = "PntcPropuestaDet.findByIdPntcPropuesta", query = "SELECT p FROM PntcPropuestaDet p WHERE p.idPntcPropuesta = :idPntcPropuesta"),
    @NamedQuery(name = "PntcPropuestaDet.findByIdPensum", query = "SELECT p FROM PntcPropuestaDet p WHERE p.idPensum = :idPensum"),
    @NamedQuery(name = "PntcPropuestaDet.findByIdPensumDet", query = "SELECT p FROM PntcPropuestaDet p WHERE p.idPensumDet = :idPensumDet"),
    @NamedQuery(name = "PntcPropuestaDet.findByIdPntcImpuestos", query = "SELECT p FROM PntcPropuestaDet p WHERE p.idPntcImpuestos = :idPntcImpuestos"),
    @NamedQuery(name = "PntcPropuestaDet.findByIdPntcTipoPropuesta", query = "SELECT p FROM PntcPropuestaDet p WHERE p.idPntcTipoPropuesta = :idPntcTipoPropuesta"),
    @NamedQuery(name = "PntcPropuestaDet.findByIdPntcTipoPropuestaDet", query = "SELECT p FROM PntcPropuestaDet p WHERE p.idPntcTipoPropuestaDet = :idPntcTipoPropuestaDet"),
    @NamedQuery(name = "PntcPropuestaDet.findByIdPntcPropuestaDetUnificado", query = "SELECT p FROM PntcPropuestaDet p WHERE p.idPntcPropuestaDetUnificado = :idPntcPropuestaDetUnificado"),
    @NamedQuery(name = "PntcPropuestaDet.findByIdPntcTipoPropuestaPerfil", query = "SELECT p FROM PntcPropuestaDet p WHERE p.idPntcTipoPropuestaPerfil = :idPntcTipoPropuestaPerfil"),
    @NamedQuery(name = "PntcPropuestaDet.findByImpuesto", query = "SELECT p FROM PntcPropuestaDet p WHERE p.impuesto = :impuesto"),
    @NamedQuery(name = "PntcPropuestaDet.findBySeccion", query = "SELECT p FROM PntcPropuestaDet p WHERE p.seccion = :seccion"),
    @NamedQuery(name = "PntcPropuestaDet.findByCodcat", query = "SELECT p FROM PntcPropuestaDet p WHERE p.codcat = :codcat"),
    @NamedQuery(name = "PntcPropuestaDet.findByTipoCatedratico", query = "SELECT p FROM PntcPropuestaDet p WHERE p.tipoCatedratico = :tipoCatedratico"),
    @NamedQuery(name = "PntcPropuestaDet.findByHorinlu", query = "SELECT p FROM PntcPropuestaDet p WHERE p.horinlu = :horinlu"),
    @NamedQuery(name = "PntcPropuestaDet.findByHorfinlu", query = "SELECT p FROM PntcPropuestaDet p WHERE p.horfinlu = :horfinlu"),
    @NamedQuery(name = "PntcPropuestaDet.findByHorinma", query = "SELECT p FROM PntcPropuestaDet p WHERE p.horinma = :horinma"),
    @NamedQuery(name = "PntcPropuestaDet.findByHorfinma", query = "SELECT p FROM PntcPropuestaDet p WHERE p.horfinma = :horfinma"),
    @NamedQuery(name = "PntcPropuestaDet.findByHorinmi", query = "SELECT p FROM PntcPropuestaDet p WHERE p.horinmi = :horinmi"),
    @NamedQuery(name = "PntcPropuestaDet.findByHorfinmi", query = "SELECT p FROM PntcPropuestaDet p WHERE p.horfinmi = :horfinmi"),
    @NamedQuery(name = "PntcPropuestaDet.findByHorinju", query = "SELECT p FROM PntcPropuestaDet p WHERE p.horinju = :horinju"),
    @NamedQuery(name = "PntcPropuestaDet.findByHorfinju", query = "SELECT p FROM PntcPropuestaDet p WHERE p.horfinju = :horfinju"),
    @NamedQuery(name = "PntcPropuestaDet.findByHorinvi", query = "SELECT p FROM PntcPropuestaDet p WHERE p.horinvi = :horinvi"),
    @NamedQuery(name = "PntcPropuestaDet.findByHorfinvi", query = "SELECT p FROM PntcPropuestaDet p WHERE p.horfinvi = :horfinvi"),
    @NamedQuery(name = "PntcPropuestaDet.findByHorinsa", query = "SELECT p FROM PntcPropuestaDet p WHERE p.horinsa = :horinsa"),
    @NamedQuery(name = "PntcPropuestaDet.findByHorfinsa", query = "SELECT p FROM PntcPropuestaDet p WHERE p.horfinsa = :horfinsa"),
    @NamedQuery(name = "PntcPropuestaDet.findByHorindo", query = "SELECT p FROM PntcPropuestaDet p WHERE p.horindo = :horindo"),
    @NamedQuery(name = "PntcPropuestaDet.findByHorfindo", query = "SELECT p FROM PntcPropuestaDet p WHERE p.horfindo = :horfindo"),
    @NamedQuery(name = "PntcPropuestaDet.findByHalu", query = "SELECT p FROM PntcPropuestaDet p WHERE p.halu = :halu"),
    @NamedQuery(name = "PntcPropuestaDet.findByHama", query = "SELECT p FROM PntcPropuestaDet p WHERE p.hama = :hama"),
    @NamedQuery(name = "PntcPropuestaDet.findByHami", query = "SELECT p FROM PntcPropuestaDet p WHERE p.hami = :hami"),
    @NamedQuery(name = "PntcPropuestaDet.findByHaju", query = "SELECT p FROM PntcPropuestaDet p WHERE p.haju = :haju"),
    @NamedQuery(name = "PntcPropuestaDet.findByHavi", query = "SELECT p FROM PntcPropuestaDet p WHERE p.havi = :havi"),
    @NamedQuery(name = "PntcPropuestaDet.findByHasa", query = "SELECT p FROM PntcPropuestaDet p WHERE p.hasa = :hasa"),
    @NamedQuery(name = "PntcPropuestaDet.findByHado", query = "SELECT p FROM PntcPropuestaDet p WHERE p.hado = :hado"),
    @NamedQuery(name = "PntcPropuestaDet.findByMinrecesolu", query = "SELECT p FROM PntcPropuestaDet p WHERE p.minrecesolu = :minrecesolu"),
    @NamedQuery(name = "PntcPropuestaDet.findByMinrecesoma", query = "SELECT p FROM PntcPropuestaDet p WHERE p.minrecesoma = :minrecesoma"),
    @NamedQuery(name = "PntcPropuestaDet.findByMinrecesomi", query = "SELECT p FROM PntcPropuestaDet p WHERE p.minrecesomi = :minrecesomi"),
    @NamedQuery(name = "PntcPropuestaDet.findByMinrecesoju", query = "SELECT p FROM PntcPropuestaDet p WHERE p.minrecesoju = :minrecesoju"),
    @NamedQuery(name = "PntcPropuestaDet.findByMinrecesovi", query = "SELECT p FROM PntcPropuestaDet p WHERE p.minrecesovi = :minrecesovi"),
    @NamedQuery(name = "PntcPropuestaDet.findByMinrecesosa", query = "SELECT p FROM PntcPropuestaDet p WHERE p.minrecesosa = :minrecesosa"),
    @NamedQuery(name = "PntcPropuestaDet.findByMinrecesodo", query = "SELECT p FROM PntcPropuestaDet p WHERE p.minrecesodo = :minrecesodo"),
    @NamedQuery(name = "PntcPropuestaDet.findByPs", query = "SELECT p FROM PntcPropuestaDet p WHERE p.ps = :ps"),
    @NamedQuery(name = "PntcPropuestaDet.findByAula", query = "SELECT p FROM PntcPropuestaDet p WHERE p.aula = :aula"),
    @NamedQuery(name = "PntcPropuestaDet.findByFecContDe", query = "SELECT p FROM PntcPropuestaDet p WHERE p.fecContDe = :fecContDe"),
    @NamedQuery(name = "PntcPropuestaDet.findByFecContA", query = "SELECT p FROM PntcPropuestaDet p WHERE p.fecContA = :fecContA"),
    @NamedQuery(name = "PntcPropuestaDet.findByObservacion", query = "SELECT p FROM PntcPropuestaDet p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "PntcPropuestaDet.findByActa", query = "SELECT p FROM PntcPropuestaDet p WHERE p.acta = :acta"),
    @NamedQuery(name = "PntcPropuestaDet.findByPunto", query = "SELECT p FROM PntcPropuestaDet p WHERE p.punto = :punto"),
    @NamedQuery(name = "PntcPropuestaDet.findByFechaResolucion", query = "SELECT p FROM PntcPropuestaDet p WHERE p.fechaResolucion = :fechaResolucion"),
    @NamedQuery(name = "PntcPropuestaDet.findByRechazado", query = "SELECT p FROM PntcPropuestaDet p WHERE p.rechazado = :rechazado"),
    @NamedQuery(name = "PntcPropuestaDet.findByPagoVeces", query = "SELECT p FROM PntcPropuestaDet p WHERE p.pagoVeces = :pagoVeces"),
    @NamedQuery(name = "PntcPropuestaDet.findByLinterinato", query = "SELECT p FROM PntcPropuestaDet p WHERE p.linterinato = :linterinato"),
    @NamedQuery(name = "PntcPropuestaDet.findByLpropuestaAutorizadoAdmin", query = "SELECT p FROM PntcPropuestaDet p WHERE p.lpropuestaAutorizadoAdmin = :lpropuestaAutorizadoAdmin"),
    @NamedQuery(name = "PntcPropuestaDet.findByLpropuestaIndefinida", query = "SELECT p FROM PntcPropuestaDet p WHERE p.lpropuestaIndefinida = :lpropuestaIndefinida"),
    @NamedQuery(name = "PntcPropuestaDet.findByFechaContratacion", query = "SELECT p FROM PntcPropuestaDet p WHERE p.fechaContratacion = :fechaContratacion"),
    @NamedQuery(name = "PntcPropuestaDet.findByUsuario", query = "SELECT p FROM PntcPropuestaDet p WHERE p.usuario = :usuario"),
    @NamedQuery(name = "PntcPropuestaDet.findByFechasys", query = "SELECT p FROM PntcPropuestaDet p WHERE p.fechasys = :fechasys"),
    @NamedQuery(name = "PntcPropuestaDet.findByMoodle", query = "SELECT p FROM PntcPropuestaDet p WHERE p.moodle = :moodle"),
    @NamedQuery(name = "PntcPropuestaDet.findByMoodleAsig", query = "SELECT p FROM PntcPropuestaDet p WHERE p.moodleAsig = :moodleAsig")})
public class PntcPropuestaDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ID_PNTC_PROPUESTA")
    private Integer idPntcPropuesta;
    @Column(name = "ID_PENSUM")
    private Integer idPensum;
    @Column(name = "ID_PENSUM_DET")
    private Integer idPensumDet;
    @Column(name = "ID_PNTC_IMPUESTOS")
    private Integer idPntcImpuestos;
    @Column(name = "ID_PNTC_TIPO_PROPUESTA")
    private Integer idPntcTipoPropuesta;
    @Column(name = "ID_PNTC_TIPO_PROPUESTA_DET")
    private Integer idPntcTipoPropuestaDet;
    @Column(name = "ID_PNTC_PROPUESTA_DET_UNIFICADO")
    private Integer idPntcPropuestaDetUnificado;
    @Column(name = "ID_PNTC_TIPO_PROPUESTA_PERFIL")
    private Integer idPntcTipoPropuestaPerfil;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IMPUESTO")
    private BigDecimal impuesto;
    @Column(name = "SECCION")
    private Character seccion;
    @Size(max = 5)
    @Column(name = "CODCAT")
    private String codcat;
    @Column(name = "TIPO_CATEDRATICO")
    private Integer tipoCatedratico;
    @Size(max = 5)
    @Column(name = "HORINLU")
    private String horinlu;
    @Size(max = 5)
    @Column(name = "HORFINLU")
    private String horfinlu;
    @Size(max = 5)
    @Column(name = "HORINMA")
    private String horinma;
    @Size(max = 5)
    @Column(name = "HORFINMA")
    private String horfinma;
    @Size(max = 5)
    @Column(name = "HORINMI")
    private String horinmi;
    @Size(max = 5)
    @Column(name = "HORFINMI")
    private String horfinmi;
    @Size(max = 5)
    @Column(name = "HORINJU")
    private String horinju;
    @Size(max = 5)
    @Column(name = "HORFINJU")
    private String horfinju;
    @Size(max = 5)
    @Column(name = "HORINVI")
    private String horinvi;
    @Size(max = 5)
    @Column(name = "HORFINVI")
    private String horfinvi;
    @Size(max = 5)
    @Column(name = "HORINSA")
    private String horinsa;
    @Size(max = 5)
    @Column(name = "HORFINSA")
    private String horfinsa;
    @Size(max = 5)
    @Column(name = "HORINDO")
    private String horindo;
    @Size(max = 5)
    @Column(name = "HORFINDO")
    private String horfindo;
    @Column(name = "HALU")
    private Character halu;
    @Column(name = "HAMA")
    private Character hama;
    @Column(name = "HAMI")
    private Character hami;
    @Column(name = "HAJU")
    private Character haju;
    @Column(name = "HAVI")
    private Character havi;
    @Column(name = "HASA")
    private Character hasa;
    @Column(name = "HADO")
    private Character hado;
    @Column(name = "MINRECESOLU")
    private Short minrecesolu;
    @Column(name = "MINRECESOMA")
    private Short minrecesoma;
    @Column(name = "MINRECESOMI")
    private Short minrecesomi;
    @Column(name = "MINRECESOJU")
    private Short minrecesoju;
    @Column(name = "MINRECESOVI")
    private Short minrecesovi;
    @Column(name = "MINRECESOSA")
    private Short minrecesosa;
    @Column(name = "MINRECESODO")
    private Short minrecesodo;
    @Column(name = "PS")
    private Short ps;
    @Size(max = 15)
    @Column(name = "AULA")
    private String aula;
    @Column(name = "FEC_CONT_DE")
    @Temporal(TemporalType.DATE)
    private Date fecContDe;
    @Column(name = "FEC_CONT_A")
    @Temporal(TemporalType.DATE)
    private Date fecContA;
    @Size(max = 100)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Size(max = 10)
    @Column(name = "ACTA")
    private String acta;
    @Size(max = 10)
    @Column(name = "PUNTO")
    private String punto;
    @Column(name = "FECHA_RESOLUCION")
    @Temporal(TemporalType.DATE)
    private Date fechaResolucion;
    @Size(max = 1)
    @Column(name = "RECHAZADO")
    private String rechazado;
    @Column(name = "PAGO_VECES")
    private Short pagoVeces;
    @Column(name = "LINTERINATO")
    private Character linterinato;
    @Column(name = "LPROPUESTA_AUTORIZADO_ADMIN")
    private Character lpropuestaAutorizadoAdmin;
    @Column(name = "LPROPUESTA_INDEFINIDA")
    private Character lpropuestaIndefinida;
    @Column(name = "FECHA_CONTRATACION")
    @Temporal(TemporalType.DATE)
    private Date fechaContratacion;
    @Size(max = 10)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHASYS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasys;
    @Column(name = "MOODLE")
    private Character moodle;
    @Column(name = "MOODLE_ASIG")
    private Character moodleAsig;

    public PntcPropuestaDet() {
    }

    public PntcPropuestaDet(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPntcPropuesta() {
        return idPntcPropuesta;
    }

    public void setIdPntcPropuesta(Integer idPntcPropuesta) {
        this.idPntcPropuesta = idPntcPropuesta;
    }

    public Integer getIdPensum() {
        return idPensum;
    }

    public void setIdPensum(Integer idPensum) {
        this.idPensum = idPensum;
    }

    public Integer getIdPensumDet() {
        return idPensumDet;
    }

    public void setIdPensumDet(Integer idPensumDet) {
        this.idPensumDet = idPensumDet;
    }

    public Integer getIdPntcImpuestos() {
        return idPntcImpuestos;
    }

    public void setIdPntcImpuestos(Integer idPntcImpuestos) {
        this.idPntcImpuestos = idPntcImpuestos;
    }

    public Integer getIdPntcTipoPropuesta() {
        return idPntcTipoPropuesta;
    }

    public void setIdPntcTipoPropuesta(Integer idPntcTipoPropuesta) {
        this.idPntcTipoPropuesta = idPntcTipoPropuesta;
    }

    public Integer getIdPntcTipoPropuestaDet() {
        return idPntcTipoPropuestaDet;
    }

    public void setIdPntcTipoPropuestaDet(Integer idPntcTipoPropuestaDet) {
        this.idPntcTipoPropuestaDet = idPntcTipoPropuestaDet;
    }

    public Integer getIdPntcPropuestaDetUnificado() {
        return idPntcPropuestaDetUnificado;
    }

    public void setIdPntcPropuestaDetUnificado(Integer idPntcPropuestaDetUnificado) {
        this.idPntcPropuestaDetUnificado = idPntcPropuestaDetUnificado;
    }

    public Integer getIdPntcTipoPropuestaPerfil() {
        return idPntcTipoPropuestaPerfil;
    }

    public void setIdPntcTipoPropuestaPerfil(Integer idPntcTipoPropuestaPerfil) {
        this.idPntcTipoPropuestaPerfil = idPntcTipoPropuestaPerfil;
    }

    public BigDecimal getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(BigDecimal impuesto) {
        this.impuesto = impuesto;
    }

    public Character getSeccion() {
        return seccion;
    }

    public void setSeccion(Character seccion) {
        this.seccion = seccion;
    }

    public String getCodcat() {
        return codcat;
    }

    public void setCodcat(String codcat) {
        this.codcat = codcat;
    }

    public Integer getTipoCatedratico() {
        return tipoCatedratico;
    }

    public void setTipoCatedratico(Integer tipoCatedratico) {
        this.tipoCatedratico = tipoCatedratico;
    }

    public String getHorinlu() {
        return horinlu;
    }

    public void setHorinlu(String horinlu) {
        this.horinlu = horinlu;
    }

    public String getHorfinlu() {
        return horfinlu;
    }

    public void setHorfinlu(String horfinlu) {
        this.horfinlu = horfinlu;
    }

    public String getHorinma() {
        return horinma;
    }

    public void setHorinma(String horinma) {
        this.horinma = horinma;
    }

    public String getHorfinma() {
        return horfinma;
    }

    public void setHorfinma(String horfinma) {
        this.horfinma = horfinma;
    }

    public String getHorinmi() {
        return horinmi;
    }

    public void setHorinmi(String horinmi) {
        this.horinmi = horinmi;
    }

    public String getHorfinmi() {
        return horfinmi;
    }

    public void setHorfinmi(String horfinmi) {
        this.horfinmi = horfinmi;
    }

    public String getHorinju() {
        return horinju;
    }

    public void setHorinju(String horinju) {
        this.horinju = horinju;
    }

    public String getHorfinju() {
        return horfinju;
    }

    public void setHorfinju(String horfinju) {
        this.horfinju = horfinju;
    }

    public String getHorinvi() {
        return horinvi;
    }

    public void setHorinvi(String horinvi) {
        this.horinvi = horinvi;
    }

    public String getHorfinvi() {
        return horfinvi;
    }

    public void setHorfinvi(String horfinvi) {
        this.horfinvi = horfinvi;
    }

    public String getHorinsa() {
        return horinsa;
    }

    public void setHorinsa(String horinsa) {
        this.horinsa = horinsa;
    }

    public String getHorfinsa() {
        return horfinsa;
    }

    public void setHorfinsa(String horfinsa) {
        this.horfinsa = horfinsa;
    }

    public String getHorindo() {
        return horindo;
    }

    public void setHorindo(String horindo) {
        this.horindo = horindo;
    }

    public String getHorfindo() {
        return horfindo;
    }

    public void setHorfindo(String horfindo) {
        this.horfindo = horfindo;
    }

    public Character getHalu() {
        return halu;
    }

    public void setHalu(Character halu) {
        this.halu = halu;
    }

    public Character getHama() {
        return hama;
    }

    public void setHama(Character hama) {
        this.hama = hama;
    }

    public Character getHami() {
        return hami;
    }

    public void setHami(Character hami) {
        this.hami = hami;
    }

    public Character getHaju() {
        return haju;
    }

    public void setHaju(Character haju) {
        this.haju = haju;
    }

    public Character getHavi() {
        return havi;
    }

    public void setHavi(Character havi) {
        this.havi = havi;
    }

    public Character getHasa() {
        return hasa;
    }

    public void setHasa(Character hasa) {
        this.hasa = hasa;
    }

    public Character getHado() {
        return hado;
    }

    public void setHado(Character hado) {
        this.hado = hado;
    }

    public Short getMinrecesolu() {
        return minrecesolu;
    }

    public void setMinrecesolu(Short minrecesolu) {
        this.minrecesolu = minrecesolu;
    }

    public Short getMinrecesoma() {
        return minrecesoma;
    }

    public void setMinrecesoma(Short minrecesoma) {
        this.minrecesoma = minrecesoma;
    }

    public Short getMinrecesomi() {
        return minrecesomi;
    }

    public void setMinrecesomi(Short minrecesomi) {
        this.minrecesomi = minrecesomi;
    }

    public Short getMinrecesoju() {
        return minrecesoju;
    }

    public void setMinrecesoju(Short minrecesoju) {
        this.minrecesoju = minrecesoju;
    }

    public Short getMinrecesovi() {
        return minrecesovi;
    }

    public void setMinrecesovi(Short minrecesovi) {
        this.minrecesovi = minrecesovi;
    }

    public Short getMinrecesosa() {
        return minrecesosa;
    }

    public void setMinrecesosa(Short minrecesosa) {
        this.minrecesosa = minrecesosa;
    }

    public Short getMinrecesodo() {
        return minrecesodo;
    }

    public void setMinrecesodo(Short minrecesodo) {
        this.minrecesodo = minrecesodo;
    }

    public Short getPs() {
        return ps;
    }

    public void setPs(Short ps) {
        this.ps = ps;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public Date getFecContDe() {
        return fecContDe;
    }

    public void setFecContDe(Date fecContDe) {
        this.fecContDe = fecContDe;
    }

    public Date getFecContA() {
        return fecContA;
    }

    public void setFecContA(Date fecContA) {
        this.fecContA = fecContA;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getActa() {
        return acta;
    }

    public void setActa(String acta) {
        this.acta = acta;
    }

    public String getPunto() {
        return punto;
    }

    public void setPunto(String punto) {
        this.punto = punto;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public String getRechazado() {
        return rechazado;
    }

    public void setRechazado(String rechazado) {
        this.rechazado = rechazado;
    }

    public Short getPagoVeces() {
        return pagoVeces;
    }

    public void setPagoVeces(Short pagoVeces) {
        this.pagoVeces = pagoVeces;
    }

    public Character getLinterinato() {
        return linterinato;
    }

    public void setLinterinato(Character linterinato) {
        this.linterinato = linterinato;
    }

    public Character getLpropuestaAutorizadoAdmin() {
        return lpropuestaAutorizadoAdmin;
    }

    public void setLpropuestaAutorizadoAdmin(Character lpropuestaAutorizadoAdmin) {
        this.lpropuestaAutorizadoAdmin = lpropuestaAutorizadoAdmin;
    }

    public Character getLpropuestaIndefinida() {
        return lpropuestaIndefinida;
    }

    public void setLpropuestaIndefinida(Character lpropuestaIndefinida) {
        this.lpropuestaIndefinida = lpropuestaIndefinida;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
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

    public Character getMoodle() {
        return moodle;
    }

    public void setMoodle(Character moodle) {
        this.moodle = moodle;
    }

    public Character getMoodleAsig() {
        return moodleAsig;
    }

    public void setMoodleAsig(Character moodleAsig) {
        this.moodleAsig = moodleAsig;
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
        if (!(object instanceof PntcPropuestaDet)) {
            return false;
        }
        PntcPropuestaDet other = (PntcPropuestaDet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PntcPropuestaDet[ id=" + id + " ]";
    }
    
}
