/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

/**
 *
 * @author mmarvin
 */
@Entity
@Table(name = "ACAD_CARRERAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcadCarreras.findAll", query = "SELECT a FROM AcadCarreras a"),
    @NamedQuery(name = "AcadCarreras.findById", query = "SELECT a FROM AcadCarreras a WHERE a.id = :id"),
    @NamedQuery(name = "AcadCarreras.findByCarrera", query = "SELECT a FROM AcadCarreras a WHERE a.carrera = :carrera"),
    @NamedQuery(name = "AcadCarreras.findByNombre", query = "SELECT a FROM AcadCarreras a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "AcadCarreras.findByFacultad", query = "SELECT a FROM AcadCarreras a WHERE a.facultad = :facultad"),
    @NamedQuery(name = "AcadCarreras.findByDecano", query = "SELECT a FROM AcadCarreras a WHERE a.decano = :decano"),
    @NamedQuery(name = "AcadCarreras.findByTituloDec", query = "SELECT a FROM AcadCarreras a WHERE a.tituloDec = :tituloDec"),
    @NamedQuery(name = "AcadCarreras.findByTituloAbr", query = "SELECT a FROM AcadCarreras a WHERE a.tituloAbr = :tituloAbr"),
    @NamedQuery(name = "AcadCarreras.findByInsord", query = "SELECT a FROM AcadCarreras a WHERE a.insord = :insord"),
    @NamedQuery(name = "AcadCarreras.findByInsext", query = "SELECT a FROM AcadCarreras a WHERE a.insext = :insext"),
    @NamedQuery(name = "AcadCarreras.findByCurso1", query = "SELECT a FROM AcadCarreras a WHERE a.curso1 = :curso1"),
    @NamedQuery(name = "AcadCarreras.findByCurso2", query = "SELECT a FROM AcadCarreras a WHERE a.curso2 = :curso2"),
    @NamedQuery(name = "AcadCarreras.findByCurso3", query = "SELECT a FROM AcadCarreras a WHERE a.curso3 = :curso3"),
    @NamedQuery(name = "AcadCarreras.findByCurso4", query = "SELECT a FROM AcadCarreras a WHERE a.curso4 = :curso4"),
    @NamedQuery(name = "AcadCarreras.findByCurso5", query = "SELECT a FROM AcadCarreras a WHERE a.curso5 = :curso5"),
    @NamedQuery(name = "AcadCarreras.findByCurso6", query = "SELECT a FROM AcadCarreras a WHERE a.curso6 = :curso6"),
    @NamedQuery(name = "AcadCarreras.findByCurso7", query = "SELECT a FROM AcadCarreras a WHERE a.curso7 = :curso7"),
    @NamedQuery(name = "AcadCarreras.findByCurso8", query = "SELECT a FROM AcadCarreras a WHERE a.curso8 = :curso8"),
    @NamedQuery(name = "AcadCarreras.findByCurso9", query = "SELECT a FROM AcadCarreras a WHERE a.curso9 = :curso9"),
    @NamedQuery(name = "AcadCarreras.findByCurso10", query = "SELECT a FROM AcadCarreras a WHERE a.curso10 = :curso10"),
    @NamedQuery(name = "AcadCarreras.findByLaborat", query = "SELECT a FROM AcadCarreras a WHERE a.laborat = :laborat"),
    @NamedQuery(name = "AcadCarreras.findByXcurso1", query = "SELECT a FROM AcadCarreras a WHERE a.xcurso1 = :xcurso1"),
    @NamedQuery(name = "AcadCarreras.findByXcurso2", query = "SELECT a FROM AcadCarreras a WHERE a.xcurso2 = :xcurso2"),
    @NamedQuery(name = "AcadCarreras.findByXcurso3", query = "SELECT a FROM AcadCarreras a WHERE a.xcurso3 = :xcurso3"),
    @NamedQuery(name = "AcadCarreras.findByXcurso4", query = "SELECT a FROM AcadCarreras a WHERE a.xcurso4 = :xcurso4"),
    @NamedQuery(name = "AcadCarreras.findByXcurso5", query = "SELECT a FROM AcadCarreras a WHERE a.xcurso5 = :xcurso5"),
    @NamedQuery(name = "AcadCarreras.findByXcurso6", query = "SELECT a FROM AcadCarreras a WHERE a.xcurso6 = :xcurso6"),
    @NamedQuery(name = "AcadCarreras.findByXcurso7", query = "SELECT a FROM AcadCarreras a WHERE a.xcurso7 = :xcurso7"),
    @NamedQuery(name = "AcadCarreras.findByXcurso8", query = "SELECT a FROM AcadCarreras a WHERE a.xcurso8 = :xcurso8"),
    @NamedQuery(name = "AcadCarreras.findByXcurso9", query = "SELECT a FROM AcadCarreras a WHERE a.xcurso9 = :xcurso9"),
    @NamedQuery(name = "AcadCarreras.findByXcurso10", query = "SELECT a FROM AcadCarreras a WHERE a.xcurso10 = :xcurso10"),
    @NamedQuery(name = "AcadCarreras.findByTipCic", query = "SELECT a FROM AcadCarreras a WHERE a.tipCic = :tipCic"),
    @NamedQuery(name = "AcadCarreras.findByIdTipoCarrera", query = "SELECT a FROM AcadCarreras a WHERE a.idTipoCarrera = :idTipoCarrera"),
    @NamedQuery(name = "AcadCarreras.findByDepto", query = "SELECT a FROM AcadCarreras a WHERE a.depto = :depto"),
    @NamedQuery(name = "AcadCarreras.findByPlanilla", query = "SELECT a FROM AcadCarreras a WHERE a.planilla = :planilla"),
    @NamedQuery(name = "AcadCarreras.findByLabsist", query = "SELECT a FROM AcadCarreras a WHERE a.labsist = :labsist"),
    @NamedQuery(name = "AcadCarreras.findByNlaboratorioSis", query = "SELECT a FROM AcadCarreras a WHERE a.nlaboratorioSis = :nlaboratorioSis"),
    @NamedQuery(name = "AcadCarreras.findByMontolaboratorioSis", query = "SELECT a FROM AcadCarreras a WHERE a.montolaboratorioSis = :montolaboratorioSis"),
    @NamedQuery(name = "AcadCarreras.findByArancelEsp", query = "SELECT a FROM AcadCarreras a WHERE a.arancelEsp = :arancelEsp"),
    @NamedQuery(name = "AcadCarreras.findByInsclinica", query = "SELECT a FROM AcadCarreras a WHERE a.insclinica = :insclinica"),
    @NamedQuery(name = "AcadCarreras.findByTransporte", query = "SELECT a FROM AcadCarreras a WHERE a.transporte = :transporte"),
    @NamedQuery(name = "AcadCarreras.findByValorTran", query = "SELECT a FROM AcadCarreras a WHERE a.valorTran = :valorTran"),
    @NamedQuery(name = "AcadCarreras.findByZonaMin", query = "SELECT a FROM AcadCarreras a WHERE a.zonaMin = :zonaMin"),
    @NamedQuery(name = "AcadCarreras.findByPunteoMin", query = "SELECT a FROM AcadCarreras a WHERE a.punteoMin = :punteoMin"),
    @NamedQuery(name = "AcadCarreras.findByZonaMax", query = "SELECT a FROM AcadCarreras a WHERE a.zonaMax = :zonaMax"),
    @NamedQuery(name = "AcadCarreras.findByRetMedic", query = "SELECT a FROM AcadCarreras a WHERE a.retMedic = :retMedic"),
    @NamedQuery(name = "AcadCarreras.findByRetrasada2", query = "SELECT a FROM AcadCarreras a WHERE a.retrasada2 = :retrasada2"),
    @NamedQuery(name = "AcadCarreras.findByInsexp", query = "SELECT a FROM AcadCarreras a WHERE a.insexp = :insexp"),
    @NamedQuery(name = "AcadCarreras.findByInstruc1", query = "SELECT a FROM AcadCarreras a WHERE a.instruc1 = :instruc1"),
    @NamedQuery(name = "AcadCarreras.findByInstruc2", query = "SELECT a FROM AcadCarreras a WHERE a.instruc2 = :instruc2"),
    @NamedQuery(name = "AcadCarreras.findByInstruc3", query = "SELECT a FROM AcadCarreras a WHERE a.instruc3 = :instruc3"),
    @NamedQuery(name = "AcadCarreras.findByInstruc4", query = "SELECT a FROM AcadCarreras a WHERE a.instruc4 = :instruc4"),
    @NamedQuery(name = "AcadCarreras.findByCodMadre", query = "SELECT a FROM AcadCarreras a WHERE a.codMadre = :codMadre"),
    @NamedQuery(name = "AcadCarreras.findByFecOrdi", query = "SELECT a FROM AcadCarreras a WHERE a.fecOrdi = :fecOrdi"),
    @NamedQuery(name = "AcadCarreras.findByFecOrdf", query = "SELECT a FROM AcadCarreras a WHERE a.fecOrdf = :fecOrdf"),
    @NamedQuery(name = "AcadCarreras.findByFecExti", query = "SELECT a FROM AcadCarreras a WHERE a.fecExti = :fecExti"),
    @NamedQuery(name = "AcadCarreras.findByFecExtf", query = "SELECT a FROM AcadCarreras a WHERE a.fecExtf = :fecExtf"),
    @NamedQuery(name = "AcadCarreras.findByInsordrep", query = "SELECT a FROM AcadCarreras a WHERE a.insordrep = :insordrep"),
    @NamedQuery(name = "AcadCarreras.findByInsextrep", query = "SELECT a FROM AcadCarreras a WHERE a.insextrep = :insextrep"),
    @NamedQuery(name = "AcadCarreras.findByInsexprep", query = "SELECT a FROM AcadCarreras a WHERE a.insexprep = :insexprep"),
    @NamedQuery(name = "AcadCarreras.findByInsordpc", query = "SELECT a FROM AcadCarreras a WHERE a.insordpc = :insordpc"),
    @NamedQuery(name = "AcadCarreras.findByInsextpc", query = "SELECT a FROM AcadCarreras a WHERE a.insextpc = :insextpc"),
    @NamedQuery(name = "AcadCarreras.findByInsexppc", query = "SELECT a FROM AcadCarreras a WHERE a.insexppc = :insexppc"),
    @NamedQuery(name = "AcadCarreras.findByCurso1rep", query = "SELECT a FROM AcadCarreras a WHERE a.curso1rep = :curso1rep"),
    @NamedQuery(name = "AcadCarreras.findByCurso2rep", query = "SELECT a FROM AcadCarreras a WHERE a.curso2rep = :curso2rep"),
    @NamedQuery(name = "AcadCarreras.findByCurso3rep", query = "SELECT a FROM AcadCarreras a WHERE a.curso3rep = :curso3rep"),
    @NamedQuery(name = "AcadCarreras.findByCurso4rep", query = "SELECT a FROM AcadCarreras a WHERE a.curso4rep = :curso4rep"),
    @NamedQuery(name = "AcadCarreras.findByCurso5rep", query = "SELECT a FROM AcadCarreras a WHERE a.curso5rep = :curso5rep"),
    @NamedQuery(name = "AcadCarreras.findByCurso6rep", query = "SELECT a FROM AcadCarreras a WHERE a.curso6rep = :curso6rep"),
    @NamedQuery(name = "AcadCarreras.findByCurso7rep", query = "SELECT a FROM AcadCarreras a WHERE a.curso7rep = :curso7rep"),
    @NamedQuery(name = "AcadCarreras.findByCurso8rep", query = "SELECT a FROM AcadCarreras a WHERE a.curso8rep = :curso8rep"),
    @NamedQuery(name = "AcadCarreras.findByCurso9rep", query = "SELECT a FROM AcadCarreras a WHERE a.curso9rep = :curso9rep"),
    @NamedQuery(name = "AcadCarreras.findByCurso10rep", query = "SELECT a FROM AcadCarreras a WHERE a.curso10rep = :curso10rep"),
    @NamedQuery(name = "AcadCarreras.findByCurso1pc", query = "SELECT a FROM AcadCarreras a WHERE a.curso1pc = :curso1pc"),
    @NamedQuery(name = "AcadCarreras.findByCurso2pc", query = "SELECT a FROM AcadCarreras a WHERE a.curso2pc = :curso2pc"),
    @NamedQuery(name = "AcadCarreras.findByCurso3pc", query = "SELECT a FROM AcadCarreras a WHERE a.curso3pc = :curso3pc"),
    @NamedQuery(name = "AcadCarreras.findByCurso4pc", query = "SELECT a FROM AcadCarreras a WHERE a.curso4pc = :curso4pc"),
    @NamedQuery(name = "AcadCarreras.findByCurso5pc", query = "SELECT a FROM AcadCarreras a WHERE a.curso5pc = :curso5pc"),
    @NamedQuery(name = "AcadCarreras.findByCurso6pc", query = "SELECT a FROM AcadCarreras a WHERE a.curso6pc = :curso6pc"),
    @NamedQuery(name = "AcadCarreras.findByCurso7pc", query = "SELECT a FROM AcadCarreras a WHERE a.curso7pc = :curso7pc"),
    @NamedQuery(name = "AcadCarreras.findByCurso8pc", query = "SELECT a FROM AcadCarreras a WHERE a.curso8pc = :curso8pc"),
    @NamedQuery(name = "AcadCarreras.findByCurso9pc", query = "SELECT a FROM AcadCarreras a WHERE a.curso9pc = :curso9pc"),
    @NamedQuery(name = "AcadCarreras.findByCurso10pc", query = "SELECT a FROM AcadCarreras a WHERE a.curso10pc = :curso10pc"),
    @NamedQuery(name = "AcadCarreras.findByValidaHorarioLab", query = "SELECT a FROM AcadCarreras a WHERE a.validaHorarioLab = :validaHorarioLab"),
    @NamedQuery(name = "AcadCarreras.findByIdJornada", query = "SELECT a FROM AcadCarreras a WHERE a.idJornada = :idJornada"),
    @NamedQuery(name = "AcadCarreras.findByIngles", query = "SELECT a FROM AcadCarreras a WHERE a.ingles = :ingles"),
    @NamedQuery(name = "AcadCarreras.findByPreguntaTraslape", query = "SELECT a FROM AcadCarreras a WHERE a.preguntaTraslape = :preguntaTraslape"),
    @NamedQuery(name = "AcadCarreras.findByUsuario", query = "SELECT a FROM AcadCarreras a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "AcadCarreras.findByFechasys", query = "SELECT a FROM AcadCarreras a WHERE a.fechasys = :fechasys"),
    @NamedQuery(name = "AcadCarreras.findByAsignaWeb", query = "SELECT a FROM AcadCarreras a WHERE a.asignaWeb = :asignaWeb"),
    @NamedQuery(name = "AcadCarreras.findByPreReq", query = "SELECT a FROM AcadCarreras a WHERE a.preReq = :preReq")})
