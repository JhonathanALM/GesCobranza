/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.ac.managedBean;

import ec.edu.espe.ac.model.Actividad;
import ec.edu.espe.ac.model.Cartera;
import ec.edu.espe.ac.session.ActividadFacadeLocal;
import ec.edu.espe.ac.session.CarteraFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.LinearAxis;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.OhlcChartModel;
import org.primefaces.model.chart.OhlcChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author pc
 */
@Named(value = "estadistica1Controller")
@SessionScoped
public class Estadistica1Controller implements Serializable {

    /**
     * Creates a new instance of Estadistica1Controller
     */
    @EJB
    private ActividadFacadeLocal EJBCartera;
    private List<Actividad> items = null;
    private Actividad selected;

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU");
    EntityManager em1 = factory.createEntityManager();

    private BarChartModel barModel;
    private BarChartModel barModelLlamada;
    private BarChartModel barModelSMS;
    private BarChartModel barModelCorreo;

    @PostConstruct
    public void init() {
        createBarModels();

    }

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public BarChartModel getBarModelLlamada() {
        return barModelLlamada;
    }

    public void setBarModelLlamada(BarChartModel barModelLlamada) {
        this.barModelLlamada = barModelLlamada;
    }

    public BarChartModel getBarModelSMS() {
        return barModelSMS;
    }

    public void setBarModelSMS(BarChartModel barModelSMS) {
        this.barModelSMS = barModelSMS;
    }

    public BarChartModel getBarModelCorreo() {
        return barModelCorreo;
    }

    public void setBarModelCorreo(BarChartModel barModelCorreo) {
        this.barModelCorreo = barModelCorreo;
    }

    public ActividadFacadeLocal getEJBCartera() {
        return EJBCartera;
    }

    public void setEJBCartera(ActividadFacadeLocal EJBCartera) {
        this.EJBCartera = EJBCartera;
    }

    public List<Actividad> getItems() {
        return items;
    }

    public void setItems(List<Actividad> items) {
        this.items = items;
    }

    public Actividad getSelected() {
        return selected;
    }

    public void setSelected(Actividad selected) {
        this.selected = selected;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    public BarChartModel initBarModel() {
        Query qll = em1.createNativeQuery("SELECT ESTADO FROM ACTIVIDAD WHERE ESTADO='" + "ATENDIDO" + "' AND TIPO='" + "Llamada Telefonica" + "'");
        Query qcr = em1.createNativeQuery("SELECT ESTADO FROM ACTIVIDAD WHERE ESTADO='" + "ATENDIDO" + "' AND TIPO='" + "Correo Electronico" + "'");
        Query qsms = em1.createNativeQuery("SELECT ESTADO FROM ACTIVIDAD WHERE ESTADO='" + "ATENDIDO" + "' AND TIPO='" + "SMS" + "'");
               
        BarChartModel model = new BarChartModel();
        ChartSeries llm = new ChartSeries();
        llm.setLabel("Llamadas");
        llm.set("Actividades", qll.getResultList().size());
        ChartSeries correo = new ChartSeries();
        correo.setLabel("Correos");
        correo.set("Actividades", qcr.getResultList().size());
        ChartSeries sms = new ChartSeries();
        sms.setLabel("SMS");
        sms.set("Actividades", qsms.getResultList().size());
        model.addSeries(llm);
        model.addSeries(correo);
        model.addSeries(sms);

        return model;
    }

    public BarChartModel initBarModelLlamadas() {
        Query q = em1.createNativeQuery("SELECT ESTADO FROM ACTIVIDAD WHERE ESTADO='" + "ATENDIDO" + "' AND TIPO='" + "Llamada Telefonica" + "'");
        Query q1 = em1.createNativeQuery("SELECT ESTADO FROM ACTIVIDAD WHERE ESTADO='" + "NO ATENDIDO" + "' AND TIPO='" + "Llamada Telefonica" + "'");
        BarChartModel model = new BarChartModel();
        ChartSeries llr = new ChartSeries();
        llr.setLabel("Llamadas respondidas");
        llr.set("Llamadas realizadas", q.getResultList().size());
        ChartSeries llnr = new ChartSeries();
        llnr.setLabel("Llamadas no respondidas");
        llnr.set("Llamadas realizadas", q1.getResultList().size());
        model.addSeries(llr);
        model.addSeries(llnr);
        return model;
    }

    public BarChartModel initBarModelCorreo() {
        BarChartModel model = new BarChartModel();
        Query q2 = em1.createNativeQuery("SELECT ESTADO FROM ACTIVIDAD WHERE ESTADO='" + "ATENDIDO" + "' AND TIPO='" + "Correo Electronico" + "'");
        ChartSeries ce = new ChartSeries();
        ce.setLabel("Correos enviados");
        ce.set("correos enviados", q2.getResultList().size());
        model.addSeries(ce);
        return model;
    }

    public BarChartModel initBarModelSMS() {
        BarChartModel model = new BarChartModel();
        Query q4 = em1.createNativeQuery("SELECT ESTADO FROM ACTIVIDAD WHERE ESTADO='" + "ATENDIDO" + "' AND TIPO='" + "SMS" + "'");
        ChartSeries smse = new ChartSeries();
        smse.setLabel("SMS");
        smse.set("SMS Enviados", q4.getResultList().size());
        model.addSeries(smse);
        return model;
    }

    public void createBarModels() {
        createBarModel();
        createBarModelLlamadas();
        createBarModelCorreo();
        createBarModelSMS();
    }

    public void createBarModel() {
        barModel = initBarModel();
        barModel.setTitle("Casos atendidos");
        barModel.setLegendPosition("ne");
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("");
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad");
        yAxis.setMin(0);
        yAxis.setMax(5);
    }

    public void createBarModelLlamadas() {
        barModelLlamada = initBarModelLlamadas();
        barModelLlamada.setTitle("Llamadas");
        barModelLlamada.setLegendPosition("ne");
        Axis xAxis = barModelLlamada.getAxis(AxisType.X);
        xAxis.setLabel("");
        Axis yAxis = barModelLlamada.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad");
        yAxis.setMin(0);
        yAxis.setMax(5);
    }

    public void createBarModelCorreo() {
        barModelCorreo = initBarModelCorreo();
        barModelCorreo.setTitle("Correos");
        barModelCorreo.setLegendPosition("ne");
        Axis xAxis = barModelCorreo.getAxis(AxisType.X);
        xAxis.setLabel("");
        Axis yAxis = barModelCorreo.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad");
        yAxis.setMin(0);
        yAxis.setMax(5);
    }

    public void createBarModelSMS() {
        barModelSMS = initBarModelSMS();
        barModelSMS.setTitle("SMS");
        barModelSMS.setLegendPosition("ne");
        Axis xAxis = barModelSMS.getAxis(AxisType.X);
        xAxis.setLabel("");
        Axis yAxis = barModelSMS.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad");
        yAxis.setMin(0);
        yAxis.setMax(5);
    }

}
