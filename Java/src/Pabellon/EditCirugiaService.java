package Pabellon;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PabellonBD.EditCirugiaBD;
import TransferObjects.Cirugia;
import Bd.DBConnectionManager;

public class EditCirugiaService 
{
	/**
	 * Autor: Sebastian Arancibia
	 * Metodo que llama a la funcion con el mismo nombre que se encuentra en la 
	 * clase que se conecta con la base de datos.
	 * @param Cirugia contiene los datos de la cirugia que se quiere editar.
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
	public int updateCirugia(Cirugia cirugia)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			EditCirugiaBD editCirugiaBD= new EditCirugiaBD(connection);
			result= editCirugiaBD.updateCirugia(cirugia);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
	
	/**
	 * Autor: Sebastian Arancibia
	 * Solicita a la clase que se conecta con la base de datos, los datos de cada cirugia.
	 * @param
	 * @return Lista con objetos de la clase Cirugia
	 */
    public List<Cirugia> getCirugias(Cirugia cirugia)
    {
    	List<Cirugia> cirugias = new ArrayList<Cirugia>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			EditCirugiaBD editCirugiaBD= new EditCirugiaBD(connection);
			cirugias = editCirugiaBD.getCirugias(cirugia);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cirugias;
    }
}
