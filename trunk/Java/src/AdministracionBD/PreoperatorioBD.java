package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Preoperatorio;


public class PreoperatorioBD {
	
	PreparedStatement insert;
	PreparedStatement selectAll;
	PreparedStatement deleteUsuario;
	
	public PreoperatorioBD(Connection connection)
	{
		try 
		{
			String query="";			
			/*query = "INSERT INTO persons(rut, name, lastname) "+
					"VALUES (?, ?, ?);";			
			insert = connection.prepareStatement(query);
			
			query = "DELETE FROM usuario " +
					"WHERE usuario = ?;";
			deleteUsuario = connection.prepareStatement(query);*/
			
			query = "SELECT nombremascota, raza, sexo, rut, nombre, apellidopaterno " +
					"FROM preoperatorio;";	
			
			selectAll = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public List<Preoperatorio> getAllDatos()
    {
    	List<Preoperatorio> atencionPre=new ArrayList<Preoperatorio>();
    	Preoperatorio atencionesPre;
    	try 
    	{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			atencionesPre= new Preoperatorio();
    			atencionesPre.setNombreMascota(result.getString(1));
    			atencionesPre.setRaza(result.getString(2));
    			atencionesPre.setSexo(result.getString(3));
    			atencionesPre.setRut(result.getString(4));
    			atencionesPre.setNombre(result.getString(5));
    			atencionesPre.setApellidoPaterno(result.getString(6));    			
    			atencionPre.add(atencionesPre);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return atencionPre;
    }
}

