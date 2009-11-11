package PeluqueriaBD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import TransferObjects.Peluqueria;

public class EditarPeluServiceBD 
{
	PreparedStatement insert;
	PreparedStatement deletete;
	PreparedStatement selectAll;
	PreparedStatement selectOne;
	Connection conn;
	String rutillo;
	String rut;
	
	
	public EditarPeluServiceBD(Connection connection)
	{
		
		conn = connection;
		try 
		{
			System.out.println("entro acacacacacacacacacac");
			String query="";
			
			query = "UPDATE consulta"+
			   " SET anamnesis=?, servicio = ?, hora = ?, fecha = ?,costo = ?, rut = ?, nombre = ?, responsable = ? "+
				 "WHERE rut = ? AND servicio = ? AND hora = ? AND fecha = ?;";
			insert = connection.prepareStatement(query);
			
			query = "SELECT anamnesis, servicio, hora, fecha, costo,  rut, nombre, responsable "+
			"FROM consulta "+
			"WHERE rut = ?;";
			selectOne = connection.prepareStatement(query);
			
			query = "SELECT anamnesis, servicio, hora, fecha, costo,  rut, nombre, responsable "+
			"FROM consulta where rut = ?;";

			selectAll = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Ingresa a una nueva persona a la base de datos
	 * @param person contiene los datos de la persona que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
    public int editarPeluqueria(Peluqueria pelu)
    {
    	
    	int result=0;
    	try 
    	{
    		
    		
    		//System.out.println(consulta.getAnamnesis()+".");
    		//System.out.println(consulta.getRut()+".");
    		
    		

    		insert.setString(1, pelu.getRutCliente());
    		insert.setString(2, pelu.getNombreMascota());
    		insert.setString(3, pelu.getResponsable());
    		insert.setString(4, pelu.getServicio());
    		insert.setString(5, pelu.getFecha());
			insert.setString(6, pelu.getCosto());
    		insert.setString(7, pelu.getDescripcion());
    	
			
			result= insert.executeUpdate();
			System.out.println(+result);
			
			
			result= insert.executeUpdate();
			System.out.println(+result);
			
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
    public List<Peluqueria> getAllPeluquerias(String rutCliente, String nombreMascota)
    {
    	List<Peluqueria> peluquerias=new ArrayList<Peluqueria>();

    	try 
    	{
    		selectAll.setString(1, rutCliente);
    		selectAll.setString(1, nombreMascota);
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			  //System.out.println("rut: "+rutCliente+".");
    		  
    			Peluqueria pelu= new Peluqueria();
    			pelu.setRutCliente(result.getString(1));
    			pelu.setNombreMascota(result.getString(2));
    			pelu.setResponsable(result.getString(3));
    			pelu.setServicio(result.getString(4));
    			pelu.setFecha(result.getString(5));
    			pelu.setCosto(result.getString(6));
    			pelu.setDescripcion(result.getString(7));
    			  
   
    			  peluquerias.add(pelu);
    		
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return peluquerias;
    }
    
   
}
