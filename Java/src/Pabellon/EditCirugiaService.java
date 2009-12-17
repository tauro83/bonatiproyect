package Pabellon;

/**
 * @autor: Sebastian Arancibia
 * @langversion Java
 * @version 1 20/10/2009
 */


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PabellonBD.EditCirugiaBD;
import TransferObjects.Cirugia;
import TransferObjects.Diagnostico;
import TransferObjects.Mascota;
import AdministracionBD.AddMascotaBD;
import Bd.DBConnectionManager;

public class EditCirugiaService 
{

	
	/**
	 * Autor: Sebastian Arancibia
	 * Solicita a la clase que se conecta con la base de datos, los datos de cada cirugia.
	 * @return cirugias Lista con objetos de la clase Cirugia
	 */
    public List getCirugias(String rutCliente, String nombreMascota, String responsable, String fecha)
    {
    	List cirugias = new ArrayList();
    	try 
		{
    		//Establece conexion con la base de datos
			Connection connection=DBConnectionManager.getConnection();
			EditCirugiaBD editCirugiaBD= new EditCirugiaBD(connection);
			cirugias = editCirugiaBD.getCirugias(rutCliente, nombreMascota, responsable, fecha);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();	
		}
    	//retorna lista de cirugias
		return cirugias;
    }
	/**
	 * Autor: Sebastian Arancibia
	 * Solicita a la clase que se conecta con la base de datos, los datos de cada diagnostico.
	 * @param diagnostico Objeto que representa un diagnostico
	 * @return result Lista con objetos de la clase Cirugia
	 */
	public int addDiagnostico(Diagnostico diagnostico){
		int result=0;
		try{
			//Establece conexion con la base de datos
			Connection connection=DBConnectionManager.getConnection();
			EditCirugiaBD editCirugiaBD= new EditCirugiaBD(connection);
			result= editCirugiaBD.addDiagnostico(diagnostico);		
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		//Retorna resultado de la accion
		return result;
    }
	/**
	 * Autor: Sebastian Arancibia
	 * Solicita a la clase que se conecta con la base de datos, los datos de cada diagnostico.
	 * @return diagnosticos Lista con objetos de la clase Diagnostico
	 */
    public List getDiagnosticos(String rutCliente, String nombreMascota, String fecha, String hora)
    {
    	List diagnosticos = new ArrayList();
    	Diagnostico d = new Diagnostico();

    	try 
		{
    		//Conexion la clase que se comunica con la base de datos
			Connection connection=DBConnectionManager.getConnection();
			EditCirugiaBD editCirugiaBD= new EditCirugiaBD(connection);
			diagnosticos = editCirugiaBD.getDiagnosticos(rutCliente, nombreMascota, fecha, hora);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();	
		}
		//lista de diagnosticos
    	diagnosticos.add(d);
		return diagnosticos;
    }
}
