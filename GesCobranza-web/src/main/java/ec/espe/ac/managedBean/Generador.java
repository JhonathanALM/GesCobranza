package ec.espe.ac.managedBean;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import org.apache.commons.io.FileUtils;
import org.apache.commons.text.RandomStringGenerator;
@Stateless
public class Generador {
private void generarRegistros() throws UnsupportedEncodingException, IOException {
        RandomStringGenerator numberGenerator = new RandomStringGenerator.Builder()
                .withinRange('0', '9').build();
        Random aleatorio = new Random(System.currentTimeMillis());
        int intAletorio = aleatorio.nextInt(24);
        int codCartera  = aleatorio.nextInt(999999999);
        int intAletorio2;
        
        
        
        StringBuilder sb = new StringBuilder();
        
        long start = System.currentTimeMillis();
        
        String[]ho=matNombre("hombre");
        String[]mu=matNombre("mujer");
        String[]ap=matNombre("apellido");
        
        //String[]pa=matNombre("pais");
        
        String[]prodBan=matNombre("productos");
        String[]direccionesE=matNombre("direcciones");
        String[]listaParentesco=matNombre("parentescos");
        
        
        for (int i = 0; i < 100; i++) {        
            String[] separador = null;
            String[] separador2 = null;
            try {
                //generador cedula
                RandomStringGenerator cedulaGenerator = new RandomStringGenerator.Builder()
                .withinRange('0', '9').build();
                String temp = "17"+cedulaGenerator.generate(8);
                sb.append(temp);
                sb.append(',');
                
                //generador nombres
                separador = randomNames(ap,mu,ho).split("\t");
                sb.append(separador[0]);
                sb.append(',');
                
                /*Toma randomicamente un producto bancario*/
                sb.append(randomProducto(prodBan));
                sb.append(',');
                
                /*Toma randomicamente una direccion*/
                sb.append(randomDirecciones(direccionesE));
                sb.append(',');
                                
                /*Genera randomicamente un telefono1*/
                sb.append(randomTelef());
                sb.append(',');
                /*Genera randomicamente un telefono2*/
                sb.append(randomTelef());
                sb.append(',');
                
                /*Genera correo*/
                sb.append("elverg@larga.com");
                sb.append(',');
                
                
                /*Toma randomicamente un nombre de refrencia cliente*/
                separador2 = randomNames(ap,mu,ho).split("\t");
                sb.append(separador2[0]);
                sb.append(',');
                
                /*Toma randomicamente un tipo de parentesco*/
                sb.append(randomParentesco(listaParentesco));
                sb.append(',');
                
                /*Genera randomicamente un telefono para Referencia*/
                sb.append(randomTelef());
                sb.append(',');
                
                /*Genera randomicamente un entero para mumero de cuotas Vencidas*/
                intAletorio2 = aleatorio.nextInt(12)+1;
                sb.append(intAletorio2);
                sb.append(',');
                
                /*Genera randomicamente un entero para numero de días vencido*/
                int intAletorio3 = intAletorio2 * aleatorio.nextInt(30)+1;
                sb.append(intAletorio3);
                sb.append(',');
                
                /*Genera randomicamente un monto para valor cuota*/             
                Double coutaMes = randomMonto();
                sb.append(coutaMes);
                sb.append(',');
                
                /*El monto interes se calcula en función de la gestion de la cobranza*/
                Double monto = randomInteres();
                sb.append(monto);
                sb.append(',');
                
                
                /*El monto interes se calcula en función de la gestion de la cobranza*/
                Double interes = randomInteres();
                sb.append(interes);
                sb.append(',');
                
                /*El monto interes se calcula en función de la gestion de la cobranza
                Double mora = randomInteres();
                sb.append(mora);*/
            
                /*Calcula el monto total*/
                /*El monto interes se calcula en función de la couta Mes mas los intereses*/
                Double total = coutaMes + interes;
                sb.append(total);
                sb.append(',');
                sb.append("comentario...");
                sb.append(',');
                sb.append("PICHINCHA");
                     
            } catch (IOException ex) {
                Logger.getLogger(Generador.class.getName()).log(Level.SEVERE, null, ex);
            }

            sb.append("\n");

        }
        File file = new File("c:\\tmp\\uno.txt");
        try {
            FileUtils.write(file, sb.toString(), "UTF-8", false);
        } catch (IOException ex) {
            Logger.getLogger(Generador.class.getName()).log(Level.SEVERE, null, ex);
        }

        long end = System.currentTimeMillis();
        System.out.println("Final Time:" + (end - start));
    }
    
