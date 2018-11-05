/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ac.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
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
 *
 * @author User
 */
@Entity
@Table(name = "CARTERA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartera.findAll", query = "SELECT c FROM Cartera c")
    , @NamedQuery(name = "Cartera.findByCodigocartera", query = "SELECT c FROM Cartera c WHERE c.codigocartera = :codigocartera")
    , @NamedQuery(name = "Cartera.findByFechacarga", query = "SELECT c FROM Cartera c WHERE c.fechacarga = :fechacarga")
    , @NamedQuery(name = "Cartera.findByCiRuc", query = "SELECT c FROM Cartera c WHERE c.ciRuc = :ciRuc")
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
    , @NamedQuery(name = "Cartera.findByMontototal", query = "SELECT c FROM Cartera c WHERE c.montototal = :montototal")})
public class Cartera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODIGOCARTERA")
    private String codigocartera;
    @Column(name = "FECHACARGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacarga;
    @Size(max = 16)
    @Column(name = "CI_RUC")
    private String ciRuc;
    @Size(max = 100)
    @Column(name = "NOMBRECLIENTE")
    private String nombrecliente;
    @Size(max = 80)
    @Column(name = "NOMBREPRODUCTO")
    private String nombreproducto;
    @Size(max = 200)
    @Column(name = "DIRECCIONCLIENTE")
    private String direccioncliente;
    @Size(max = 15)
    @Column(name = "TELEFONOCLIENTE")
    private String telefonocliente;
    @Size(max = 100)
    @Column(name = "NOMBREREFERENCIA")
    private String nombrereferencia;
    @Size(max = 20)
    @Column(name = "PARENTESCOREFERENCIA")
    private String parentescoreferencia;
    @Size(max = 15)
    @Column(name = "TELEFONOREFERENCIA")
    private String telefonoreferencia;
    @Column(name = "NUMEROCUOTASVENCIDAS")
    private BigInteger numerocuotasvencidas;
    @Column(name = "DIASMORA")
    private BigInteger diasmora;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORCUOTA")
    private BigDecimal valorcuota;
    @Column(name = "MONTO")
    private BigDecimal monto;
    @Column(name = "MONTOINTERESES")
    private BigDecimal montointereses;
    @Column(name = "MONTOTOTAL")
    private BigDecimal montototal;
    @OneToMany(mappedBy = "codigocartera")
    private List<Configcobranza> configcobranzaList;

    public Cartera() {
    }

    public Cartera(String codigocartera) {
        this.codigocartera = codigocartera;
    }

    public String getCodigocartera() {
        return codigocartera;
    }

    public void setCodigocartera(String codigocartera) {
        this.codigocartera = codigocartera;
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

    @XmlTransient
    public List<Configcobranza> getConfigcobranzaList() {
        return configcobranzaList;
    }

    public void setConfigcobranzaList(List<Configcobranza> configcobranzaList) {
        this.configcobranzaList = configcobranzaList;
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
