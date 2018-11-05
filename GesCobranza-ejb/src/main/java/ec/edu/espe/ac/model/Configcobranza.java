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
 *
 * @author User
 */
@Entity
@Table(name = "CONFIGCOBRANZA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configcobranza.findAll", query = "SELECT c FROM Configcobranza c")
    , @NamedQuery(name = "Configcobranza.findByUserID", query = "SELECT c FROM Configcobranza c WHERE c.id = :userid")
    , @NamedQuery(name = "Configcobranza.findByCarteraID", query = "SELECT c FROM Configcobranza c WHERE c.codigocartera = :codigocartera")
    , @NamedQuery(name = "Configcobranza.findByCodigoconf", query = "SELECT c FROM Configcobranza c WHERE c.codigoconf = :codigoconf")
    , @NamedQuery(name = "Configcobranza.findByAccion", query = "SELECT c FROM Configcobranza c WHERE c.accion = :accion")
    , @NamedQuery(name = "Configcobranza.findByEstado", query = "SELECT c FROM Configcobranza c WHERE c.estado = :estado")
    , @NamedQuery(name = "Configcobranza.findByFechaatencion", query = "SELECT c FROM Configcobranza c WHERE c.fechaatencion = :fechaatencion")
    , @NamedQuery(name = "Configcobranza.findByResultado", query = "SELECT c FROM Configcobranza c WHERE c.resultado = :resultado")
    , @NamedQuery(name = "Configcobranza.findByDetalleresultado", query = "SELECT c FROM Configcobranza c WHERE c.detalleresultado = :detalleresultado")
    , @NamedQuery(name = "Configcobranza.findByCostollamada", query = "SELECT c FROM Configcobranza c WHERE c.costollamada = :costollamada")})
public class Configcobranza implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOCONF")
    private BigDecimal codigoconf;
    @Size(max = 150)
    @Column(name = "ACCION")
    private String accion;
    @Size(max = 100)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "FECHAATENCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaatencion;
    @Size(max = 150)
    @Column(name = "RESULTADO")
    private String resultado;
    @Size(max = 150)
    @Column(name = "DETALLERESULTADO")
    private String detalleresultado;
    @Column(name = "COSTOLLAMADA")
    private BigInteger costollamada;
    @JoinColumn(name = "CODIGOCARTERA", referencedColumnName = "CODIGOCARTERA")
    @ManyToOne
    private Cartera codigocartera;
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    @ManyToOne
    private Usuario id;

    public Configcobranza() {
    }

    public Configcobranza(BigDecimal codigoconf) {
        this.codigoconf = codigoconf;
    }

    public BigDecimal getCodigoconf() {
        return codigoconf;
    }

    public void setCodigoconf(BigDecimal codigoconf) {
        this.codigoconf = codigoconf;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaatencion() {
        return fechaatencion;
    }

    public void setFechaatencion(Date fechaatencion) {
        this.fechaatencion = fechaatencion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getDetalleresultado() {
        return detalleresultado;
    }

    public void setDetalleresultado(String detalleresultado) {
        this.detalleresultado = detalleresultado;
    }

    public BigInteger getCostollamada() {
        return costollamada;
    }

    public void setCostollamada(BigInteger costollamada) {
        this.costollamada = costollamada;
    }

    public Cartera getCodigocartera() {
        return codigocartera;
    }

    public void setCodigocartera(Cartera codigocartera) {
        this.codigocartera = codigocartera;
    }

    public Usuario getId() {
        return id;
    }

    public void setId(Usuario id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoconf != null ? codigoconf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configcobranza)) {
            return false;
        }
        Configcobranza other = (Configcobranza) object;
        if ((this.codigoconf == null && other.codigoconf != null) || (this.codigoconf != null && !this.codigoconf.equals(other.codigoconf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ac.model.Configcobranza[ codigoconf=" + codigoconf + " ]";
    }
    
}
