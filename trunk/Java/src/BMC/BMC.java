package BMC;
/**********************************
 * @author Camilo Verdugo Günther
 * Universidad de Talca 2010
 * camilo.verdugo@gmail.com
 * *******************************
 *
 * ACCIONES
 * Testear la conexion
 * Obtener todos los productos de la BD
 * Obtener las ultimas ventas
 * Registrar nuevos productos: Comprueba si el producto existe , de lo contrario busca un id correlativo
 * Resetear las ultimas ventas
 *
 * BMC CONFIGURACION PUERTO
 * Codigo 541
 *
 *
 * SETUP
 * Copiar el driver en:                 <c:\pstlcc>
 * Archivo de envio                     <c:\pstlcc\PRGU.01>
 * Archivo de recepcion                 <c:\pstlcc\REPC.01>
 *
 * INFORMACION
 * La ejecucion es sobre la aplicacio:  <c:\pstlcc\Pstlcc.exe>
 *
 * LEYENDA PARAMETROS
 * A B CD EF G H // I
 * A:Puerto             0: port0  1: port1
 * B:Velocidad COM      1:38400  2:19200  3:9600  4:9600  5:4800  6:2400
 * CD:Nº Maquina        01
 * EF:ECR               00 //Corresponde al ID de la maquina #xxB
 * G:JOB                =: test conexion   U: Productos c: Reporte de ventas
 * H:Modo               0:Recibir sobre archivo PRGU.01     1:Enviar a la caja el archivo PRGU.01   2:Limpia todos los contadores de ventas
 * I:Tipo productos     A:Todos los productos      S:Solo los vendidos
 *
 *
 *
 * PARAMETROS PSTLCC:
 *  1.Test:                             030101=0//A
 *  2.Recepcion de productos vendidos   030101c0//S
 *  3.Recepcion de todos los productos  030101U0//A
 *  5.Envio productos nuevos            030101U1//A
 *  6.Final del dia sincronizacion      03010102    (Borrar los productos vendidos)
 *
 *
 * ARCHVOS PRGU, REPC
 *  Primera linea		* y fin de linea
*   lineas medias		fin de linea despues del numero
*   ultima                      termino de archivo
 *
 * EJEMPLO PRGU
 * 00000000000001COCA COLA LRG 0100000200000000000000000000010000000001000101
 * 0                Creacion del articulo de la maquina, siempre en 0
 * 0000000000001    codigo de barra
 * COCA COLA LRG    Nombre del producto (16 caracteres)
 * 01               Codigo departamento
 * 00000200         precio              (8 digitos)
 *
 *
 * EJEMPLO REPC.01
 * 0000000000001000005550000000583000000000000000000000000000000000000
 * 0000000000001    codigo de barra
 * 000005           nº de unidades vendidas
 * 5500             precio
 * 
 */

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import AdministracionBD.AddUsuarioBD;
import Bd.DBConnectionManager;
import TransferObjects.Usuario;

public class BMC {
   
	
	public static boolean obtenerProductos() throws IOException, InterruptedException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		if(BMC.RespaldarBMC()){
			System.out.println("PRODUCTOS CARGADOS");
			if(BMC.obtenerReporteStock()){
				System.out.println("STOCK CARGADOS");
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
		
	}
       
    public static boolean conectar() throws IOException, InterruptedException{

        String command="cmd /c Pstlcc 030101=0//A";
        Process p = Runtime.getRuntime().exec(command);
        InputStream stdout = p.getInputStream ();

        BufferedReader buff = new BufferedReader (new InputStreamReader (stdout));

        String retorno="";
        String line;
        while ((line = buff.readLine ()) != null) {
            retorno += line;
        }
        System.out.println(retorno);

        InputStream stderr = p.getErrorStream ();


        BufferedReader brCleanU2 = new BufferedReader (new InputStreamReader (stderr));

        while ((line = brCleanU2.readLine ()) != null) {
            System.out.println (line);
        }

        if(retorno.contains("succsess")){
           return true;
        }if(retorno.contains("ECR is not ready")){
           return false;
        }
        return false;
    }

    public static boolean RespaldarBMC() throws IOException, InterruptedException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalAccessException{

        String command="cmd /c Pstlcc 030101U0//A";
        Process p = Runtime.getRuntime().exec(command);
        InputStream stdout = p.getInputStream ();

        BufferedReader buff = new BufferedReader (new InputStreamReader (stdout));

        String retorno="";
        String line;
        while ((line = buff.readLine ()) != null) {
            retorno += line;
        }
        System.out.println(retorno);

        if(retorno.contains("succsess")){
            BD.setProductosNuevos(BMC.readPRGU());
            return true;
        }if(retorno.contains("ECR is not ready")){
            //BD.setProductosNuevos(BMC.readPRGU());
            return false;
        }
        return true;
    }
    //REPORTE DE VENTAS
    public  static boolean obtenerReporteDiario() throws IOException, InterruptedException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        String command="cmd /c Pstlcc 030101c0//S";
        Process p = Runtime.getRuntime().exec(command);
        InputStream stdout = p.getInputStream ();

        BufferedReader buff = new BufferedReader (new InputStreamReader (stdout));

        String retorno="";
        String line;
        while ((line = buff.readLine ()) != null) {
            retorno += line;
        }
        System.out.println(retorno);

        if(retorno.contains("succsess")){
           BD.setProductosVendidos(BMC.readREPC());
           return true;
        }if(retorno.contains("ECR is not ready")){
           BD.setProductosVendidos(BMC.readREPC());
          //return false;
        }
       return true;
    }

