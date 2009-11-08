package PabellonBD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import TransferObjects.Preoperatorio;


public class AddPreOperatorioBD {

	Connection con;
	PreparedStatement insert;
	
	public AddPreOperatorioBD(Connection connection)
	{
		this.con = connection;
		
		try 
    	{
			
			
			String query="";			
			query = "INSERT INTO preoperatorio(idpreoperatorio,observaciones,sintomas,diagnostico,fecha,hora,responsable,ayudante) "+
					"VALUES (?, ?, ?, ?,?,? ,?,?);";			
			insert = con.prepareStatement(query);
			
		} 
    	catch (SQLException e) 
    	{
    		
			e.printStackTrace();
			 
			
		}
	}
	
	public int addPreoperatorio(Preoperatorio u) throws SQLException
	{
		
		
		int result=0;
		
		try 
    	{
			System.out.print("Entra Try");
			
			
			
			
			insert.setString(1, u.idpreoperatorio);
			insert.setString(2, u.observaciones);
			insert.setString(3, u.sintomas);
			insert.setString(4, u.diagnostico);
			insert.setString(5, u.fecha);
			insert.setString(6, u.hora);
			insert.setString(7, u.responsable);		
			insert.setString(8, u.ayudante);
			
			result=insert.executeUpdate();
			
			System.out.print(result);
			
			System.out.print(u.idpreoperatorio);
			System.out.print(u.observaciones);
			System.out.print(u.sintomas);
			System.out.print(u.diagnostico);
			System.out.print(u.fecha);
			System.out.print(u.hora);
			System.out.print(u.responsable);
			System.out.print(u.ayudante);
		} 
    	catch (SQLException e) 
    	{
    		
			e.printStackTrace();
			
			
		}
    	
        return result;
	}
	
}
