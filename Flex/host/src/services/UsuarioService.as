//=======================================================================
// FECHA: CREACIÓN: 20/08/09
// AUTOR: Camilo Verdugo
// Comentarios: Clase que establece la conexion con la capa logica y
//				realiza la accion de registrar un usuario
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
	 *  Clase que gesitiona la conexion. Mediante el constructor
	 *  Se instancia la conexion con la capa logica , indicando los datos del servidor. 
	 * 	@author  "Camilo Verdugo"
	*/

	public class UsuarioService extends RemoteObject
	{
		/**
		 * Constructor de la clase
		 * @param amfChannel Indica la ruta del servidor Jboss
		 * @param destination indica el package el nombre del package en la capa logica.
		 * @param source indica el nombre de la clase de la capa logica seguida por el package
		 * */
		public function UsuarioService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf", host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AddUsuario";
			this.source="Administracion.AddUsuario";			
		}
		
		/**
		 * Registra un usuario a la capa 2
		 * @param user es una instancia del transferObject Usuario, instanciado en la capa logica.
		 * @param addUsuario es el metodo de la clase Administracion de la capa logica.
		 * */
		public function regUsuario(user:Usuario):void
		{
			this.getOperation("addUsuario").send(user);
		}
		
	}
}