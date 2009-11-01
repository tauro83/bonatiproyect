package Policlinico;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import AdministracionBD.AddMascotaBD;
import PabellonBD.AddCirugiaBD;
import AdministracionBD.UsuarioEditBD;
import AdministracionBD.UsuarioElimBD;
import TransferObjects.Cliente;
import TransferObjects.Mascota;
import TransferObjects.Usuario;
import Bd.DBConnectionManager;
import TransferObjects.Cirugia;

public class AddControlService {
	public List<Usuario> persons; //Lista en la cual se almacenan los datos de los usuarios del sistema.
	/**
	 * Autor: Sebastian Arancibia
	 * Metodo que llama a la funcion addControl, de la clase AddControlBD, que se encuentra en el paquete PoliclinicoBD,
	 * en este metodo se procesan los datos del nuevo control a guardar que llega como parametro.
	 * En un comienzo se procesa los nombres del responsable y del ayudante de la cirugia, realizando un llamado al
	 * metodo getAllUsuariosE(), la que almacena los datos de los usuarios en la lista persons, para asi obtener las
	 * claves primarias del ayudante y del veterinario responsable.
	 * se asignan estos valores a la cirugia y son enviados al metodo addCirugia, a traves del objeto de tipo cirugia.
	 * @param Cirugia, nuevaCir, que representa la cirugia que sera almacenada o registrada en la base de datos.
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado.
	 */
	public int AddControl(Cirugia nuevaCir)
    {		
		/**
		 * En este proceso se divide en nombre del veterinario y del ayudante para acceder a la base de
		 * datos, para en los procesos posteriores procesar dicha informacion 
		 */
		this.getAllUsuariosE();
		String nombreVet = nuevaCir.getVeterinario();
		String nombres[] = nombreVet.split(" ");
		String nombreAyu = nuevaCir.getAyudante();
		String nombresa[] = nombreAyu.split(" ");
		
		
		int n = persons.size();
		
		/**
		 * En este proceso se accede a la base de datos para obtener los id de los 
		 * veterinarios, para almacenarlos en la base de datos. 
		 */
		for(int i=0;i<n;i++){
			Usuario u = persons.get(i); 
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
				nuevaCir.setVeterinario(u.getUsuario().trim());
			}
		}
		
		/**
		 * En este proceso se accede a la base de datos para obtener los id de los 
		 * ayudantes, para almacenarlos en la base de datos. 
		 */
		for(int i=0;i<n;i++){
			Usuario u = persons.get(i); 
			/**
			 * En este codigo se quitan los espacios en blancos que se obtienen de la base de datos
			 */
			String nombre = u.getNombre().trim();
			String nombre2 = u.getApellidoPaterno().trim();
			/**
			 * En este codigo se comparan los datos obtenidos con los que llegan de la capa 1
			 * para ver cual es el veterinario correspondiente.			
			 */
			if(nombre.equals(nombresa[0]) && nombre2.equals(nombresa[1])){
				nuevaCir.setAyudante(u.getUsuario().trim());
			}
		}

		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			AddCirugiaBD cirugiaBd = new AddCirugiaBD(connection);
			//result = cirugiaBd.addCirugia(nuevaCir);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
	
	
	/**
	 * Autor: Sebastian Arancibia
	 * Metodo que llama a la funcion getCliente, de la clase AddCirugiaDB, que se encuentra en el paquete PabellonBD,
	 * en este metodo se recibe un rut con el cual se realiza una solicitud de informacion, para verificar si el cliente
	 * existe.
	 * @param String rutCliente, recibe un string que representa el rut del cliente que se necesita verificar si existe.
	 * @return retorna el rut del cliente si es que existe.
	 */
	public Cliente getCliente(String rutCliente){
    	Cliente cliente = null;
    	try {
			Connection connection=DBConnectionManager.getConnection();
			AddCirugiaBD addCirugiaBD = new AddCirugiaBD(connection);
			//cliente = addCirugiaBD.getCliente(rutCliente);		
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	/**
	 * Autor: Sebastian Arancibia
	 * Metodo que llama a la funcion getAllMascotas, de la clase AddCirugiaDB, que se encuentra en el paquete PabellonBD,
	 * en este metodo se realiza una solicitud de las mascotas que existen en el sistema.
	 * @param no recibe parametro.
	 * @return Listado de mascotas, objetos con todos los datos de las mascotas registradas.
	 */
	public List<Mascota> getAllMascotas(){
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	try {
			Connection connection=DBConnectionManager.getConnection();
			AddCirugiaBD cirugiaBD = new AddCirugiaBD(connection);
			mascotas= cirugiaBD.getAllMascotas();		
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		return mascotas;
    }
    
	/**
	 * Autor: Sebastian Arancibia
	 * Metodo que llama a la funcion getMascotas, de la clase AddCirugiaDB, que se encuentra en el paquete PabellonBD,
	 * metodo que realiza una solicitud de las mascotas que posee un determinado cliente identificado por el rut que 
	 * se recibe de entrada.
	 * @param String rutCliente, es el rut del cliente del cual se quieren obtener las mascotas.
	 * @return Listado de mascotas, objetos con todos los datos de las mascotas registradas a nombre del cliente con 
	 * dicho rut.
	 */
	public List<Mascota> getMascotas(String rutCliente){
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	try {
			Connection connection=DBConnectionManager.getConnection();
			AddCirugiaBD cirugiaBD= new AddCirugiaBD(connection);
			mascotas= cirugiaBD.getMascotas(rutCliente);		
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		return mascotas;
    }
	
		
	
	/**
	 * Autor: Sebastian Arancibia
	 * Metodo que llama a la funcion getAllUsuariosE, de la clase UsuarioEditBD, que se encuentra en el paquete 
	 * AdministracionBD, metodo que realiza una solicitud de los usuarios del sistema y los almacena en la lista persons,
	 * para que otros metodos puedan acceder a esta.
	 * @param No recibe parametro.
	 * @return No retorna resultado.
	 */
    public void getAllUsuariosE()
    {
    	persons=new ArrayList<Usuario>();
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