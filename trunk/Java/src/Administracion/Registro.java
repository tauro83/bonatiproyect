//=======================================================================
// FECHA CREACIÓN: 30/09/09
// AUTOR:Nicolas Delgado
// Comentario: Esta clase permite guardar todos los registro de una atención realizada
// en los servicios al interior de la clinica veterinaria.
//======================================================================


package Administracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import AdministracionBD.AddRegistroBd;


import Bd.DBConnectionManager;

public class Registro {
	
	
	/**
	 * Corresponde a un atributo que solamente podran ser accedido desde la misma clase o desde
	 * sus subclases, este atributo nos permitira poder saber el costo de una prestasión de un 
	 * servicio de la clinica veterinaria.
	 */
	
	public int costoAtencion; 
	
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
	
	protected String fecha;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
	
	/**
	 * Corresponde a un atributo que solamente podran ser accedido desde la misma clase o desde
	 * sus subclases, este atributo nos permitirá poder obtener el nombre de la mascota que se esta 
	 * atendiendo al interior de un servicio.
	 */
	
	protected String nombreMascota;
	
	/**
	 * Corresponde a un atributo que solamente podran ser accedido desde la misma clase o desde
	 * sus subclases, este atributo nos permitira poder almacenar la hora en que fue atendida la mascota al
	 * interior de uno de los servicios de la clinica veterinaria.
	 */
	
	protected String hora;
	
	
	/**
	 * Corresponde a un atributo que solamente podran ser accedido desde la misma clase o desde
	 * sus subclases, este atributo corresponde a la identificacion de los servicios que prestan al clinica 
	 * veterianaria los cuales tendran las siguientes identificación:
	 * 1.-Pabellon, 2.-Policlinico, 3.-PetShop, 4.-Hoteleria, 5.-peluqueria
	 */
	
	protected int idServicio;
	
	/**
	 * Corresponde a un atributo que solamente podran ser accedido desde la misma clase o desde
	 * sus subclases, este atributo permite conocer la fecha de nacimiento de la mascota para poder extraer la
	 * edad de ella para la recetación de distintos medicamentos o vacunaciones.
	 */
	
	protected String mascotaFechaNacimiento;
	
	/**
	 * Corresponde a un atributo que solamente podran ser accedido desde la misma clase o desde
	 * sus subclases, este atributo es el identificador del cliente presencial de la clinica veterinaria
	 * que nos permite realizar el nexo entre la mascota y el cliente .
	 */
	
	protected int rutCliente;
	
	/**
	 * Este metodo corresponde al constructor de la clase. 
	 * @throws Exception 
	 * @throws SQLException 
	 * 
	 */
	
	
    public Registro(int costoAtencion,String responsable,String fecha,String nombreMascota,String hora,int idServicio,String mascotaFechaNacimiento,int rutCliente) throws SQLException{
       Registro r=new Registro(4000,"maria","12/09/09","cuky","12:30",3,"12/04/08",1234567);
    	
       this.costoAtencion=costoAtencion;
       this.responsable=responsable;
       this.fecha=fecha;
       this.nombreMascota=nombreMascota;
       this.hora=hora;
       this.idServicio=idServicio;
       this.mascotaFechaNacimiento=mascotaFechaNacimiento;
       this.rutCliente=rutCliente;
       
       
       Registro.addRegistro(r);
       
	
    }
	
	
	/**
	 * Este metodo nos permitira poder obtener la hora en que se esta efectuado el 
	 * registro al interior de un servicio de la clinica veterinaria. 
	 * 
	 */
	

	public String getHora() {
		return hora;
	}
	

	/**
	 * Este metodo nos permitira poder modificar la hora en que será efectuado el 
	 * registro al interior de un servicio de la clinica veterinaria. 
	 * @param  hora Este metodo recibe como entrada variable Time Hora, que corresponde a la libreria de "java.sql". 
	 */

	protected void setHora(String hora) {
		this.hora = hora;
	}

	/**
	 * Este metodo nos permitira poder obtener el identificador del servicio en que se esta 
	 * prestando la atención a una mascota, los cuales deberan ir acorde a la 
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
	 * Este metodo nos permitira poder obtener la fecha en que se le fue efectuada una prestación
	 * de servicio a una mascota al interior de la clinica veterinaria.
	 */


