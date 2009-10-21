package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import TransferObjects.Preoperatorio;
/*
 * Esta clase realiza la conexion con la base de datos, para extraer todos los datos relacionados con un preoperatorio.
*/
public class PreoperatorioBD {
	
	PreparedStatement selectAll;
	PreparedStatement selectAtenciones;
	
	/*
	 * Esta metodo corresponde al constructor de la clase PreoperatorioBD en donde se realiza la conexion a la base de datos,
	 * y tambien se realizan las consultas sql que se van a realizar a las tabla de preoperatorio y atencion.
	 * */
	
	public PreoperatorioBD(Connection connection)
	{
		try 
		{
			String query="";			
			
			query = "SELECT nombremascota, raza, sexo, rut, nombre, apellidopaterno " +
					"FROM preoperatorio;";	
			
			selectAll = connection.prepareStatement(query);
			
			query = "SELECT observaciones, sintomas, diagnostico, servicio, hora, fecha " +
			"FROM preoperatorio;";	
	
	        selectAtenciones = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Esta metodo
	 * */
	
	public List<Preoperatorio> getAllDatos()
    {
    	List<Preoperatorio> atencionPre=new ArrayList<Preoperatorio>();
    	Preoperatorio atencionesPre;
    	
    	try 
    	{
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{			
    			    atencionesPre= new Preoperatorio();
        			atencionesPre.setNombreMascota(result.getString(1).trim());
        			atencionesPre.setRaza(result.getString(2).trim());
        			atencionesPre.setSexo(result.getString(3).trim());
        			atencionesPre.setRut(result.getString(4).trim());
        			atencionesPre.setNombre(result.getString(5).trim());
        			atencionesPre.setApellidoPaterno(result.getString(6).trim()); 
        			
        			
        			
        			atencionPre.add(atencionesPre);
    			
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return atencionPre;
    }
	
    public List<Preoperatorio> getAllAtenciones()
    {
    	List<Preoperatorio> atencionPre2=new ArrayList<Preoperatorio>();
    	Preoperatorio atencionesPre2;
    	try 
		{
    		
    	ResultSet result = selectAtenciones.executeQuery();
		while(result.next())
		{
			
			atencionesPre2= new Preoperatorio();
			atencionesPre2.setObservaciones(result.getString(1));
			atencionesPre2.setSintomas(result.getString(2));
			atencionesPre2.setDiagnostico(result.getString(3));
			atencionesPre2.setServicio(result.getString(4));
			atencionesPre2.setHora(result.getString(5));
			atencionesPre2.setFecha(result.getString(6));    			
			atencionPre2.add(atencionesPre2);
		}
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return atencionPre2;
    }

}

