package Peluqueria;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

//import org.apache.commons.httpclient.CircularRedirectException;



import PeluqueriaBD.EditarPeluServiceBD;
import PeluqueriaBD.GetCatalogosBD;
import TransferObjects.CatPeluqueria;
import TransferObjects.Peluqueria;
import TransferObjects.Usuario;
import AdministracionBD.UsuarioEditBD;
import Bd.DBConnectionManager;

public class EditarPeluService {
	ArrayList catalogoss = new ArrayList();
	public List persons; //Lista en la cual se almacenan los datos de los usuarios del sistema.
	
	
	/**
	 * Metodo que llama a la funcion editarPeluqueria, de la clase EditarPeluServiceDB, que se encuentra en el paquete 
	 * PeluqueriaBD, en este metodo se procesan los datos de la nueva cirugia a guardar que llega como parametro.
	 * En un comienzo se procesa, la que almacena los datos de los usuarios en la lista persons, 
	 * para asi obtener las claves primarias del ayudante y del veterinario responsable.
	 * se asignan estos valores a la cirugia y son enviados al metodo addCirugia, a traves del objeto de 
	 * tipo cirugia.
	 * @autor  Raul Lopez
	 * @param Cirugia, nuevaCir, que representa la cirugia que sera almacenada o registrada en la base de datos.
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado.
	 * @throws SQLException 
	 * @throws SQLException 
	 */
	public int editarPeluqueria(Peluqueria pelu) throws SQLException
    {
		getCatalogosPel();
		/**
		 * En este proceso se divide en nombre del veterinario y del ayudante para acceder a la base de
		 * datos, para en los procesos posteriores procesar dicha informacion 
		 */
		this.getAllUsuariosE();
		String nombreVet = pelu.getResponsable();
		String nombres[] = nombreVet.split(" ");
		
		
		int n = persons.size();
		
		/**
		 * En este proceso se accede a la base de datos para obtener los id de los 
		 * veterinarios, para almacenarlos en la base de datos. 
		 */
		for(int i=0;i<n;i++){
			Usuario u = (Usuario) persons.get(i); 
			/**
			 * En este codigo se quitan los espacios en blancos que se obtienen de la base de datos
			 */
			String nombre = u.getNombre().trim();
			String nombre2 = u.getApellidoPaterno().trim();
			/**
			 * En este codigo se comparan los datos obtenidos con los que llegan de la capa 1
			 * para ver cual es el veterinario correspondiente.			
			 */
			if(nombre.equals(nombres[0]) && nombre2.equals(nombres[1])){
				pelu.setResponsable(u.getUsuario().trim());
			}
		}
		
		int result=0;
		try 
		{	
			Connection connection=DBConnectionManager.getConnection();
			EditarPeluServiceBD peluqueriaDB= new EditarPeluServiceBD(connection);
			result = peluqueriaDB.editarPeluqueria(pelu,catalogoss);		
			connection.close();
			System.out.println("cierra");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
	
	/**
	 * 
	 * @autor  Raul Lopez
	 * @param rutCliente
	 * @param nombreMascota
	 * @return peluquerias, listado de atenciones de peluqueria.
	 */

    public List  getAllPeluquerias(String rutCliente, String nombreMascota)
    {
    	List peluquerias =new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			EditarPeluServiceBD peluqueriaDB= new EditarPeluServiceBD(connection);
			peluquerias = peluqueriaDB.getAllPeluquerias(rutCliente, nombreMascota);		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return peluquerias;
    }
    

	/**
	 * Metodo que llama a la funcion getAllUsuariosE, de la clase UsuarioEditBD, que se encuentra en el paquete 
	 * AdministracionBD, metodo que realiza una solicitud de los usuarios del sistema y los almacena en la lista persons,
	 * para que otros metodos puedan acceder a esta.
	 * @autor  Raul Lopez
	 * @param No recibe parametro.
	 * @return No retorna resultado.
	 */
    public void getAllUsuariosE()
    {
    	persons=new ArrayList();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			UsuarioEditBD personDB= new UsuarioEditBD(connection);
			persons= personDB.getAllUsuariosE();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
 	}
 
 	/**
	 * Obtiene las vacunas registradas en el sistema a traves de las clases de configuración.
	 * @autor Raul Lopez
	 * @param tipo obtiene las configuraciones que corresponden a las vacunas, desde de 
	 * la capa ConfiguracionBD
	 * @return una lista con todas las tuplas del tipo enviado como parametro
	 */
	public void getCatalogosPel() throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		GetCatalogosBD conBD = new GetCatalogosBD(connection);
		catalogoss = conBD.getCatalgosBD();
		connection.close();
	}
	
	public List getServiciosAnteriores(String responsable,Date fecha ,String hora)
    {
    	List serviciosAgregados = new ArrayList();
    	Peluqueria d = new Peluqueria();
    	//System.out.println(responsable);

    	try 
		{
    		//Conexion la clase que se comunica con la base de datos
			Connection connection=DBConnectionManager.getConnection();
			EditarPeluServiceBD editPeluBD= new EditarPeluServiceBD(connection);
			serviciosAgregados = editPeluBD.getServiciosAnteriores(responsable, fecha, hora);
			
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();	
		}
		//lista de diagnosticos
    	serviciosAgregados.add(d);
		return serviciosAgregados;
    }
    
    
    
   

}