	public String getFecha() {
		return fecha;
	}
	
	/**
	 * Este metodo nos permitira poder modificar la fecha en que fue efectuado el 
	 * registro al interior de un servicio de la clinica veterinaria. 
	 * @param  fecha Este metodo recibe como entrada String que nos permitira poder prediseñar 
	 * un estandar de formato de la fecha que se mencionara en el siguiente ejemplo: dd/mm/aaaa
	 */


	protected void setFecha(String fecha) {
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

	protected void setNombreMascota(String nombreMascota) {
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
	

	protected void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	

	/**
	 * Este metodo nos permitira poder obtener el valor total efectuado en el paso de la mascota 
	 * al interior de los servicios de la clinica veterinaria. 
	 * 
	 */

	public int getCostoAtencion() {
		return costoAtencion;
	}
	
	/**
	 * Este metodo nos permitira poder modificar el valor total del cada uno de los pasos 
	 * que tenga la mascota al interior de los servicios de la clinica veterinaria.
	 * @param  costoAtención Este metodo recibe un variable Int como entrada la cual va ir siendo 
	 * modificada a medida que a la mascota se le preste un servicio. 
	 */

	protected void setCostoAtencion(int costoAtencion) {
		this.costoAtencion = costoAtencion;
	} 
	
	/**
	 * Este metodo nos permitira poder obtener la fecha de nacimiento de la mascota, por la cual se 
	 * permitira poder obtener la edad de la mascota para la recetacion de medicamentos y vacunas.
	 */
	
	public String getMascotaFechaNacimiento() {
		return mascotaFechaNacimiento;
	}
	
	/**
	 * Este metodo nos permitira poder modificar la fecha de nacimiento de la mascota ya sea por 
	 * el motivo que sea que se habla produccido un error al momento de ingresar los datos. 
	 * @param  mascotaFechaNacimiento Este metodo recibe como entrada String que nos permitira poder prediseñar 
	 * un estandar de formato de la fecha de nacimiento de una mascota que se mencionara en el siguiente 
	 * ejemplo: dd/mm/aaaa
	 */

	public void setMascotaFechaNacimiento(String mascotaFechaNacimiento) {
		this.mascotaFechaNacimiento = mascotaFechaNacimiento;
	}

	/**
	 * Este metodo nos permitira poder obtener el rut de un ncliente presencial que se encuentre registrado en 
	 * la clinica veterinaria.
	 */
	
	public int getRutCliente() {
		return rutCliente;
	}
	
	/**
	 * Este metodo nos permitira poder modificar el rut del cliente ya sea por 
	 * el motivo que sea que se habla produccido un error al momento de ingresar los datos. 
	 * @param  rutCliente Este metodo recibe como entrada Integer poder modificar el Rut de un cliente 
	 * presencial.
	 */

	protected void setRutCliente(int rutCliente) {
		this.rutCliente = rutCliente;
	}
		
		/**
		 * Este metodo nos permitira poder poder agregar una atencion realizada al interior de una 
		 * servicio el cual se podran obtener los datos y enviarlos a la clase de base de datos RegistroDB.
		 * @throws SQLException 
		 */
		
		protected static String addRegistro(Registro r) throws SQLException{
			
			Connection connection=DBConnectionManager.getConnection();
			AddRegistroBd acbd = new AddRegistroBd(connection);	
			return acbd.addRegistro(r);
		
			
		}
				 
			/**
			 * Este metodo nos permitira  poder eliminar una atencion realizada al interior de una 
			 * servicio el cual se podran obtener los datos, para luego ser modificados de la base de datos.
			 */
		 
		/*protected  String deteleRegistro()throws SQLException{
			return nombreMascota;
			 
		 }*/
		 
		 
			/**
			 * Este metodo permitira  poder obtener una atencion realizada al interior de una 
			 * servicio que se encuentre almacenada en la base de datos.
			 */
		 
		/*protected List<Registro> getRegistro()throws SQLException{
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
	    }*/
			


	
	

}
