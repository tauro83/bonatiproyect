//=======================================================================
// AUTOR: Sebastian Arancibia
// Descripcion: Clase entidad DiaAgendaDB de sistema, que se comunica con la base de datos 
//				Solo contiene los metodos para hacer get/set de los atributos en la base de datos.
//=======================================================================

package PetshopBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import TransferObjects.Venta;
/**
 * @langversion Java
 * @author Sebastian Arancibia
 * @version 1 05/10/2009
 */
public class ReporteVentaBD
{

	PreparedStatement selectbetween, selectmenor, selectmayor;
	Connection conn;
	
	
	/**
	 * 
	 * @langversion Java
	 * @author Sebastian Arancibia
	 * @version 1 05/10/2009
	 */
	public ReporteVentaBD(Connection connection)
	{
		conn = connection;
		try 
		{	//Declaraciones de consultas para la base de datos
			String query="";			
			query = "SELECT codigo, unidades, precio, fecha " +
					"FROM productoVendido " +
					"WHERE fecha BETWEEN ? and ?;";
			selectbetween = connection.prepareStatement(query);
			
			query = "SELECT codigo, unidades, precio, fecha " +
					"FROM productoVendido " +
					"WHERE fecha <= ?;";
			selectmenor = connection.prepareStatement(query);
			
			query = "SELECT codigo, unidades, precio, fecha " +
					"FROM productoVendido " +
					"WHERE fecha >= ?;";
			selectmayor = connection.prepareStatement(query);
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
    public List getReporteVenta(Date fechaInicio, Date fechaFin)
    {
		System.out.println("Fecha Inicio: "+fechaInicio.toString());
		System.out.println("Fecha Fin: "+fechaFin.toString());
		
    	List reportes=new ArrayList();
    	Venta venta;
    	
    	try 
    	{

			java.sql.Date fechaInicioSql = new java.sql.Date(fechaInicio.getTime());
			java.sql.Date fechaFinSql = new java.sql.Date(fechaFin.getTime());
    		
    		selectmenor.setDate(1, fechaFinSql);
    		
    		ResultSet result = selectmenor.executeQuery();
    		while(result.next())
    		{
    			venta = new Venta();
    			
    			venta.codigo = result.getString(1).trim();
    			venta.unidades = result.getInt(2);
    			venta.precio = result.getInt(3);
    			venta.fecha = result.getDate(4);
    			
    			reportes.add(venta);

    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return reportes;
    }
}