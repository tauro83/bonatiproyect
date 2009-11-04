//=======================================================================
// FECHA CREACIÓN:  27/10/2009
// AUTOR: Andres Garrido
// Clase que conecta con capa 2
//=======================================================================
package Policlinico{

	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import transferObjects.Mascota;
	
	public class GetAllControles extends RemoteObject{
		public function GetAllControles(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="GetAllControles";
			this.source="Policlinico.GetAllControles";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en GetAllControles, Detalle: "+event.fault.message);
		}
		public function getAllControles():void{
			this.getOperation("getAllControles").send();
		}
		

	}
}