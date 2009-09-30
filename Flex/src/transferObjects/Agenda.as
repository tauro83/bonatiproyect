package transferObjects
{
	[Bindable]
    [RemoteClass(alias="transferObjects.Person")]
    import mx.collections.ArrayCollection;
	public class Agenda
	{
		public var fecha:String;
		public var estado:String;
		public var citas:ArrayCollection;
	}
}