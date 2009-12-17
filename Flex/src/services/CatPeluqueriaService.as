//=======================================================================
// FECHA CREACIÓN: 24/10/09
// AUTOR: Erwin Díaz
// Comentarios: Clase que establece la conexion con la capa logica y
//				realiza la accion de registrar un catalogo de peluquería
//=======================================================================


package services
{
	import flash.display.Sprite;
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;	
	import transferObjects.CatPeluqueria;
	import util.host;
	
	/**
	 * 	@author  Erwin Díaz
	 *  Clase que gesitiona la conexion. Mediante el constructor
	 *  Se instancia la conexion con la capa logica , indicando los datos del servidor. 
	*/

	public class CatPeluqueriaService extends RemoteObject
	{
		/**
		 * @author Erwin Díaz
		 * @param amfChannel Indica la ruta del servidor Jboss
		 * @param destination indica el package el nombre del package en la capa logica.
		 * @param source indica el nombre de la clase de la capa logica seguida por el package
		 * */
		public function CatPeluqueriaService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AddCatalogo";
			this.source="Peluqueria.AddCatalogo";			
		}
		
		/**
		 * @author Erwin Díaz
		 * @param user es una instancia del transferObject Usuario, instanciado en la capa logica.
		 * @param addUsuario es el metodo de la clase Administracion de la capa logica.
		 * */
		public function regCatalogo(cat:CatPeluqueria):void
		{
			this.getOperation("addCatalogo").send(cat);
		}
		
	}
}