//=======================================================================
// AUTOR: Sebastian Arancibia
// Descripcion: Clase entidad DiaAgendaDB de sistema, que se comunica con la base de datos 
//				Solo contiene los metodos para hacer get/set de los atributos en la base de datos.
//=======================================================================

package AgendaBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Cita;
import Agenda.DiaAgenda;
import Administracion.*;
/**
 * Clase para la conexion entre la base de datos y la capa logica
 * @langversion Java
 * @author Sebastian Arancibia
 * @version 1 05/10/2009
 */
public class DiaAgendaDB
{

	PreparedStatement selectAll, bloquear, selectBloqueados;
	Connection conn;
	
	/**
	 * Clase para la conexion entre la base de datos y la capa logica
	 * @langversion Java
	 * @author Sebastian Arancibia
	 * @version 1 05/10/2009
	 */
	public DiaAgendaDB(Connection connection)
	{
		conn = connection;
		try 
		{	//Declaraciones de consultas para la base de datos
			String query="";			
			query = "SELECT fecha, rutcliente, nombremascota, hora, servicio, responsable "+
					"FROM cita;";
			selectAll = connection.prepareStatement(query);
			
			query = "INSERT INTO horasbloqueadas (rutcliente,nombremascota,fecha,hora,servicio,responsable) "+
					"VALUES (?, ?, ?, ?,?,? );";			
			bloquear = connection.prepareStatement(query);
			
			query = "SELECT fecha, rutcliente, nombremascota, hora, servicio, responsable "+
			"FROM horasbloqueadas;";
			selectBloqueados = connection.prepareStatement(query);
			

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * @param fecha
	 * @return Lista de DiaAgenda correspondiente a la fecha
	 */
    public List getDiaAgenda(String fecha)
    {
    	List citas=new ArrayList();
    	DiaAgenda cita;
    	try 
    	{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			cita= new DiaAgenda();
    			//Selecciona solamente los que pertenecen a la fecha indicada
    			if(fecha.equals(result.getString(1).trim())){
	    			cita = new DiaAgenda();
	    			cita.setFecha((result.getString(1).trim()));
    				cita.setCliente(result.getString(2).trim());
	    			cita.setMascota((result.getString(3).trim()));
	    			cita.setHora((result.getString(4).trim()));
	    			cita.setServicio((result.getString(5).trim()));
	    			cita.setResponsable((result.getString(6).trim()));

	    			AddMascotaService ams = new AddMascotaService();
	    			
	    			cita.nombreCliente = ams.getCliente(cita.cliente);

	    			citas.add(cita);
    			}
    		}
    		result = selectBloqueados.executeQuery();
    		while(result.next())
    		{
    			cita= new DiaAgenda();
    			//Selecciona solamente los que pertenecen a la fecha indicada
    			if(fecha.equals(result.getString(1).trim())){
	    			cita = new DiaAgenda();
	    			cita.setFecha((result.getString(1).trim()));
    				cita.setCliente(result.getString(2).trim());
	    			cita.setMascota((result.getString(3).trim()));
	    			cita.setHora((result.getString(4).trim()));
	    			cita.setServicio((result.getString(5).trim()));
	    			cita.setResponsable((result.getString(6).trim()));
	    			cita.nombreCliente = "No Disponible";

	    			citas.add(cita);
    			}
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return citas;
    }
    public String bloquear(Cita c) throws SQLException
	{
		String result = null;			
		
		
		bloquear.setString(1, c.cliente.trim());
		bloquear.setString(2, c.mascota);
		bloquear.setString(3, c.fecha);
		bloquear.setString(4, c.hora);
		bloquear.setString(5, c.servicio);
		bloquear.setString(6, c.usuario);
		
		try 
    	{
			result=""+bloquear.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
			result = " "+e.toString(); 
			
		}
    	
    	if(result.length()==1){
    		return "1";
    		
    	}
    	else {
    		return   "0";  	
		}
	}
}
