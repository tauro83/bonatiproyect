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
		public var idpostoperatorio:String;
		public var observaciones:String;
		public var sintomas:String;
		public var diagnostico:String;
		public var responsable:String;
		public var ayudante:String;
		public var clienterut:String;
		public var nombreCliente:String;
		public var apellido:String;
		public var stfecha:String;
		public var shora:String;
		public var sexo:String;
		public var raza:String;
		public var estado:int;
		public var motivo:String;
		public var fechaA:String;
		public var usuarioA:String;
		
	}
}