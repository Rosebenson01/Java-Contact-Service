/**
 * Rose Benson
 * CS-320
 * Module 5
 */

package appointment;

import java.util.Date;

public class Appointment {
	
	private String appointmentID;
	private Date appointmentDate;
	private String description;
	
	
	public Appointment(String appointmentID, Date appointmentDate, String description) {
		
		
		/**
		 * Appointment ID shall not be null and cannot be longer than 10 characters 
		 */
		if (appointmentID == null || appointmentID.length() > 10) {
			throw new IllegalArgumentException("Appointment Id is invalid");
		}
		
		/**
		 * Appointment Date shall not be null and cannot be in the past
		 */
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("appointment date is invalid");
		}
		
		/**
		 * Appointment description shall not be null and cannot be longer than 50 characters
		 */
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Description is invalid");
		}
		
		this.appointmentID = appointmentID;
		this.appointmentDate = appointmentDate;
		this.description = description;
	}
	
	/*
	 * Appointment ID can not be updatable 
	 */
	public String getAppointmentID() {
		return appointmentID;
	}
	
	/**
	 * 
	 */
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public void setAppointmentDate(Date appointmentDate) {
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Appointment date is invalid");	
		}
		this.appointmentDate = appointmentDate;
	}
	
	/**
	 * Valiadte appointment description
	 */
	
	public String getdescription() {
		return description;
	}
	
	public void setdescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Description is invalid");
		}
		this.description = description;
	}
	
}
