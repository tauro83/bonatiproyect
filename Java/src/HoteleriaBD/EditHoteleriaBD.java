//=======================================================================
// FECHA CREACIÓN: 10 de Noviembre de 2009
// AUTOR: Sebastian Arancibia
// …. Clase para la comunicacion entre java y base de datos 
//=======================================================================


package HoteleriaBD;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import TransferObjects.Hoteleria;

/**
 * Clase utilizada para la comunicacion entre capa 1 y 2 (Flex y Java)
 *
 * @author  Sebastian Arancibia
 * @version 0.1, 10/11/09
 */
public class EditHoteleriaBD 
{
	PreparedStatement update;
	Connection conn;
	
	/**
	 * Metodo que llama a la funcion con el mismo nombre que se encuentra en la 
	 * clase que se conecta con la base de datos.
	 * 
	 * @autor Sebastian Arancibia
	 * @param connection contiene los datos de la conexion a la base de datos
	 */
	public EditHoteleriaBD(Connection connection)
	{
		
		conn = connection;
		try 
		{
			String query="";
			
			//Consulta a la tabla atencionalojamiento de la base de datos
			query = "UPDATE atencionalojamiento"+
			   " SET servicio = ?, hora = ?, fechaingreso = ?, costo = ?, responsable = ?, cliente = ?, mascota = ?, canil = ?, fechasalida = ?, comentario = ?, diasestadia = ?, eliminado = ? "+
				 "WHERE fechaingreso = ? AND fechasalida = ? AND canil = ?;";
			
			update = connection.prepareStatement(query);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * Modifica la tabla atencionalojamiento a la base de datos
	 * @autor Sebastian Arancibia
	 * @param h contiene los datos del registro de Hoteleria que se quiere editar.
	 * @param fea Fecha de Entrada antigua a la modificacion
	 * @param fsa Fecha de Salida antigua a la modificacion
	 * @param ca Canil antiguo a la modificacion
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
    public int editarHoteleria(Hoteleria h, Date fea, Date fsa, int ca)
    {
    	int result=0;
    	try 
    	{
    		//Insercion de a la base de datos
			update.setString(1, h.getServicio());
			update.setString(2, h.getHora());
			update.setDate(3, h.getFechaIngreso());
			update.setString(4, h.getCosto());
			update.setString(5, h.getResponsable());
			update.setString(6, h.getCliente());
			update.setString(7, h.getMascota());
			update.setInt(8, h.getCanil());
			update.setDate(9, h.getFechaSalida());
			update.setString(10, h.getComentario());
			update.setInt(11, h.getDiasEstadia());
			update.setBoolean(12, h.getEliminado());
			
			update.setDate(13, fea);
			update.setDate(14, fsa);
			update.setInt(15, ca);
			
			

			
			result= update.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
	
}
