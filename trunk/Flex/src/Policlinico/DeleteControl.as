//=======================================================================
// FECHA CREACIÓN:  04/11/2009
// AUTOR: Andres Garrido
// Clase que conecta con capa 2
//=======================================================================
package Policlinico{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	//clase encargada de eliminar un control agendado
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
		//función oyente para el constructor de la clase
		//que captura una falla y la informa al usuario
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en DeleteControl, Detalle: "+event.fault.message);
		}
		//función que se comunica con la capa 2 para eliminar un control
		//datos la hora, fecha y responsable, de manera de poder identificarlo
		//de manera única
		public function deleteControl(hora:String, fecha:Date, responsable:String):void{
			this.getOperation("deleteControl").send(hora,fecha,responsable);
		}
		
		

	}
}