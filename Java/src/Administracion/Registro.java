package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Usuario;
import AdministracionBD.AddRegistroBd;
import AdministracionBD.UsuarioEditDB;
import Bd.DBConnectionManager;

public class Registro {
	
	/**
	 * Corresponde a un atributo que solamente podran ser accedido desde la misma clase o desde
	 * sus subclases, este atributo nos permitira poder saber el costo de una prestacion de un 
	 * servicio de la clinica veterinaria.
	 */
	
	public int costoAtención; 
	
	/**
	 * Corresponde a un atributo que solamente podran ser accedido desde la misma clase o desde
	 * sus subclases, este atributo nos permitira conocer la persona que realizo la atención 
	 * al interior  de los  servicio que presta la clinica veterinaria para sus mascotas.
	 */
	
	public String responsable;
	
	/**
	 * Corresponde a un atributo que solamente podran ser accedido desde la misma clase o desde
	 * sus subclases, este atributo nos permitira conocer la fecha en que fue efectuado el registro al 
	 * interior de uno de los servicios.
	 */
	
	public String fecha;
	
	/**
	 * Corresponde a un atributo que solamente podran ser accedido desde la misma clase o desde
	 * sus subclases, este atributo nos permitirá poder obtener el nombre de la mascota que se esta 
	 * atendiendo al interior de un servicio.
	 */
	
	public String nombreMascota;
	
	/**
	 * Corresponde a un atributo que solamente podran ser accedido desde la misma clase o desde
	 * sus subclases, este atributo nos permitira poder almacenar la hora en que fue atendida la mascota al
	 * interior de uno de los servicios de la clinica veterinaria, este tipo de atributo tiene un valor "Time"
	 * que es extraido de las libreria de java para seguir con el formato de los parametros exigido para el desarrollo
	 * de este sistema.
	 */
	
	public String hora;
	
	
	/**
	 * Corresponde a un atributo que solamente podran ser accedido desde la misma clase o desde
	 * sus subclases, este atributo corresponde a la identificacion de los servicios que prestan al clinica 
	 * veterianaria los cuales tendran las siguientes identificación:
	 * 1.-Pabellon, 2.-Policlinico, 3.-PetShop, 4.-Hoteleria, 5.-peluqueria
	 */
	
	public int idServicio;
	
	/**
	 * Corresponde a un atributo que solamente podran ser accedido desde la misma clase o desde
	 * sus subclases, este atributo permite conocer la fecha de la mascota y poder acceder a los
	 * datos de la mascota.
	 */
	
	public String mascotaFechaNacimiento;
	
	/**
	 * Corresponde a un atributo que solamente podran ser accedido desde la misma clase o desde
	 * sus subclases, este atributo permite es el identificador del cliente de la clinica veterinaria
	 * que nos permite el nexo entre la mascota y el cliente .
	 */
	
	public int rutCliente;
	
	/**
	 * Este metodo nos permitira poder obtener la hora en que se esta efectuado el 
	 * registro al interior de un servicio de la clinica veterinaria. 
	 * 
	 */
	

	public String getHora() {
		return hora;
	}
	
	/**
	 * Este metodo corresponde al constructor de la clase. 
	 * @throws SQLException 
	 * 
	 */
	
	
    public Registro(int costoAtención,String responsable,String fecha,String nombreMascota,String hora,int idServicio,String mascotaFechaNacimiento,int rutCliente) throws SQLException{
       	Registro r1=new Registro(14213, "as", "da", "das", "das", 3, "sa", 1243243);
		Registro.addRegistro(r1);
	}
	
	
	

	/**
	 * Este metodo nos permitira poder modificar la hora en que será efectuado el 
	 * registro al interior de un servicio de la clinica veterinaria. 
	 * @param  hora Este metodo recibe como entrada variable Time Hora, que corresponde a la libreria de "java.sql". 
	 */

	public void setHora(String hora) {
		this.hora = hora;
	}

	/**
	 * Este metodo nos permitira poder obtener el identificador del servicio en que se esta 
	 * prestando la atencion a una mascota, los cuales deberan ir acorde a la 
	 * numeración mencionada anteriormente.	 
	 * 
	 */

	public int getIdServicio() {
		return idServicio;
	}
	