    public static boolean actualizarCaja() throws IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        
        ArrayList<ProductoNuevo> pn = new ArrayList();
        pn = BD.getProductosNuevos();
        BMC.printPnuevos(pn);

        FileWriter fstream = new FileWriter("C:\\Windows\\PRGU.01");
        BufferedWriter out = new BufferedWriter(fstream);

        out.write("*\n");
        for(int i=0;i<pn.size();i++){
            out.write("0");
            out.write(pn.get(i).codigo);
            out.write(pn.get(i).nombre);
            out.write("01");

            String precioS = pn.get(i).precio+"";
            for(int j=0;j<7-(precioS.length());j++){
                out.write("0");
            }
            out.write(pn.get(i).precio+"");
            out.write("0000000000000000000000000000000000000");
            out.write("\n");
        }
        System.out.println("Escribiendo PRGU");
        out.close();
        fstream.close();
        System.out.println("PRGU actualizado");
       

        return BMC.actualizarCajaCMD();
    }


    public static boolean actualizarCajaCMD() throws IOException{


        String command="cmd /c Pstlcc 030101U1//A";

        Process p = Runtime.getRuntime().exec(command);
        InputStream stdout = p.getInputStream();

        BufferedReader buff = new BufferedReader (new InputStreamReader (stdout));

        String retorno="";
        String line;
        while ((line = buff.readLine ()) != null) {
            retorno += line;
        }
        System.out.println(retorno);

        if(retorno.contains("succsess")){
           return true;
        }if(retorno.contains("ECR is not ready")){
           return false;
        }
        return false;
    }


     public static boolean obtenerReporteStock()throws IOException, InterruptedException, InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException
    {
        String command="cmd /c Pstlcc 030101X0//A";
        Process p = Runtime.getRuntime().exec(command);
        InputStream stdout = p.getInputStream ();

        BufferedReader buff = new BufferedReader (new InputStreamReader (stdout));

        String retorno="";
        String line;
        while ((line = buff.readLine ()) != null) {
            retorno += line;
        }
        System.out.println(retorno);

        if(retorno.contains("succsess")){
           BD.updateStock(BMC.readPRGX());
           return true;
        }if(retorno.contains("ECR is not ready")){
           //BD.updateStock(BMC.readPRGX());
           return false;
        }
        return true;
    }

    //REPORTE de VENTAS
    // Lee el archivo REPC, lo mapea a un ArrayList y lo imprime
    public static ArrayList<ProductoVendido> readREPC() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        ArrayList<ProductoVendido> pvendidos    = new ArrayList();

        File file = new File("C:\\Windows\\REPC.01");
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;

        try {
          fis = new FileInputStream(file);
          bis = new BufferedInputStream(fis);
          dis = new DataInputStream(bis);

          while (dis.available() != 0) {
            String linea =  dis.readLine();
            if(linea.length()>26){
                System.out.println(linea);
                ProductoVendido pv = new ProductoVendido();
                pv.codigo   = linea.substring(0,13);
                pv.unidades = Integer.parseInt(linea.substring(14,19));
                pv.precio   = Integer.parseInt(linea.substring(26,31));


                if(!BD.existeProductoVendido(pv)){
                    pvendidos.add(pv);
                }
            }
            
          }
          fis.close();
          bis.close();
          dis.close();
         
          
          }catch (FileNotFoundException e) {
             e.printStackTrace();

          }catch (IOException e) {
             e.printStackTrace();
          }
         
         BMC.printPvendidos(pvendidos);
         return pvendidos;


    }

    //Lee el archivo PRGU lo mapea a un arrayList, lo retorna e imprime
    public  static ArrayList<ProductoNuevo> readPRGU() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
      
        ArrayList<ProductoNuevo> pnuevos = new ArrayList();
        File file = new File("C:\\Windows\\PRGU.01");

        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        System.out.println("Leyendo PRGU.01");
        try {
              fis = new FileInputStream(file);
              bis = new BufferedInputStream(fis);
              dis = new DataInputStream(bis);

             while (dis.available() != 0) {
                String linea =  dis.readLine();

                if(linea.length()>39){
                    System.out.println(linea);
                    ProductoNuevo pn = new ProductoNuevo();
                    pn.codigo   = linea.substring(1,14);
                    pn.nombre   = linea.substring(14,30);
                    pn.departamento = Integer.parseInt(linea.substring(31,32));
                    pn.precio       = Integer.parseInt(linea.substring(33,40));

                    if(!BD.existeProducto(pn) && pn.precio>1){
                        pnuevos.add(pn);
                    }
                }
              }

              fis.close();
              bis.close();
              dis.close();

           }catch (FileNotFoundException e) {
             e.printStackTrace();

          }catch (IOException e) {
             e.printStackTrace();
          }

          BMC.printPnuevos(pnuevos);         
          return pnuevos;
          
    }
    //Reporte de stock
    public static ArrayList<ProductoStock> readPRGX() throws InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException{
        ArrayList<ProductoStock> pstock    = new ArrayList();

        File file = new File("C:\\Windows\\PRGX.01");
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;

        try {
          fis = new FileInputStream(file);
          bis = new BufferedInputStream(fis);
          dis = new DataInputStream(bis);
          
          while (dis.available() != 0) {
            String linea =  dis.readLine();
            if(linea.length()>17){
                System.out.println(linea);
                ProductoStock ps = new ProductoStock();
                ps.codigo   = linea.substring(0,13);
                ps.stock    = Integer.parseInt(linea.substring(15,18));

                if(true){
                    pstock.add(ps);
                }
            }
            
          }
          fis.close();
          bis.close();
          dis.close();

          }catch (FileNotFoundException e) {
             e.printStackTrace();

          }catch (IOException e) {
             e.printStackTrace();
          }
        
         BMC.printPStock(pstock);
         return pstock;
    }

    // 12900 0000
    public int getPrecio(String precio) {
        String precioAlreves = "";
        String precioOrdenado = "";
        for(int i=precio.length()-1;i>=0;i--){
            precioAlreves += precio.charAt(i);
        }
        int precioAlrevesSinCero = Integer.parseInt(precioAlreves);
        //System.out.println("precioAlreves:"+precioAlreves);

        String SprecioAlrevesSinCero = ""+precioAlrevesSinCero;

        for(int i=SprecioAlrevesSinCero.length()-1;i>=0;i--){
            precioOrdenado += SprecioAlrevesSinCero.charAt(i);
        }
        // System.out.println("precioOrdenado:"+precioOrdenado);
        //System.out.println(Integer.parseInt(precioOrdenado+"00"));
        return Integer.parseInt(precioOrdenado+"00");
    }
    public static void printPvendidos(ArrayList<ProductoVendido> pv){
        for(int i=0;i<pv.size();i++){
           System.out.println(pv.get(i).toString());
       }
    }
    public static void printPnuevos(ArrayList<ProductoNuevo> pn){
        for(int i=0;i<pn.size();i++){
           System.out.println(pn.get(i).toString());
       }
    }
    public static void printPStock(ArrayList<ProductoStock> ps){
        for(int i=0;i<ps.size();i++){
           System.out.println(ps.get(i).toString());
       }
    }

}
