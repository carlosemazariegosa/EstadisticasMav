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
@Table(name = "ACAD_CURSOS_DET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcadCursosDet.findAll", query = "SELECT a FROM AcadCursosDet a"),
    @NamedQuery(name = "AcadCursosDet.findById", query = "SELECT a FROM AcadCursosDet a WHERE a.id = :id"),
    @NamedQuery(name = "AcadCursosDet.findByIdAcadPensumDet", query = "SELECT a FROM AcadCursosDet a WHERE a.idAcadPensumDet = :idAcadPensumDet"),
    @NamedQuery(name = "AcadCursosDet.findByIdAcadCursosDetUnificado", query = "SELECT a FROM AcadCursosDet a WHERE a.idAcadCursosDetUnificado = :idAcadCursosDetUnificado"),
    @NamedQuery(name = "AcadCursosDet.findBySemesAno", query = "SELECT a FROM AcadCursosDet a WHERE a.semesAno = :semesAno"),
    @NamedQuery(name = "AcadCursosDet.findByCodcarr", query = "SELECT a FROM AcadCursosDet a WHERE a.codcarr = :codcarr"),
    @NamedQuery(name = "AcadCursosDet.findByCodcur", query = "SELECT a FROM AcadCursosDet a WHERE a.codcur = :codcur"),
    @NamedQuery(name = "AcadCursosDet.findBySeccion", query = "SELECT a FROM AcadCursosDet a WHERE a.seccion = :seccion"),
    @NamedQuery(name = "AcadCursosDet.findByNombre", query = "SELECT a FROM AcadCursosDet a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "AcadCursosDet.findByCodcat", query = "SELECT a FROM AcadCursosDet a WHERE a.codcat = :codcat"),
    @NamedQuery(name = "AcadCursosDet.findByCodprer", query = "SELECT a FROM AcadCursosDet a WHERE a.codprer = :codprer"),
    @NamedQuery(name = "AcadCursosDet.findByCreditos", query = "SELECT a FROM AcadCursosDet a WHERE a.creditos = :creditos"),
    @NamedQuery(name = "AcadCursosDet.findByCiclo", query = "SELECT a FROM AcadCursosDet a WHERE a.ciclo = :ciclo"),
    @NamedQuery(name = "AcadCursosDet.findByAlumCur", query = "SELECT a FROM AcadCursosDet a WHERE a.alumCur = :alumCur"),
    @NamedQuery(name = "AcadCursosDet.findByAula", query = "SELECT a FROM AcadCursosDet a WHERE a.aula = :aula"),
    @NamedQuery(name = "AcadCursosDet.findByHorinilu", query = "SELECT a FROM AcadCursosDet a WHERE a.horinilu = :horinilu"),
    @NamedQuery(name = "AcadCursosDet.findByHorfinlu", query = "SELECT a FROM AcadCursosDet a WHERE a.horfinlu = :horfinlu"),
    @NamedQuery(name = "AcadCursosDet.findByHorinima", query = "SELECT a FROM AcadCursosDet a WHERE a.horinima = :horinima"),
    @NamedQuery(name = "AcadCursosDet.findByHorfinma", query = "SELECT a FROM AcadCursosDet a WHERE a.horfinma = :horfinma"),
    @NamedQuery(name = "AcadCursosDet.findByHorinimi", query = "SELECT a FROM AcadCursosDet a WHERE a.horinimi = :horinimi"),
    @NamedQuery(name = "AcadCursosDet.findByHorfinmi", query = "SELECT a FROM AcadCursosDet a WHERE a.horfinmi = :horfinmi"),
    @NamedQuery(name = "AcadCursosDet.findByHoriniju", query = "SELECT a FROM AcadCursosDet a WHERE a.horiniju = :horiniju"),
    @NamedQuery(name = "AcadCursosDet.findByHorfinju", query = "SELECT a FROM AcadCursosDet a WHERE a.horfinju = :horfinju"),
    @NamedQuery(name = "AcadCursosDet.findByHorinivi", query = "SELECT a FROM AcadCursosDet a WHERE a.horinivi = :horinivi"),
    @NamedQuery(name = "AcadCursosDet.findByHorfinvi", query = "SELECT a FROM AcadCursosDet a WHERE a.horfinvi = :horfinvi"),
    @NamedQuery(name = "AcadCursosDet.findByHorinisa", query = "SELECT a FROM AcadCursosDet a WHERE a.horinisa = :horinisa"),
    @NamedQuery(name = "AcadCursosDet.findByHorfinsa", query = "SELECT a FROM AcadCursosDet a WHERE a.horfinsa = :horfinsa"),
    @NamedQuery(name = "AcadCursosDet.findByHorinido", query = "SELECT a FROM AcadCursosDet a WHERE a.horinido = :horinido"),
    @NamedQuery(name = "AcadCursosDet.findByHorfindo", query = "SELECT a FROM AcadCursosDet a WHERE a.horfindo = :horfindo"),
    @NamedQuery(name = "AcadCursosDet.findByHalu", query = "SELECT a FROM AcadCursosDet a WHERE a.halu = :halu"),
    @NamedQuery(name = "AcadCursosDet.findByHama", query = "SELECT a FROM AcadCursosDet a WHERE a.hama = :hama"),
    @NamedQuery(name = "AcadCursosDet.findByHami", query = "SELECT a FROM AcadCursosDet a WHERE a.hami = :hami"),
    @NamedQuery(name = "AcadCursosDet.findByHaju", query = "SELECT a FROM AcadCursosDet a WHERE a.haju = :haju"),
    @NamedQuery(name = "AcadCursosDet.findByHavi", query = "SELECT a FROM AcadCursosDet a WHERE a.havi = :havi"),
    @NamedQuery(name = "AcadCursosDet.findByHasa", query = "SELECT a FROM AcadCursosDet a WHERE a.hasa = :hasa"),
    @NamedQuery(name = "AcadCursosDet.findByHado", query = "SELECT a FROM AcadCursosDet a WHERE a.hado = :hado"),
    @NamedQuery(name = "AcadCursosDet.findByMinrecesolu", query = "SELECT a FROM AcadCursosDet a WHERE a.minrecesolu = :minrecesolu"),
    @NamedQuery(name = "AcadCursosDet.findByMinrecesoma", query = "SELECT a FROM AcadCursosDet a WHERE a.minrecesoma = :minrecesoma"),
    @NamedQuery(name = "AcadCursosDet.findByMinrecesomi", query = "SELECT a FROM AcadCursosDet a WHERE a.minrecesomi = :minrecesomi"),
    @NamedQuery(name = "AcadCursosDet.findByMinrecesoju", query = "SELECT a FROM AcadCursosDet a WHERE a.minrecesoju = :minrecesoju"),
    @NamedQuery(name = "AcadCursosDet.findByMinrecesovi", query = "SELECT a FROM AcadCursosDet a WHERE a.minrecesovi = :minrecesovi"),
    @NamedQuery(name = "AcadCursosDet.findByMinrecesosa", query = "SELECT a FROM AcadCursosDet a WHERE a.minrecesosa = :minrecesosa"),
    @NamedQuery(name = "AcadCursosDet.findByMinrecesodo", query = "SELECT a FROM AcadCursosDet a WHERE a.minrecesodo = :minrecesodo"),
    @NamedQuery(name = "AcadCursosDet.findByAsignados", query = "SELECT a FROM AcadCursosDet a WHERE a.asignados = :asignados"),
    @NamedQuery(name = "AcadCursosDet.findByPagaLab", query = "SELECT a FROM AcadCursosDet a WHERE a.pagaLab = :pagaLab"),
    @NamedQuery(name = "AcadCursosDet.findByCostLab", query = "SELECT a FROM AcadCursosDet a WHERE a.costLab = :costLab"),
    @NamedQuery(name = "AcadCursosDet.findByClinica", query = "SELECT a FROM AcadCursosDet a WHERE a.clinica = :clinica"),
    @NamedQuery(name = "AcadCursosDet.findByPerDob", query = "SELECT a FROM AcadCursosDet a WHERE a.perDob = :perDob"),
    @NamedQuery(name = "AcadCursosDet.findByFecIng1p", query = "SELECT a FROM AcadCursosDet a WHERE a.fecIng1p = :fecIng1p"),
    @NamedQuery(name = "AcadCursosDet.findByFecExa1p", query = "SELECT a FROM AcadCursosDet a WHERE a.fecExa1p = :fecExa1p"),
    @NamedQuery(name = "AcadCursosDet.findByP1", query = "SELECT a FROM AcadCursosDet a WHERE a.p1 = :p1"),
    @NamedQuery(name = "AcadCursosDet.findByM1", query = "SELECT a FROM AcadCursosDet a WHERE a.m1 = :m1"),
    @NamedQuery(name = "AcadCursosDet.findByFecIng1e", query = "SELECT a FROM AcadCursosDet a WHERE a.fecIng1e = :fecIng1e"),
    @NamedQuery(name = "AcadCursosDet.findByFecExa1e", query = "SELECT a FROM AcadCursosDet a WHERE a.fecExa1e = :fecExa1e"),
    @NamedQuery(name = "AcadCursosDet.findByE1", query = "SELECT a FROM AcadCursosDet a WHERE a.e1 = :e1"),
    @NamedQuery(name = "AcadCursosDet.findByM2", query = "SELECT a FROM AcadCursosDet a WHERE a.m2 = :m2"),
    @NamedQuery(name = "AcadCursosDet.findByFecIng2p", query = "SELECT a FROM AcadCursosDet a WHERE a.fecIng2p = :fecIng2p"),
    @NamedQuery(name = "AcadCursosDet.findByFecExa2p", query = "SELECT a FROM AcadCursosDet a WHERE a.fecExa2p = :fecExa2p"),
    @NamedQuery(name = "AcadCursosDet.findByP2", query = "SELECT a FROM AcadCursosDet a WHERE a.p2 = :p2"),
    @NamedQuery(name = "AcadCursosDet.findByM3", query = "SELECT a FROM AcadCursosDet a WHERE a.m3 = :m3"),
    @NamedQuery(name = "AcadCursosDet.findByFecIng2e", query = "SELECT a FROM AcadCursosDet a WHERE a.fecIng2e = :fecIng2e"),
    @NamedQuery(name = "AcadCursosDet.findByFecExa2e", query = "SELECT a FROM AcadCursosDet a WHERE a.fecExa2e = :fecExa2e"),
    @NamedQuery(name = "AcadCursosDet.findByE2", query = "SELECT a FROM AcadCursosDet a WHERE a.e2 = :e2"),
    @NamedQuery(name = "AcadCursosDet.findByM4", query = "SELECT a FROM AcadCursosDet a WHERE a.m4 = :m4"),
    @NamedQuery(name = "AcadCursosDet.findByFecIngF", query = "SELECT a FROM AcadCursosDet a WHERE a.fecIngF = :fecIngF"),
    @NamedQuery(name = "AcadCursosDet.findByFecExaF", query = "SELECT a FROM AcadCursosDet a WHERE a.fecExaF = :fecExaF"),
    @NamedQuery(name = "AcadCursosDet.findByF", query = "SELECT a FROM AcadCursosDet a WHERE a.f = :f"),
    @NamedQuery(name = "AcadCursosDet.findByM5", query = "SELECT a FROM AcadCursosDet a WHERE a.m5 = :m5"),
    @NamedQuery(name = "AcadCursosDet.findByFecIngRe", query = "SELECT a FROM AcadCursosDet a WHERE a.fecIngRe = :fecIngRe"),
    @NamedQuery(name = "AcadCursosDet.findByFecExaRe", query = "SELECT a FROM AcadCursosDet a WHERE a.fecExaRe = :fecExaRe"),
    @NamedQuery(name = "AcadCursosDet.findByR1", query = "SELECT a FROM AcadCursosDet a WHERE a.r1 = :r1"),
    @NamedQuery(name = "AcadCursosDet.findByM6", query = "SELECT a FROM AcadCursosDet a WHERE a.m6 = :m6"),
    @NamedQuery(name = "AcadCursosDet.findByFecIngR2", query = "SELECT a FROM AcadCursosDet a WHERE a.fecIngR2 = :fecIngR2"),
    @NamedQuery(name = "AcadCursosDet.findByFecExaR2", query = "SELECT a FROM AcadCursosDet a WHERE a.fecExaR2 = :fecExaR2"),
    @NamedQuery(name = "AcadCursosDet.findByZonaMin", query = "SELECT a FROM AcadCursosDet a WHERE a.zonaMin = :zonaMin"),
    @NamedQuery(name = "AcadCursosDet.findByZonaMax", query = "SELECT a FROM AcadCursosDet a WHERE a.zonaMax = :zonaMax"),
    @NamedQuery(name = "AcadCursosDet.findByPteoMin", query = "SELECT a FROM AcadCursosDet a WHERE a.pteoMin = :pteoMin"),
    @NamedQuery(name = "AcadCursosDet.findByPteoP1", query = "SELECT a FROM AcadCursosDet a WHERE a.pteoP1 = :pteoP1"),
    @NamedQuery(name = "AcadCursosDet.findByPteoP2", query = "SELECT a FROM AcadCursosDet a WHERE a.pteoP2 = :pteoP2"),
    @NamedQuery(name = "AcadCursosDet.findByPteoAct1", query = "SELECT a FROM AcadCursosDet a WHERE a.pteoAct1 = :pteoAct1"),
    @NamedQuery(name = "AcadCursosDet.findByPteoAct2", query = "SELECT a FROM AcadCursosDet a WHERE a.pteoAct2 = :pteoAct2"),
    @NamedQuery(name = "AcadCursosDet.findByIdBit", query = "SELECT a FROM AcadCursosDet a WHERE a.idBit = :idBit"),
    @NamedQuery(name = "AcadCursosDet.findByFechaBit", query = "SELECT a FROM AcadCursosDet a WHERE a.fechaBit = :fechaBit"),
    @NamedQuery(name = "AcadCursosDet.findByHoraBit", query = "SELECT a FROM AcadCursosDet a WHERE a.horaBit = :horaBit"),
    @NamedQuery(name = "AcadCursosDet.findByMaquina", query = "SELECT a FROM AcadCursosDet a WHERE a.maquina = :maquina"),
    @NamedQuery(name = "AcadCursosDet.findByIdAct", query = "SELECT a FROM AcadCursosDet a WHERE a.idAct = :idAct"),
    @NamedQuery(name = "AcadCursosDet.findByFechaAct", query = "SELECT a FROM AcadCursosDet a WHERE a.fechaAct = :fechaAct"),
    @NamedQuery(name = "AcadCursosDet.findByHoraAct", query = "SELECT a FROM AcadCursosDet a WHERE a.horaAct = :horaAct"),
    @NamedQuery(name = "AcadCursosDet.findByMaquinaAct", query = "SELECT a FROM AcadCursosDet a WHERE a.maquinaAct = :maquinaAct"),
    @NamedQuery(name = "AcadCursosDet.findByObserva1", query = "SELECT a FROM AcadCursosDet a WHERE a.observa1 = :observa1"),
    @NamedQuery(name = "AcadCursosDet.findByObserva2", query = "SELECT a FROM AcadCursosDet a WHERE a.observa2 = :observa2"),
    @NamedQuery(name = "AcadCursosDet.findByFirmaElec", query = "SELECT a FROM AcadCursosDet a WHERE a.firmaElec = :firmaElec"),
    @NamedQuery(name = "AcadCursosDet.findByMoodle", query = "SELECT a FROM AcadCursosDet a WHERE a.moodle = :moodle"),
    @NamedQuery(name = "AcadCursosDet.findByCertificable", query = "SELECT a FROM AcadCursosDet a WHERE a.certificable = :certificable"),
    @NamedQuery(name = "AcadCursosDet.findByMkToWeb", query = "SELECT a FROM AcadCursosDet a WHERE a.mkToWeb = :mkToWeb"),
    @NamedQuery(name = "AcadCursosDet.findByUsuario", query = "SELECT a FROM AcadCursosDet a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "AcadCursosDet.findByFechasys", query = "SELECT a FROM AcadCursosDet a WHERE a.fechasys = :fechasys")})
public class AcadCursosDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ID_ACAD_PENSUM_DET")
    private Integer idAcadPensumDet;
    @Column(name = "ID_ACAD_CURSOS_DET_UNIFICADO")
    private Integer idAcadCursosDetUnificado;
    @Size(max = 5)
    @Column(name = "SEMES_ANO")
    private String semesAno;
    @Size(max = 4)
    @Column(name = "CODCARR")
    private String codcarr;
    @Size(max = 3)
    @Column(name = "CODCUR")
    private String codcur;
    @Column(name = "SECCION")
    private Character seccion;
    @Size(max = 60)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 5)
    @Column(name = "CODCAT")
    private String codcat;
    @Size(max = 3)
    @Column(name = "CODPRER")
    private String codprer;
    @Column(name = "CREDITOS")
    private Integer creditos;
    @Size(max = 2)
    @Column(name = "CICLO")
    private String ciclo;
    @Column(name = "ALUM_CUR")
    private Integer alumCur;
    @Size(max = 15)
    @Column(name = "AULA")
    private String aula;
    @Size(max = 5)
    @Column(name = "HORINILU")
    private String horinilu;
    @Size(max = 5)
    @Column(name = "HORFINLU")
    private String horfinlu;
    @Size(max = 5)
    @Column(name = "HORINIMA")
    private String horinima;
    @Size(max = 5)
    @Column(name = "HORFINMA")
    private String horfinma;
    @Size(max = 5)
    @Column(name = "HORINIMI")
    private String horinimi;
    @Size(max = 5)
    @Column(name = "HORFINMI")
    private String horfinmi;
    @Size(max = 5)
    @Column(name = "HORINIJU")
    private String horiniju;
    @Size(max = 5)
    @Column(name = "HORFINJU")
    private String horfinju;
    @Size(max = 5)
    @Column(name = "HORINIVI")
    private String horinivi;
    @Size(max = 5)
    @Column(name = "HORFINVI")
    private String horfinvi;
    @Size(max = 5)
    @Column(name = "HORINISA")
    private String horinisa;
    @Size(max = 5)
    @Column(name = "HORFINSA")
    private String horfinsa;
    @Size(max = 5)
    @Column(name = "HORINIDO")
    private String horinido;
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
    @Column(name = "ASIGNADOS")
    private Integer asignados;
    @Column(name = "PAGA_LAB")
    private Character pagaLab;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COST_LAB")
    private BigDecimal costLab;
    @Column(name = "CLINICA")
    private Character clinica;
    @Column(name = "PER_DOB")
    private Character perDob;
    @Column(name = "FEC_ING_1P")
    @Temporal(TemporalType.DATE)
    private Date fecIng1p;
    @Column(name = "FEC_EXA_1P")
    @Temporal(TemporalType.DATE)
    private Date fecExa1p;
    @Column(name = "P1")
    private Character p1;
    @Column(name = "M1")
    private Character m1;
    @Column(name = "FEC_ING_1E")
    @Temporal(TemporalType.DATE)
    private Date fecIng1e;
    @Column(name = "FEC_EXA_1E")
    @Temporal(TemporalType.DATE)
    private Date fecExa1e;
    @Column(name = "E1")
    private Character e1;
    @Column(name = "M2")
    private Character m2;
    @Column(name = "FEC_ING_2P")
    @Temporal(TemporalType.DATE)
    private Date fecIng2p;
    @Column(name = "FEC_EXA_2P")
    @Temporal(TemporalType.DATE)
    private Date fecExa2p;
    @Column(name = "P2")
    private Character p2;
    @Column(name = "M3")
    private Character m3;
    @Column(name = "FEC_ING_2E")
    @Temporal(TemporalType.DATE)
    private Date fecIng2e;
    @Column(name = "FEC_EXA_2E")
    @Temporal(TemporalType.DATE)
    private Date fecExa2e;
    @Column(name = "E2")
    private Character e2;
    @Column(name = "M4")
    private Character m4;
    @Column(name = "FEC_ING_F")
    @Temporal(TemporalType.DATE)
    private Date fecIngF;
    @Column(name = "FEC_EXA_F")
    @Temporal(TemporalType.DATE)
    private Date fecExaF;
    @Column(name = "F")
    private Character f;
    @Column(name = "M5")
    private Character m5;
    @Column(name = "FEC_ING_RE")
    @Temporal(TemporalType.DATE)
    private Date fecIngRe;
    @Column(name = "FEC_EXA_RE")
    @Temporal(TemporalType.DATE)
    private Date fecExaRe;
    @Column(name = "R1")
    private Character r1;
    @Column(name = "M6")
    private Character m6;
    @Column(name = "FEC_ING_R2")
    @Temporal(TemporalType.DATE)
    private Date fecIngR2;
    @Column(name = "FEC_EXA_R2")
    @Temporal(TemporalType.DATE)
    private Date fecExaR2;
    @Column(name = "ZONA_MIN")
    private BigDecimal zonaMin;
    @Column(name = "ZONA_MAX")
    private BigDecimal zonaMax;
    @Column(name = "PTEO_MIN")
    private BigDecimal pteoMin;
    @Column(name = "PTEO_P1")
    private BigDecimal pteoP1;
    @Column(name = "PTEO_P2")
    private BigDecimal pteoP2;
    @Column(name = "PTEO_ACT1")
    private BigDecimal pteoAct1;
    @Column(name = "PTEO_ACT2")
    private BigDecimal pteoAct2;
    @Size(max = 8)
    @Column(name = "ID_BIT")
    private String idBit;
    @Column(name = "FECHA_BIT")
    @Temporal(TemporalType.DATE)
    private Date fechaBit;
    @Size(max = 8)
    @Column(name = "HORA_BIT")
    private String horaBit;
    @Size(max = 25)
    @Column(name = "MAQUINA")
    private String maquina;
    @Size(max = 8)
    @Column(name = "ID_ACT")
    private String idAct;
    @Column(name = "FECHA_ACT")
    @Temporal(TemporalType.DATE)
    private Date fechaAct;
    @Size(max = 8)
    @Column(name = "HORA_ACT")
    private String horaAct;
    @Size(max = 25)
    @Column(name = "MAQUINA_ACT")
    private String maquinaAct;
    @Size(max = 100)
    @Column(name = "OBSERVA1")
    private String observa1;
    @Size(max = 100)
    @Column(name = "OBSERVA2")
    private String observa2;
    @Column(name = "FIRMA_ELEC")
    private Character firmaElec;
    @Column(name = "MOODLE")
    private Character moodle;
    @Column(name = "CERTIFICABLE")
    private Character certificable;
    @Column(name = "MK_TO_WEB")
    private Character mkToWeb;
    @Size(max = 10)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHASYS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasys;

    public AcadCursosDet() {
    }

    public AcadCursosDet(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAcadPensumDet() {
        return idAcadPensumDet;
    }

    public void setIdAcadPensumDet(Integer idAcadPensumDet) {
        this.idAcadPensumDet = idAcadPensumDet;
    }

    public Integer getIdAcadCursosDetUnificado() {
        return idAcadCursosDetUnificado;
    }

    public void setIdAcadCursosDetUnificado(Integer idAcadCursosDetUnificado) {
        this.idAcadCursosDetUnificado = idAcadCursosDetUnificado;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodcat() {
        return codcat;
    }

    public void setCodcat(String codcat) {
        this.codcat = codcat;
    }

    public String getCodprer() {
        return codprer;
    }

    public void setCodprer(String codprer) {
        this.codprer = codprer;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Integer getAlumCur() {
        return alumCur;
    }

    public void setAlumCur(Integer alumCur) {
        this.alumCur = alumCur;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getHorinilu() {
        return horinilu;
    }

    public void setHorinilu(String horinilu) {
        this.horinilu = horinilu;
    }

    public String getHorfinlu() {
        return horfinlu;
    }

    public void setHorfinlu(String horfinlu) {
        this.horfinlu = horfinlu;
    }

    public String getHorinima() {
        return horinima;
    }

    public void setHorinima(String horinima) {
        this.horinima = horinima;
    }

    public String getHorfinma() {
        return horfinma;
    }

    public void setHorfinma(String horfinma) {
        this.horfinma = horfinma;
    }

    public String getHorinimi() {
        return horinimi;
    }

    public void setHorinimi(String horinimi) {
        this.horinimi = horinimi;
    }

    public String getHorfinmi() {
        return horfinmi;
    }

    public void setHorfinmi(String horfinmi) {
        this.horfinmi = horfinmi;
    }

    public String getHoriniju() {
        return horiniju;
    }

    public void setHoriniju(String horiniju) {
        this.horiniju = horiniju;
    }

    public String getHorfinju() {
        return horfinju;
    }

    public void setHorfinju(String horfinju) {
        this.horfinju = horfinju;
    }

    public String getHorinivi() {
        return horinivi;
    }

    public void setHorinivi(String horinivi) {
        this.horinivi = horinivi;
    }

    public String getHorfinvi() {
        return horfinvi;
    }

    public void setHorfinvi(String horfinvi) {
        this.horfinvi = horfinvi;
    }

    public String getHorinisa() {
        return horinisa;
    }

    public void setHorinisa(String horinisa) {
        this.horinisa = horinisa;
    }

    public String getHorfinsa() {
        return horfinsa;
    }

    public void setHorfinsa(String horfinsa) {
        this.horfinsa = horfinsa;
    }

    public String getHorinido() {
        return horinido;
    }

    public void setHorinido(String horinido) {
        this.horinido = horinido;
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

    public Integer getAsignados() {
        return asignados;
    }

    public void setAsignados(Integer asignados) {
        this.asignados = asignados;
    }

    public Character getPagaLab() {
        return pagaLab;
    }

    public void setPagaLab(Character pagaLab) {
        this.pagaLab = pagaLab;
    }

    public BigDecimal getCostLab() {
        return costLab;
    }

    public void setCostLab(BigDecimal costLab) {
        this.costLab = costLab;
    }

    public Character getClinica() {
        return clinica;
    }

    public void setClinica(Character clinica) {
        this.clinica = clinica;
    }

    public Character getPerDob() {
        return perDob;
    }

    public void setPerDob(Character perDob) {
        this.perDob = perDob;
    }

    public Date getFecIng1p() {
        return fecIng1p;
    }

    public void setFecIng1p(Date fecIng1p) {
        this.fecIng1p = fecIng1p;
    }

    public Date getFecExa1p() {
        return fecExa1p;
    }

    public void setFecExa1p(Date fecExa1p) {
        this.fecExa1p = fecExa1p;
    }

    public Character getP1() {
        return p1;
    }

    public void setP1(Character p1) {
        this.p1 = p1;
    }

    public Character getM1() {
        return m1;
    }

    public void setM1(Character m1) {
        this.m1 = m1;
    }

    public Date getFecIng1e() {
        return fecIng1e;
    }

    public void setFecIng1e(Date fecIng1e) {
        this.fecIng1e = fecIng1e;
    }

    public Date getFecExa1e() {
        return fecExa1e;
    }

    public void setFecExa1e(Date fecExa1e) {
        this.fecExa1e = fecExa1e;
    }

    public Character getE1() {
        return e1;
    }

    public void setE1(Character e1) {
        this.e1 = e1;
    }

    public Character getM2() {
        return m2;
    }

    public void setM2(Character m2) {
        this.m2 = m2;
    }

    public Date getFecIng2p() {
        return fecIng2p;
    }

    public void setFecIng2p(Date fecIng2p) {
        this.fecIng2p = fecIng2p;
    }

    public Date getFecExa2p() {
        return fecExa2p;
    }

    public void setFecExa2p(Date fecExa2p) {
        this.fecExa2p = fecExa2p;
    }

    public Character getP2() {
        return p2;
    }

    public void setP2(Character p2) {
        this.p2 = p2;
    }

    public Character getM3() {
        return m3;
    }

    public void setM3(Character m3) {
        this.m3 = m3;
    }

    public Date getFecIng2e() {
        return fecIng2e;
    }

    public void setFecIng2e(Date fecIng2e) {
        this.fecIng2e = fecIng2e;
    }

    public Date getFecExa2e() {
        return fecExa2e;
    }

    public void setFecExa2e(Date fecExa2e) {
        this.fecExa2e = fecExa2e;
    }

    public Character getE2() {
        return e2;
    }

    public void setE2(Character e2) {
        this.e2 = e2;
    }

    public Character getM4() {
        return m4;
    }

    public void setM4(Character m4) {
        this.m4 = m4;
    }

    public Date getFecIngF() {
        return fecIngF;
    }

    public void setFecIngF(Date fecIngF) {
        this.fecIngF = fecIngF;
    }

    public Date getFecExaF() {
        return fecExaF;
    }

    public void setFecExaF(Date fecExaF) {
        this.fecExaF = fecExaF;
    }

    public Character getF() {
        return f;
    }

    public void setF(Character f) {
        this.f = f;
    }

    public Character getM5() {
        return m5;
    }

    public void setM5(Character m5) {
        this.m5 = m5;
    }

    public Date getFecIngRe() {
        return fecIngRe;
    }

    public void setFecIngRe(Date fecIngRe) {
        this.fecIngRe = fecIngRe;
    }

    public Date getFecExaRe() {
        return fecExaRe;
    }

    public void setFecExaRe(Date fecExaRe) {
        this.fecExaRe = fecExaRe;
    }

    public Character getR1() {
        return r1;
    }

    public void setR1(Character r1) {
        this.r1 = r1;
    }

    public Character getM6() {
        return m6;
    }

    public void setM6(Character m6) {
        this.m6 = m6;
    }

    public Date getFecIngR2() {
        return fecIngR2;
    }

    public void setFecIngR2(Date fecIngR2) {
        this.fecIngR2 = fecIngR2;
    }

    public Date getFecExaR2() {
        return fecExaR2;
    }

    public void setFecExaR2(Date fecExaR2) {
        this.fecExaR2 = fecExaR2;
    }

    public BigDecimal getZonaMin() {
        return zonaMin;
    }

    public void setZonaMin(BigDecimal zonaMin) {
        this.zonaMin = zonaMin;
    }

    public BigDecimal getZonaMax() {
        return zonaMax;
    }

    public void setZonaMax(BigDecimal zonaMax) {
        this.zonaMax = zonaMax;
    }

    public BigDecimal getPteoMin() {
        return pteoMin;
    }

    public void setPteoMin(BigDecimal pteoMin) {
        this.pteoMin = pteoMin;
    }

    public BigDecimal getPteoP1() {
        return pteoP1;
    }

    public void setPteoP1(BigDecimal pteoP1) {
        this.pteoP1 = pteoP1;
    }

    public BigDecimal getPteoP2() {
        return pteoP2;
    }

    public void setPteoP2(BigDecimal pteoP2) {
        this.pteoP2 = pteoP2;
    }

    public BigDecimal getPteoAct1() {
        return pteoAct1;
    }

    public void setPteoAct1(BigDecimal pteoAct1) {
        this.pteoAct1 = pteoAct1;
    }

    public BigDecimal getPteoAct2() {
        return pteoAct2;
    }

    public void setPteoAct2(BigDecimal pteoAct2) {
        this.pteoAct2 = pteoAct2;
    }

    public String getIdBit() {
        return idBit;
    }

    public void setIdBit(String idBit) {
        this.idBit = idBit;
    }

    public Date getFechaBit() {
        return fechaBit;
    }

    public void setFechaBit(Date fechaBit) {
        this.fechaBit = fechaBit;
    }

    public String getHoraBit() {
        return horaBit;
    }

    public void setHoraBit(String horaBit) {
        this.horaBit = horaBit;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getIdAct() {
        return idAct;
    }

    public void setIdAct(String idAct) {
        this.idAct = idAct;
    }

    public Date getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(Date fechaAct) {
        this.fechaAct = fechaAct;
    }

    public String getHoraAct() {
        return horaAct;
    }

    public void setHoraAct(String horaAct) {
        this.horaAct = horaAct;
    }

    public String getMaquinaAct() {
        return maquinaAct;
    }

    public void setMaquinaAct(String maquinaAct) {
        this.maquinaAct = maquinaAct;
    }

    public String getObserva1() {
        return observa1;
    }

    public void setObserva1(String observa1) {
        this.observa1 = observa1;
    }

    public String getObserva2() {
        return observa2;
    }

    public void setObserva2(String observa2) {
        this.observa2 = observa2;
    }

    public Character getFirmaElec() {
        return firmaElec;
    }

    public void setFirmaElec(Character firmaElec) {
        this.firmaElec = firmaElec;
    }

    public Character getMoodle() {
        return moodle;
    }

    public void setMoodle(Character moodle) {
        this.moodle = moodle;
    }

    public Character getCertificable() {
        return certificable;
    }

    public void setCertificable(Character certificable) {
        this.certificable = certificable;
    }

    public Character getMkToWeb() {
        return mkToWeb;
    }

    public void setMkToWeb(Character mkToWeb) {
        this.mkToWeb = mkToWeb;
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
        if (!(object instanceof AcadCursosDet)) {
            return false;
        }
        AcadCursosDet other = (AcadCursosDet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AcadCursosDet[ id=" + id + " ]";
    }
    
}
