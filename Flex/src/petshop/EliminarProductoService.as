package petshop
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.Producto;
	
	import util.host;
	
	public class EliminarProductoService extends RemoteObject
	{
		public function EliminarProductoService()
		{
			
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="EliminarProductoService";
			this.source="Petshop.EliminarProductoService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en EliminarProductoService, Detalle: "+event.fault.message);
		}
		

		public function eliminarProducto(rut:String):void
		{
			this.getOperation("eliminarProducto").send(rut);
		}
		
		/**
		 * Se obtienen todos los clientes que están registrados en la base de datos
		 */ 
		public function getProductosActivosTipo():void
		{
			this.getOperation("getProductosActivosTipo").send();
		}
		
		public function getProductosInactivosTipo():void
		{
			this.getOperation("getProductosInactivosTipo").send();
		}
		
		public function cargarProductosDetalle(pro:Producto ):void
		{
			this.getOperation("cargarProductosDetalle").send(pro);
		}
		
		public function anularProducto(codigo:String):void
		{
			this.getOperation("anularProducto").send(codigo);
		}
		
		public function eliminarVarios(nombre:String, precio:String, categoria:String, descripcion:String):void
		{
			this.getOperation("eliminarVarios").send(nombre, precio, categoria, descripcion);
		}
		public function PurgarProductoTipo(nombre:String, precio:String, categoria:String, descripcion:String):void
		{
			this.getOperation("PurgarProductoTipo").send(nombre, precio, categoria, descripcion);
		}	

	}
}