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
import Agenda.BitacoraCita;
/**
 * @langversion Java
 * @author Sebastian Arancibia
 * @version 1 05/10/2009
 */
public class BitacoraCitaBD
{

	PreparedStatement selectAll;
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
    public List <BitacoraCita> getBitacoraCitaBD()
    {
    	List<BitacoraCita> bitacoras=new ArrayList<BitacoraCita>();
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
}