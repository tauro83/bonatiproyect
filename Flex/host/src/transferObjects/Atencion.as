//=======================================================================
// FECHA: CREACIÓN: 20/08/09
// AUTOR: Camilo Verdugo
// Comentarios: TransferObject que es instanciado en la el componente Ficha
//=======================================================================

package transferObjects
{	
	[Bindable]
    [RemoteClass(alias="TransferObjects.Atencion")]
	
	/**
	 * Clase que encapsula los datos de una atencion, esta clase posee una equivalente en la capa 2
	 * De tal forma que se pueda hacer una mapeo directo desde las capas.
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