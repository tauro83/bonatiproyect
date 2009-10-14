package PabellonBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Cirugia;



public class EditCirugiaBD 
{
	PreparedStatement insert;
	PreparedStatement selectAll;
	Connection conn;
	
	/**
	 * @autor: Sebastian Arancibia
	 * Realiza las Querys para comunicarse con la base de datos.
	 * @param Connection, que permite conectarse con la base de datos.
	 * @return void. Solo captura algun error si es que hubiera en la base de datos.
	 */
	public EditCirugiaBD(Connection connection)
	{
		conn = connection;
		try 
		{
			String query="";
			
			//Consulta a Base de Datos
			query = "";

			
			insert = connection.prepareStatement(query);
			
			//Consulta a Base de Datos
			query = "";
				
			selectAll = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
		
	/**
	 * @autor: Sebastian Arancibia
	 * Ingresa a una nueva cirugia a la base de datos
	 * @param cirugia contiene los datos de la cirugia que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
    public int updateCirugia(Cirugia cirugia)
    {
    	int result=0;
    	try 
    	{
			//insert.setString(12, cirugia.getCliente());
			
			result= insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
	
	/**
	 * Procesa los datos obtenidos de la base de datos para ser retornados a la capa 1
	 * con los datos de cada cirugia en el sistema.
	 * @param 
	 * @return Una lista de objetos de la clase Usuario.
	 */
    public List<Cirugia> getCirugias(Cirugia c)
    {
    	List<Cirugia> cirugias=new ArrayList<Cirugia>();
    	Cirugia cirugia;
    	try 
    	{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			cirugia = new Cirugia();
    			//cirugia.setNombre(result.getString(1));
    			cirugias.add(cirugia);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return cirugias;
    }
}
