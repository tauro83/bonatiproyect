/**
 * @Author Andres Garrido
 * @Version 1
 * Clase que nos conecta con la capa 2
*/
package pabellon{
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
		

	
	public class EditarPostOperatorio extends RemoteObject{
		public function EditarPostOperatorio(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="EditarPostOperatorio";
			this.source="Pabellon.EditarPostOperatorio";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en EditarPostOperatorio, Detalle: "+event.fault.message);
		}
		public function editarPostOperatoio(lista:ArrayCollection):void{
			this.getOperation("editarPostOperatorio").send(lista);
		}

	}
	
}