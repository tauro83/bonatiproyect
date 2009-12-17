//=======================================================================
// FECHA CREACIÓN: 05/10/2009
// AUTOR: Sebastian Arancibia
// …. Clase que contiene los atributos del objeto DiaAgenda
//=======================================================================

package transferObjects
{
	[Bindable]
    [RemoteClass(alias="transferObjects.DiaAgenda")]
    import mx.collections.ArrayCollection;
    
    /**
	 * Clase utilizada para representar el objeto DiaAgenda correspondiente a las citas del dia en la agenda
	 * @author  Sebastian Arancibia
	 * @version 1, 05/10/2009
	 */
	public class DiaAgenda
	{
		/** Atributo referente al cliente de la cita */
		public var cliente:String;
		
		/** Atributo referente al mascota de la cita */
		public var mascota:String;
		
		/** Atributo referente al servicio de la cita */
		public var servicio:String;
		
		/** Atributo referente al responsable de la cita */
		public var responsable:String;
		
		/** Atributo referente a la hora de la cita */
		public var hora:String;
		
		/** Atributo referente a la fecha de la cita */
		public var fecha:String;
		
	}
}