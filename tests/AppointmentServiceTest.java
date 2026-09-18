package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import appointment.AppointmentService;
import appointment.Appointment;

public class AppointmentServiceTest {
	
	private AppointmentService service;
	private Date futureDate;
	
	
	@BeforeEach
	void setUp() {
		service = new AppointmentService();
		futureDate = new Date(System.currentTimeMillis() + 100000);
	}
	
	/**
	 * Testing valid appointment
	 */
	@Test
	void testAddAppointment() {
		Appointment appt = new Appointment("A1", futureDate, "Doctor visit");
		service.addAppointment(appt);
		
		Appointment retrieved = service.getAppointment("A1");
		assertNotNull(retrieved);
		assertEquals("A1", retrieved.getAppointmentID());
		assertEquals("Doctor visit", retrieved.getdescription());
	}
	
	/**
	 * testing to make sure duplicate ID fails
	 */
	@Test
	void testAddDuplicateAppointment() {
		Appointment appt1 = new Appointment("A1", futureDate, "Doctor visit");
		Appointment appt2 = new Appointment("A1", futureDate, "Dentist visit");
		
		service.addAppointment(appt1);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(appt2);
		});
	}
	
	/**
	 * Deleting an existing appointment
	 */
	@Test
	void testDeleteAppointment() {
		Appointment appt = new Appointment("A1", futureDate, "Doctor Visit");
		service.addAppointment(appt);
		
		service.deleteAppointment("A1");
		
		assertNull(service.getAppointment("A1"));
	}
	
	/**
	 * Test deleting non-existant appointment 
	 */
	@Test
	void testDeleteNonExistentAppointment() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteAppointment("B1");
		});
	}
	
	/**
	 * Testing get appointment returns null if appointment not found
	 */
	@Test
	void testGetNonexistentAppointment() {
		Appointment appt = service.getAppointment("A123");
		assertNull(appt);
	}
	
	/**
	 * Test adding null appointment fails
	 */
	@Test
	void testAddNullAppointment() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(null);
		});
	}
	
}
