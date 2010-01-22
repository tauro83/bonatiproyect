package PabellonBD;

/**
 * @autor: Sebastian Arancibia
 * @langversion Java
 * @version 1 05/10/2009
 */



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import TransferObjects.Cirugia;
import TransferObjects.Diagnostico;
import TransferObjects.Mascota;



public class EditCirugiaBD 
{
	PreparedStatement select;
	PreparedStatement selectDiagnostico;
	PreparedStatement addDiagnostico;
	
	Connection conn;
	/**
	 * Realiza las Querys para comunicarse con la base de datos.
	 * @param connection Connection, que permite conectarse con la base de datos.
	 */
	public EditCirugiaBD(Connection connection)
	{
		conn = connection;
		try 
		{
			String query="";
			query = "SELECT costo, fecha, responsable, hora, mascotanombre, clienterut, ayudante "+
					"FROM cirugia " +
					"WHERE estado = '0';";
			//Consulta a Base de Datos			
			select = connection.prepareStatement(query);
			
			query = "SELECT diagnostico, nuevafecha, tipocirugia, nuevahora, clienterut, mascotanombre, fecha, hora "+
					"FROM diagnosticos;";
			//Consulta a Base de Datos			
			selectDiagnostico = connection.prepareStatement(query);
			
			query = "INSERT INTO diagnosticos(clienterut, mascotanombre, hora, fecha, diagnostico, nuevafecha, nuevahora, tipocirugia, id) "+
			"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";				
			addDiagnostico = connection.prepareStatement(query);
			//Consulta a Base de Datos
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Procesa los datos obtenidos de la base de datos para ser retornados a la capa 1
	 * con los datos de cada cirugia en el sistema.
	 * @return cirugias Una lista de objetos de la clase Usuario.
	 */
    public List getCirugias(String rutCliente, String nombreMascota, String responsable, String fecha)
    {
    	List cirugias=new ArrayList();
    	Cirugia cirugia;
    	try 
    	{
    		
    		ResultSet result = select.executeQuery();
    		while(result.next())
    		{
    			boolean is = true;
    			cirugia = new Cirugia();
    			cirugia.setCosto(result.getString(1).trim());
    			cirugia.setFecha(result.getString(2).trim());
    			cirugia.setVeterinario(result.getString(3).trim());
    			//cirugia.setTipoCir(result.getString(4).trim());
    			cirugia.setHora(result.getTime(4).toString());
    			cirugia.setMascotaNombre(result.getString(5).trim());
    			cirugia.setClienteRut(result.getString(6).trim());
    			cirugia.setAyudante(result.getString(7).trim());
    			
    			//Compara uno de los datos ingresados
    			if(!rutCliente.equals("") && !rutCliente.equals(cirugia.getClienteRut()))
    				is = false;
    			if(!responsable.equals("") && !responsable.equals(cirugia.getVeterinario()))
    				is = false;
    			if(!nombreMascota.equals("") && !nombreMascota.equals(cirugia.getMascotaNombre()))
    				is = false;
    			if(fecha != null && !fecha.equals(cirugia.getFecha()))
    				is = false;
    			
    			//objeto cirugia encontrado
    			if(is)
    				cirugias.add(cirugia);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	//retorna objeto cirugia encontrado
    	return cirugias;
    }
    
	/**
	 * Procesa los datos obtenidos de la base de datos para ser retornados a la capa 1
	 * con los datos de cada diagnostico en el sistema.
	 * @return diagnosticos Una lista de objetos de la clase diagnostico.
	 */
    
	public List getDiagnosticos(String rutCliente, String nombreMascota, String fecha, String hora)
    {
    	List diagnosticos=new ArrayList();
    	Diagnostico diagnostico;
    	try 
    	{
    		//Pasa un string a time
    		String[] comp = hora.split(":");
    		Time time = new Time(Integer.parseInt(comp[0]), Integer.parseInt(comp[1]), Integer.parseInt(comp[2]));

    		ResultSet result = selectDiagnostico.executeQuery();
    		while(result.next())
    		{
    			diagnostico = new Diagnostico();
    			//System.out.println("COMPARO: |"+ rutCliente+"|"+result.getString(5).trim()+"|"+nombreMascota+"|"+result.getString(6).trim()+"|"+fecha+"|"+result.getString(7).trim()+"|"+hora+"|"+result.getTime(8).toString()+"|");
    			//Selecciona y filtra los diagnosticos
    			if(rutCliente.equals(result.getString(5).trim()) && nombreMascota.equals(result.getString(6).trim()) && fecha.equals(result.getString(7).trim()) && hora.equals(result.getTime(8).toString())){
    				diagnostico.setDiagnostico(result.getString(1));
	    			diagnostico.setNuevaFecha(result.getString(2).trim());
	    			diagnostico.setTipoCir(result.getString(3).trim());
	    			diagnostico.setNuevaHora(result.getTime(4).toString().trim());
	
	    			diagnosticos.add(diagnostico);
    			}
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	//Lista de diagnosticos
    	return diagnosticos;
    }
    
	/**
	 * Procesa los datos obtenidos de flex para ser guardados en la base de datos
	 * con los datos de cada diagnostico en el sistema.
	 * @param diagnostico Objeto de tipo diagnostico
	 * @return result resultado de la insercion de datos
	 */

	public int addDiagnostico(Diagnostico diagnostico){
    	int result=0;
    	try{
    		
			addDiagnostico.setString(1, diagnostico.clienteRut);
			addDiagnostico.setString(2, diagnostico.mascotaNombre);
    		
			//Pasa de hora de string a time
			String[] comp = diagnostico.hora.split(":");
    		Time time = new Time(Integer.parseInt(comp[0]), Integer.parseInt(comp[1]), Integer.parseInt(comp[2]));
    		addDiagnostico.setTime(3, time);
			addDiagnostico.setString(4, diagnostico.fecha);
			addDiagnostico.setString(5, diagnostico.diagnostico);
			addDiagnostico.setString(6, diagnostico.nuevaFecha);
    		
			//Consulta fecha actual a libreria de java
			Calendar c = Calendar.getInstance();
    		int hora = c.get(Calendar.HOUR_OF_DAY);
    		int minutos = c.get(Calendar.MINUTE);
    		int segundos = c.get(Calendar.SECOND);
    		Time t = new Time(hora, minutos, segundos);
    		addDiagnostico.setTime(7, t);
			addDiagnostico.setString(8, diagnostico.tipoCir);
			addDiagnostico.setString(9, "0");
			
			result= addDiagnostico.executeUpdate();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	//retorna resultado
    	return result;
    }
}
