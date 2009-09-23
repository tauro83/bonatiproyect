package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transferObjects.Mascota;


public class MantenerMascota{
	PreparedStatement insert;
	PreparedStatement selectAll;
	PreparedStatement delete;
	PreparedStatement purgar;
	public MantenerMascota(Connection connection){
		try{
			String query="";			
			query = "INSERT INTO mascota(nombre, raza, fecha_nacimiento, sexo, edad, estado, id) "+
					"VALUES (?, ?, ?, ?, ?, ?, ?);";			
			insert = connection.prepareStatement(query);
			
			query = "SELECT *" +
					"FROM mascota;";			
			selectAll = connection.prepareStatement(query);
			
			query = "DELETE FROM mascota WHERE id=?";
			
			delete = connection.prepareStatement(query);
			
			query = "UPDATE mascota SET estado=0 WHERE id=?";
			
			purgar = connection.prepareStatement(query);
		} 
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	/**
	 * Ingresa a una nueva persona a la base de datos
	 * @param mascota contiene los datos de la mascota que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
    public int insertMascota(Mascota mascota){
    	int result=0;
    	try{
			insert.setString(1, mascota.getNombre());
			insert.setString(2, mascota.getRaza());
			insert.setString(3, mascota.getFechaNacimiento());
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
    public int deleteMascota(int id){
    	int result=0;
    	try{
    		delete.setInt(1, id);
    		result = delete.executeUpdate();
    	}
    	catch (SQLException e){
    		e.printStackTrace();
    	}
    	return result;
    }
    public int purgarMascota(int id) {
    	int result=0;
    	try{
    		purgar.setInt(1, id);
    		result = purgar.executeUpdate();
    	}
    	catch (SQLException e){
    		e.printStackTrace();
    	}
    	return result;
	}
    public List<Mascota> getAllMascotas(){
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	Mascota mascota;
    	try{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next()){
    			mascota= new Mascota();
    			mascota.setNombre(result.getString(1));
    			mascota.setRaza(result.getString(2));
    			mascota.setFechaNacimiento(result.getDate(3).toString());
    			mascota.setSexo(result.getString(4));
    			mascota.setEdad(result.getInt(5));
    			mascota.setEstado(result.getInt(6));
    			mascota.setID(result.getInt(7));
    			mascotas.add(mascota);
    		}
		} 
    	catch (SQLException e){
			System.out.print("Error getAllMascotas: "+e.getStackTrace());
		}
    	return mascotas;
    }
	
}
