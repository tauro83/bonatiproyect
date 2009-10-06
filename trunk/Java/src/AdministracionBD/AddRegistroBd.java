package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Usuario;

import Administracion.Registro;




public class AddRegistroBd{
	Connection connection;	
	
	
	public AddRegistroBd(Connection connection)
	{		
		this.connection = connection;	
	}
	

	public String addRegistro(Registro r) throws SQLException
	{
	
		String result = null;
		PreparedStatement insert;
		String query="";
		
		query="INSERT INTO Registro (costoAtención,responsable,fecha,nombreMascota,hora,idServicio,mascotaFechaNacimiento,rutCliente) "+
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


	public List<Registro> getRegistro() throws SQLException {
		List<Registro> register=new ArrayList<Registro>();
    	Registro r;
    	try 
    	{
    		PreparedStatement selectAll = null;
			ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{
    			r= new Registro(0, null, null, null, null, 0, null, 0);
   
    			r.setCostoAtención(result.getInt(1));
    			r.setResponsable(result.getString(2));
                r.setFecha(result.getString(3));
    			r.setNombreMascota(result.getString(4));
    			r.setHora(result.getString(5));
    			r.setIdServicio(result.getInt(6));
    			r.setMascotaFechaNacimiento(result.getString(7));
    			r.setRutCliente(result.getInt(8));
    			
    			register.add(r);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return register;
    }

	
}
