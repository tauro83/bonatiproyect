//=======================================================================
// Fecha Creaccion: 05/10/09
// AUTOR: Camilo Verdugo G.
// Descripcion:Clase que es llamada desde la capa de presentacion, en particular del action Script
//=======================================================================


package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import TransferObjects.Mascota;
import TransferObjects.Cliente;
import TransferObjects.Atencion;
import AdministracionBD.GetFichasBD;
import Bd.DBConnectionManager;

public class GetFichas {
		Connection connection;
		
		/**
		 * Obtiene una lista de mascota
		 * @return Listado de mascotas, las cuales seran mostradas para su seleccion y 
		 * posterior visualizacion de la ficha
		 */
		public List getMascotas()
	    {
	    	List mascotas=new ArrayList();
	    	try 
			{
	    		connection=DBConnectionManager.getConnection();
				GetFichasBD gfi= new GetFichasBD(connection);
				mascotas	= gfi.getAllMascotas();		
				connection.close();
			} 
	    	catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return mascotas;
	    }
		
		/**
		 * obtiene un solo cliente a partir del rut
		 * @param rut mediante este parametro de identifica a un cliente en particular
		 * @return Cliente dueño de la mascota dado el parametro pasado
		 */
		public Cliente getCliente(String rut)
		{
			Cliente c = new Cliente();		
		try 
			{
	    		connection=DBConnectionManager.getConnection();
				GetFichasBD gfi= new GetFichasBD(connection);
				c = gfi.getCliente(rut);
				connection.close();
			} 
	    	catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return c;
	    }
		
		/**
		 * Obtiene la lista de atenciones
		 * @param rut Parametro de identificacion de las atenciones de una mascota
		 * @param nombre Segundo parametro necesario de la identidicacion de  una mascota
		 * @return Retona un lista de atenciones, desde la capa de BD
		 */
		public List getAtenciones(String rut,String nombre)
		{
			List atenciones = new ArrayList();
	    	try 
			{
	    		connection=DBConnectionManager.getConnection();
				GetFichasBD gfi= new GetFichasBD(connection);
				atenciones	= gfi.getAllAtenciones(rut,nombre);		
				connection.close();
			} 
	    	catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return atenciones;
	    }
		
}


	

