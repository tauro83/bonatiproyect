package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	/**
	 * Clase encargada de realizar la conexión entre la capa
	 * lógica y la interfaz gráfica
	 * @autor Nicolas Delgado
	 */
	public class editarProducto1 extends RemoteObject
	{
		public function editarProducto1()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="editarProducto1";
			this.source="Administracion.editarProducto1";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en editarProducto1, Detalle: "+event.fault.message);
		}

		
		/**
		* Este metodo se encar de obtener todos los registro de peluquería que se encuentran al 
		* interior de la base de datos. 
		*/ 
		public function getAllVacunaciones():void
		{
			this.getOperation("getAllVacunaciones").send();
		}
		
		public function modificarProducto(descripcion:String,categoria:String,precio:String,nombre:String,codigo:String):void
		{
			this.getOperation("modificarProducto").send(nombre,descripcion,precio,categoria,codigo);
		}
	}
}