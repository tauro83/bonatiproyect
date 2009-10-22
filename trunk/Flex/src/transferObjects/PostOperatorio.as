/**
 * @Author Andres Garrido
 * @Version 1
 * Objeto PostOperatorio equivalente al que existe en la capa 2
*/
package transferObjects{
	[Bindable]
    [RemoteClass(alias="TransferObjects.PostOperatorio")]
	public class PostOperatorio extends Atencion{
		public var medicamentos:String;
		public var alimentos:String;
		public var indicaciones:String;
		public var nombreMascota:String;
		public var nombreDueño:String;
		public var rut:String;
		public var apellidoDueño:String;
		
	}
}