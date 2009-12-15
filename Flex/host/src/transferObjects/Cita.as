
//=======================================================================
// FECHA: CREACIÓN: 03 Octubre
// AUTOR: Victor Silva
// Comentarios: TransferObject que es instanciado en la el componente RegistraCita
//				Luego es enviado por citaServices a la capa 2. Esta clase encapsula los atributos
//				de una cita del sistema.
//=======================================================================


package transferObjects
{
	[Bindable]
    [RemoteClass(alias="TransferObjects.Cita")]
	public class Cita
	{
		public var cliente:String;
		public var mascota:String;
		public var fecha:String;
		public var hora:String;
		public var servicio:String;
		public var usuario:String;


	}
}