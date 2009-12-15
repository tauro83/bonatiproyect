//=======================================================================
// FECHA CREACIÓN: 05/10/2009
// AUTOR: Sebastian Arancibia
// …. Clase que contiene los atributos del objeto BitacoraCita
//=======================================================================
package transferObjects
{
	[Bindable]
    [RemoteClass(alias="Agenda.BitacoraCita")]
    
     /**
	 * Clase utilizada para representar el objeto BitacoraCita correspondiente a las citas modificadas
	 * @author  Sebastian Arancibia
	 * @version 1, 05/10/2009
	 */
	public class BitacoraCita
	{
		/** Usuario responsable de la edicion de la cita*/
		public var usuario:String;
		
		/** Accion que se realiza sobre la cita*/
		public var accion:String;
		
		/** Fecha en que se realiza la accion*/
		public var fechaAccion:String;
		
		/** Hora en que se realiza la accion*/
		public var horaAccion:String;
		
		/** Fecha de la cita modificada*/
		public var fechaCita:String;
		
		/** Hora de la cita modificada*/
		public var horaCita:String;
		
		/** Cliente de la cita modificada*/
		public var cliente:String;
		
		/** Mascota de la cita modificada*/
		public var mascota:String;
		
		/** Servicio de la cita modificada*/
		public var servicio:String;
				
		public function BitacoraCita(){
			var d:Date = new Date();
			this.fechaAccion = d.getDate()+"/"+(d.getMonth()+1)+"/"+d.getFullYear();
			this.horaAccion = d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();
		}
	}
}