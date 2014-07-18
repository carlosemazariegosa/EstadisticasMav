/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmarvin
 */
@Entity
@Table(name = "SIS_PROGRAMAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SisProgramas.findAll", query = "SELECT s FROM SisProgramas s"),
    @NamedQuery(name = "SisProgramas.findById", query = "SELECT s FROM SisProgramas s WHERE s.id = :id"),
    @NamedQuery(name = "SisProgramas.findByModulo", query = "SELECT s FROM SisProgramas s WHERE s.modulo = :modulo"),
    @NamedQuery(name = "SisProgramas.findByNombre", query = "SELECT s FROM SisProgramas s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SisProgramas.findByNombreWeb", query = "SELECT s FROM SisProgramas s WHERE s.nombreWeb = :nombreWeb"),
    @NamedQuery(name = "SisProgramas.findByTipo", query = "SELECT s FROM SisProgramas s WHERE s.tipo = :tipo"),
    @NamedQuery(name = "SisProgramas.findByIcono", query = "SELECT s FROM SisProgramas s WHERE s.icono = :icono"),
    @NamedQuery(name = "SisProgramas.findByTitulo", query = "SELECT s FROM SisProgramas s WHERE s.titulo = :titulo"),
    @NamedQuery(name = "SisProgramas.findByNiveles", query = "SELECT s FROM SisProgramas s WHERE s.niveles = :niveles"),
    @NamedQuery(name = "SisProgramas.findByHabilitado", query = "SELECT s FROM SisProgramas s WHERE s.habilitado = :habilitado")})
public class SisProgramas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "MODULO")
    private Integer modulo;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name = "NOMBRE_WEB")
    private String nombreWeb;
    @Column(name = "TIPO")
    private Character tipo;
    @Size(max = 50)
    @Column(name = "ICONO")
    private String icono;
    @Size(max = 50)
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "NIVELES")
    private Short niveles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HABILITADO")
    private char habilitado;
    
    @OneToMany(mappedBy = "programa",fetch=FetchType.EAGER)
    private Collection<SisAccesos> SisAccesosCollection;

    public Collection<SisAccesos> getSisAccesosCollection() {
        return SisAccesosCollection;
    }

    public void setSisAccesosCollection(Collection<SisAccesos> SisAccesosCollection) {
        this.SisAccesosCollection = SisAccesosCollection;
    }

    public SisProgramas() {
    }

    public SisProgramas(Integer id) {
        this.id = id;
    }

    public SisProgramas(Integer id, char habilitado) {
        this.id = id;
        this.habilitado = habilitado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getModulo() {
        return modulo;
    }

    public void setModulo(Integer modulo) {
        this.modulo = modulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreWeb() {
        return nombreWeb;
    }

    public void setNombreWeb(String nombreWeb) {
        this.nombreWeb = nombreWeb;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Short getNiveles() {
        return niveles;
    }

    public void setNiveles(Short niveles) {
        this.niveles = niveles;
    }

    public char getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(char habilitado) {
        this.habilitado = habilitado;
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
        if (!(object instanceof SisProgramas)) {
            return false;
        }
        SisProgramas other = (SisProgramas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acad.entity.SisProgramas[ id=" + id + " ]";
    }
    
}
