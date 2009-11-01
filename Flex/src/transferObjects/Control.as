
//=======================================================================
// FECHA: CREACIÓN: 27 Octubre de 2009
// AUTOR: Sebastian Arancibia
//=======================================================================


package transferObjects
{
	[Bindable]
    [RemoteClass(alias="TransferObjects.Control")]
	public class Control
	{
		// Rut de Cliente
		public var cliente:String;
		// Descripcion del control
		public var descripcion:String;
		// Nombre de la mascota
		public var mascota:String;
		// Fecha en que se realiza el control
		public var fecha:Date;
		// Hora en que se realiza el control
		public var hora:String;
		// Responsable que esta a del actual control
		public var responsable:String;
		//Costo del control
		public var costo:String;
		//Servicio
		public var servicio:String;
	}
}