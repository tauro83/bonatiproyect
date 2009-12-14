//=======================================================================
// FECHA CREACIÓN: 30/09/09
// AUTOR:Nicolas Delgado
// Comentario: Esta clase guarda directamente en la base de datos todos los datos relacionado
// con la atencion de una mascota al interior de los servicios de la clinica veterinaria.
//======================================================================

package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Administracion.Registro;


public class AddRegistroBd {
	Connection connection;	
	
	/**
	 * Este metodo corresponde al constructor de la clase AddRegistroBd que se extiende de la super clase Registro.
	 * @param connection Este atributo hace la conexión a la base de datos para poder guardar los datos al interior de ella.
	 */
	
	public AddRegistroBd(Connection connection) throws SQLException
	{		 
		
		this.connection = connection;
		
				
	}
	
	/**
	 * Este metodo nos permite poder guardar los objetos al interior de la base de datos para que sean 
	 * almacenados ahi.
	 * @return 
	 * 
	 */

	
	public String addRegistro(Registro r) throws SQLException
	{
		String result = null;
		PreparedStatement insert;
		String query="";
		
		
		query="INSERT INTO Registro (costoAtencion,responsable,fecha,nombreMascota,hora,idServicio,mascotaFechaNacimiento,rutCliente) "+
		      "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		insert = connection.prepareStatement(query);

		
		
		insert.setInt(1,r.getCostoAtencion());
		insert.setString(2, r.getResponsable());
		insert.setString(3, r.getFecha());
		insert.setString(4, r.getNombreMascota());
		insert.setString(5, r.getHora());
		insert.setInt(6, r.getIdServicio());
		insert.setString(7, r.getMascotaFechaNacimiento());
		insert.setInt(8, r.getRutCliente());
		
		
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

	/**
	 * Este metodo nos permite poder extraer una lista de datos del tipo Registro que se encuentran 
	 * almacenada al interior de la base de datos.
	 * 
	 */

	/*@SuppressWarnings("null")
	public List<Registro> getRegistro() throws SQLException {
		List<Registro> register=new ArrayList<Registro>();
    	try 
    	{
    		PreparedStatement selectAll = null;
			ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{

    			super.setCostoAtencion(result.getInt(1));
    			super.setResponsable(result.getString(2));
                super.setFecha(result.getString(3));
                super.setNombreMascota(result.getString(4));
                super.setHora(result.getString(5));
                super.setIdServicio(result.getInt(6));
                super.setMascotaFechaNacimiento(result.getString(7));
                super.setRutCliente(result.getInt(8));
    			
    			}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return register;
    }*/

	
}
