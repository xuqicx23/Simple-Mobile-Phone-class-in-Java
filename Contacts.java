
public class Contacts {
	private String name;
	private String phoneNumber;
	
	//Constructor
	public Contacts(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	//createContact method, using for creating contact within this class
	public static Contacts createContact(String name, String phoneNumber) {
		return new Contacts(name, phoneNumber);
	}
	
	//getters & setters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
