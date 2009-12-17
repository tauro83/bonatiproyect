//=======================================================================
// Fecha Creaccion: 05/10/09
// AUTOR: Camilo Verdugo
// Descripcion: Clase que hace las consultas SQL y retorna una lista de Atenciones, las cuales indican:
// Numero de atenciones.
//=======================================================================

package PeluqueriaBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import TransferObjects.EstadisticasPeluqueria;

public class GetEstadisticasAtencionesBD {
	PreparedStatement selectAll;
	Connection connection;
	ResultSet result;
	
	/**
	 * Constructor de la clase
	 * @param connection link establecido con la BD
	 */
	public GetEstadisticasAtencionesBD(Connection connection)
	{
		this.connection = connection;
	}
	
	/**
	 * Obtiene las estadisticas
	 * @param inicio Comienzo del rango de fechas, en formato yyyy-mm-dd
	 * @param fin Final del rango de fechas, en formato yyyy-mm-dd
	 * @return Lista con 3 objetos estadisticas, los cuales indican el numero de atenciones para Ba�o, Pedicura y corte
	 * @throws SQLException captura cualquier error tras la ejecucion de la setencia SQL
	 */
	public List getEstadisticasBD(String inicio,String fin) throws SQLException
    {
    	List atenciones=new ArrayList();
    	//fecha, nuevafecha
    	//serviciospeluqueria(servicio, nombre, clienterut, mascotanombre, hora, responsable, fecha, nuevafecha, nuevahora, costo, descripcion)
    	String queryCorte		=  "select count(*) from serviciospeluqueria where fecha between '"+inicio+"' and '"+fin+"' AND serviciospeluqueria.servicio='Corte'";
		String queryPedicure 	=  "select count(*) from serviciospeluqueria where fecha between '"+inicio+"' and '"+fin+"' AND serviciospeluqueria.servicio='Pedicura'";
		String queryBanio 		=  "select count(*) from serviciospeluqueria where fecha between '"+inicio+"' and '"+fin+"' AND serviciospeluqueria.servicio='Ba�o'";	
		
		EstadisticasPeluqueria  corte = new EstadisticasPeluqueria();
		EstadisticasPeluqueria  banio= new EstadisticasPeluqueria();
		EstadisticasPeluqueria  pedicure= new EstadisticasPeluqueria();
		corte.setTipo("Corte");
		banio.setTipo("Ba�o");
		pedicure.setTipo("Pedicura");
		//Obteniendo cortes
		selectAll = connection.prepareStatement(queryCorte);
		result = selectAll.executeQuery();
		
		while(result.next())
		{
			corte.setNumAtenciones(result.getInt(1));
		}
		
		//Obteniendo Pedicures
		selectAll = connection.prepareStatement(queryPedicure);
		result = selectAll.executeQuery();
		
		while(result.next())
		{
			pedicure.setNumAtenciones(result.getInt(1));
		}
		
		//Obteniendo ba�os
		selectAll = connection.prepareStatement(queryBanio);
		result = selectAll.executeQuery();
		
		while(result.next())
		{
			banio.setNumAtenciones(result.getInt(1));
		}
		
		atenciones.add(corte);
		atenciones.add(banio);
		atenciones.add(pedicure);
    	
    	return atenciones;
    }
}