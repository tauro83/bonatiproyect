/**
 * @Author Camilo Verdugo
 * @Version 1
*/
package transferObjects
{	
	[Bindable]
    [RemoteClass(alias="TransferObjects.Atencion")]
	/**
	 * 
	 * Clase que encapsula los datos de una atencion, esta clase posee una equivalente en la capa 2
	 * De tal forma que se pueda hacer una mapeo directo desde las capas.
	 * 
	 */    
	public class Atencion
	{
		public var clienteRut:String;
		public var mascotaNombre:String;
		public var servicio:String;
		public var hora:String;
		public var fecha:Date;
		public var costo:String;
		public var sfecha:String;
	}
}