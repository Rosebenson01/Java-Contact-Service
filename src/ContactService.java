/** Rose Benson
* CS-320
* Module 3
*/

package contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

	private int currentIDNum = 0;

	// In-memory storage
	public static List<Contact> contactList = new ArrayList<>();

	/**
	 * Add a contact with a unique ID
	 */
	public void addContact(String firstName, String lastName, String phoneNumber, String address) {

		String contactID = String.valueOf(currentIDNum);
		Contact newContact = new Contact(contactID, firstName, lastName, phoneNumber, address);

		contactList.add(newContact);
		currentIDNum++;
	}

	/**
	 * Delete contact by contact ID
	 */
	public void deleteContact(String contactID) {
		contactList.removeIf(contact -> contact.getContactID().equals(contactID));
	}

	/**
	 * Update first name
	 */
	public void editFirstName(String contactID, String firstName) {
		for (Contact contact : contactList) {
			if (contact.getContactID().equals(contactID)) {
				contact.setFirstName(firstName);
			}
		}
	}

	/**
	 * Update last name
	 */
	public void editLastName(String contactID, String lastName) {
		for (Contact contact : contactList) {
			if (contact.getContactID().equals(contactID)) {
				contact.setLastName(lastName);
			}
		}
	}

	/**
	 * Update phone number
	 */
	public void editPhoneNumber(String contactID, String phoneNumber) {
		for (Contact contact : contactList) {
			if (contact.getContactID().equals(contactID)) {
				contact.setPhoneNumber(phoneNumber);
			}
		}
	}

	/**
	 * Update address
	 */
	public void editAddress(String contactID, String address) {
		for (Contact contact : contactList) {
			if (contact.getContactID().equals(contactID)) {
				contact.setAddress(address);
			}
		}
	}
}
