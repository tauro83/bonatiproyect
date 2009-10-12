package transferObjects
{
	[Bindable]
    [RemoteClass(alias="transferObjects.Person")]
	public class Person
	{
		public var rut:String;
		public var name:String;
		public var lastName:String;
	}
}