public class AcadCarreras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CARRERA")
    private String carrera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 125)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name = "FACULTAD")
    private String facultad;
    @Size(max = 50)
    @Column(name = "DECANO")
    private String decano;
    @Size(max = 15)
    @Column(name = "TITULO_DEC")
    private String tituloDec;
    @Size(max = 4)
    @Column(name = "TITULO_ABR")
    private String tituloAbr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "INSORD")
    private BigDecimal insord;
    @Column(name = "INSEXT")
    private BigDecimal insext;
    @Column(name = "CURSO1")
    private BigDecimal curso1;
    @Column(name = "CURSO2")
    private BigDecimal curso2;
    @Column(name = "CURSO3")
    private BigDecimal curso3;
    @Column(name = "CURSO4")
    private BigDecimal curso4;
    @Column(name = "CURSO5")
    private BigDecimal curso5;
    @Column(name = "CURSO6")
    private BigDecimal curso6;
    @Column(name = "CURSO7")
    private BigDecimal curso7;
    @Column(name = "CURSO8")
    private BigDecimal curso8;
    @Column(name = "CURSO9")
    private BigDecimal curso9;
    @Column(name = "CURSO10")
    private BigDecimal curso10;
    @Column(name = "LABORAT")
    private BigDecimal laborat;
    @Column(name = "XCURSO1")
    private BigDecimal xcurso1;
    @Column(name = "XCURSO2")
    private BigDecimal xcurso2;
    @Column(name = "XCURSO3")
    private BigDecimal xcurso3;
    @Column(name = "XCURSO4")
    private BigDecimal xcurso4;
    @Column(name = "XCURSO5")
    private BigDecimal xcurso5;
    @Column(name = "XCURSO6")
    private BigDecimal xcurso6;
    @Column(name = "XCURSO7")
    private BigDecimal xcurso7;
    @Column(name = "XCURSO8")
    private BigDecimal xcurso8;
    @Column(name = "XCURSO9")
    private BigDecimal xcurso9;
    @Column(name = "XCURSO10")
    private BigDecimal xcurso10;
    @Column(name = "TIP_CIC")
    private Integer tipCic;
    @Column(name = "ID_TIPO_CARRERA")
    private Integer idTipoCarrera;
    @Size(max = 3)
    @Column(name = "DEPTO")
    private String depto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLANILLA")
    private char planilla;
    @Column(name = "LABSIST")
    private Character labsist;
    @Column(name = "NLABORATORIO_SIS")
    private Integer nlaboratorioSis;
    @Column(name = "MONTOLABORATORIO_SIS")
    private BigDecimal montolaboratorioSis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ARANCEL_ESP")
    private char arancelEsp;
    @Column(name = "INSCLINICA")
    private BigDecimal insclinica;
    @Column(name = "TRANSPORTE")
    private Character transporte;
    @Column(name = "VALOR_TRAN")
    private BigDecimal valorTran;
    @Column(name = "ZONA_MIN")
    private BigDecimal zonaMin;
    @Column(name = "PUNTEO_MIN")
    private BigDecimal punteoMin;
    @Column(name = "ZONA_MAX")
    private BigDecimal zonaMax;
    @Column(name = "RET_MEDIC")
    private Character retMedic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RETRASADA2")
    private char retrasada2;
    @Column(name = "INSEXP")
    private BigDecimal insexp;
    @Size(max = 40)
    @Column(name = "INSTRUC1")
    private String instruc1;
    @Size(max = 40)
    @Column(name = "INSTRUC2")
    private String instruc2;
    @Size(max = 40)
    @Column(name = "INSTRUC3")
    private String instruc3;
    @Size(max = 40)
    @Column(name = "INSTRUC4")
    private String instruc4;
    @Size(max = 4)
    @Column(name = "COD_MADRE")
    private String codMadre;
    @Column(name = "FEC_ORDI")
    @Temporal(TemporalType.DATE)
    private Date fecOrdi;
    @Column(name = "FEC_ORDF")
    @Temporal(TemporalType.DATE)
    private Date fecOrdf;
    @Column(name = "FEC_EXTI")
    @Temporal(TemporalType.DATE)
    private Date fecExti;
    @Column(name = "FEC_EXTF")
    @Temporal(TemporalType.DATE)
    private Date fecExtf;
    @Column(name = "INSORDREP")
    private BigDecimal insordrep;
    @Column(name = "INSEXTREP")
    private BigDecimal insextrep;
    @Column(name = "INSEXPREP")
    private BigDecimal insexprep;
    @Column(name = "INSORDPC")
    private BigDecimal insordpc;
    @Column(name = "INSEXTPC")
    private BigDecimal insextpc;
    @Column(name = "INSEXPPC")
    private BigDecimal insexppc;
    @Column(name = "CURSO1REP")
    private BigDecimal curso1rep;
    @Column(name = "CURSO2REP")
    private BigDecimal curso2rep;
    @Column(name = "CURSO3REP")
    private BigDecimal curso3rep;
    @Column(name = "CURSO4REP")
    private BigDecimal curso4rep;
    @Column(name = "CURSO5REP")
    private BigDecimal curso5rep;
    @Column(name = "CURSO6REP")
    private BigDecimal curso6rep;
    @Column(name = "CURSO7REP")
    private BigDecimal curso7rep;
    @Column(name = "CURSO8REP")
    private BigDecimal curso8rep;
    @Column(name = "CURSO9REP")
    private BigDecimal curso9rep;
    @Column(name = "CURSO10REP")
    private BigDecimal curso10rep;
    @Column(name = "CURSO1PC")
    private BigDecimal curso1pc;
    @Column(name = "CURSO2PC")
    private BigDecimal curso2pc;
    @Column(name = "CURSO3PC")
    private BigDecimal curso3pc;
    @Column(name = "CURSO4PC")
    private BigDecimal curso4pc;
    @Column(name = "CURSO5PC")
    private BigDecimal curso5pc;
    @Column(name = "CURSO6PC")
    private BigDecimal curso6pc;
    @Column(name = "CURSO7PC")
    private BigDecimal curso7pc;
    @Column(name = "CURSO8PC")
    private BigDecimal curso8pc;
    @Column(name = "CURSO9PC")
    private BigDecimal curso9pc;
    @Column(name = "CURSO10PC")
    private BigDecimal curso10pc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALIDA_HORARIO_LAB")
    private char validaHorarioLab;
    @Column(name = "ID_JORNADA")
    private Integer idJornada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INGLES")
    private char ingles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PREGUNTA_TRASLAPE")
    private char preguntaTraslape;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHASYS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasys;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASIGNA_WEB")
    private char asignaWeb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRE_REQ")
    private char preReq;

    public AcadCarreras() {
    }

    public AcadCarreras(Integer id) {
        this.id = id;
    }

    public AcadCarreras(Integer id, String carrera, String nombre, char planilla, char arancelEsp, char retrasada2, char validaHorarioLab, char ingles, char preguntaTraslape, String usuario, char asignaWeb, char preReq) {
        this.id = id;
        this.carrera = carrera;
        this.nombre = nombre;
        this.planilla = planilla;
        this.arancelEsp = arancelEsp;
        this.retrasada2 = retrasada2;
        this.validaHorarioLab = validaHorarioLab;
        this.ingles = ingles;
        this.preguntaTraslape = preguntaTraslape;
        this.usuario = usuario;
        this.asignaWeb = asignaWeb;
        this.preReq = preReq;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getDecano() {
        return decano;
    }

    public void setDecano(String decano) {
        this.decano = decano;
    }

    public String getTituloDec() {
        return tituloDec;
    }

    public void setTituloDec(String tituloDec) {
        this.tituloDec = tituloDec;
    }

    public String getTituloAbr() {
        return tituloAbr;
    }

    public void setTituloAbr(String tituloAbr) {
        this.tituloAbr = tituloAbr;
    }

    public BigDecimal getInsord() {
        return insord;
    }

    public void setInsord(BigDecimal insord) {
        this.insord = insord;
    }

    public BigDecimal getInsext() {
        return insext;
    }

    public void setInsext(BigDecimal insext) {
        this.insext = insext;
    }

    public BigDecimal getCurso1() {
        return curso1;
    }

    public void setCurso1(BigDecimal curso1) {
        this.curso1 = curso1;
    }

    public BigDecimal getCurso2() {
        return curso2;
    }

    public void setCurso2(BigDecimal curso2) {
        this.curso2 = curso2;
    }

    public BigDecimal getCurso3() {
        return curso3;
    }

    public void setCurso3(BigDecimal curso3) {
        this.curso3 = curso3;
    }

    public BigDecimal getCurso4() {
        return curso4;
    }

    public void setCurso4(BigDecimal curso4) {
        this.curso4 = curso4;
    }

    public BigDecimal getCurso5() {
        return curso5;
    }

    public void setCurso5(BigDecimal curso5) {
        this.curso5 = curso5;
    }

    public BigDecimal getCurso6() {
        return curso6;
    }

    public void setCurso6(BigDecimal curso6) {
        this.curso6 = curso6;
    }

    public BigDecimal getCurso7() {
        return curso7;
    }

    public void setCurso7(BigDecimal curso7) {
        this.curso7 = curso7;
    }

    public BigDecimal getCurso8() {
        return curso8;
    }

    public void setCurso8(BigDecimal curso8) {
        this.curso8 = curso8;
    }

    public BigDecimal getCurso9() {
        return curso9;
    }

    public void setCurso9(BigDecimal curso9) {
        this.curso9 = curso9;
    }

    public BigDecimal getCurso10() {
        return curso10;
    }

    public void setCurso10(BigDecimal curso10) {
        this.curso10 = curso10;
    }

    public BigDecimal getLaborat() {
        return laborat;
    }

    public void setLaborat(BigDecimal laborat) {
        this.laborat = laborat;
    }

    public BigDecimal getXcurso1() {
        return xcurso1;
    }

    public void setXcurso1(BigDecimal xcurso1) {
        this.xcurso1 = xcurso1;
    }

    public BigDecimal getXcurso2() {
        return xcurso2;
    }

    public void setXcurso2(BigDecimal xcurso2) {
        this.xcurso2 = xcurso2;
    }

    public BigDecimal getXcurso3() {
        return xcurso3;
    }

    public void setXcurso3(BigDecimal xcurso3) {
        this.xcurso3 = xcurso3;
    }

    public BigDecimal getXcurso4() {
        return xcurso4;
    }

    public void setXcurso4(BigDecimal xcurso4) {
        this.xcurso4 = xcurso4;
    }

    public BigDecimal getXcurso5() {
        return xcurso5;
    }

    public void setXcurso5(BigDecimal xcurso5) {
        this.xcurso5 = xcurso5;
    }

    public BigDecimal getXcurso6() {
        return xcurso6;
    }

    public void setXcurso6(BigDecimal xcurso6) {
        this.xcurso6 = xcurso6;
    }

    public BigDecimal getXcurso7() {
        return xcurso7;
    }

    public void setXcurso7(BigDecimal xcurso7) {
        this.xcurso7 = xcurso7;
    }

    public BigDecimal getXcurso8() {
        return xcurso8;
    }

    public void setXcurso8(BigDecimal xcurso8) {
        this.xcurso8 = xcurso8;
    }

    public BigDecimal getXcurso9() {
        return xcurso9;
    }

    public void setXcurso9(BigDecimal xcurso9) {
        this.xcurso9 = xcurso9;
    }

    public BigDecimal getXcurso10() {
        return xcurso10;
    }

    public void setXcurso10(BigDecimal xcurso10) {
        this.xcurso10 = xcurso10;
    }

    public Integer getTipCic() {
        return tipCic;
    }

    public void setTipCic(Integer tipCic) {
        this.tipCic = tipCic;
    }

    public Integer getIdTipoCarrera() {
        return idTipoCarrera;
    }

    public void setIdTipoCarrera(Integer idTipoCarrera) {
        this.idTipoCarrera = idTipoCarrera;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public char getPlanilla() {
        return planilla;
    }

    public void setPlanilla(char planilla) {
        this.planilla = planilla;
    }

    public Character getLabsist() {
        return labsist;
    }

    public void setLabsist(Character labsist) {
        this.labsist = labsist;
    }

    public Integer getNlaboratorioSis() {
        return nlaboratorioSis;
    }

    public void setNlaboratorioSis(Integer nlaboratorioSis) {
        this.nlaboratorioSis = nlaboratorioSis;
    }

    public BigDecimal getMontolaboratorioSis() {
        return montolaboratorioSis;
    }

    public void setMontolaboratorioSis(BigDecimal montolaboratorioSis) {
        this.montolaboratorioSis = montolaboratorioSis;
    }

    public char getArancelEsp() {
        return arancelEsp;
    }

    public void setArancelEsp(char arancelEsp) {
        this.arancelEsp = arancelEsp;
    }

    public BigDecimal getInsclinica() {
        return insclinica;
    }

    public void setInsclinica(BigDecimal insclinica) {
        this.insclinica = insclinica;
    }

    public Character getTransporte() {
        return transporte;
    }

    public void setTransporte(Character transporte) {
        this.transporte = transporte;
    }

    public BigDecimal getValorTran() {
        return valorTran;
    }

    public void setValorTran(BigDecimal valorTran) {
        this.valorTran = valorTran;
    }

    public BigDecimal getZonaMin() {
        return zonaMin;
    }

    public void setZonaMin(BigDecimal zonaMin) {
        this.zonaMin = zonaMin;
    }

    public BigDecimal getPunteoMin() {
        return punteoMin;
    }

    public void setPunteoMin(BigDecimal punteoMin) {
        this.punteoMin = punteoMin;
    }

    public BigDecimal getZonaMax() {
        return zonaMax;
    }

    public void setZonaMax(BigDecimal zonaMax) {
        this.zonaMax = zonaMax;
    }

    public Character getRetMedic() {
        return retMedic;
    }

    public void setRetMedic(Character retMedic) {
        this.retMedic = retMedic;
    }

    public char getRetrasada2() {
        return retrasada2;
    }

    public void setRetrasada2(char retrasada2) {
        this.retrasada2 = retrasada2;
    }

    public BigDecimal getInsexp() {
        return insexp;
    }

    public void setInsexp(BigDecimal insexp) {
        this.insexp = insexp;
    }

    public String getInstruc1() {
        return instruc1;
    }

    public void setInstruc1(String instruc1) {
        this.instruc1 = instruc1;
    }

    public String getInstruc2() {
        return instruc2;
    }

    public void setInstruc2(String instruc2) {
        this.instruc2 = instruc2;
    }

    public String getInstruc3() {
        return instruc3;
    }

    public void setInstruc3(String instruc3) {
        this.instruc3 = instruc3;
    }

    public String getInstruc4() {
        return instruc4;
    }

    public void setInstruc4(String instruc4) {
        this.instruc4 = instruc4;
    }

    public String getCodMadre() {
        return codMadre;
    }

    public void setCodMadre(String codMadre) {
        this.codMadre = codMadre;
    }

    public Date getFecOrdi() {
        return fecOrdi;
    }

    public void setFecOrdi(Date fecOrdi) {
        this.fecOrdi = fecOrdi;
    }

    public Date getFecOrdf() {
        return fecOrdf;
    }

    public void setFecOrdf(Date fecOrdf) {
        this.fecOrdf = fecOrdf;
    }

    public Date getFecExti() {
        return fecExti;
    }

    public void setFecExti(Date fecExti) {
        this.fecExti = fecExti;
    }

    public Date getFecExtf() {
        return fecExtf;
    }

    public void setFecExtf(Date fecExtf) {
        this.fecExtf = fecExtf;
    }

    public BigDecimal getInsordrep() {
        return insordrep;
    }

    public void setInsordrep(BigDecimal insordrep) {
        this.insordrep = insordrep;
    }

    public BigDecimal getInsextrep() {
        return insextrep;
    }

    public void setInsextrep(BigDecimal insextrep) {
        this.insextrep = insextrep;
    }

    public BigDecimal getInsexprep() {
        return insexprep;
    }

    public void setInsexprep(BigDecimal insexprep) {
        this.insexprep = insexprep;
    }

    public BigDecimal getInsordpc() {
        return insordpc;
    }

    public void setInsordpc(BigDecimal insordpc) {
        this.insordpc = insordpc;
    }

    public BigDecimal getInsextpc() {
        return insextpc;
    }

    public void setInsextpc(BigDecimal insextpc) {
        this.insextpc = insextpc;
    }

    public BigDecimal getInsexppc() {
        return insexppc;
    }

    public void setInsexppc(BigDecimal insexppc) {
        this.insexppc = insexppc;
    }

    public BigDecimal getCurso1rep() {
        return curso1rep;
    }

    public void setCurso1rep(BigDecimal curso1rep) {
        this.curso1rep = curso1rep;
    }

    public BigDecimal getCurso2rep() {
        return curso2rep;
    }

    public void setCurso2rep(BigDecimal curso2rep) {
        this.curso2rep = curso2rep;
    }

    public BigDecimal getCurso3rep() {
        return curso3rep;
    }

    public void setCurso3rep(BigDecimal curso3rep) {
        this.curso3rep = curso3rep;
    }

    public BigDecimal getCurso4rep() {
        return curso4rep;
    }

    public void setCurso4rep(BigDecimal curso4rep) {
        this.curso4rep = curso4rep;
    }

    public BigDecimal getCurso5rep() {
        return curso5rep;
    }

    public void setCurso5rep(BigDecimal curso5rep) {
        this.curso5rep = curso5rep;
    }

    public BigDecimal getCurso6rep() {
        return curso6rep;
    }

    public void setCurso6rep(BigDecimal curso6rep) {
        this.curso6rep = curso6rep;
    }

    public BigDecimal getCurso7rep() {
        return curso7rep;
    }

    public void setCurso7rep(BigDecimal curso7rep) {
        this.curso7rep = curso7rep;
    }

    public BigDecimal getCurso8rep() {
        return curso8rep;
    }

    public void setCurso8rep(BigDecimal curso8rep) {
        this.curso8rep = curso8rep;
    }

    public BigDecimal getCurso9rep() {
        return curso9rep;
    }

    public void setCurso9rep(BigDecimal curso9rep) {
        this.curso9rep = curso9rep;
    }

    public BigDecimal getCurso10rep() {
        return curso10rep;
    }

    public void setCurso10rep(BigDecimal curso10rep) {
        this.curso10rep = curso10rep;
    }

    public BigDecimal getCurso1pc() {
        return curso1pc;
    }

    public void setCurso1pc(BigDecimal curso1pc) {
        this.curso1pc = curso1pc;
    }

    public BigDecimal getCurso2pc() {
        return curso2pc;
    }

    public void setCurso2pc(BigDecimal curso2pc) {
        this.curso2pc = curso2pc;
    }

    public BigDecimal getCurso3pc() {
        return curso3pc;
    }

    public void setCurso3pc(BigDecimal curso3pc) {
        this.curso3pc = curso3pc;
    }

    public BigDecimal getCurso4pc() {
        return curso4pc;
    }

    public void setCurso4pc(BigDecimal curso4pc) {
        this.curso4pc = curso4pc;
    }

    public BigDecimal getCurso5pc() {
        return curso5pc;
    }

    public void setCurso5pc(BigDecimal curso5pc) {
        this.curso5pc = curso5pc;
    }

    public BigDecimal getCurso6pc() {
        return curso6pc;
    }

    public void setCurso6pc(BigDecimal curso6pc) {
        this.curso6pc = curso6pc;
    }

    public BigDecimal getCurso7pc() {
        return curso7pc;
    }

    public void setCurso7pc(BigDecimal curso7pc) {
        this.curso7pc = curso7pc;
    }

    public BigDecimal getCurso8pc() {
        return curso8pc;
    }

    public void setCurso8pc(BigDecimal curso8pc) {
        this.curso8pc = curso8pc;
    }

    public BigDecimal getCurso9pc() {
        return curso9pc;
    }

    public void setCurso9pc(BigDecimal curso9pc) {
        this.curso9pc = curso9pc;
    }

    public BigDecimal getCurso10pc() {
        return curso10pc;
    }

    public void setCurso10pc(BigDecimal curso10pc) {
        this.curso10pc = curso10pc;
    }

    public char getValidaHorarioLab() {
        return validaHorarioLab;
    }

    public void setValidaHorarioLab(char validaHorarioLab) {
        this.validaHorarioLab = validaHorarioLab;
    }

    public Integer getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(Integer idJornada) {
        this.idJornada = idJornada;
    }

    public char getIngles() {
        return ingles;
    }

    public void setIngles(char ingles) {
        this.ingles = ingles;
    }

    public char getPreguntaTraslape() {
        return preguntaTraslape;
    }

    public void setPreguntaTraslape(char preguntaTraslape) {
        this.preguntaTraslape = preguntaTraslape;
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

    public char getAsignaWeb() {
        return asignaWeb;
    }

    public void setAsignaWeb(char asignaWeb) {
        this.asignaWeb = asignaWeb;
    }

    public char getPreReq() {
        return preReq;
    }

    public void setPreReq(char preReq) {
        this.preReq = preReq;
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
        if (!(object instanceof AcadCarreras)) {
            return false;
        }
        AcadCarreras other = (AcadCarreras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AcadCarreras[ id=" + id + " ]";
    }
    
}
