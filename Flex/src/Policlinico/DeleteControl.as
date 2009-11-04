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
	public class DeleteControl extends RemoteObject{
		public function DeleteControl(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="DeleteControl";
			this.source="Policlinico.DeleteControl";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en DeleteControl, Detalle: "+event.fault.message);
		}
		public function deleteControl(hora:String, fecha:Date, responsable:String):void{
			this.getOperation("deleteControl").send(hora,fecha,responsable);
		}
		
		

	}
}