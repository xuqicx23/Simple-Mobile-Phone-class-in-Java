import java.util.ArrayList;

public class MobilePhone {
	private String myNumber;
	private ArrayList<Contacts> myContacts;
	
	//constructor
	public MobilePhone(String myNumber) {
		this.myNumber = myNumber;
		this.myContacts = new ArrayList<Contacts>();
	}
	
	//Method for adding contacts into the contacts list.
	public boolean addContacts(Contacts contact) {
		if ( findContact(contact) >= 0 ) {
			System.out.println("Contact has been in the List");
			return false;
		}
		else {
			//just add this contact into my ArrayList
			this.myContacts.add(contact);
			return true;
		}
	}
	
	//Updating method for updating the existing contact in our current mobile phone
	public void updateContacts(Contacts oldContact, Contacts newContact) {
		if (findContact(oldContact) < 0) {
			return;
		}
		int target = findContact(oldContact); //return the index of old contact
		this.myContacts.set(target, newContact);
	}
	
	//Following are overloaded two versions of find method
	public int findContact(Contacts contact) {
		return myContacts.indexOf(contact);
	}	
	public int findContact(String name) {
		for ( int i = 0; i < this.myContacts.size(); i++) {
			 Contacts currcontact = this.myContacts.get(i);
			 //Using equals method from the Object class to compare strings, not ==
			 if (currcontact.getName().equals(name)) {
				 return i;
			 }
		}
		//not found the name in the ArrayList, I just return -1 for nothing
		return -1;
	}
	
	//query method using for query in the contact list
	public String queryContact(Contacts contact) {
		if (findContact(contact) >= 0 ) {
			return contact.getName();
		}
		return null;		
	}
	public Contacts queryContacts(String name) {
		int position = findContact(name);
		if (position >= 0) {
			return this.myContacts.get(position);
		}
		else {
			return null;
		}
	}
	
	//method using for remove elements in the current contact lists.
	public boolean removeContact(Contacts contact) {
		int position = findContact(contact);
		if (position < 0) {
			System.out.println("contact is not in the list right now!");
			return false;
		}
		this.myContacts.remove(position);
		return true;
	}
	
	//printContacts method for printing out all the contacts message in our phone
	public void printContact() {
		for ( int i = 0; i < this.myContacts.size(); i++) {
			System.out.println((i+1) + ":" + this.myContacts.get(i).getName() + " with number " + this.myContacts.get(i).getPhoneNumber());
		}
	}

}
