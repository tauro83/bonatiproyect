//=======================================================================
// FECHA CREACIÓN: 16/11/09 
// AUTOR: Nicolas Delgado
// Se declara la clase Registro de Peluquería, una vez instanciada 
// representa el objeto de transferencia entre la capa lógica
// y la interfaz gráfica
//=======================================================================

package transferObjects
{
	import mx.controls.CheckBox;
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.anuPeluqueria")]
	
	 /**
    * Usada para la transferencia de datos entre la capa lógica
    * y la interfaz gráfica
    * @autor Nicolas Delgado
    */
	public class anuPeluqueria
	{
		public var checkbox:CheckBox = new CheckBox;
		public var sel:Boolean;
		
		public var rutCliente:String; // representa al rut del cliente
		public var nombreCliente:String; // representa al nombre del cliente
		public var apellido:String; // representa al apellido del cliente
		public var raza:String; // representa a la raza de la mascota
		public var sexo:String; // representa al sexo de la mascota
		public var nombreMascota:String; // representa al nombre de la mascota
		public var costo:String; // representa el costo de la atencion de un registro de peluquería
		public var servicio:String; // representa el nombre del servicio
		public var hora:String; // representa la hora en que fue realizada la atención.
		public var fecha:String; // representa la fecha en que fue realizada la atención.
		public var descripcion:String; // representa un descripcion de que fue lo que se realizo en el servicio.
		public var responsable:String; // representa a la person aque presto el servicio.
		public var nombreCatalogo:String; // representa al nombre del catalogo.
		public var estado:int; // representa el estado en que se encuentra el registro de peluquería.
		public var motivo:String;
		public var fechaA:String;
		public var usuarioA:String;
	}
}
