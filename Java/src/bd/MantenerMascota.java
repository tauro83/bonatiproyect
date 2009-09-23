package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import logica.Mascota;



public class MantenerMascota 
{
	PreparedStatement insert;
	PreparedStatement selectAll;
	PreparedStatement delete;
	
	public MantenerMascota(Connection connection){
		try{
			String query="";			
			query = "INSERT INTO mascota(nombre, raza, fecha_nacimiento, sexo, edad, estado, id) "+
					"VALUES (?, ?, ?, ?, ?, ?, ?);";			
			insert = connection.prepareStatement(query);
			
			query = "SELECT nombre, raza, fecha_nacimiento, sexo, edad, estado, id" +
					"FROM mascota;";			
			selectAll = connection.prepareStatement(query);
			
			query = "DELETE FROM mascota" +
			"WHERE id=?";
			
			delete = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * Ingresa a una nueva persona a la base de datos
	 * @param person contiene los datos de la persona que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
    public int insertMascota(Mascota mascota){
    	int result=0;
    	try{
			
			insert.setString(1, mascota.getNombre());
			insert.setString(2, mascota.getRaza());
			insert.setString(3, mascota.getFechaNacimiento().toString());
			insert.setString(4, mascota.getSexo());
			insert.setString(5, String.valueOf(mascota.getEdad()));
			insert.setString(6, String.valueOf(mascota.getEstado()));
			insert.setString(7, String.valueOf(mascota.getID()));
			result= insert.executeUpdate();
		} 
    	catch (SQLException e){
			e.printStackTrace();
		}
    	return result;
    }
    public int deleteMascota(String id){
    	int result=0;
    	try{
    		delete.setString(1, id);
    		result = delete.executeUpdate();
    	}
    	catch (SQLException e){
    		e.printStackTrace();
    	}
    	return result;
    }
    public List<Mascota> getAllMascotas(){
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	Mascota mascota;
    	System.out.println("asd0 MascotaDB");
    	try{
    		System.out.println("asd1 MascotaDB");
    		System.out.println(selectAll.toString());
    		ResultSet result = selectAll.executeQuery();
    		System.out.println("asd2 MascotaDB");
    		while(result.next()){
    			mascota= new Mascota();
    			mascota.setNombre(result.getString(1));
    			mascota.setRaza(result.getString(2));
    			System.out.println("asd3 MascotaDB");
    			System.out.println(result.getString(3));
    			mascota.setFechaNacimiento(Date.valueOf(result.getString(3)));
    			System.out.println("asd4 MascotaDB");
    			mascota.setSexo(result.getString(4));
    			mascota.setEdad(result.getInt(5));
    			mascota.setEstado(result.getInt(6));
    			mascota.setID(result.getInt(7));
    			mascotas.add(mascota);
    			System.out.println("asd5 MascotaDB");
    		}
		} 
    	catch (SQLException e) 
    	{
			System.out.print("Error getAllMascotas: "+e.getStackTrace());
		}
    	return mascotas;
    }
}
