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


/**
 * @author Camilo Verdugo
 * @version 2
 * Clase que es llamada desde la capa de presentacion, en particular del action Script
 */
public class GetFichas {
	
	
		Connection connection;
		
		/**
		 * 
		 * @return Listado de mascotas, las cuales seran mostradas para su seleccion y 
		 * posterior visualizacion de la ficha
		 */
		public List<Mascota> getMascotas()
	    {
	    	List<Mascota> mascotas=new ArrayList<Mascota>();
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
		 * 
		 * @param rut mediante este parametro de identifica a un cliente en particular
		 * @return Cliente dueño de la mascota dado el parametro pasado
		 */
		public Cliente getCliente(String rut)
		{
			Cliente c = new Cliente();
			c.setNombre("defecto");
		
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
		 * 
		 * @param rut Parametro de identificacion de las atenciones de una mascota
		 * @param nombre Segundo parametro necesario de la identidicacion de  una mascota
		 * @return Retona un lista de atenciones, desde la capa de BD
		 */
		public List<Atencion> getAtenciones(String rut,String nombre)
		{
			List<Atencion> atenciones = new ArrayList<Atencion>();
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


	

