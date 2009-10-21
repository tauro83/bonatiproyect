//=======================================================================
// FECHA: CREACIÓN: 13 Octubre
// AUTOR: Nicolas Delgado
// Comentarios: TransferObject que es instanciado en la el componente Preoperatorio
//				Luego es enviado por PreoperatorioServices a la capa 2. Esta clase encapsula los atributos
//				De un Preoperatorio.
//=======================================================================

package transferObjects
{
	import mx.controls.CheckBox;
	
	[Bindable]
    [RemoteClass(alias="TransferObjects.Preoperatorio")]
	public class Preoperatorio
	{

		public var observaciones:String;
		public var sintomas:String;
		public var diagnostico:String;
		public var fecha:String;
		public var hora:String;
		public var idpreoperatorio:String;
		public var responsable:String;
		public var ayudante:String;
		/*
		* Estos atributos permitiran poder realizar la eliminacion de un preoperatorio realizado		 
		* a una mascota.
		*/
	
	//****************************
	    public var checkbox:CheckBox = new CheckBox;
		public var sel:Boolean;
	//****************************
		
	}
}