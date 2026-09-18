/** Rose Benson
* CS-320
* Module 3
*/

package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import contact.Contact;

public class ContactTest {
	
	@DisplayName("Test a valid Constructor")
	@Test
	public void testvalidConstructor() {
		String contactID = "12345";
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = "1234567890";
		String address = "123 Main Street";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phoneNumber, address); 
		
		
		assertEquals("12345", testContact.getContactID());
		assertEquals("John", testContact.getFirstName()); 
		assertEquals("Doe", testContact.getLastName()); 
		assertEquals("1234567890", testContact.getPhoneNumber()); 
		assertEquals("address", testContact.getAddress()); 
				
	}
	
	
	@DisplayName("Test invalid Constructor")
	@Test
	public void testvalidPhoneNumber() {
		String contactID = "456";
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = "123456789";
		String address = "123 Main Street";
		
		assertThrows(IllegalArgumentException.class,() -> {
			new Contact(contactID, firstName, lastName, phoneNumber, address);
		});
	}
	
	
	@DisplayName("Test a valid setFirstName")
	@Test
	public void testSetFirstName() {
		String contactID = "12345";
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = "1234567890";
		String address = "123 Main Street";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
		testContact.setFirstName("Test");
		assertEquals("Test", testContact.getFirstName());
		
	}
	
	
	@DisplayName("Set First name to null")
	@Test
	public void testBadSetFirst() {
		String contactID = "12345";
		String firstName = "John";
        String lastName = "HDoe";
        String phoneNumber = "1234567890";
        String address = "123 Main Street";
		
        Contact testContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
        
        
        assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setFirstName(null);	
        });
	}
    
	
	/**
	 * Test the setFirstName with length too great; should throw an exception 
	 */
	@DisplayName("Set First name too long")
	@Test
	public void testLongSetFirst() {
		String contactId = "12345";
      	String firstName = "John";
        String lastName = "Doe";
        String phoneNumber = "1234567890";
        String address = "123 Main Street";
        
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   

        
        assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setFirstName("TooLongOfAFirstName");
        });
	}
	
	
	@DisplayName("Set Last name too long")
	@Test
	public void testLongSetLast() {
		String contactId = "12345";
      	String firstName = "John";
        String lastName = "Doe";
        String phoneNumber = "1234567890";
        String address = "123 Main Street";
        
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);  
        
        assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setLastName("TooLongOfALastName");
        });

	}
	
	@DisplayName("Test invalid address (too long)")
	@Test
	public void testSetInavalidAddress() {
		String contactId = "12345";
      	String firstName = "John";
        String lastName = "Doe";
        String phoneNumber = "1234567890";
        String address = "123 Main Street";
        
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address); 
        
        assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setAddress("12345678910 way too long  home address Drive main street");
        });
	}
	
	@DisplayName("Test a valid length setAddress")
	@Test
	public void testGoodAddress() {
		String contactId = "12345";
      	String firstName = "John";
        String lastName = "Doe";
        String phoneNumber = "1234567890";
        String address = "123 Main Street";
        
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address); 
        
        testContact.setAddress("123 main Address");        
        assertEquals("123 main Address", testContact.getAddress());

	}
	

}
