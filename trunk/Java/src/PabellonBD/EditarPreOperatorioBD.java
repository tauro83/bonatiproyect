package PabellonBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Preoperatorio;

public class EditarPreOperatorioBD {

	PreparedStatement todos;
	PreparedStatement editar;
	Connection conn;
	
	
	public EditarPreOperatorioBD(Connection connection)
	{
		
		conn = connection;
		try 
		{
			String query="";
			
			query = "UPDATE preoperatorio"+
			   " SET observaciones= ?, sintomas = ?, diagnostico = ?,fecha = ?, hora = ?, responsable = ?, ayudante = ? "+
				 "WHERE rut = ? AND fecha = ? AND hora = ?;";
			editar = connection.prepareStatement(query);
			
			query = "SELECT rut, nombre, observaciones, sintomas, diagnostico,  fecha, hora, responsable, ayudante "+
			"FROM preoperatorio "+
			"WHERE rut = ?;";
			todos = connection.prepareStatement(query);

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
    public int editarPreOperatorio(Preoperatorio preo, String rut, String fecha, String hora)
    {
    	int result=0;
    	try 
    	{
            editar.setString(1, preo.getObservaciones());
            editar.setString(2, preo.getSintomas());
            editar.setString(3, preo.getDiagnostico());
            editar.setString(4, preo.getFecha());
            editar.setString(5, preo.getHora());
            editar.setString(6, preo.getResponsable());
            editar.setString(7, preo.getAyudante());
    		editar.setString(8, rut);
    		editar.setString(9, fecha);
    		editar.setString(10, hora);
    		
			result= editar.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
	
	 public List<Preoperatorio> cargarPreO(String rut)
	    {
	    	List<Preoperatorio> preoperatorios=new ArrayList<Preoperatorio>();

	    	try 
	    	{
	    		todos.setString(1, rut);
	    		ResultSet result = todos.executeQuery();
	    		while(result.next())
	    		{
	    		  
	    			Preoperatorio preo= new Preoperatorio();
	    			preo.setRut(result.getString(1));
	    			preo.setNombre(result.getString(2));
	    			preo.setObservaciones(result.getString(3));
	    			preo.setSintomas(result.getString(4));
	    			preo.setDiagnostico(result.getString(5));
	    			preo.setFecha(result.getString(6));
	    			preo.setHora(result.getString(7));
	    			preo.setResponsable(result.getString(8));
	    			preo.setAyudante(result.getString(9));
	    			 preoperatorios.add(preo);
	    		
	    		}
			} 
	    	catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
	    	return preoperatorios;
	    }
	
}
