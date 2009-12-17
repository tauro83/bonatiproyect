// ActionScript file

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
			this.destination="EditarPostOperatorioService";
			this.source="Services.EditarPostOperatorioService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 */ 
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en EditarPostOperatorioService, Detalle: "+event.fault.message);
		}
		/**
		 * Se obtienen todas los registros de post-operatorio activos del sistema
		 */ 
		public function editarPostOperatorio(String fecha, String hora):void{
			this.getOperation("editarPostOperatorio").send();
		}