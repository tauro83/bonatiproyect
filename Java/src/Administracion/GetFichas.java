//=======================================================================
// AUTOR: Camilo Verdugo G.
// Descripcion: Clase entidad Usuario de sistema, encapsula informacion de un
//					Usuario y el privilegio de acceso al sistema.
//					Solo contiene los metodos para hacer get/set de los atributos.
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


	

