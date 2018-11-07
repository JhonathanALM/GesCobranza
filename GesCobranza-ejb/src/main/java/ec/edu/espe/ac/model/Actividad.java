package ec.edu.espe.ac.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ACTIVIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a")
    , @NamedQuery(name = "Actividad.findByCodigact", query = "SELECT a FROM Actividad a WHERE a.codigact = :codigact")
    , @NamedQuery(name = "Actividad.findByFechaatencion", query = "SELECT a FROM Actividad a WHERE a.fechaatencion = :fechaatencion")
    , @NamedQuery(name = "Actividad.findByTipo", query = "SELECT a FROM Actividad a WHERE a.tipo = :tipo")
    , @NamedQuery(name = "Actividad.findByEtiqueta", query = "SELECT a FROM Actividad a WHERE a.etiqueta = :etiqueta")
    , @NamedQuery(name = "Actividad.findByEstado", query = "SELECT a FROM Actividad a WHERE a.estado = :estado")
    , @NamedQuery(name = "Actividad.findByFechatentativa", query = "SELECT a FROM Actividad a WHERE a.fechatentativa = :fechatentativa")
    , @NamedQuery(name = "Actividad.findByDetalle", query = "SELECT a FROM Actividad a WHERE a.detalle = :detalle")
    , @NamedQuery(name = "Actividad.findByValor", query = "SELECT a FROM Actividad a WHERE a.valor = :valor")
    , @NamedQuery(name = "Actividad.findByOtro", query = "SELECT a FROM Actividad a WHERE a.otro = :otro")})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGACT")
    private BigDecimal codigact;
    @Column(name = "FECHAATENCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaatencion;
    @Size(max = 128)
    @Column(name = "TIPO")
    private String tipo;
    @Size(max = 128)
    @Column(name = "ETIQUETA")
    private String etiqueta;
    @Size(max = 128)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "FECHATENTATIVA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechatentativa;
    @Size(max = 1024)
    @Column(name = "DETALLE")
    private String detalle;
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Size(max = 512)
    @Column(name = "OTRO")
    private String otro;
    @JoinColumn(name = "CODIGOCAR", referencedColumnName = "CODIGOCAR")
    @ManyToOne
    private Cartera codigocar;

    public Actividad() {
    }

    public Actividad(BigDecimal codigact) {
        this.codigact = codigact;
    }

    public BigDecimal getCodigact() {
        return codigact;
    }

    public void setCodigact(BigDecimal codigact) {
        this.codigact = codigact;
    }

    public Date getFechaatencion() {
        return fechaatencion;
    }

    public void setFechaatencion(Date fechaatencion) {
        this.fechaatencion = fechaatencion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechatentativa() {
        return fechatentativa;
    }

    public void setFechatentativa(Date fechatentativa) {
        this.fechatentativa = fechatentativa;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getOtro() {
        return otro;
    }

    public void setOtro(String otro) {
        this.otro = otro;
    }

    public Cartera getCodigocar() {
        return codigocar;
    }

    public void setCodigocar(Cartera codigocar) {
        this.codigocar = codigocar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigact != null ? codigact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.codigact == null && other.codigact != null) || (this.codigact != null && !this.codigact.equals(other.codigact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ac.model.Actividad[ codigact=" + codigact + " ]";
    }

}
