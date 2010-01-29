//=======================================================================
// AUTOR: Sebastian Arancibia
// Descripcion: Clase DiaAgendaService de sistema,
//=======================================================================

package Agenda;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bd.DBConnectionManager;
import AdministracionBD.AddCitaBD;
import AgendaBD.DiaAgendaDB;
import Agenda.DiaAgenda;
import TransferObjects.Cita;
/**
 * @langversion Java
 * @author Sebastian Arancibia
 * @version 1 05/10/2009
 */
public class DiaAgendaServices 
{
	/**
	 * Clase para la conexion entre la capa 2 y capa 1
	 * @param fecha de una cita
	 * @return Lista de citas pertenecientes a la fecha
	 */
    public List getDiaAgenda(String fecha){
    	List citas=new ArrayList();
    	try 
		{   //conexion a la base de datos
			Connection connection=DBConnectionManager.getConnection();
			DiaAgendaDB diaAgendaDB= new DiaAgendaDB(connection);
			citas = diaAgendaDB.getDiaAgenda(fecha);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	//retorna citas
		return citas;
    }
	public static String bloquear(Cita c) throws SQLException {
		Connection connection = DBConnectionManager.getConnection();
		DiaAgendaDB acbd = new DiaAgendaDB(connection);
		return acbd.bloquear(c);
	}
}
