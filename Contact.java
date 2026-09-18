/** Rose Benson
* CS-320
* Module 3
*/

package contact;

public class Contact {

	private final String contactID;   // not updatable
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;

	// ---------- Validation Methods ----------

	private boolean validateContactID(String contactID) {
		return contactID != null && contactID.length() <= 10;
	}

	private boolean validateFirstName(String firstName) {
		return firstName != null && firstName.length() <= 10;
	}

	private boolean validateLastName(String lastName) {
		return lastName != null && lastName.length() <= 10;
	}

	private boolean validatePhoneNumber(String phoneNumber) {
		return phoneNumber != null && phoneNumber.matches("\\d{10}");
	}

	private boolean validateAddress(String address) {
		return address != null && address.length() <= 30;
	}

	// ---------- Constructor ----------

	public Contact(String contactID,
				   String firstName,
				   String lastName,
				   String phoneNumber,
				   String address) {

		if (!validateContactID(contactID)) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		if (!validateFirstName(firstName)) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (!validateLastName(lastName)) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (!validatePhoneNumber(phoneNumber)) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if (!validateAddress(address)) {
			throw new IllegalArgumentException("Invalid address");
		}

		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	// ---------- Getters ----------

	public String getContactID() {
		return contactID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	// ---------- Setters (updatable fields only) ----------

	public void setFirstName(String firstName) {
		if (!validateFirstName(firstName)) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		if (!validateLastName(lastName)) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (!validatePhoneNumber(phoneNumber)) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		if (!validateAddress(address)) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address;
	}
}
