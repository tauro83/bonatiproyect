//=======================================================================
// FECHA CREACIÓN:  03/11/2009
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
	import util.host;
	//clase encargada de obtener todos los controles
	//agendados que esten en la base de datos
	public class GetAllControles extends RemoteObject{
		public function GetAllControles(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="GetAllControles";
			this.source="Policlinico.GetAllControles";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		//función oyente para el constructor de la clase
		//que captura una falla y la informa al usuario
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en GetAllControles, Detalle: "+event.fault.message);
		}
		//función que se comunica con la capa 2 para la obtención
		//de los controles agendados
		public function getAllControles():void{
			this.getOperation("getAllControles").send();
		}
		public function getAllControlesAnu():void{
			this.getOperation("getAllControlesAnu").send();
		}

	}
}