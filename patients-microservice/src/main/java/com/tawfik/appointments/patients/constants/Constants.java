package com.tawfik.appointments.patients.constants;

public class Constants {

	public static final String DOCTOR_SERVICE_BASE_URL = "http://localhost:8000/";
	public static final String DOCTOR_IS_APPOINTMENT_AVAILABLE_URL = DOCTOR_SERVICE_BASE_URL
			+ "/api/appointments/{appointmentId}/is-available";
	
	public static final String DOCTOR_MARK_APPOINTMENT_UNAVAILABLE_URL = DOCTOR_SERVICE_BASE_URL
			+ "/api/appointments/{appointmentId}/mark-unavailable";
	
	

}
