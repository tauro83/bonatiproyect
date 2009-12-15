//=======================================================================
// FECHA CREACIÓN:  07/11/2009
// AUTOR: Andres Garrido
// Clase que conecta con capa 2
//=======================================================================

package administracion{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import transferObjects.Mascota;
	import util.host;

	public class GetAllHoteleriaService extends RemoteObject
	{
		public function GetAllHoteleriaService(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="GetAllHoteleriaService";
			this.source="Administracion.GetAllHoteleriaService";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en GetAllHoteleriaService, Detalle: "+event.fault.message);
		}
		public function getAllHoteleria():void{
			this.getOperation("getAllHoteleria").send();
		}
		
	}
}