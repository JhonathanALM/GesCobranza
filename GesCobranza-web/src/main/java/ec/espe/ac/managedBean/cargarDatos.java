package ec.espe.ac.managedBean;

import ec.edu.espe.ac.model.Permora;
import ec.edu.espe.ac.session.PermoraFacadeLocal;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import javax.inject.Named;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import sun.applet.Main;

/**
 *
 * @author jhona
 */
@Named
@ViewScoped
public class cargarDatos implements Serializable {

    @EJB
    private PermoraFacadeLocal EJBPermora;
    private Permora ct = new Permora();

    public String add() {
        int cont = 1;
        System.out.println("Entro a cargar...");
        File fileMora = new File("c:\\tmp\\uno.txt");
        List<String> readLines = new ArrayList<String>();
        try {
            readLines = verificateFiles(fileMora);
        } catch (IOException ex) {
            Logger.getLogger(cargarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (readLines != null) {
            transferData(readLines);
        }
        System.out.println("Dia " + cont);
        cont++;
        return "inicio";
    }

    private List<String> verificateFiles(File file) throws IOException {
        List<String> readLines;
        if (file.exists()) {
            readLines = FileUtils.readLines(file, "UTF-8");
        } else {

            readLines = null;
        }
        return readLines;
    }

    private void transferData(List<String> readSource) {
       Iterator iter = readSource.iterator();
        String[] values;
        StringBuilder sb = new StringBuilder();
        int i=0;
        while (iter.hasNext()) {
            Permora cr= new Permora();
            values = iter.next().toString().split(",");
            System.out.println("Hola : " + values[0] + " " + values[1]);                    
            ct.setCodigopermora(BigDecimal.valueOf(Long.valueOf(i)));
            ct.setFechacarga(new java.sql.Date(new java.util.Date().getTime()));
            ct.setCiRuc(values[0]);
            ct.setNombrecliente(values[1]);
            ct.setNombreproducto(values[2]);
            ct.setDireccioncliente(values[3]);
            ct.setTelefono1cliente(values[4]);
            ct.setTelefono2cliente(values[5]);
            ct.setCorreocliente(values[6]);
            ct.setNombrereferencia(values[7]);
            ct.setParentescoreferencia(values[8]);
            ct.setTelefonoreferencia(values[9]);
            ct.setNumerocuotasvencidas(BigInteger.valueOf(Long.valueOf(values[10])));
            ct.setDiasmora(BigInteger.valueOf(Long.valueOf(values[11])));
            ct.setValorcuota(BigDecimal.valueOf(Double.valueOf(values[12])));
            ct.setMonto(BigDecimal.valueOf(Double.valueOf(values[13])));
            ct.setMontointereses(BigDecimal.valueOf(Double.valueOf(values[14])));
            ct.setMontototal(BigDecimal.valueOf(Double.valueOf(values[15])));
            ct.setComentario(values[16]);
            ct.setInstfinanciera(values[17]);
            this.EJBPermora.create(this.ct);
            i=i+1;
        }
    }
    
    /*public String add(){
        //System.out.println("anaianaianianainainaiani");
        this.ct.setCodigocartera("1");
        this.ct.setFechacarga(new java.sql.Date(new java.util.Date().getTime()));
        cargar();
        System.out.println(ct.getCodigocartera()+" "+ct.getFechacarga()+"-"+ct.getNombrecliente());
        this.EJBPermora.create(this.ct);
        return "index";
    }*/

    /*public Permora getCt() {
        return ct;
    }

    public void setCt(Permora ct) {
        this.ct = ct;
    }*/

    

}
