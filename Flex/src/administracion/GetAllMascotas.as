//=======================================================================
// FECHA CREACIÓN:  19/10/2009
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
	
	public class GetAllMascotas extends RemoteObject{
		public function GetAllMascotas(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="GetAllMascotas";
			this.source="Administracion.GetAllMascotas";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en GetAllMascotas, Detalle: "+event.fault.message);
		}
		public function getAllMascotas():void{
			this.getOperation("getAllMascotas").send();
		}
		

	}
}