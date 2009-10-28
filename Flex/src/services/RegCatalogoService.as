//=======================================================================
// FECHA: CREACIÓN: 24 Octubre
// AUTOR: Erwin Díaz
// Comentarios: Clase encargada de enviar y recibir los objetos de la 
// 				capa lógica hacia la capa de interfaz
//=======================================================================
		
package services
{
	

	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	/**
	 * Encargada de enviar y recibir información desde la capa lógica a
	 * la capa interfaz, los transferObject que se envian hacia la capa lógica
	 * y viceversa son del tipo catalogo_bano y catalogo_corte
	 * @autor Erwin Díaz
	 */
	public class RegCatalogoService extends RemoteObject
	{
		/**
		 * Encargada de realizar la sincronización entre la clase que tiene el
		 * mismo nombre en la capa lógica, ademas se encarga de dar la dirección 
		 * en la que se monta la aplicacióm
		 */
		public function PreoperatorioService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="RegCatalogoService";
			this.source="services.RegCatalogoService";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 * En caso de existir un error en la conexión esta función es la encargada
		 * de mostrar un mensaje que contiene el detalle del error
		 * 
		 */
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en RegCatalogoService, Detalle: "+event.fault.message);
		}
		/**
		 * Inserta un registro del tipo corte en la base de datos,
		 * esto incluye una imagen que ha sido seleccionada por el usuario
		 * todo esto queda dentro de la base de datos
		 * 
		 */
		public function insertCatalogo_bano():void
		{
			this.getOperation("insertCatalogo_bano").send(person);
		}
		/**
		 * Función que permite guardar un registro de tipo corte en la
		 * base de datos, se envían los datos a la capa lógica y luego se
		 * guardan en la base de datos, esto incluye una imagen que es seleccionada
		 * por el usuario
		 * 
		 */
		public function insertCatalogo_corte():void
		{
			this.getOperation("insertCatalogo_corte").send(person);
		}
		
		
		
	}
}