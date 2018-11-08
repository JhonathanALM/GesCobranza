package ec.edu.espe.ac.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author jhona
 */
@Entity
@Table(name = "CARTERA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartera.findAll", query = "SELECT c FROM Cartera c")
    , @NamedQuery(name = "Cartera.findByCodigocar", query = "SELECT c FROM Cartera c WHERE c.codigocar = :codigocar")
    , @NamedQuery(name = "Cartera.findByFechaasig", query = "SELECT c FROM Cartera c WHERE c.fechaasig = :fechaasig")
    , @NamedQuery(name = "Cartera.findByEstadoasig", query = "SELECT c FROM Cartera c WHERE c.estadoasig = :estadoasig")
    ,@NamedQuery(name =  "Users.findByName", query = "SELECT c FROM Cartera c WHERE c.codigoagente= :name")})
public class Cartera implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOCAR")
    private BigDecimal codigocar;
    @Column(name = "FECHAASIG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaasig;
    @Column(name = "ESTADOASIG")
    private BigInteger estadoasig;
    @JoinColumn(name = "CODIGOAGENTE", referencedColumnName = "CODIGOAGENTE")
    @ManyToOne
    private Agente codigoagente;
    @JoinColumn(name = "CODIGOPERMORA", referencedColumnName = "CODIGOPERMORA")
    @ManyToOne
    private Permora codigopermora;
    @OneToMany(mappedBy = "codigocar")
    private Collection<Actividad> actividadCollection;

    public Cartera() {
    }

    public Cartera(BigDecimal codigocar) {
        this.codigocar = codigocar;
    }

    public BigDecimal getCodigocar() {
        return codigocar;
    }

    public void setCodigocar(BigDecimal codigocar) {
        this.codigocar = codigocar;
    }

    public Date getFechaasig() {
        return fechaasig;
    }

    public void setFechaasig(Date fechaasig) {
        this.fechaasig = fechaasig;
    }

    public BigInteger getEstadoasig() {
        return estadoasig;
    }

    public void setEstadoasig(BigInteger estadoasig) {
        this.estadoasig = estadoasig;
    }

    public Agente getCodigoagente() {
        return codigoagente;
    }

    public void setCodigoagente(Agente codigoagente) {
        this.codigoagente = codigoagente;
    }

    public Permora getCodigopermora() {
        return codigopermora;
    }

    public void setCodigopermora(Permora codigopermora) {
        this.codigopermora = codigopermora;
    }

    @XmlTransient
    public Collection<Actividad> getActividadCollection() {
        return actividadCollection;
    }

    public void setActividadCollection(Collection<Actividad> actividadCollection) {
        this.actividadCollection = actividadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocar != null ? codigocar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartera)) {
            return false;
        }
        Cartera other = (Cartera) object;
        if ((this.codigocar == null && other.codigocar != null) || (this.codigocar != null && !this.codigocar.equals(other.codigocar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ac.model.Cartera[ codigocar=" + codigocar + " ]";
    }

}
