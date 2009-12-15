//=======================================================================
// FECHA: CREACIÓN: 12 Septiembre
// AUTOR: Andres garrido
// Comentarios: TransferObject que es instanciado en el componente GraficosClinica
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