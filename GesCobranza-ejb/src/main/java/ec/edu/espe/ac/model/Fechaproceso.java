package ec.edu.espe.ac.model;

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
 * @author jhona
 */
@Entity
@Table(name = "FECHAPROCESO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fechaproceso.findAll", query = "SELECT f FROM Fechaproceso f")
    , @NamedQuery(name = "Fechaproceso.findByCodfeproc", query = "SELECT f FROM Fechaproceso f WHERE f.codfeproc = :codfeproc")
    , @NamedQuery(name = "Fechaproceso.findByFecha", query = "SELECT f FROM Fechaproceso f WHERE f.fecha = :fecha")
    , @NamedQuery(name = "Fechaproceso.findByDescripcion", query = "SELECT f FROM Fechaproceso f WHERE f.descripcion = :descripcion")})
public class Fechaproceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CODFEPROC")
    private String codfeproc;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 128)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public Fechaproceso() {
    }

    public Fechaproceso(String codfeproc) {
        this.codfeproc = codfeproc;
    }

    public String getCodfeproc() {
        return codfeproc;
    }

    public void setCodfeproc(String codfeproc) {
        this.codfeproc = codfeproc;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codfeproc != null ? codfeproc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fechaproceso)) {
            return false;
        }
        Fechaproceso other = (Fechaproceso) object;
        if ((this.codfeproc == null && other.codfeproc != null) || (this.codfeproc != null && !this.codfeproc.equals(other.codfeproc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ac.model.Fechaproceso[ codfeproc=" + codfeproc + " ]";
    }

}
