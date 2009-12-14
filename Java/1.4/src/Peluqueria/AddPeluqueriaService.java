//=======================================================================
//FECHA CREACIÓN: 27/10/09
//AUTOR:Jimmy Muñoz
//Comenetario: Esta Clase desarrolla la conexion entre java y la base
//de datos postgret en nuestreo caso, almacenando los datos de los usuarios, y recuperando datos.
//======================================================================

package Peluqueria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdministracionBD.UsuarioEditBD;
import PeluqueriaBD.AddPeluqueriaBD;
import PeluqueriaBD.GetCatalogosBD;
import PoliclinicoBD.AddVacunacionBD;
import TransferObjects.CatPeluqueria;
import TransferObjects.Cliente;
import TransferObjects.Mascota;
import TransferObjects.Peluqueria;
import TransferObjects.Usuario;
import Bd.DBConnectionManager;

public class AddPeluqueriaService {
	ArrayList catalogoss = new ArrayList();
	public List persons; //Lista en la cual se almacenan los datos de los usuarios del sistema.
	/**
	 * Metodo que llama a la funcion addPeluqueria, de la clase AddPeluqueriaDB, que se encuentra en el paquete 
	 * PabellonBD, en este metodo se procesan los datos de la nueva cirugia a guardar que llega como parametro.
	 * En un comienzo se procesa los nombres del responsable y del ayudante de la cirugia, realizando un 
	 * llamado al metodo getAllUsuariosE(), la que almacena los datos de los usuarios en la lista persons, 
	 * para asi obtener las claves primarias del ayudante y del veterinario responsable.
	 * se asignan estos valores a la cirugia y son enviados al metodo addCirugia, a traves del objeto de 
	 * tipo cirugia.
	 * @autor  Jimmy Muñoz
	 * @param Cirugia, nuevaCir, que representa la cirugia que sera almacenada o registrada en la base de datos.
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado.
	 * @throws SQLException 
	 */
	public int AddPeluqueria(Peluqueria nuevaPel) throws SQLException
 {	
		getCatalogosPel();
		/**
		 * En este proceso se divide en nombre del veterinario y del ayudante para acceder a la base de
		 * datos, para en los procesos posteriores procesar dicha informacion 
		 */
		this.getAllUsuariosE();
		String nombreVet = nuevaPel.getResponsable();
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
				nuevaPel.setResponsable(u.getUsuario().trim());
			}
		}
		
		
		/**
		 * 
		 */
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			AddPeluqueriaBD peluqBd = new AddPeluqueriaBD(connection);
			result = peluqBd.addPeluqueria(nuevaPel,catalogoss);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
 }
	
	/**
	 * Obtiene las vacunas registradas en el sistema a traves de las clases de configuración.
	 * @autor  Jimmy Muñoz
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
	
	/**
	 * Metodo que llama a la funcion getCliente, de la clase AddCirugiaDB, que se encuentra en el paquete PabellonBD,
	 * en este metodo se recibe un rut con el cual se realiza una solicitud de informacion, para verificar si el cliente
	 * existe.
	 * @autor  Jimmy Muñoz
	 * @param String rutCliente, recibe un string que representa el rut del cliente que se necesita verificar si existe.
	 * @return retorna el rut del cliente si es que existe.
	 */
	public Cliente getCliente(String rutCliente){
 	Cliente cliente = null;
 	try {
			Connection connection=DBConnectionManager.getConnection();
			AddVacunacionBD vacunaBd = new AddVacunacionBD(connection);
			cliente = vacunaBd.getCliente(rutCliente);		
			connection.close();
		} 
 	catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	    
	/**
	 * Metodo que llama a la funcion getMascotas, de la clase AddCirugiaDB, que se encuentra en el paquete PabellonBD,
	 * metodo que realiza una solicitud de las mascotas que posee un determinado cliente identificado por el rut que 
	 * se recibe de entrada.
	 * @autor  Jimmy Muñoz
	 * @param String rutCliente, es el rut del cliente del cual se quieren obtener las mascotas.
	 * @return Listado de mascotas, objetos con todos los datos de las mascotas registradas a nombre del cliente con 
	 * dicho rut.
	 */
	public List getMascotas(String rutCliente){
 	List mascotas=new ArrayList();
 	try {
			Connection connection=DBConnectionManager.getConnection();
			AddPeluqueriaBD peluqueriaBd = new AddPeluqueriaBD(connection);
			mascotas= peluqueriaBd.getMascotas(rutCliente);		
			connection.close();
		} 
 	catch (SQLException e) {
			e.printStackTrace();
		}
		return mascotas;
 }
	
	
	
	
	/**
	 * Metodo que llama a la funcion getAllUsuariosE, de esta clase, la cual se comunica con 
	 * la base de datos cargando los datos de los usuarios del sistema.
	 * Posterior a esto, comienza a procesar los datos obtenidos para enviarlo como resultado 
	 * a la capa de flex, para esto concatena el nombre y el apellido del usuario que tenga 
	 * como cargo Veterinario, y este resultado de la concatenacion es añadido a la lista que 
	 * se retornara hacia la capa 1.
	 * @autor  Jimmy Muñoz
	 * @param No recibe parametro.
	 * @return Listado de String con los nombres de los veterinarios.
	 */
	public List getTiposPeluqueros(){
		List cirus=new ArrayList();
		
		/**
		 * En este codigo se llama a la base de datos para obtener los datos de los usuarios
		 * y guardarlos en la variable persosns.
		 */
		this.getAllUsuariosE();
		cirus.add("");
		int n = persons.size();
		/**
		 * En este codigo se se procesa los datos de todos los usuarios que fueron devueltos del llamado anterior.
		 * para ser retornado a la capa1.
		 */
		for(int i=0;i<n;i++){
			Usuario u = (Usuario) persons.get(i); 
			/**
			 * Se borran los espacios en blanco obtenidos de la base de datos.
			 * de la variable cargo. Para comparar, pues solo debe retornar los que tengan como cargo Veterinario.
			 */
			String cargo = u.getCargo().trim();
			if(cargo.equals("Peluquero")){
				/**
				 * Se borran los espacios en blanco obtenidos de la base de datos.
				 * de la variable nombre y apellido paterno. Luego se concatena y almacena en el array
				 * para ser devuelto a la capa1.
				 */
				String nombre = u.getNombre().trim();
				String apellido = u.getApellidoPaterno().trim();
				String nombFinal = nombre.concat(" "+apellido);
				cirus.add(nombFinal);
			}
		}

		return cirus;	
	}
	
	
	/**
	 * Metodo que llama a la funcion getAllUsuariosE, de la clase UsuarioEditBD, que se encuentra en el paquete 
	 * AdministracionBD, metodo que realiza una solicitud de los usuarios del sistema y los almacena en la lista persons,
	 * para que otros metodos puedan acceder a esta.
	 * @autor  Jimmy Muñoz
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
* Metodo que llama a la funcion getAllUsuariosE, de esta clase, la cual se comunica con 
* la base de datos cargando los datos de los usuarios del sistema.
* Posterior a esto, comienza a procesar los datos obtenidos para enviarlo como resultado 
* a la capa de flex, para esto concatena el nombre y el apellido del usuario que tenga 
* como cargo Veterinario, y este resultado de la concatenacion es añadido a la lista que 
* se retornara hacia la capa 1.
* @autor  Jimmy Muñoz
* @param No recibe parametro.
* @return Listado de String con los nombres de los veterinarios.
*/
public List getResponsable(){
			List cirus=new ArrayList();
			
			/**
			 * En este codigo se llama a la base de datos para obtener los datos de los usuarios
			 * y guardarlos en la variable persosns.
			 */
			this.getAllUsuariosE();
			
			int n = persons.size();
			/**
			 * En este codigo se se procesa los datos de todos los usuarios que fueron devueltos del llamado anterior.
			 * para ser retornado a la capa1.
			 */
			for(int i=0;i<n;i++){
				Usuario u = (Usuario) persons.get(i); 
				/**
				 * Se borran los espacios en blanco obtenidos de la base de datos.
				 * de la variable cargo. Para comparar, pues solo debe retornar los que tengan como cargo Veterinario.
				 */
				String cargo = u.getCargo().trim();
				if(cargo.equals("Peluquero")){
					/**
					 * Se 
					 */
					
					cirus.add(u);
				}
			}

			return cirus;	
		}

	}


