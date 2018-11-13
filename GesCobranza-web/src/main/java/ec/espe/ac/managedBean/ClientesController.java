package ec.espe.ac.managedBean;

import ec.edu.espe.ac.model.Actividad;
import ec.edu.espe.ac.model.Agente;
import ec.edu.espe.ac.model.Cartera;
import ec.edu.espe.ac.model.Permora;
import ec.edu.espe.ac.session.ActividadFacadeLocal;
import ec.edu.espe.ac.session.AgenteFacadeLocal;
import ec.edu.espe.ac.session.CarteraFacadeLocal;
import ec.edu.espe.ac.session.PermoraFacadeLocal;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author jhona
 */
@Named
@SessionScoped
public class ClientesController implements Serializable {

    @EJB
    private CarteraFacadeLocal EJBCartera;
    private List<Cartera> items = null;
    private Cartera selected;

    @EJB
    private ActividadFacadeLocal EJBActividad;
    private Actividad ad;
    private List<Actividad> items2 = null;

    private String option;
    private List<String> options;

    private MenuModel model;

    @PostConstruct
    public void init() {

        ad = new Actividad();
    }

    public ClientesController() {

    }

    public void listarMenus() {
        /*First submenu
        model = new DefaultMenuModel();
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Menu de Actividades");
        
        if (this.selected.getEstadoasig() == BigInteger.valueOf(Long.valueOf(1))) {
            DefaultMenuItem item = new DefaultMenuItem("SMS");
            item.setUrl("http://www.primefaces.org");
            item.setIcon("pi pi-home");
            firstSubmenu.addElement(item);
            DefaultMenuItem item2 = new DefaultMenuItem("Email");
            item2.setUrl("http://www.primefaces.org");
            item2.setIcon("pi pi-home");
            firstSubmenu.addElement(item2);
        } else {
            DefaultMenuItem item = new DefaultMenuItem("Llamada");
            item.setUrl("http://www.primefaces.org");
            item.setIcon("pi pi-save");
            firstSubmenu.addElement(item);
        }

        model.addElement(firstSubmenu);*/
        System.out.println("LLenando el menu para " + this.selected.getEstadoasig());
        options = new ArrayList<String>();
        if (this.selected.getEstadoasig().toString().equals("1")) {
            options.add("Correo Electronico");
            options.add("SMS");
        }
        if (this.selected.getEstadoasig().toString().equals("2")) {
            options.add("Correo Electronico");
            options.add("SMS");
            options.add("Llamada Telefonica");
        }
        if (this.selected.getEstadoasig().toString().equals("3")) {
            options.add("Llamada Telefonica");
            options.add("Llamada Telefonica Familiar");
            options.add("Visita Personal");
        }

    }

    public List<Cartera> getItems() {
        Agente ar = (Agente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("agente");

        System.out.println("Estoy llenando los clientes para" + ar.getNombre() + " " + ar.getCodigoagente());
        if (items == null) {
            items = EJBCartera.CarteraFiltro(ar);
        }
        return items;
    }

    public void setItems(List<Cartera> items) {
        this.items = items;
    }

    public CarteraFacadeLocal getEJBCartera() {
        return EJBCartera;
    }

    public void setEJBCartera(CarteraFacadeLocal EJBCartera) {
        this.EJBCartera = EJBCartera;
    }

    private CarteraFacadeLocal getFacade() {
        return EJBCartera;
    }

    public Cartera getSelected() {
        System.out.println("Este es el seleccionado? " + selected.getCodigopermora().getNombrecliente());
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cartera", selected);
        return selected;
    }

    public void setSelected(Cartera selected) {
        this.selected = selected;
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public String preparateView() {
        this.listarMenus();
        return "Cliente";
    }

    public Actividad getAd() {
        return ad;
    }

    public void setAd(Actividad ad) {
        this.ad = ad;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String creando() {
        ad.setCodigact(BigDecimal.ONE);
        ad.setFechaatencion(new java.sql.Date(new java.util.Date().getTime()));
        ad.setCodigocar(selected);
        System.out.println("|>>" + ad.getDetalle());
        EJBActividad.create(ad);
        return "Menu Cliente";
    }

    public List<Actividad> getItems2() {
        System.out.println("Estoy las actividades de: " + this.selected);
        if (items2 == null) {
            items2 = EJBActividad.ActividadFiltro(this.selected);
        }
        return items2;
    }

    public void setItems2(List<Actividad> items2) {
        this.items2 = items2;
    }

}
