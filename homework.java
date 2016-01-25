import java.util.Scanner;

public class homework {
	//I create a program which implements simple mobile phone with the following capabilities
	//Able to store, modify, remove and query contact names.
	//I create a class for Contacts(with name and phone number).
	//Also a MobilePhone class which holds the ArrayList of Contacts.
	//This MobilePhone can Quit, print list of all Contacts, add new Contact, update existing contact and remove contact as well as
	//search for contact.
	
	private static Scanner scanner = new Scanner(System.in);
	private static MobilePhone mobilePhone = new MobilePhone("0919 599 5218");
	
	public static void main(String[] args) {
			
		boolean quit = false;
		startPhone();
		printActions();
		
		while (!quit) {
			System.out.println("\nEnter you action: (press 6 for showing all actions)");
			int action = scanner.nextInt();
			scanner.nextLine();
			
			switch (action) {
			case 0:
				System.out.println("Phone is shuttling down!");
				quit = true;
				break;
			
			case 1:
				System.out.println("All the contacts are: ");
				//this is the OOP way of designing, implemented in mobilePhone class
				mobilePhone.printContact();
				break;
				
			case 2:
				addNewContact();
				break;
				
			case 3:
				updateContact();
				break;
				
			case 4:
				removeContact();
				break;
				
			case 5:
				QueryContact();
				break;
				
			case 6:
				printActions();
				break;
			}
		}
	}
	
	private static void addNewContact() {
		System.out.println("Enter new contact name: ");
		String name = scanner.nextLine();
		System.out.println("Enter you phone number: ");
		String phoneNumber = scanner.nextLine();
		Contacts newContact = Contacts.createContact(name, phoneNumber);
		if (mobilePhone.addContacts(newContact)) {
			System.out.println("New contact has been added: " + name + ":" + phoneNumber);
		}
		else {
			System.out.println("Contact has already been in the phone list");
		}
	}
	
	private static void updateContact() {
		System.out.println("Enter the name you want to update");
		String name = scanner.nextLine();
		Contacts updatecontact = mobilePhone.queryContacts(name);
		if (updatecontact == null) {
			System.out.println("Contact cannot be found on this phone");
			return;
		}
		System.out.println("Please enter the new name: ");
		String newName = scanner.nextLine();
		System.out.println("Please enter the new phoneNumber: ");
		String newNumber = scanner.nextLine();
		Contacts newContact = Contacts.createContact(newName, newNumber);
		mobilePhone.updateContacts(updatecontact, newContact);
	}
	
	private static void removeContact() {
		System.out.print("Enter the name for remove: ");
		String name = scanner.nextLine();
		Contacts existingContact = mobilePhone.queryContacts(name);
		if (existingContact == null) {
			System.out.println("Contact cannot be found");
			return;
		}
		if ( mobilePhone.removeContact(existingContact) ) {
			System.out.println("Successfully remove the contact");
			return;
		}
		System.out.println("Error deleting the contact");
	}
	
	private static void QueryContact() {
		System.out.print("Enter the name for query: ");
		String name = scanner.nextLine();
		Contacts existingContact = mobilePhone.queryContacts(name);
		if (existingContact == null) {
			System.out.println("Contact cannot be found");
			return;
		}
		System.out.println("Name " + existingContact.getName() + " Phone Number " + existingContact.getPhoneNumber());
	}
	
	private static void printActions() {
		System.out.println("Avaliable actions:");
		System.out.println("0 = shuttle down\n"
				+ "1 = print all the contacts\n"
				+ "2 = add a new contact\n"
				+ "3 = update existing contact\n"
				+ "4 = remove existing contact\n"
				+ "5 = query if a contact exist\n"
				+ "6 = print a list of avaliable actions"
				);
	}

	private static void startPhone() {
		System.out.println("The phone is turning on");
	}
	
}
