package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Mascota;

public class GetFichasBD {
	
	PreparedStatement selectAll;
	Connection connection;
		
	public GetFichasBD(Connection connection)
	{
		this.connection = connection;
		
		String query="";	
		
		try{
			query = "SELECT rut, nombre, fechanacimiento,claseanimal,raza,sexo,estado FROM mascota";
					
			selectAll = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	public List<Mascota> getAllMascotas()
    {
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	Mascota mas;
    	
    	//mas = new Mascota3();
    	//mas.setNombre("aaa");
    	//mascotas.add(mas);
    	try 
    	{
    		
			ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			mas = new Mascota();
    			mas.setRutCliente(result.getString(1));
    			mas.setNombre(result.getString(2));
    			//mas.setFechaNacimiento(result.getString(3));
    			//mas.setSexo(result.getString(4));
    			//mas.setRaza(result.getString(5));
    			mascotas.add(mas);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	
    	return mascotas;
    }

}
