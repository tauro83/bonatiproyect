
//=======================================================================
// FECHA: CREACIÓN: 27 Octubre de 2009
// AUTOR: Sebastian Arancibia
//=======================================================================


package transferObjects
{
	[Bindable]
    [RemoteClass(alias="TransferObjects.Control")]
	public class Cita
	{
		// Rut de Cliente
		public var cliente:String;
		// Nombre de la mascota
		public var mascota:String;
		// Fecha en que se realiza el control
		public var fecha:String;
		// Hora en que se realiza el control
		public var hora:String;
		// Fecha en que se fija el proximo control, esto debe ser guardado en la agenda
		public var fechaProxControl:String;	
		// Hora en que se realiza el proximo control, esto debe ser guardado en la agenda
		public var horaProxControl:String;
		// Responsable que esta a cargo del proximo control
		public var responsable:String;
	}
}