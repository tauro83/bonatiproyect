package transferObjects
{
	/**
 	 * 	@author  "Sebastian Arancibia"
	 * 	@Fecha  11 Octubre de 2009
	 *  @Descripcion Objeto de diagnostico que contiene toda su informacion		 		
	 * */
	[Bindable]
    [RemoteClass(alias="TransferObjects.Diagnostico")]
    
	public class Diagnostico
	{
		public var clienteRut:String;
		public var mascotaNombre:String;
		public var hora:String;
		public var nuevaHora:String;
		public var fecha:String;
		public var nuevaFecha:String;
		public var tipoCir:String;
		public var diagnostico:String;

	}
}