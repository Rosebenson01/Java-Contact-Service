package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Date;

import appointment.Appointment;

public class AppointmentTest {
	
	/**
	 * Create a valid future date
	 */
	private Date futureDate() {
		return new Date(System.currentTimeMillis() + 100000);
	}
	
	/**
	 * Creating a valid appointment
	 */
	@Test
	void testValidAppointmentCreation() {
		Appointment appt = new Appointment("A123", futureDate(), "Doctor visit");
		
		assertEquals("A123", appt.getAppointmentID());
		assertEquals("Doctor visit", appt.getdescription());
		assertNotNull(appt.getAppointmentDate());
	}
	
	/**
	 * Validating Appointment ID
	 */
	@Test
	void testAppointmentIDNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, futureDate(), "Test");
		});
		
	}
	
	/**
	 * Validating Date
	 */
	
	@Test 
	void testAppointmentDateNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("A1", null, "Test");
		});
	}
	
	@Test
	void testDescriptionTooLong() {
		String longDescription =
				"This description is longer than 50 character try again" ;
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("A1", futureDate(), longDescription);
		});
	}
	
	@Test
	void testSetValidDescription() {
		Appointment appt = new Appointment("A1", futureDate(), "Initial");
		appt.setdescription("Updated");
		
		assertEquals("Updated", appt.getdescription());
	}
	
	@Test
	void testSetINvalidDescripton() {
		Appointment appt = new Appointment("A1", futureDate(), "Initial");
		
		assertThrows(IllegalArgumentException.class, () -> {
			appt.setdescription(null);
		});
	}

	@Test
	void testSetValidDate() {
		Appointment appt = new Appointment("A1", futureDate(), "Test");
		Date newDate = new Date(System.currentTimeMillis() + 200000);
		
		appt.setAppointmentDate(newDate);
		
		assertEquals(newDate, appt.getAppointmentDate());
	}
	
	@Test
	void testSetPastDateFails() {
		Appointment appt = new Appointment("A1", futureDate(), "Test");
		Date pastDate = new Date(System.currentTimeMillis() - 100000);
		
		assertThrows(IllegalArgumentException.class, () -> {
			appt.setAppointmentDate(pastDate);
		});
	}
}
