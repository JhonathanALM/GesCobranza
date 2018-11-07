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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author jhona
 */
@Entity
@Table(name = "PERMORA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permora.findAll", query = "SELECT p FROM Permora p")
    , @NamedQuery(name = "Permora.findByCodigopermora", query = "SELECT p FROM Permora p WHERE p.codigopermora = :codigopermora")
    , @NamedQuery(name = "Permora.findByFechacarga", query = "SELECT p FROM Permora p WHERE p.fechacarga = :fechacarga")
    , @NamedQuery(name = "Permora.findByCiRuc", query = "SELECT p FROM Permora p WHERE p.ciRuc = :ciRuc")
    , @NamedQuery(name = "Permora.findByNombrecliente", query = "SELECT p FROM Permora p WHERE p.nombrecliente = :nombrecliente")
    , @NamedQuery(name = "Permora.findByNombreproducto", query = "SELECT p FROM Permora p WHERE p.nombreproducto = :nombreproducto")
    , @NamedQuery(name = "Permora.findByDireccioncliente", query = "SELECT p FROM Permora p WHERE p.direccioncliente = :direccioncliente")
    , @NamedQuery(name = "Permora.findByTelefono1cliente", query = "SELECT p FROM Permora p WHERE p.telefono1cliente = :telefono1cliente")
    , @NamedQuery(name = "Permora.findByTelefono2cliente", query = "SELECT p FROM Permora p WHERE p.telefono2cliente = :telefono2cliente")
    , @NamedQuery(name = "Permora.findByCorreocliente", query = "SELECT p FROM Permora p WHERE p.correocliente = :correocliente")
    , @NamedQuery(name = "Permora.findByNombrereferencia", query = "SELECT p FROM Permora p WHERE p.nombrereferencia = :nombrereferencia")
    , @NamedQuery(name = "Permora.findByParentescoreferencia", query = "SELECT p FROM Permora p WHERE p.parentescoreferencia = :parentescoreferencia")
    , @NamedQuery(name = "Permora.findByTelefonoreferencia", query = "SELECT p FROM Permora p WHERE p.telefonoreferencia = :telefonoreferencia")
    , @NamedQuery(name = "Permora.findByNumerocuotasvencidas", query = "SELECT p FROM Permora p WHERE p.numerocuotasvencidas = :numerocuotasvencidas")
    , @NamedQuery(name = "Permora.findByDiasmora", query = "SELECT p FROM Permora p WHERE p.diasmora = :diasmora")
    , @NamedQuery(name = "Permora.findByValorcuota", query = "SELECT p FROM Permora p WHERE p.valorcuota = :valorcuota")
    , @NamedQuery(name = "Permora.findByMonto", query = "SELECT p FROM Permora p WHERE p.monto = :monto")
    , @NamedQuery(name = "Permora.findByMontointereses", query = "SELECT p FROM Permora p WHERE p.montointereses = :montointereses")
    , @NamedQuery(name = "Permora.findByMontototal", query = "SELECT p FROM Permora p WHERE p.montototal = :montototal")
    , @NamedQuery(name = "Permora.findByComentario", query = "SELECT p FROM Permora p WHERE p.comentario = :comentario")
    , @NamedQuery(name = "Permora.findByInstfinanciera", query = "SELECT p FROM Permora p WHERE p.instfinanciera = :instfinanciera")})
public class Permora implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOPERMORA")
    private BigDecimal codigopermora;
    @Column(name = "FECHACARGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacarga;
    @Size(max = 16)
    @Column(name = "CI_RUC")
    private String ciRuc;
    @Size(max = 128)
    @Column(name = "NOMBRECLIENTE")
    private String nombrecliente;
    @Size(max = 128)
    @Column(name = "NOMBREPRODUCTO")
    private String nombreproducto;
    @Size(max = 200)
    @Column(name = "DIRECCIONCLIENTE")
    private String direccioncliente;
    @Size(max = 15)
    @Column(name = "TELEFONO1CLIENTE")
    private String telefono1cliente;
    @Size(max = 15)
    @Column(name = "TELEFONO2CLIENTE")
    private String telefono2cliente;
    @Size(max = 128)
    @Column(name = "CORREOCLIENTE")
    private String correocliente;
    @Size(max = 128)
    @Column(name = "NOMBREREFERENCIA")
    private String nombrereferencia;
    @Size(max = 128)
    @Column(name = "PARENTESCOREFERENCIA")
    private String parentescoreferencia;
    @Size(max = 15)
    @Column(name = "TELEFONOREFERENCIA")
    private String telefonoreferencia;
    @Column(name = "NUMEROCUOTASVENCIDAS")
    private BigInteger numerocuotasvencidas;
    @Column(name = "DIASMORA")
    private BigInteger diasmora;
    @Column(name = "VALORCUOTA")
    private BigDecimal valorcuota;
    @Column(name = "MONTO")
    private BigDecimal monto;
    @Column(name = "MONTOINTERESES")
    private BigDecimal montointereses;
    @Column(name = "MONTOTOTAL")
    private BigDecimal montototal;
    @Size(max = 512)
    @Column(name = "COMENTARIO")
    private String comentario;
    @Size(max = 128)
    @Column(name = "INSTFINANCIERA")
    private String instfinanciera;
    @OneToMany(mappedBy = "codigopermora")
    private Collection<Cartera> carteraCollection;

    public Permora() {
    }

    public Permora(BigDecimal codigopermora) {
        this.codigopermora = codigopermora;
    }

    public BigDecimal getCodigopermora() {
        return codigopermora;
    }

    public void setCodigopermora(BigDecimal codigopermora) {
        this.codigopermora = codigopermora;
    }

    public Date getFechacarga() {
        return fechacarga;
    }

    public void setFechacarga(Date fechacarga) {
        this.fechacarga = fechacarga;
    }

    public String getCiRuc() {
        return ciRuc;
    }

    public void setCiRuc(String ciRuc) {
        this.ciRuc = ciRuc;
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

    public String getTelefono1cliente() {
        return telefono1cliente;
    }

    public void setTelefono1cliente(String telefono1cliente) {
        this.telefono1cliente = telefono1cliente;
    }

    public String getTelefono2cliente() {
        return telefono2cliente;
    }

    public void setTelefono2cliente(String telefono2cliente) {
        this.telefono2cliente = telefono2cliente;
    }

    public String getCorreocliente() {
        return correocliente;
    }

    public void setCorreocliente(String correocliente) {
        this.correocliente = correocliente;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getInstfinanciera() {
        return instfinanciera;
    }

    public void setInstfinanciera(String instfinanciera) {
        this.instfinanciera = instfinanciera;
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
        hash += (codigopermora != null ? codigopermora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permora)) {
            return false;
        }
        Permora other = (Permora) object;
        if ((this.codigopermora == null && other.codigopermora != null) || (this.codigopermora != null && !this.codigopermora.equals(other.codigopermora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ac.model.Permora[ codigopermora=" + codigopermora + " ]";
    }

}
