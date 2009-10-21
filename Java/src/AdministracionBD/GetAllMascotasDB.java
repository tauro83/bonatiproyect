package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Mascota;

public class GetAllMascotasDB{
	PreparedStatement selectAll;
	Connection connection;

	public GetAllMascotasDB(Connection connection) throws SQLException{
		
		this.connection = connection;
		
		String query = "SELECT *"+
		"FROM mascota;";

		selectAll = connection.prepareStatement(query);
	}

	public List<Mascota> getAllMascotas()
    {
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	Mascota mas;		
    	
    	try{
			ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			mas = new Mascota();
    			mas.setRutCliente(result.getString(1));
    			mas.setNombre(result.getString(2));
    			mas.setFechaNacimiento(result.getString(3));
    			mas.setClaseAnimal(result.getString(4));
    			mas.setRaza(result.getString(5));
    			mas.setSexo(result.getString(6));
    			mas.setEstado(result.getBoolean(7));
    			if(mas.getEstado())
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
