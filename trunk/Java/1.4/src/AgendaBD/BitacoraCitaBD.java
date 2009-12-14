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

import TransferObjects.Mascota;
import Agenda.BitacoraCita;
/**
 * @langversion Java
 * @author Sebastian Arancibia
 * @version 1 05/10/2009
 */
public class BitacoraCitaBD
{

	PreparedStatement selectAll, insert;
	Connection conn;
	
	
	/**
	 * 
	 * @langversion Java
	 * @author Sebastian Arancibia
	 * @version 1 05/10/2009
	 */
	public BitacoraCitaBD(Connection connection)
	{
		conn = connection;
		try 
		{	//Declaraciones de consultas para la base de datos
			String query="";			
			query = "SELECT usuario, accion, fechaaccion, horaaccion, fechacita, horacita, cliente, mascota, servicio "+
					"FROM bitacora;";
			selectAll = connection.prepareStatement(query);
			
			
			query = "INSERT INTO bitacora(usuario, accion, fechaaccion, horaaccion, fechacita, horacita, cliente, mascota, servicio) "+
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
			insert = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * @param fecha
	 * @return Lista de DiaAgenda pertenecientes a la fecha
	 */
    public List getBitacoraCitaBD()
    {
    	List bitacoras=new ArrayList();
    	BitacoraCita bitacora;
    	try 
    	{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			bitacora= new BitacoraCita();
    			
    			bitacora.usuario = result.getString(1).trim();
    			bitacora.accion = result.getString(2).trim();
    			bitacora.fechaAccion = result.getString(3).trim();
    			bitacora.horaAccion = result.getString(4).trim();
    			bitacora.fechaCita = result.getString(5).trim();
    			bitacora.horaCita = result.getString(6).trim();
    			bitacora.cliente = result.getString(7).trim();
    			bitacora.mascota = result.getString(8).trim();
    			bitacora.servicio = result.getString(9).trim();
    			
    			bitacoras.add(bitacora);

    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return bitacoras;
    }
	/**
	 * Ingresa a una nueva BitacoraCita a la base de datos
	 * @autor Sebastian Arancibia
	 * @param bc contiene los datos de la bitacoraCita que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
    public int addBitacoraCitaBD(BitacoraCita bc){
    	int result=0;
    	try{

			insert.setString(1, bc.usuario);
			insert.setString(2, bc.accion);
			insert.setString(3, bc.getFechaAccion());
			insert.setString(4, bc.horaAccion);
			insert.setString(5, bc.getFechaCita());
			insert.setString(6, bc.horaCita);
			insert.setString(7, bc.getCliente());
			insert.setString(8, bc.getMascota());
			insert.setString(9, bc.getServicio());
			
			result = insert.executeUpdate();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return result;
    }
}