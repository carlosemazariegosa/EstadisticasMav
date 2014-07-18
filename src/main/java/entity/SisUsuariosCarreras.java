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
@Table(name = "SIS_USUARIOS_CARRERAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SisUsuariosCarreras.findAll", query = "SELECT s FROM SisUsuariosCarreras s"),
    @NamedQuery(name = "SisUsuariosCarreras.findById", query = "SELECT s FROM SisUsuariosCarreras s WHERE s.id = :id"),
    @NamedQuery(name = "SisUsuariosCarreras.findByIdSisUsuario", query = "SELECT s FROM SisUsuariosCarreras s WHERE s.idSisUsuario = :idSisUsuario"),
    @NamedQuery(name = "SisUsuariosCarreras.findByCodcarr", query = "SELECT s FROM SisUsuariosCarreras s WHERE s.codcarr = :codcarr"),
    @NamedQuery(name = "SisUsuariosCarreras.findByUsuario", query = "SELECT s FROM SisUsuariosCarreras s WHERE s.usuario = :usuario"),
    @NamedQuery(name = "SisUsuariosCarreras.findByFechasys", query = "SELECT s FROM SisUsuariosCarreras s WHERE s.fechasys = :fechasys")})
public class SisUsuariosCarreras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ID_SIS_USUARIO")
    private Integer idSisUsuario;
    @Size(max = 4)
    @Column(name = "CODCARR")
    private String codcarr;
    @Size(max = 10)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHASYS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasys;

    public SisUsuariosCarreras() {
    }

    public SisUsuariosCarreras(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdSisUsuario() {
        return idSisUsuario;
    }

    public void setIdSisUsuario(Integer idSisUsuario) {
        this.idSisUsuario = idSisUsuario;
    }

    public String getCodcarr() {
        return codcarr;
    }

    public void setCodcarr(String codcarr) {
        this.codcarr = codcarr;
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
        if (!(object instanceof SisUsuariosCarreras)) {
            return false;
        }
        SisUsuariosCarreras other = (SisUsuariosCarreras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SisUsuariosCarreras[ id=" + id + " ]";
    }
    
}
