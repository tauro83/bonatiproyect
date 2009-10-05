package AgendaBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Agenda.DiaAgenda;



public class DiaAgendaDB
{

	PreparedStatement selectAll;
	Connection conn;
	
	
	public DiaAgendaDB(Connection connection)
	{
		conn = connection;
		try 
		{
			String query="";			
			
			query = "SELECT fecha, rutcliente, nombremascota, hora, servicio, responsable "+
					"FROM cita;";
			
			selectAll = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
    public List <DiaAgenda> getDiaAgenda(String fecha)
    {
    	List<DiaAgenda> citas=new ArrayList<DiaAgenda>();
    	DiaAgenda cita;
    	try 
    	{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			cita= new DiaAgenda();
    			//System.out.println("Comparo: |" + fecha + "| con |" + result.getString(1).trim()+"|");
    			
    			if(fecha.equals(result.getString(1).trim())){
    				//System.out.println("Selecciono: " + result.getString(1).trim());
	    			cita = new DiaAgenda();
	    			cita.setFecha((result.getString(1).trim()));
    				cita.setCliente(result.getString(2).trim());
	    			cita.setMascota((result.getString(3).trim()));
	    			cita.setHora((result.getString(4).trim()));
	    			cita.setServicio((result.getString(5).trim()));
	    			cita.setResponsable((result.getString(6).trim()));

	    			
	    			citas.add(cita);
    			}
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return citas;
    }
}
