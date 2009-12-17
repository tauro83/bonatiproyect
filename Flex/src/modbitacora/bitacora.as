//=======================================================================
// FECHA CREACIÓN: 02/12/09
// AUTOR: Erwin Díaz
// Comentarios: Clase que se encarga de realizar la conexion entre la capa
// 				lógica y la interfaz
//=======================================================================
		
			
package modbitacora
{
	import mx.controls.CheckBox;
	
	[Bindable]
    [RemoteClass(alias="Bitacora.Bitacora")]
	
	 /**
    * Usada para la transferencia de datos entre la capa lógica
    * y la interfaz gráfica
    * @autor Erwin Díaz
    */
	public class bitacora
	{
		public var fecha:String; 
		public var usuario:String; 
		public var accion:String; 
		public var servicio:String; 
	}
}
