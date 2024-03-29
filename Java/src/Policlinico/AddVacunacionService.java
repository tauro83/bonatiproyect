//=======================================================================
// FECHA CREACI�N: 27/10/09
// AUTOR:Jimmy Mu�oz
// Comenetario: Esta Clase desarrolla la conexion entre java y la base
// de datos postgret en nuestreo caso, almacenando los datos de los usuarios, y recuperando datos.
//======================================================================

package Policlinico;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdministracionBD.UsuarioEditBD;
import PoliclinicoBD.AddVacunacionBD;
import TransferObjects.Cliente;
import TransferObjects.ConfiguracionVacuna;
import TransferObjects.Mascota;
import TransferObjects.Usuario;
import Bd.DBConnectionManager;
import ConfiguracionBD.ConfigurarBD;
import TransferObjects.Vacunacion;

public class AddVacunacionService {
	ArrayList vacc = new ArrayList();
	public List persons; //Lista en la cual se almacenan los datos de los usuarios del sistema.
	/**
	 * Metodo que llama a la funcion addVacunacion, de la clase AddVacunacionDB, que se encuentra en el paquete 
	 * PabellonBD, en este metodo se procesan los datos de la nueva cirugia a guardar que llega como parametro.
	 * En un comienzo se procesa los nombres del responsable y del ayudante de la cirugia, realizando un 
	 * llamado al metodo getAllUsuariosE(), la que almacena los datos de los usuarios en la lista persons, 
	 * para asi obtener las claves primarias del ayudante y del veterinario responsable.
	 * se asignan estos valores a la cirugia y son enviados al metodo addCirugia, a traves del objeto de 
	 * tipo cirugia.
	 * @autor  Jimmy Mu�oz
	 * @param Cirugia, nuevaCir, que representa la cirugia que sera almacenada o registrada en la base de datos.
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserci�n ha fallado.
	 * @throws SQLException 
	 */
	public int AddVacuna(Vacunacion nuevaVac) throws SQLException
    {	
		getConfiguracionVacuna();
		/**
		 * En este proceso se divide en nombre del veterinario y del ayudante para acceder a la base de
		 * datos, para en los procesos posteriores procesar dicha informacion 
		 */
		this.getAllUsuariosE();
		String nombreVet = nuevaVac.getVeterinario();		
		
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
			String nombre = u.getNombre().trim()+" "+u.getApellidoPaterno().trim();
			/**
			 * En este codigo se comparan los datos obtenidos con los que llegan de la capa 1
			 * para ver cual es el veterinario correspondiente.			
			 */
			if(nombre.equals(nombreVet)){
				nuevaVac.setVeterinario(u.getUsuario().trim());
			}
		}
		
		
		/**
		 * 
		 */
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			AddVacunacionBD vacunaBd = new AddVacunacionBD(connection);
			result = vacunaBd.addVacunacion(nuevaVac,vacc);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
	
	/**
	 * Obtiene las vacunas registradas en el sistema a traves de las clases de configuraci�n.
	 * @autor  Jimmy Mu�oz
	 * @param tipo obtiene las configuraciones que corresponden a las vacunas, desde de 
	 * la capa ConfiguracionBD
	 * @return una lista con todas las tuplas del tipo enviado como parametro
	 */
	public void getConfiguracionVacuna() throws SQLException{
		Connection connection=DBConnectionManager.getConnection();
		ConfigurarBD conBD = new ConfigurarBD(connection);
		vacc = conBD.getConfiguracionesVacunas();
		connection.close();
	}
	
	/**
	 * Metodo que llama a la funcion getCliente, de la clase AddCirugiaDB, que se encuentra en el paquete PabellonBD,
	 * en este metodo se recibe un rut con el cual se realiza una solicitud de informacion, para verificar si el cliente
	 * existe.
	 * @autor  Jimmy Mu�oz
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
	 * @autor  Jimmy Mu�oz
	 * @param String rutCliente, es el rut del cliente del cual se quieren obtener las mascotas.
	 * @return Listado de mascotas, objetos con todos los datos de las mascotas registradas a nombre del cliente con 
	 * dicho rut.
	 */
	public List getMascotas(String rutCliente){
    	List mascotas=new ArrayList();
    	try {
			Connection connection=DBConnectionManager.getConnection();
			AddVacunacionBD vacunaBd = new AddVacunacionBD(connection);
			mascotas= vacunaBd.getMascotas(rutCliente);		
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
	 * como cargo Veterinario, y este resultado de la concatenacion es a�adido a la lista que 
	 * se retornara hacia la capa 1.
	 * @autor  Jimmy Mu�oz
	 * @param No recibe parametro.
	 * @return Listado de String con los nombres de los veterinarios.
	 */
	public List getTiposVeterinarios(){
		List vetes=new ArrayList();
		
		/**
		 * En este codigo se llama a la base de datos para obtener los datos de los usuarios
		 * y guardarlos en la variable persosns.
		 */
		this.getAllUsuariosE();
		vetes.add("");
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
			String servuser = u.getServicio().trim();
			if(cargo.equals("Veterinario")||servuser.equals("Pabellon")||servuser.equals("Pabell�n")|| servuser.equals("Clinica") ||servuser.equals("Cl�nica") || servuser.equals("Policlinico I") ||servuser.equals("Policl�nico I")||servuser.equals("Policlinico II") ||servuser.equals("Policl�nico II")|| cargo.equals("Veterinario")||cargo.equals("Veterinaria")){
				/**
				 * Se borran los espacios en blanco obtenidos de la base de datos.
				 * de la variable nombre y apellido paterno. Luego se concatena y almacena en el array
				 * para ser devuelto a la capa1.
				 */
				if(!cargo.equals("Ayudante")){	
					String nombre = u.getNombre().trim();
					String apellido = u.getApellidoPaterno().trim();
					String nombFinal = nombre.concat(" "+apellido);
					vetes.add(nombFinal);
				}
			}
		}

		return vetes;	
	}
	
	
	/**
	 * Metodo que llama a la funcion getAllUsuariosE, de la clase UsuarioEditBD, que se encuentra en el paquete 
	 * AdministracionBD, metodo que realiza una solicitud de los usuarios del sistema y los almacena en la lista persons,
	 * para que otros metodos puedan acceder a esta.
	 * @autor  Jimmy Mu�oz
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
}

