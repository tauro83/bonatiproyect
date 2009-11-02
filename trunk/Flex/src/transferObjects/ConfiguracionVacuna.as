//=======================================================================
// FECHA: CREACIÓN: 31 Octubre
// AUTOR: Camilo Verdugo
// Comentarios: TransferObject que es instanciado para mantener las configuraciones del sistema
//=======================================================================

package transferObjects
{
	[RemoteClass(alias="TransferObjects.ConfiguracionVacuna")]
	public class ConfiguracionVacuna
	{
		public var nombre:String;
		public var precio:String;
		public var descripcion:String;
		public var caducidad:String;

	}
}