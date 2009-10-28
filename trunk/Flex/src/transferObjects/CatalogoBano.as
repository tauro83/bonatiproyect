//=======================================================================
// FECHA: CREACIÓN: 24 Octubre
// AUTOR: Erwin Díaz
// Comentarios: Objeto del tipo corte, se instancia para enviar y recibir
//				datos que corresponden a este tipo de objetos entre la capa de interfaz,
//				lógica y base de datos.
//=======================================================================

package transferObjects
{
	import flash.utils.ByteArray;
		
	[Bindable]
    [RemoteClass(alias="TransferObjects.CatalogoBano")]
	/**
	 * se instancia para enviar y recibir datos que corresponden 
	 * a este tipo de objetos entre la capa de interfaz,
	 * lógica y base de datos.
	 */    
	public class CatalogoBano
	{
		public var servicio:String;
		public var nombre:String;
		public var foto:ByteArray;
		public var hora:String;
		public var fecha:Date;
		public var costo:String;
		public var categoría:String;
		public var descripcion:String;
	}
}