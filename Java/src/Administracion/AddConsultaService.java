package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdministracionBD.AddConsultaBD;
import AdministracionBD.UsuarioEditBD;
import Bd.DBConnectionManager;
import PoliclinicoBD.AddVacunacionBD;
import TransferObjects.Cliente;
import TransferObjects.Consulta;
import TransferObjects.Mascota;
import TransferObjects.Usuario;


public class AddConsultaService {

	
	public static int addConsulta(Consulta consult2) throws SQLException
    {		
			
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			AddConsultaBD con = new AddConsultaBD(connection);
			result = con.addConsulta(consult2);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
			return result ;
		
    }
	
	
	public Cliente getCliente(String rutCliente){
    	Cliente cliente = null;
    	try {
			Connection connection=DBConnectionManager.getConnection();
			AddConsultaBD vacunaBd = new AddConsultaBD(connection);
			cliente = vacunaBd.getCliente(rutCliente);		
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	

	public List<Mascota> getAllMascotas(){
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	try {
			Connection connection=DBConnectionManager.getConnection();
			AddConsultaBD vacunaBd = new AddConsultaBD(connection);
			mascotas= vacunaBd.getAllMascotas();		
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		return mascotas;
    }
    

	public List<Mascota> getMascotas(String rutCliente){
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	try {
			Connection connection=DBConnectionManager.getConnection();
			AddVacunacionBD vacunaBd = new AddVacunacionBD(connection);
			mascotas= vacunaBd.getMascotas(rutCliente);		
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		return mascotas;
    }
	
    
    
    /**
     * 
     * 
     * 
     * **/
    

}
