package RegistroBd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;

import Registro.Registro;



public class RegistroBd extends Registro{
	Connection connection;
		
	
	
	
	public RegistroBd(Connection connection, int costoAtencion,String responsable,Date fecha,String nombreMascota,Time hora, int idServicio,Date mascotaFechaNacimiento,int rutCliente)
	{
		super(costoAtencion,responsable,fecha,nombreMascota,hora, idServicio,mascotaFechaNacimiento,rutCliente);
		this.connection = connection;
		
		
	}
	

	public String addRegistro() throws SQLException
	{
		String result = null;
		PreparedStatement insert;
		String query="";
		
		query="INSERT INTO registro(costoAtencion, atencionRealizada, fecha, idMascota, hora, idRegistro, idServicio, idFicha) "+
		"VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		insert = connection.prepareStatement(query);
		
		/*
		insert.setInt(1, );
		insert.setString(2, register.atencionRealizada);
		insert.setDate(3, (Date) register.fecha);
		insert.setInt(4, register.idMascota);
		insert.setTime(5, register.hora);
		insert.setInt(6, register.idRegistro);
		insert.setInt(7, register.idServicio);
		insert.setInt(8, register.idFicha);
		*/
		
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
	
	
}
