//=======================================================================
// AUTOR: Camilo Verdugo G.
// Descripcion: Clase entidad Usuario de sistema, encapsula informacion de un
//				Usuario y el privilegio de acceso al sistema.
//				Solo contiene los metodos para hacer get/set de los atributos.
//=======================================================================

package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Mascota;
import AdministracionBD.GetFichasBD;
import Bd.DBConnectionManager;

public class VisualizarFicha {
	
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
}

