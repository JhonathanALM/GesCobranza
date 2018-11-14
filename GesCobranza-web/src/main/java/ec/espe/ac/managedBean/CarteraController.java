package ec.espe.ac.managedBean;

import ec.edu.espe.ac.model.Cartera;
import ec.edu.espe.ac.session.CarteraFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

@Named(value = "carteraController")
@SessionScoped
public class CarteraController implements Serializable {

    @EJB
    private CarteraFacadeLocal EJBCartera;
    private List<Cartera> items = null;
    private Cartera selected;

    private int cuantosA=0;
    private int cuantosB=0;
    private int cuantosC=0;

    public CarteraController() {
    }

    @PostConstruct
    public void init() {

        contar();
    }

    public List<Cartera> getItems() {
        if (items == null) {
            items = EJBCartera.findAll();
        }
        return items;
    }

    public void setItems(List<Cartera> items) {
        this.items = items;
    }

    public Cartera getSelected() {
        return selected;
    }

    public void setSelected(Cartera selected) {
        this.selected = selected;
    }

    public void contar() {
        for (Cartera p : EJBCartera.findAll()) {
            if (p.getEstadoasig().toString().equals("1")) {
                this.cuantosA = +this.cuantosA + 1;
            }
            if (p.getEstadoasig().toString().equals("2")) {
                this.cuantosB = +this.cuantosB + 1;
            }
            if (p.getEstadoasig().toString().equals("3")) {
                this.cuantosC = +this.cuantosC + 1;
            }
        }
    }

    public int getCuantosA() {
        return cuantosA;
    }

    public void setCuantosA(int cuantosA) {
        this.cuantosA = cuantosA;
    }

    public int getCuantosB() {
        return cuantosB;
    }

    public void setCuantosB(int cuantosB) {
        this.cuantosB = cuantosB;
    }

    public int getCuantosC() {
        return cuantosC;
    }

    public void setCuantosC(int cuantosC) {
        this.cuantosC = cuantosC;
    }

}
