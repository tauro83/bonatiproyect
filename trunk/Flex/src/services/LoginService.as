//=======================================================================
// FECHA: CREACIÓN: 
// AUTOR: Esteban Cruz
// Script de login del sistema, dentro de esta se puede realizar 
// comprobacion para el login
//=======================================================================

package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.Usuario;

	public class LoginService extends RemoteObject
	{
		public function LoginService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="LoginService";
			this.source="services.LoginService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en PersonService, Detalle: "+event.fault.message);
		}
		
		/**
	 	* Obtiene los usuarios existentes en la base de datos, 
	 	* y verifica que el login ingresado sea correcto
		 * @return 1 si el login ingresado es correcto, de lo 
	 	* contrario 0
	 	*/
		public function existLogin(login:Usuario):void
		{
			this.getOperation("existLogin").send(login);
		}
		
	}
}