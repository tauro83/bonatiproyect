//=======================================================================
// FECHA CREACIÓN:  09/11/2009
// AUTOR: Victor Silva
// …. Clase Declara el canal, y los servicios a los cuales se estan enviando los datos.
// Y la direccion en la cual esta levantado la capa 2.
//=======================================================================


package hoteleria
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	import transferObjects.Hoteleria;
	
	public class RegistHoteleriaService extends RemoteObject
	{
		public function RegistHoteleriaService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="RegistHoteleriaService";
			this.source="Hoteleria.RegistHoteleriaService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}

	/**
	 	 * 	@author  "Victor Silva"
		 * 	@Fecha  09 Noviembre 2009
		 *  @Descripcion Metodo que en caso de error, muestra en a traves de 
		 * un popup, esto se debe a que estos son errores de sistema, por lo 
		 * tanto es necesario informarlo de otra forma.		 		
		 * */
		public function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en RegistHoteleriaService, Detalle: "+event.fault.message);
		}
		/**
	 	 * 	@author  "Victor Silva"
		 * 	@Fecha  09 Noviembre 2009
		 *  @Descripcion Metodo que envia a la capa 2, el registro de hoteleria, 
		 * para almacenarlo en la base de datos. Llamando al metodo correspondiente.
		 * 	@Param hoteleria Recibe como parametro un objeto de la clase Hoteleria, para enviarlo a la capa2. 		
		 * */
		public function registrarHoteleria(alojar:Hoteleria):void
		{
			this.getOperation("registrarHoteleria").send(alojar);
		}
		public function consultar(rut:String, nombre:String):void
		{
		this.getOperation("consultar").send(rut,nombre);
		}

	}
}