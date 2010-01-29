//=======================================================================
// FECHA CREACIÓN: 05/10/2009
// AUTOR: Sebastian Arancibia
// …. Clase que comunica con java (capa 2)
//=======================================================================

package services{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.Cita;
	
	import util.host;

	/**
	 * Clase Declara el canal, y los servicios a los cuales se estan enviando los datos.
	 * Y la direccion en la cual esta levantado la capa 2.
	 * @author Sebastian Arancibia
	 * @version 05/10/2009
	 * @langversion ActionScript 3.0
	*/
	public class DiaAgendaServices extends RemoteObject{
		public function DiaAgendaServices(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			//Destino capa 2 
			this.destination="DiaAgendaServices";
			this.source="Agenda.DiaAgendaServices";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 *  Metodo Declara el canal, y los servicios a los cuales se estan enviando los datos.
		 *  Y la direccion en la cual esta levantado la capa 2.
	 	 * 	@author  Sebastian Arancibia	 		
		 * */
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en DiaAgendaServices, Detalle: "+event.fault.message);
		}
		/**
		 * Metodo que solicita a la capa 2 los datos de todos las mascotas del sistema que
		 * compartan los atributos enviados  
		 * @author  Sebastian Arancibia
		 * @param fecha Feca de las citas que se quiere retornar
		 **/
		public function getDiaAgenda(fecha:String):void{
			this.getOperation("getDiaAgenda").send(fecha);
		}
		public function bloquear(b:Cita):void{
			this.getOperation("bloquear").send(b);
		}
		
	}
}