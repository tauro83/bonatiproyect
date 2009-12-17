//=======================================================================
// FECHA CREACIÓN: 15/09/09
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
	
	import util.host;

    /** 
	 *  Se encarga de hacer la conexion con la capa 2 del sistema para poder hacer 
	 *  la verificación del usuario a la base de datos.  
	 *  @author  "Esteban Cruz"
	 **/	 
	public class LoginService extends RemoteObject
	{
		public function LoginService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf", host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="LoginService";
			this.source="Administracion.LoginService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 *  event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 *  @author  "Esteban Cruz"
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en LoginService, Detalle: "+event.fault.message);
		}
		
		/**
		 *  Obtiene los usuarios existentes en la base de datos, 
	 	 *  y verifica que el login ingresado sea correcto
	 	 *  @author  "Esteban Cruz"
		 *  @return 1 si el login ingresado es correcto, de lo 
	 	 *  contrario 0
	 	 */
	 	public function getUsuario(usuario:String, contrasena:String):void
	 	{
	 		this.getOperation("getUsuario").send(usuario,contrasena);
	 	} 
	 	 
	 	 
		public function existLogin(login:Usuario):void
		{
			this.getOperation("existLogin").send(login);
		}
		public function pRegistrar(login:Usuario):void
		{
			this.getOperation("pRegistrar").send(login);
		}
		
		public function pEditar(login:Usuario):void
		{
			this.getOperation("pEditar").send(login);
		}
		
		public function pEliminar(login:Usuario):void
		{
			this.getOperation("pEliminar").send(login);
		}
		
		public function pPurgar(login:Usuario):void
		{
			this.getOperation("pPurgar").send(login);
		}
	}
}