    private String[] matNombre(String q) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        int numlin = 150;
        /*if(q.equals("pais"))
            numlin=57;*/
        String nombresm[] = new String[numlin];
        BufferedReader m = new BufferedReader(new InputStreamReader(new FileInputStream("c:\\tmp\\"+q+".txt"), "utf-8"));
        String linea2 = m.readLine();
        int contador = 0;
        while (linea2 != null && contador < numlin) {
            nombresm[contador] = linea2;
            //System.out.println(q+" "+ linea2);
            linea2 = m.readLine();
            contador++;
        }
        return nombresm;
    }
    private String randomNames(String[] apellidos,String[] nombresm,String[] nombresh) throws IOException {
        Random r = new Random();
        String persona;
        int aux = r.nextInt(2);
        
        if (aux == 0) {
            persona = apellidos[r.nextInt(100)] + " " + apellidos[r.nextInt(100)] + " " + nombresm[r.nextInt(100)] + " " + nombresm[r.nextInt(100)];
        } else {
            persona = apellidos[r.nextInt(100)] + " " + apellidos[r.nextInt(100)] + " " + nombresh[r.nextInt(100)] + " " + nombresh[r.nextInt(100)];
        }

        return persona;
    }
    
    private String randomProducto(String[] tiposProducto) throws IOException {
        Random r = new Random();
        String productoBancario = tiposProducto[r.nextInt(4)];
        return productoBancario;
    }
    
    private String randomDirecciones(String[] direccionesEspaña) throws IOException {
        Random r = new Random();
        String direccion = direccionesEspaña[r.nextInt(55)];
        return direccion;
    }
    
    private String randomTelef() throws IOException {
        Random r = new Random();
        double telefono;
        String finalNum;
        int aux = r.nextInt(2);
        
        /*Si es Cero es Celular sino es telfono Local*/
        if (aux == 0) {
           finalNum = "09"+ Integer.toString(ThreadLocalRandom.current().nextInt(11111111,99999999));
        } else {
            finalNum = "02"+ Integer.toString(ThreadLocalRandom.current().nextInt(1111111,9999999));
        }
        return finalNum;
    }
    
    private String randomParentesco(String[] listaParentesco) throws IOException {
        Random r = new Random();
        String parentesco = listaParentesco[r.nextInt(12)];
        return parentesco;
    }

    private Double randomMonto() throws IOException {
        
        RandomStringGenerator coutaPago = new RandomStringGenerator.Builder()
                .withinRange('0', '9').build();
        Double temp = Double.parseDouble(coutaPago.generate(3));
        temp = temp*2.243;
        String newMonto = String.valueOf(temp);
        newMonto = newMonto.substring(0,3);
        Double vfinal = Double.parseDouble(newMonto);
        return vfinal; 
    }
    
    private Double randomInteres() throws IOException {
        
        RandomStringGenerator coutaInteres = new RandomStringGenerator.Builder()
                .withinRange('1', '9').build();
        Double temp2 = Double.parseDouble(coutaInteres.generate(2));
        temp2 = temp2*0.24;
        String newMonto2 = String.valueOf(temp2);
        newMonto2 = newMonto2.substring(0,3);
        Double interes = Double.parseDouble(newMonto2);
        return interes; 
    }
}