	/**
	 * Este metodo nos permitira poder modificar de identificación de un servicio, ya sea por 
	 * el motivo que sea que se halla producido al momento del ingreso de los datos.  
	 * @param  idServicio Este metodo recibe un variable Int como identificador,que tomara el valor de uno de los
	 * servicio descripto anteriormente. 
	 */

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	
	/**
	 * Este metodo nos permitira poder obtener el identificador de una ficha de la mascota
	 * que se le este prestando la atencion en uno de los servicios de la clinica veterinaria.	 
	 */


	public String getFecha() {
		return fecha;
	}
	
	/**
	 * Este metodo nos permitira poder modificar la fecha en que fue efectuado el 
	 * registro al interior de un servicio de la clinica veterinaria. 
	 * @param  fecha Este metodo recibe como entrada variable Date Fecha, que corresponde 
	 * a la libreria de "java.util.Date". 
	 */


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Este metodo nos permitira poder obtener el nombre de la mascota que se encuentra registrada 
	 * al interior de la clinica veterinaria. 
	 */

	public String getNombreMascota() {
		return nombreMascota;
	}
	
	/**
	 * Este metodo nos permitira poder modificar el nombre de una mascota, ya sea por 
	 * el motivo que sea que se halla producido al momento del ingreso de los datos.  
	 * @param  nombreMascota Este metodo recibe una variable String que sera el nombre de la 
	 * mascota. 
	 */

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	
	/**
	 * Este metodo nos permitira poder obtener el nombre del empleado de la clinica veterinaria que realizo
	 * la atención de una mascota. 
	 */

	public String getResponsable() {
		return responsable;
	}
	
	/**
	 * Este metodo nos permitira poder modificar el nombre del empleadoque realizo la atención de la mascota,
	 *  ya sea por el motivo que sea que se halla producido al momento del ingreso de los 
	 * datos.  
	 * @param  responsable Este metodo recibe un variable String como nombre del empleado. 
	 */
	

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	

	/**
	 * Este metodo nos permitira poder obtener el valor total efectuado en el paso de la mascota 
	 * al interior de los servicios de la clinica veterinaria. 
	 * 
	 */

	public int getCostoAtención() {
		return costoAtención;
	}
	
	/**
	 * Este metodo nos permitira poder modificar el valor total del cada uno de los pasos 
	 * que tenga la mascota al interior de los servicios de la clinica veterinaria.
	 * @param  costoAtención Este metodo recibe un variable Int como entrada la cual va ir siendo 
	 * modificada a medida que a la mascota se le preste un servicio. 
	 */

	public void setCostoAtención(int costoAtención) {
		this.costoAtención = costoAtención;
	}

	/**
	 * Este metodo nos permitira poder poder agregar una atencion realizada al interior de una 
	 * servicio el cual se podran obtener los datos y enviarlos a la clase de base de datos RegistroDB.
	 * @throws SQLException 
	 */
	
	public static String addRegistro(Registro r) throws SQLException{
 
		
		Connection connection=DBConnectionManager.getConnection();
		AddRegistroBd acbd = new AddRegistroBd(connection);		
		return acbd.addRegistro(r);
		
	}
			 
		/**
		 * Este metodo nos permitira  poder eliminar una atencion realizada al interior de una 
		 * servicio el cual se podran obtener los datos, para luego ser modificados de la base de datos.
		 */
	 
	public  String deteleRegistro()throws SQLException{
		return nombreMascota;
		 
	 }
	 
	 
		/**
		 * Este metodo nos permitira  poder obtener una atencion realizada al interior de una 
		 * servicio.
		 */
	 
	public List<Registro> getRegistro()throws SQLException{
	   	List<Registro> register=new ArrayList<Registro>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			AddRegistroBd acbd = new AddRegistroBd(connection);
			register= acbd.getRegistro();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return register;
    }
		 

		public String getMascotaFechaNacimiento() {
			return mascotaFechaNacimiento;
		}

		public void setMascotaFechaNacimiento(String mascotaFechaNacimiento) {
			this.mascotaFechaNacimiento = mascotaFechaNacimiento;
		}

		public int getRutCliente() {
			return rutCliente;
		}

		public void setRutCliente(int rutCliente) {
			this.rutCliente = rutCliente;
		}
	
	

}
