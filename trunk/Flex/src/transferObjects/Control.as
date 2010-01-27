
//=======================================================================
// FECHA: CREACIÓN: 27 Octubre de 2009
// AUTOR: Sebastian Arancibia
//=======================================================================


package transferObjects
{
	import mx.formatters.DateFormatter;
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
		//Servicio al que esta asociado el control que por defecto es "POLICLINICO"
		public var servicio:String;
		
		public var fechas:String;
		
		public var motivo:String;
		//toma la fecha en formato date, la pasa a string y luego la guarda en 'fechas'
		public function dateToString():void{
			var dateFormatted:DateFormatter = new DateFormatter();
			dateFormatted.formatString = "DD/MM/YYYY";
			this.fechas = dateFormatted.format(this.fecha) as String;
		}
	}
	
}