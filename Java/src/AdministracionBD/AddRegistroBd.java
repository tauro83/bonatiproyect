package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;

import Administracion.Registro;




public class AddRegistroBd{
	Connection connection;	
	
	
	public AddRegistroBd(Connection connection)
	{
		
		this.connection = connection;	
		
	}
	

	public String addRegistroBD(Registro r) throws SQLException
	{
	
		String result = null;
		PreparedStatement insert;
		String query="";
		
		query="INSERT INTO Registro (costoAtencion,responsable,fecha,nombreMascota,hora,idServicio,mascotaFechaNacimiento,rutCliente) "+
		"VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		insert = connection.prepareStatement(query);
		
		
		insert.setInt(1, r.costoAtención);
		insert.setString(2, r.responsable);
		insert.setString(3, r.fecha);
		insert.setString(4, r.nombreMascota);
		insert.setString(5, r.hora);
		insert.setInt(6, r.idServicio);
		insert.setString(7, r.mascotaFechaNacimiento);
		insert.setInt(8, r.rutCliente);
		
		
		try 
    	{
			result = "Resultado: "+insert.executeUpdate()+" ";
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
			result = result +" "+e.toString(); 
			
		}
		
		return result;
		
	}


	protected String deteleRegistro() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	protected String getRegistro() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	protected String setRegistro() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
