package logica;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import bd.MantenerMascota;

import bd.DBConnectionManager;

public class MascotaService{
	public int insertMascota(Mascota mascota){
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			MantenerMascota mascotaDB= new MantenerMascota(connection);
			result= mascotaDB.insertMascota(mascota);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
	public int deleteMascota(String id){
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			MantenerMascota mascotaDB= new MantenerMascota(connection);
			result= mascotaDB.deleteMascota(id);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
    public List<Mascota> getAllMascotas(){	
    	System.out.println("asd getAllMacotaas");
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			MantenerMascota mascotaDB= new MantenerMascota(connection);
			mascotas= mascotaDB.getAllMascotas();		
			connection.close();
			
		} 
    	catch (SQLException e) 
		{
    		System.out.print("Error en MascotaService,getAllMascotas,Detalle:");
			e.printStackTrace();
		}
		return mascotas;
    }
}