/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ac.model;

import java.math.BigDecimal;

/**
 *
 * @author User
 */
public class ReporteBanco {
    BigDecimal total;
    String institucion;
    Integer numeroCasos;

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public Integer getNumeroCasos() {
        return numeroCasos;
    }

    public void setNumeroCasos(Integer numeroCasos) {
        this.numeroCasos = numeroCasos;
    }
    
    
    
}
