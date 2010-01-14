//=======================================================================
// FECHA CREACIÓN: 14/10/09
// AUTOR: Erwin Díaz 
// Comentario: Clase que se encarga de realizar la conexion entre la capa
// lógica y la interfaz
//=======================================================================

package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import util.host;
	/**
	 * Clase encargada de realizar la conexión entre la capa
	 * lógica y la interfaz gráfica
	 * @autor Erwin Díaz
	 */
	public class PostOperatorioService extends RemoteObject
	{
		public function PostOperatorioService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="PostOperatorioService";
			this.source="Pabellon.PostOperatorioService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 */ 
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en PostOperatorioService, Detalle: "+event.fault.message);
		}
		/**
		 * Se obtienen todas los registros de post-operatorio activos del sistema
		 */ 
		public function getAllPostOperatorioActivo():void{
			this.getOperation("getAllPostOperatorioActivo").send();
		}
		public function elimAtencion(hora:String, rut:String, nomMascota:String):void{
			this.getOperation("elimAtencion").send(hora, rut, nomMascota);
		}
		/**
		 * Se obtienen todas los registros de post-operatorio que están registrados en la base de datos
		 */ 
		public function anulAtencion(hora:String, rut:String, nomMascota:String, motivo:String):void{
			this.getOperation("anulAtencion").send(hora, rut, nomMascota, motivo);
		}
		/**
		 * Se obtienen todas los registros de post-operatorio que están registrados en la base de datos
		 */ 
		public function getAllPostOperatorioAnul():void{
			this.getOperation("getAllPostOperatorioAnul").send();
		}
		/**
		 * Se obtienen todas los registros de post-operatorio que están registrados en la base de datos
		 */ 
		public function getAllPostOperatorio():void
		{
			this.getOperation("getAllPostOperatorio").send();
		}
		/**
		 * Se obtienen todas los registros de post-operatorio que están registrados en la base de datos
		 */ 
		public function getAllPostNull(nombreMascota:String, clienterut:String):void
		{
			this.getOperation("getAllPostNull").send(nombreMascota,clienterut);
		}
		/**
		 * Se obtienen todas los registros de post-operatorio que están registrados en la base de datos
		 */ 
		public function getAllPostOperatorio2(nombreMascota:String, clienterut:String):void
		{
			this.getOperation("getAllPostOperatorio2").send(nombreMascota,clienterut);
		}

		public function getAllVacunacionesV():void
		{
			this.getOperation("getAllVacunacionesV").send();
		}
	}
}