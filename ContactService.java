package ContactProgram;

import ContactProgram.Contact;
import java.util.ArrayList;

public class ContactService {
	
	//Create new array lists to hold the contacts created and unique ID fields.
	private ArrayList<Contact> ContactList;
	private ArrayList<String> Ids;
	
	//Default constructor with blank array lists.
	public ContactService() {
		ContactList = new ArrayList<Contact>();
		Ids = new ArrayList<String>();
	}
	
	//Method to add a new contact, checks if a valid unique id has been provided. Class will throw an error if the arguments are bad.
	public void addContact(String id, String firstName, String lastName, String phoneNumber, String address) {
		if (Ids.contains(id) || (id == null)) {
			throw new IllegalArgumentException("The id given is not unique and is in use for a contact, or is null.");
		}
		else {
		Contact newone = new Contact(id, firstName, lastName, phoneNumber, address);
		Ids.add(id);
		ContactList.add(newone);
		}
	}
	
	//Method to delete an existing contact object and the associated ID in the list of IDs. Throws an error if the id doesn't exist.
	public void deleteContact(String id) {
		if (Ids.contains(id)) {
		ContactList.remove(Ids.indexOf(id));
		Ids.remove(id);
		}
		else {
			throw new IllegalArgumentException("The id given does not exist as a contact.");
		}
	}
	
	//Method to update contact info. for a unique contact id, throws an error if the id doesn't exist, field doesn't exist, or class will throw an error if the value is bad.
	public void updateContact(String id, String field, String value) {
		if (Ids.contains(id) && field != null) {
			switch (field) {
			    case "FirstName": ContactList.get(Ids.indexOf(id)).setFirstName(value);
			    break;
			    case "LastName": ContactList.get(Ids.indexOf(id)).setLastName(value);
			    break;
			    case "PhoneNumber": ContactList.get(Ids.indexOf(id)).setNumber(value);
			    break;
			    case "Address": ContactList.get(Ids.indexOf(id)).setAddress(value);
			    break;
			    default: throw new IllegalArgumentException("The field specified is not recognized. Fields are: FirstName, LastName, PhoneNumber, Address.");
			}
		}
		else {
			throw new IllegalArgumentException("The id given does not exist as a contact or the field is null.");
		}
	}
}
