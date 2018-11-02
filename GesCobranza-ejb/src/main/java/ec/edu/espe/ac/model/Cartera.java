package ec.edu.espe.ac.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "CARTERA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartera.findAll", query = "SELECT c FROM Cartera c")
    , @NamedQuery(name = "Cartera.findByCodigocartera", query = "SELECT c FROM Cartera c WHERE c.codigocartera = :codigocartera")
    , @NamedQuery(name = "Cartera.findByNombrecliente", query = "SELECT c FROM Cartera c WHERE c.nombrecliente = :nombrecliente")
    , @NamedQuery(name = "Cartera.findByNombreproducto", query = "SELECT c FROM Cartera c WHERE c.nombreproducto = :nombreproducto")
    , @NamedQuery(name = "Cartera.findByDireccioncliente", query = "SELECT c FROM Cartera c WHERE c.direccioncliente = :direccioncliente")
    , @NamedQuery(name = "Cartera.findByTelefonocliente", query = "SELECT c FROM Cartera c WHERE c.telefonocliente = :telefonocliente")
    , @NamedQuery(name = "Cartera.findByNombrereferencia", query = "SELECT c FROM Cartera c WHERE c.nombrereferencia = :nombrereferencia")
    , @NamedQuery(name = "Cartera.findByParentescoreferencia", query = "SELECT c FROM Cartera c WHERE c.parentescoreferencia = :parentescoreferencia")
    , @NamedQuery(name = "Cartera.findByTelefonoreferencia", query = "SELECT c FROM Cartera c WHERE c.telefonoreferencia = :telefonoreferencia")
    , @NamedQuery(name = "Cartera.findByNumerocuotasvencidas", query = "SELECT c FROM Cartera c WHERE c.numerocuotasvencidas = :numerocuotasvencidas")
    , @NamedQuery(name = "Cartera.findByDiasmora", query = "SELECT c FROM Cartera c WHERE c.diasmora = :diasmora")
    , @NamedQuery(name = "Cartera.findByValorcuota", query = "SELECT c FROM Cartera c WHERE c.valorcuota = :valorcuota")
    , @NamedQuery(name = "Cartera.findByMonto", query = "SELECT c FROM Cartera c WHERE c.monto = :monto")
    , @NamedQuery(name = "Cartera.findByMontointereses", query = "SELECT c FROM Cartera c WHERE c.montointereses = :montointereses")
    , @NamedQuery(name = "Cartera.findByMontototal", query = "SELECT c FROM Cartera c WHERE c.montototal = :montototal")
    , @NamedQuery(name = "Cartera.findByCiRuc", query = "SELECT c FROM Cartera c WHERE c.ciRuc = :ciRuc")})
public class Cartera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODIGOCARTERA")
    private String codigocartera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRECLIENTE")
    private String nombrecliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "NOMBREPRODUCTO")
    private String nombreproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DIRECCIONCLIENTE")
    private String direccioncliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TELEFONOCLIENTE")
    private String telefonocliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBREREFERENCIA")
    private String nombrereferencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PARENTESCOREFERENCIA")
    private String parentescoreferencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TELEFONOREFERENCIA")
    private String telefonoreferencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMEROCUOTASVENCIDAS")
    private BigInteger numerocuotasvencidas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIASMORA")
    private BigInteger diasmora;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALORCUOTA")
    private BigDecimal valorcuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO")
    private BigDecimal monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTOINTERESES")
    private BigDecimal montointereses;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTOTOTAL")
    private BigDecimal montototal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "CI_RUC")
    private String ciRuc;
    @OneToMany(mappedBy = "codigocartera")
    private Collection<Configcobranza> configcobranzaCollection;

    public Cartera() {
    }

    public Cartera(String codigocartera) {
        this.codigocartera = codigocartera;
    }

    public Cartera(String codigocartera, String nombrecliente, String nombreproducto, String direccioncliente, String telefonocliente, String nombrereferencia, String parentescoreferencia, String telefonoreferencia, BigInteger numerocuotasvencidas, BigInteger diasmora, BigDecimal valorcuota, BigDecimal monto, BigDecimal montointereses, BigDecimal montototal, String ciRuc) {
        this.codigocartera = codigocartera;
        this.nombrecliente = nombrecliente;
        this.nombreproducto = nombreproducto;
        this.direccioncliente = direccioncliente;
        this.telefonocliente = telefonocliente;
        this.nombrereferencia = nombrereferencia;
        this.parentescoreferencia = parentescoreferencia;
        this.telefonoreferencia = telefonoreferencia;
        this.numerocuotasvencidas = numerocuotasvencidas;
        this.diasmora = diasmora;
        this.valorcuota = valorcuota;
        this.monto = monto;
        this.montointereses = montointereses;
        this.montototal = montototal;
        this.ciRuc = ciRuc;
    }

    public String getCodigocartera() {
        return codigocartera;
    }

    public void setCodigocartera(String codigocartera) {
        this.codigocartera = codigocartera;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public String getDireccioncliente() {
        return direccioncliente;
    }

    public void setDireccioncliente(String direccioncliente) {
        this.direccioncliente = direccioncliente;
    }

    public String getTelefonocliente() {
        return telefonocliente;
    }

    public void setTelefonocliente(String telefonocliente) {
        this.telefonocliente = telefonocliente;
    }

    public String getNombrereferencia() {
        return nombrereferencia;
    }

    public void setNombrereferencia(String nombrereferencia) {
        this.nombrereferencia = nombrereferencia;
    }

    public String getParentescoreferencia() {
        return parentescoreferencia;
    }

    public void setParentescoreferencia(String parentescoreferencia) {
        this.parentescoreferencia = parentescoreferencia;
    }

    public String getTelefonoreferencia() {
        return telefonoreferencia;
    }

    public void setTelefonoreferencia(String telefonoreferencia) {
        this.telefonoreferencia = telefonoreferencia;
    }

    public BigInteger getNumerocuotasvencidas() {
        return numerocuotasvencidas;
    }

    public void setNumerocuotasvencidas(BigInteger numerocuotasvencidas) {
        this.numerocuotasvencidas = numerocuotasvencidas;
    }

    public BigInteger getDiasmora() {
        return diasmora;
    }

    public void setDiasmora(BigInteger diasmora) {
        this.diasmora = diasmora;
    }

    public BigDecimal getValorcuota() {
        return valorcuota;
    }

    public void setValorcuota(BigDecimal valorcuota) {
        this.valorcuota = valorcuota;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getMontointereses() {
        return montointereses;
    }

    public void setMontointereses(BigDecimal montointereses) {
        this.montointereses = montointereses;
    }

    public BigDecimal getMontototal() {
        return montototal;
    }

    public void setMontototal(BigDecimal montototal) {
        this.montototal = montototal;
    }

    public String getCiRuc() {
        return ciRuc;
    }

    public void setCiRuc(String ciRuc) {
        this.ciRuc = ciRuc;
    }

    @XmlTransient
    public Collection<Configcobranza> getConfigcobranzaCollection() {
        return configcobranzaCollection;
    }

    public void setConfigcobranzaCollection(Collection<Configcobranza> configcobranzaCollection) {
        this.configcobranzaCollection = configcobranzaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocartera != null ? codigocartera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartera)) {
            return false;
        }
        Cartera other = (Cartera) object;
        if ((this.codigocartera == null && other.codigocartera != null) || (this.codigocartera != null && !this.codigocartera.equals(other.codigocartera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ac.model.Cartera[ codigocartera=" + codigocartera + " ]";
    }

}
