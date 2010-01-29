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
import AgendaBD.BitacoraCitaBD;
import Agenda.BitacoraCita;
/**
 * Clase para la conexion entre la capa 2 y la capa de 1
 * @langversion Java
 * @author Sebastian Arancibia
 * @version 1 05/10/2009
 */
public class BitacoraCitaService{
	/**
	 * Clase para la conexion entre la capa 2 y la capa de 1
	 * @param fecha
	 * @return Lista de DiaAgenda pertenecientes a la fecha
	 */
    public List getAllBitacoraCita(){
    	List bitacora=new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			BitacoraCitaBD bitacoraCitaBD= new BitacoraCitaBD(connection);
			bitacora = bitacoraCitaBD.getBitacoraCitaBD();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return bitacora;
    }
	/**
	 * Clase para la conexion entre la capa 2 y la capa de 1
	 * @param bc Datos para agregar a la bitacora
	 */
    public void addBitacoraCita(BitacoraCita bc){
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			BitacoraCitaBD bitacoraCitaBD= new BitacoraCitaBD(connection);
			bitacoraCitaBD.addBitacoraCitaBD(bc);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    }
    public void respaldarBitacora(){
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			BitacoraCitaBD bitacoraCitaBD= new BitacoraCitaBD(connection);
			bitacoraCitaBD.respaldarBitacora();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    }
}
