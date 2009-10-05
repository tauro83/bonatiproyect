//=======================================================================
// AUTOR: Camilo Verdugo G.
//
package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Mascota;
import TransferObjects.Cliente;

public class GetFichasBD {
	
	PreparedStatement selectAll;
	Connection connection;
		
	public GetFichasBD(Connection connection)
	{
		this.connection = connection;
		
	}
	
	public Cliente getCliente(String rut) throws SQLException{
		Cliente c = new Cliente();
		String query = "select rut,telefono1,telefono2,nombre,correo,estado,domicilioNumero," +
				"" +
				"domicilioComuna, domicilioCalle from clientepresencial where rut='"+rut.trim()+"';";
		
		selectAll = connection.prepareStatement(query);
		ResultSet result = selectAll.executeQuery();
		
		while(result.next())
		{
			c.setRut(result.getString(1).trim());
			c.setTelefono(result.getString(2).trim());
			c.setTelefono2(result.getString(3).trim());
			c.setNombre(result.getString(4).trim());
			c.setEmail(result.getString(5).trim());
			c.setEstado(result.getBoolean(6));
			c.setDireccion(result.getString(9).trim()+" "+result.getString(7).trim() +", "+result.getString(8).trim());
		}
		
		
		return c;
	}
	
	public List<Mascota> getAllMascotas()
    {
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	Mascota mas;
    	
    	String query = "SELECT rut, nombre,fechanacimiento,claseanimal,raza,sexo,estado FROM mascota";
		
		
    	
    	//mas = new Mascota3();
    	//mas.setNombre("aaa");
    	//mascotas.add(mas);
    	try 
    	{
    		selectAll = connection.prepareStatement(query);
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
