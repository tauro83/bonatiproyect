package Clinica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import Bd.DBConnectionManager;

public class AddEstadistica {

	Connection connection;
	PreparedStatement add;
	ResultSet result;
	String query;
	Date date;
	public AddEstadistica(){
		
	}
	public void add(int tipo, String fecha, int area) throws SQLException{
		connection = DBConnectionManager.getConnection();
		//new Date (year, month, day)
		//year - the year minus 1900; must be 0 to 8099. (Note that 8099 is 9999 minus 1900.)
		//month - 0 to 11
		//day - 1 to 31
		
		
		if(tipo!=2 && area!=2){
			String[] l =fecha.split("/");
			date = new Date(1900-Integer.parseInt(l[2]), Integer.parseInt(l[1])-1, Integer.parseInt(l[0]));
		}
		else{
			String[] l =fecha.split("-");
			//tipo=2 y area=2 corresponde a control
			date = new Date(1900-Integer.parseInt(l[0]), Integer.parseInt(l[1])-1, Integer.parseInt(l[2]));
		}
		query="INSERT INTO estadisticasclinica("+
            "tipo, fecha, area)"+
			" VALUES (?, ?, ?);";
		add = connection.prepareStatement(query);
		add.setInt(1, tipo);
		add.setDate(2, date);
		add.setInt(3, area);
		add.executeUpdate();
		connection.close();
	}
	public void add(int tipo, String fecha, int area, Connection conn) throws SQLException{
		
		//new Date (year, month, day)
		//year - the year minus 1900; must be 0 to 8099. (Note that 8099 is 9999 minus 1900.)
		//month - 0 to 11
		//day - 1 to 31
		
		
		if(tipo!=2 && area!=2){
			String[] l =fecha.split("/");
			date = new Date(1900-Integer.parseInt(l[2]), Integer.parseInt(l[1])-1, Integer.parseInt(l[0]));
		}
		else{
			String[] l =fecha.split("-");
			//tipo=2 y area=2 corresponde a control
			date = new Date(1900-Integer.parseInt(l[0]), Integer.parseInt(l[1])-1, Integer.parseInt(l[2]));
		}
		query="INSERT INTO estadisticasclinica("+
            "tipo, fecha, area)"+
			" VALUES (?, ?, ?);";
		add = conn.prepareStatement(query);
		add.setInt(1, tipo);
		add.setDate(2, date);
		add.setInt(3, area);
		add.executeUpdate();
		connection.close();
	}
}
