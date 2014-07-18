/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmarvin
 */
@Entity
@Table(name = "ACAD_TIPO_MOV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcadTipoMov.findAll", query = "SELECT a FROM AcadTipoMov a"),
    @NamedQuery(name = "AcadTipoMov.findById", query = "SELECT a FROM AcadTipoMov a WHERE a.id = :id"),
    @NamedQuery(name = "AcadTipoMov.findByCodigoMov", query = "SELECT a FROM AcadTipoMov a WHERE a.codigoMov = :codigoMov"),
    @NamedQuery(name = "AcadTipoMov.findByNombre", query = "SELECT a FROM AcadTipoMov a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "AcadTipoMov.findByTipoMov", query = "SELECT a FROM AcadTipoMov a WHERE a.tipoMov = :tipoMov"),
    @NamedQuery(name = "AcadTipoMov.findByAbreviatura", query = "SELECT a FROM AcadTipoMov a WHERE a.abreviatura = :abreviatura"),
    @NamedQuery(name = "AcadTipoMov.findByValor", query = "SELECT a FROM AcadTipoMov a WHERE a.valor = :valor"),
    @NamedQuery(name = "AcadTipoMov.findByModificable", query = "SELECT a FROM AcadTipoMov a WHERE a.modificable = :modificable"),
    @NamedQuery(name = "AcadTipoMov.findByActivo", query = "SELECT a FROM AcadTipoMov a WHERE a.activo = :activo"),
    @NamedQuery(name = "AcadTipoMov.findByObservacion", query = "SELECT a FROM AcadTipoMov a WHERE a.observacion = :observacion"),
    @NamedQuery(name = "AcadTipoMov.findByJuegos", query = "SELECT a FROM AcadTipoMov a WHERE a.juegos = :juegos"),
    @NamedQuery(name = "AcadTipoMov.findByPagoEval", query = "SELECT a FROM AcadTipoMov a WHERE a.pagoEval = :pagoEval"),
    @NamedQuery(name = "AcadTipoMov.findByProntopago", query = "SELECT a FROM AcadTipoMov a WHERE a.prontopago = :prontopago"),
    @NamedQuery(name = "AcadTipoMov.findByTipoPagoInscrip", query = "SELECT a FROM AcadTipoMov a WHERE a.tipoPagoInscrip = :tipoPagoInscrip"),
    @NamedQuery(name = "AcadTipoMov.findByPagoParqueo", query = "SELECT a FROM AcadTipoMov a WHERE a.pagoParqueo = :pagoParqueo")})
public class AcadTipoMov implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODIGO_MOV")
    private String codigoMov;
    @Size(max = 60)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "TIPO_MOV")
    private Character tipoMov;
    @Size(max = 8)
    @Column(name = "ABREVIATURA")
    private String abreviatura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "MODIFICABLE")
    private Character modificable;
    @Column(name = "ACTIVO")
    private Character activo;
    @Size(max = 80)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "INSTRUCCIONES")
    private String instrucciones;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "INSTRUCCIONESCU")
    private String instruccionescu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "JUEGOS")
    private char juegos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAGO_EVAL")
    private char pagoEval;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRONTOPAGO")
    private char prontopago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_PAGO_INSCRIP")
    private char tipoPagoInscrip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAGO_PARQUEO")
    private char pagoParqueo;

    public AcadTipoMov() {
    }

    public AcadTipoMov(Integer id) {
        this.id = id;
    }

    public AcadTipoMov(Integer id, String codigoMov, char juegos, char pagoEval, char prontopago, char tipoPagoInscrip, char pagoParqueo) {
        this.id = id;
        this.codigoMov = codigoMov;
        this.juegos = juegos;
        this.pagoEval = pagoEval;
        this.prontopago = prontopago;
        this.tipoPagoInscrip = tipoPagoInscrip;
        this.pagoParqueo = pagoParqueo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoMov() {
        return codigoMov;
    }

    public void setCodigoMov(String codigoMov) {
        this.codigoMov = codigoMov;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(Character tipoMov) {
        this.tipoMov = tipoMov;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Character getModificable() {
        return modificable;
    }

    public void setModificable(Character modificable) {
        this.modificable = modificable;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public String getInstruccionescu() {
        return instruccionescu;
    }

    public void setInstruccionescu(String instruccionescu) {
        this.instruccionescu = instruccionescu;
    }

    public char getJuegos() {
        return juegos;
    }

    public void setJuegos(char juegos) {
        this.juegos = juegos;
    }

    public char getPagoEval() {
        return pagoEval;
    }

    public void setPagoEval(char pagoEval) {
        this.pagoEval = pagoEval;
    }

    public char getProntopago() {
        return prontopago;
    }

    public void setProntopago(char prontopago) {
        this.prontopago = prontopago;
    }

    public char getTipoPagoInscrip() {
        return tipoPagoInscrip;
    }

    public void setTipoPagoInscrip(char tipoPagoInscrip) {
        this.tipoPagoInscrip = tipoPagoInscrip;
    }

    public char getPagoParqueo() {
        return pagoParqueo;
    }

    public void setPagoParqueo(char pagoParqueo) {
        this.pagoParqueo = pagoParqueo;
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
        if (!(object instanceof AcadTipoMov)) {
            return false;
        }
        AcadTipoMov other = (AcadTipoMov) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AcadTipoMov[ id=" + id + " ]";
    }
    
}
