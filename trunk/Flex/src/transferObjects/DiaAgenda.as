package transferObjects
{
	[Bindable]
    [RemoteClass(alias="transferObjects.DiaAgenda")]
    import mx.collections.ArrayCollection;
	public class DiaAgenda
	{
		public var cliente:String;
		public var mascota:String;
		public var servicio:String;
		public var responsable:String;
		public var hora:String;
		public var fecha:String;
	}
}