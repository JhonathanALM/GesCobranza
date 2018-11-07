package ec.edu.espe.ac.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author jhona
 */
@Entity
@Table(name = "AGENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agente.findAll", query = "SELECT a FROM Agente a")
    , @NamedQuery(name = "Agente.findByCodigoagente", query = "SELECT a FROM Agente a WHERE a.codigoagente = :codigoagente")
    , @NamedQuery(name = "Agente.findByNombre", query = "SELECT a FROM Agente a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Agente.findByClave", query = "SELECT a FROM Agente a WHERE a.clave = :clave")
    , @NamedQuery(name = "Agente.findByCorreo", query = "SELECT a FROM Agente a WHERE a.correo = :correo")
    , @NamedQuery(name = "Agente.findByTipo", query = "SELECT a FROM Agente a WHERE a.tipo = :tipo")})
public class Agente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOAGENTE")
    private BigDecimal codigoagente;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 32)
    @Column(name = "CLAVE")
    private String clave;
    @Size(max = 64)
    @Column(name = "CORREO")
    private String correo;
    @Size(max = 128)
    @Column(name = "TIPO")
    private String tipo;
    @OneToMany(mappedBy = "codigoagente")
    private Collection<Cartera> carteraCollection;

    public Agente() {
    }

    public Agente(BigDecimal codigoagente) {
        this.codigoagente = codigoagente;
    }

    public BigDecimal getCodigoagente() {
        return codigoagente;
    }

    public void setCodigoagente(BigDecimal codigoagente) {
        this.codigoagente = codigoagente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Cartera> getCarteraCollection() {
        return carteraCollection;
    }

    public void setCarteraCollection(Collection<Cartera> carteraCollection) {
        this.carteraCollection = carteraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoagente != null ? codigoagente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agente)) {
            return false;
        }
        Agente other = (Agente) object;
        if ((this.codigoagente == null && other.codigoagente != null) || (this.codigoagente != null && !this.codigoagente.equals(other.codigoagente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ac.model.Agente[ codigoagente=" + codigoagente + " ]";
    }

}
