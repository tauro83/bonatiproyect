package PabellonBD;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import TransferObjects.Preoperatorio;


public class AddPreOperatorioBD {

	Connection con;
	PreparedStatement insert;
	PreparedStatement addEstadisticas;
	
	public AddPreOperatorioBD(Connection connection)
	{
		this.con = connection;
		
		try 
    	{
			
			
			String query="";			
			query = "INSERT INTO preoperatorio(rut, nombre,observaciones,sintomas,diagnostico,fecha,hora,responsable,ayudante) "+
					"VALUES (?, ?, ?, ?,?,? ,?,?,?);";			
			insert = con.prepareStatement(query);
			
			query="INSERT INTO estadisticasclinica("+
            "tipo, fecha, area)"+
			" VALUES (?, ?, ?);";
			addEstadisticas = connection.prepareStatement(query);
			
		} 
    	catch (SQLException e) 
    	{
    		
			e.printStackTrace();
			 
		}
	}
	
	public String addPreoperatorio(Preoperatorio u) throws SQLException
	{
		
		
		String result;
		
		try 
    	{
			
			
			Calendar c = Calendar.getInstance();
    		int hora = c.get(Calendar.HOUR_OF_DAY);
    		int minutos = c.get(Calendar.MINUTE);
    		int segundos = c.get(Calendar.SECOND);
    		
    		String h=hora+":"+minutos+":"+segundos;
			
			
			insert.setString(1, u.rut);
			insert.setString(2, u.nombre);
			insert.setString(3, u.observaciones);
			insert.setString(4, u.sintomas);
			insert.setString(5, u.diagnostico);
			insert.setString(6, u.fecha);
			insert.setString(7, h.trim());
			insert.setString(8, u.responsable);		
			insert.setString(9, u.ayudante);
			

			//agregando los datos a estadisticasClinica
			String[] l =u.fecha.split("/");
			Date date = new Date(1900-Integer.parseInt(l[2]), Integer.parseInt(l[1])-1, Integer.parseInt(l[0]));
			addEstadisticas.setInt(1, 1);
			addEstadisticas.setDate(2, date);
			addEstadisticas.setInt(3, 1);
			addEstadisticas.executeUpdate();
			//
			
			result=""+insert.executeQuery();
			//result=insert.executeUpdate();
			
			
		} 
    	catch (SQLException e) 
    	{
    		
			//e.printStackTrace();
    		e.printStackTrace();
			result = " "+e.toString(); 
	
		}
    	if(result.length()==1){
    		return "1";
    		
    	}
    	else {
    		return   "0";  	
		}
    	
        //return result;
	}
	
}
