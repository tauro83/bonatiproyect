//=======================================================================
// FECHA: CREACIÓN: 19 Septiembre
// AUTOR: Camilo Verdugo
// Comentarios: TransferObject que es instanciado en el componente GraficosPeluqueria
//				El cual es enviado a la capa logica, con el numero de atenciones y el tipo
//=======================================================================
package transferObjects
{
	[Bindable]
    [RemoteClass(alias="transferObjects.EstadisticasPeluqueria")]
	public class EstadisticasPeluqueria
	{ 		
		public var tipo:String;
		public var numAtenciones:Number;
	}
}