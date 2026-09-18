package appointment;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

public class AppointmentService {
	
	private Map<String, Appointment> appointments;
	
	public AppointmentService() {
		appointments = new HashMap<>();
	}
	
	/*
	 * Appointment service shall be able to add appointment with a unique appointment ID
	 */
	public void addAppointment(Appointment appointment) {
		
		if (appointment == null) {
			throw new IllegalArgumentException("Appointment cannot be null");
		}
		
		String id = appointment.getAppointmentID();
		
		if (appointments.containsKey(id)) {
			throw new IllegalArgumentException("Appointment ID already exists");
		}
		appointments.put(id,  appointment);
	}
	
	/**
	 * Appointment service shall be able to delete appointments per appointment ID
	 */
	
	public void deleteAppointment(String appointmentID) {
		
		if (appointmentID == null || !appointments.containsKey(appointmentID) ) {
			throw new IllegalArgumentException("Appointment not found");
		}
		
		
		appointments.remove(appointmentID);
	}
	
	public Appointment getAppointment(String appointmentID) {
		return appointments.get(appointmentID);
	}
}
