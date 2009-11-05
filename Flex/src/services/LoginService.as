//=======================================================================
// FECHA CREACIÓN: 15 Septiembre
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
			this.source="Administracion.LoginService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 *  @author  "Esteban Cruz"
		 * 	@Fecha  15 Septiembre
		 *  @Descripcion event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en LoginService, Detalle: "+event.fault.message);
		}
		
		/**
	 	 *  @author  "Esteban Cruz"
		 *  @Fecha  15 Septiembre
		 *  @Descripcion Obtiene los usuarios existentes en la base de datos, 
	 	 *  y verifica que el login ingresado sea correcto
		 *  @return 1 si el login ingresado es correcto, de lo 
	 	 *  contrario 0
	 	 */
		public function existLogin(login:Usuario):void
		{
			this.getOperation("existLogin").send(login);
		}
		
	}
}